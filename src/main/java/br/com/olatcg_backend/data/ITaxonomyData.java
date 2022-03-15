package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.Taxonomy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaxonomyData extends CrudRepository<Taxonomy, Integer> {
    List<Taxonomy> findByAnalysis(Analysis analysis);

    @Query("SELECT t FROM Taxonomy t " +
            "JOIN t.alignment.biologicalSequenceA bioSeq " +
            "WHERE bioSeq.id = :bioSeqId")
    Taxonomy findByBiologicalSequenceId(@Param("bioSeqId") Long bioSeqId);
}
