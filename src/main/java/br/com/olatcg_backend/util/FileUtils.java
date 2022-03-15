package br.com.olatcg_backend.util;

import br.com.olatcg_backend.domain.BiologicalSequence;
import br.com.olatcg_backend.domain.Taxonomy;
import br.com.olatcg_backend.domain.vo.DecodedFileVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.enumerator.SupportedFileTypeEnum;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FileUtils {

    private static final Pattern patternDataFromUrl = Pattern.compile("([data:A-z]*\\/[A-z]*)(;base64,)([A-z0-9]*)");

    public String generateEncodedFastaFileFrom(List<Taxonomy> taxonomies) {
        String fileContent = "";
        for(Taxonomy tax: taxonomies){
            BiologicalSequence bioSeq = tax.getAlignment().getSequenceA();
            fileContent += ">" + bioSeq.getId().toString() + "\n" + bioSeq.getBases() + "\n";
        }
        return Base64.getEncoder().encodeToString(fileContent.getBytes());
    }

    public static DecodedFileVo decodeFile(String encodedFile) throws CustomException {
        try {
            DecodedFileVo decodedFileVo = new DecodedFileVo();
            Matcher matcher = patternDataFromUrl.matcher(encodedFile);
            if(matcher.find()){
                decodedFileVo.setFileType(SupportedFileTypeEnum
                        .getEnumByCode(matcher.group(1).replace("data:", "")));
                String encodedFileContent = matcher.group(3);
                decodedFileVo.setDescodedContent(new String(Base64.getMimeDecoder().decode(encodedFileContent)));
            }
            return decodedFileVo;
        } catch (Exception e){
            throw new CustomException(ErrorEnum.DECODE_FILE_ERROR);
        }
    }
}
