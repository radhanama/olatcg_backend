package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.data.IAnalysisData;
import br.com.olatcg_backend.enumerator.AnalysisTypeEnum;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.AnalysisSearchItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnalysisController {

    @Autowired
    private IAnalysisData analysisRepo;

    @GetMapping(Routes.ANALYSIS + "/searchByType")
    public List<AnalysisSearchItemDTO> searchByType(@RequestParam AnalysisTypeEnum type){
        List<AnalysisSearchItemDTO> resp = analysisRepo.findByType(type)
                .stream().map(anl -> new AnalysisSearchItemDTO(anl))
                .collect(Collectors.toList());
        Collections.reverse(resp);
        return resp;
    }
}
