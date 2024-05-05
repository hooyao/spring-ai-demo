package com.codecrush.codetranslator.service;

public enum ProgrammingLanguage {
    Php("php"),
    Python("python"),
    Golang("golang"),
    Rust("rust"),
    CSharp("csharp"),
    Cpp("cpp"),
    C("c programing language"),
    Java("java");

    private final String language;

    private ProgrammingLanguage(String language) {
        this.language = language;
    }

    public String toString() {
        return this.language;
    }
}
