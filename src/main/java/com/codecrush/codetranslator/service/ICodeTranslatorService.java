package com.codecrush.codetranslator.service;

import com.codecrush.codetranslator.dto.TranslateCodeResponseDto;

public interface ICodeTranslatorService {
    TranslateCodeResponseDto translateCode(String code, ProgrammingLanguage from, ProgrammingLanguage to);
}
