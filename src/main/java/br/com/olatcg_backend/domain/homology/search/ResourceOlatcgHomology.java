package br.com.olatcg_backend.domain.homology.search;

import lombok.Getter;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class ResourceOlatcgHomology {

    public static Map<String, String> taxonomyMap;
    public static List<SequenceIdPair> targetSequenceList;

    public ResourceOlatcgHomology() {
        taxonomyMap = initializeTaxonomyMap();
        targetSequenceList = initializeTargetSequenceList();
    }

    public static Map<String, String> initializeTaxonomyMap() {
        Map<String, String> taxMap = new HashMap<>();

        InputStream taxonomyListBytes = getFileBytes("taxonomyList.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(taxonomyListBytes))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                String id = parts[0];
                String value = parts[1];
                taxMap.put(id, value);
            }

            return taxMap;
        } catch (IOException e) {
            throw new RuntimeException("Can't read taxonomy list");
        }
    }

    public static List<SequenceIdPair> initializeTargetSequenceList() {
        List<SequenceIdPair> targetList = new ArrayList<>();

        InputStream sequenceList = getFileBytes("sequenceList.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(sequenceList))) {
            String line;
            String id = null;
            String sequence = null;
            while ((line = reader.readLine()) != null) {

                Pattern pattern = Pattern.compile("(>\\S+)|([ATCG]+)", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);

                // Find and add the ID and value parts
                while (matcher.find()) {
                    id = matcher.group(1) != null ? matcher.group(1).replace(">", "") : id;
                    sequence = matcher.group(2) != null ? matcher.group(2) : sequence;
                }

                if(id != null && sequence != null) {
                    targetList.add(new SequenceIdPair(id, sequence));
                    id = null;
                    sequence = null;
                }
            }

            return targetList;

        } catch (Exception e) {
            throw new RuntimeException("Can't convert file to sequence list");
        }
    }

    public static InputStream getFileBytes(String fileName) {
        try {
            ClassPathResource resource = new ClassPathResource("olatcg/" + fileName);
            return resource.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in resource folder: " + fileName);
        }
    }
}
