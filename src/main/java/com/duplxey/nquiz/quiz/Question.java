package com.duplxey.nquiz.quiz;

public class Question {

    private String text;
    private Answer[] answers;

    public Question(String text, Answer[] answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}
