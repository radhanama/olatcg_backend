package br.com.olatcg_backend.domain.homology.search;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Homology {

    protected List<SequenceIdPair> sequenceIdPairList;
    protected Integer openPenalty;
    protected Integer extensionPenalty;

    @Getter
    @Setter
    protected Long analysisId;

    @Getter
    @Setter
    protected String newick;

    @Getter
    @Setter
    protected Double coefficientOfVariation;

    @Getter
    @Setter
    protected List<HomologyHit> homologyHitList;


    public Homology(List<SequenceIdPair> sequenceIdPairList, Integer openPenalty, Integer extensionPenalty) {
        this.sequenceIdPairList = sequenceIdPairList;
        this.openPenalty = openPenalty;
        this.extensionPenalty = extensionPenalty;
        homologyHitList = new ArrayList<>();
    }

    public abstract void search();

}
