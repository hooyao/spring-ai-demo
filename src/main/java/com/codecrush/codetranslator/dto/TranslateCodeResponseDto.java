package com.codecrush.codetranslator.dto;

public class TranslateCodeResponseDto {
    private String translatedCode;

    public TranslateCodeResponseDto() {
    }

    public TranslateCodeResponseDto(String code) {
        this.translatedCode = code;
    }

    public String getTranslatedCode() {
        return translatedCode;
    }


    public void setTranslatedCode(String translatedCode) {
        this.translatedCode = translatedCode;
    }
}
