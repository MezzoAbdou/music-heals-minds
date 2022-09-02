package com.musicHealsMinds.MusicHealsMinds.model;

public class TriviaQuestion {
    private String question;
    private int questionId;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public TriviaQuestion(int questionId, String question ){
        this.questionId = questionId;
        this.question = question;

    }
    public TriviaQuestion(){

    }
}
