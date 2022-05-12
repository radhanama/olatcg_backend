package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiResponseVo;
import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiRequestVo;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.stereotype.Repository;

@Repository
public interface ISequenceAlignmentData {
    SequenceAlignmentApiResponseVo align(SequenceAlignmentApiRequestVo vo) throws CustomException;
}
