package com.codecrush.codetranslator.dto;

import com.codecrush.codetranslator.service.ProgrammingLanguage;

public class TranslateCodeRequestDto {
    private String originalCode;
    private ProgrammingLanguage from;
    private ProgrammingLanguage to;

    public TranslateCodeRequestDto(String code, ProgrammingLanguage from, ProgrammingLanguage to) {
        this.originalCode = code;
        this.from = from;
        this.to = to;
    }

    public String getOriginalCode() {
        return originalCode;
    }

    public ProgrammingLanguage getFrom() {
        return from;
    }

    public ProgrammingLanguage getTo() {
        return to;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    public void setFrom(ProgrammingLanguage from) {
        this.from = from;
    }

    public void setTo(ProgrammingLanguage to) {
        this.to = to;
    }
}
