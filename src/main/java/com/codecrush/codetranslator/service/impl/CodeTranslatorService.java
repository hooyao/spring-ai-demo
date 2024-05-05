package com.codecrush.codetranslator.service.impl;

import com.codecrush.codetranslator.dto.TranslateCodeResponseDto;
import com.codecrush.codetranslator.service.ICodeTranslatorService;
import com.codecrush.codetranslator.service.ProgrammingLanguage;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeTranslatorService implements ICodeTranslatorService {

    private final ChatClient chatClient;

    @Autowired
    public CodeTranslatorService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public TranslateCodeResponseDto translateCode(String code, ProgrammingLanguage from, ProgrammingLanguage to) {
        // https://docs.spring.io/spring-ai/reference/api/output-parser.html#_example_usage
        // BeanOutputParser is used to format the LLM output to a specific bean format
        BeanOutputParser<TranslateCodeResponseDto> translateCodeDtoBeanOutputParser =
                new BeanOutputParser<>(TranslateCodeResponseDto.class);

        String promptString = """
                Please convert the given {from} code to {to}
                ```{from}
                {originalCode}
                ```
                {format}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptString);
        promptTemplate.add("from", from.toString());
        promptTemplate.add("to", to.toString());
        promptTemplate.add("originalCode", code);
        promptTemplate.add("format", translateCodeDtoBeanOutputParser.getFormat());

        promptTemplate.setOutputParser(translateCodeDtoBeanOutputParser);

        ChatResponse response = chatClient.call(promptTemplate.create());
        return translateCodeDtoBeanOutputParser.parse(response.getResult().getOutput().getContent());
    }
}
