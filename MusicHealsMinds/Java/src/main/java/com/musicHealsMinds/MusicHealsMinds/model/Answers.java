package com.musicHealsMinds.MusicHealsMinds.model;

public class Answers {
    private int answerId;
    private int questionId;
    private String answer;

    //do we need this since it is in the other class?
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answers (int answerId, int questionId, String answer){
        this.answerId = answerId;
        this.questionId = questionId;
        this.answer = answer;
    }
    public Answers(){

    }


}
