package com.musicHealsMinds.MusicHealsMinds.model;

public class QuestionChoices {
    private int choiceId;
    private String choice1;
    private String choice2;
    private String choice3;
    private int questionId;

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String option2) {
        this.choice2 = choice2;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public QuestionChoices (int choiceId, String choice1, String choice2, String choice3, int questionId){
        this.choiceId = choiceId;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.questionId = questionId;
    }
    public QuestionChoices (){

    }
}
