package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.Analysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnalysisData extends CrudRepository<Analysis, Long> {
    @Query("SELECT DISTINCT a FROM Analysis a JOIN a.taxonomies ORDER BY a.id DESC")
    List<Analysis> findAllTaxonomyAnalyzes();

    @Query("SELECT DISTINCT a FROM Analysis a JOIN a.taxonomies t WHERE a.id = :idAnalysis")
    List<Analysis> findTaxonomyAnalyzesById(@Param("idAnalysis") Long idAnalysis);

    @Query("SELECT DISTINCT a FROM Analysis a JOIN a.alignments ORDER BY a.id DESC")
    List<Analysis> findAllAlignmentAnalyzes();
}
