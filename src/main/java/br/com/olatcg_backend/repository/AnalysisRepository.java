package br.com.olatcg_backend.repository;

import br.com.olatcg_backend.domain.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.entity.Analysis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

    Page<Analysis> findByType(AnalysisTypeEnum type, Pageable pageable);

}
