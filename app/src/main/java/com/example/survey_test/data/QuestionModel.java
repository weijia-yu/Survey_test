package com.example.survey_test.data;

public class QuestionModel {
    private final int id;

    private final String question;

    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public QuestionModel(int id, String question) {
        this.id = id;
        this.question = question;
    }
}
