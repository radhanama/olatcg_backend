package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.Analysis;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnalysisData extends JpaRepository<Analysis, Long> {
    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.taxonomies WHERE a.type = 'TAXONOMY' OR a.type = 'TAXONOMY_BLAST' ORDER BY a.id DESC")
    List<Analysis> findAllTaxonomyAnalyzes();

    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.alignments WHERE a.type = 'ALIGNMENT' ORDER BY a.id DESC")
    List<Analysis> findAllAlignmentAnalyzes();

    @Query("SELECT DISTINCT a FROM Analysis a LEFT JOIN FETCH a.alignments WHERE a.id = :analysisId AND a.type = 'ALIGNMENT'")
    Analysis findAlignmentAnalysisById(Long analysisId);

    List<Analysis> findByType(AnalysisTypeEnum type);
}
