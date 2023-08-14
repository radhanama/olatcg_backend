package br.com.olatcg_backend.domain.homology.search;

import br.com.olatcg_backend.domain.pairwise.alignment.LocalPairwiseAlignment;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static br.com.olatcg_backend.domain.homology.search.ResourceOlatcgHomology.targetSequenceList;
import static br.com.olatcg_backend.domain.homology.search.ResourceOlatcgHomology.taxonomyMap;

@Slf4j
public class OlatcgHomology extends Homology {

    public OlatcgHomology(List<SequenceIdPair> sequenceIdPairList, Integer openPenalty, Integer extensionPenalty) {
        super(sequenceIdPairList, openPenalty, extensionPenalty);
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(4); // Adjust based on the number of available CPU cores

    @Override
    public void search() {

        List<Future<HomologyHit>> futures = new ArrayList<>();

        for (SequenceIdPair querySeq : sequenceIdPairList) {
            futures.add(executorService.submit(() -> {

                LocalPairwiseAlignment bestAln = null;

                for (SequenceIdPair targetSeq : targetSequenceList) {

                    LocalPairwiseAlignment actualAln = new LocalPairwiseAlignment();

                    actualAln.setQueryId(querySeq.getId());
                    actualAln.setTargetId(targetSeq.getId());
                    actualAln.setSequenceA(querySeq.getSequence());
                    actualAln.setSequenceB(targetSeq.getSequence());
                    actualAln.setOpenPenalty(openPenalty);
                    actualAln.setExtensionPenalty(extensionPenalty);

                    actualAln.align();

                    if (isBestMatch(bestAln, actualAln)) {
                        bestAln = actualAln;
                    }
                }

                String taxonomy = findCorrespondingTaxonomy(Objects.requireNonNull(bestAln).getTargetId());

                if (taxonomy == null) {
                    throw new RuntimeException("There is no taxonomy registered for the sequence of id " + bestAln.getTargetId());
                }

                return new HomologyHit(bestAln, taxonomy);
            }));
        }

        for (Future<HomologyHit> future : futures) {
            try {
                homologyHitList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                log.info(Arrays.toString(e.getStackTrace()));
            }
        }

        executorService.shutdown();
    }

    private String findCorrespondingTaxonomy(String querySeqId) {
        return taxonomyMap.get(querySeqId);
    }

    private boolean isBestMatch(LocalPairwiseAlignment oldAln, LocalPairwiseAlignment newAln) {
        return oldAln == null || oldAln.getIdentityPercentage() != null && oldAln.getIdentityPercentage().compareTo(newAln.getIdentityPercentage()) < 0;
    }

}
