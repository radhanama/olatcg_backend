package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.service.PhylogenyService;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.PhylogenyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhylogenyController {

    @Autowired
    private PhylogenyService phylogenyService;

    @PostMapping(Routes.PHYLOGENY_API + "/getNewickFromTaxonomy")
    public PhylogenyResponseDTO getNewickFormatFromTaxonomy(@RequestParam Long idAnalysis) throws CustomException {
        return phylogenyService.getNewickFormatFromTaxonomy(idAnalysis);
    }
}
