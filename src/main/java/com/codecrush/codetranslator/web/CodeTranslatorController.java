package com.codecrush.codetranslator.web;

import com.codecrush.codetranslator.dto.TranslateCodeRequestDto;
import com.codecrush.codetranslator.dto.TranslateCodeResponseDto;
import com.codecrush.codetranslator.service.impl.CodeTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai")
public class CodeTranslatorController {
    private final CodeTranslatorService codeTranslatorService;

    @Autowired
    public CodeTranslatorController(CodeTranslatorService codeTranslatorService) {
        this.codeTranslatorService = codeTranslatorService;
    }

    @PostMapping("/code")
    public ResponseEntity<TranslateCodeResponseDto> generatePoetry(
            @RequestBody TranslateCodeRequestDto requestDto
    ) {
        return ResponseEntity.ok(
                this.codeTranslatorService.translateCode(
                        requestDto.getOriginalCode(), requestDto.getFrom(), requestDto.getTo()));
    }
}
