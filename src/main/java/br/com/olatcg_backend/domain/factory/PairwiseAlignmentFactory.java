package br.com.olatcg_backend.domain.factory;

import br.com.olatcg_backend.domain.pairwise.alignment.PairwiseAlignment;
import br.com.olatcg_backend.domain.enumerator.AlignmentTypeEnum;
import io.tej.SwaggerCodgen.model.AlignmentTypeEnumDTO;
import io.tej.SwaggerCodgen.model.PairwiseAlnReqDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PairwiseAlignmentFactory {

    public static PairwiseAlignment build(AlignmentTypeEnumDTO alignmentTypeEnumDTO, PairwiseAlnReqDTO pairwiseAlnReqDTO){
        List<PairwiseAlignment> implementations = findImplementations();
        for(PairwiseAlignment implementation: implementations){
            if(implementation.getType().name().equals(alignmentTypeEnumDTO.name())){
                associateDTOValuesToChoosenImpl(implementation, alignmentTypeEnumDTO, pairwiseAlnReqDTO);
                return implementation;
            }
        }
        throw new IllegalArgumentException("No pairwise alignment implementation found for type " + alignmentTypeEnumDTO);
    }

    private static List<PairwiseAlignment> findImplementations() {
        List<PairwiseAlignment> subclasses = new ArrayList<>();
        Reflections reflections = new Reflections(
                new ConfigurationBuilder().forPackages(
                        PairwiseAlignment.class.getPackage().getName()));
        Set<Class<? extends PairwiseAlignment>> subTypes = reflections.getSubTypesOf(PairwiseAlignment.class);
        for (Class<? extends PairwiseAlignment> subclass : subTypes) {
            try {
                PairwiseAlignment instance = subclass.getDeclaredConstructor().newInstance();
                subclasses.add(instance);
            } catch (Exception e) {
                throw new RuntimeException("Failed to instatiate pairwise alignment implementation: " + subclass.getName(), e);
            }
        }
        return subclasses;
    }

    private static void associateDTOValuesToChoosenImpl(PairwiseAlignment implementation, AlignmentTypeEnumDTO alignmentTypeEnumDTO, PairwiseAlnReqDTO pairwiseAlnReqDTO) {
        implementation.setSequenceA(pairwiseAlnReqDTO.getSequenceA());
        implementation.setSequenceB(pairwiseAlnReqDTO.getSequenceB());
        implementation.setOpenPenalty(pairwiseAlnReqDTO.getOpenPenalty());
        implementation.setExtensionPenalty(pairwiseAlnReqDTO.getExtensionPenalty());
        implementation.setType(AlignmentTypeEnum.valueOf(alignmentTypeEnumDTO.getValue()));
    }
}
