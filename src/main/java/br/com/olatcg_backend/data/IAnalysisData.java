package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.Analysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnalysisData extends CrudRepository<Analysis, Long> {
    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.taxonomies WHERE a.type = 'TAXONOMY' ORDER BY a.id DESC")
    List<Analysis> findAllTaxonomyAnalyzes();

    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.taxonomies t WHERE a.id = :idAnalysis AND a.type = 'TAXONOMY'")
    List<Analysis> findTaxonomyAnalyzesById(@Param("idAnalysis") Long idAnalysis);

    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.alignments WHERE a.type = 'ALIGNMENT' ORDER BY a.id DESC")
    List<Analysis> findAllAlignmentAnalyzes();
}
