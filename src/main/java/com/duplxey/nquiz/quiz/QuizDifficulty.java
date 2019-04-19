package com.duplxey.nquiz.quiz;

public enum QuizDifficulty {
    EASY(0),
    MEDIUM(1),
    HARD(2),
    EXTREME(3),
    ;

    private int level;

    QuizDifficulty(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
