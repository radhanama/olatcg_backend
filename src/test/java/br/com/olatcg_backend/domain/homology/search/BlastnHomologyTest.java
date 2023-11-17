package br.com.olatcg_backend.domain.homology.search;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

public class BlastnHomologyTest {

    @Test
    public void execute_ValidInput_ReturnsHomologyList() {
        List<SequenceIdPair> sequenceIdPairList = createDummySequenceIdPairList();
        BlastnHomology blastnHomology = new BlastnHomology(sequenceIdPairList, 1, 1);

        blastnHomology.search();
    }

    @Test
    public void JSONStringToVo_ValidJson_ReturnsHomologyList() {
        String validJson = "{\"blastOutputs\": [{\"results\": {\"search\": {\"hitVos\": [{}]}}}] }";
        BlastnHomology blastnHomology = new BlastnHomology(new ArrayList<>(), 1, 1);

        List<Homology> result = blastnHomology.JSONStringToVo(validJson);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Add more specific assertions based on your expected output
    }

    //@Test
    //public void hitVoToDomain_ValidHitVo_ReturnsHomology() {
    //    HitVo validHitVo = new HitVo();
    //    validHitVo.setNum(1);
    //    validHitVo.setLen(100);
//
    //    BlastnHomology blastnHomology = new BlastnHomology(new ArrayList<>(), 1, 1);
    //    Homology result = blastnHomology.hitVoToDomain(validHitVo);
//
    //    assertNotNull(result);
    //    // Add more specific assertions based on your expected output
    //}

    // Add more test cases to cover different scenarios

    private List<SequenceIdPair> createDummySequenceIdPairList() {
        List<SequenceIdPair> sequenceIdPairList = new ArrayList<>();
        // Create dummy SequenceIdPair objects and add them to the list
        return sequenceIdPairList;
    }
}
