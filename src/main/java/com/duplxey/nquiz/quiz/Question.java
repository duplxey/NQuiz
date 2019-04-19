package com.duplxey.nquiz.quiz;

public class Question {

    private String text;
    private Answer[] answers;
    private int correct;

    public Question(String text, Answer[] answers, int correct) {
        this.text = text;
        this.answers = answers;
        this.correct = correct;
    }

    public boolean isCorrect(int i) {
        return i == correct;
    }

    public String getText() {
        return text;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public int getCorrect() {
        return correct;
    }
}
