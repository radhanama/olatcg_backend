package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.vo.PhylogenyApiRequestVo;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhylogenySearchData {
    String obtainNewickFormatFrom(PhylogenyApiRequestVo vo) throws CustomException;
}
