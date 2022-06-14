package br.com.olatcg_backend.data;

import br.com.olatcg_backend.domain.vo.TaxonomySeachApiRequestVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchBlastnApiResponseVo;
import br.com.olatcg_backend.util.CustomException;

public interface ITaxonomySearchData {
    TaxonomySearchApiResponseVo obtainTaxonomyFrom(TaxonomySeachApiRequestVo vo) throws CustomException;
    TaxonomySearchBlastnApiResponseVo obtainTaxonomyBlastnFrom(TaxonomySeachApiRequestVo vo) throws CustomException;
}
