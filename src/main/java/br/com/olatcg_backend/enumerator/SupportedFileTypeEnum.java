package br.com.olatcg_backend.enumerator;

public enum SupportedFileTypeEnum {
    TEXT_PLAIN("text/plain");

    private String code;

    SupportedFileTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static SupportedFileTypeEnum getEnumByCode(String code){
        for(SupportedFileTypeEnum type: SupportedFileTypeEnum.values()){
            if(type.getCode().equals(code)){
                return type;
            }
        }
        return null;
    }
}
