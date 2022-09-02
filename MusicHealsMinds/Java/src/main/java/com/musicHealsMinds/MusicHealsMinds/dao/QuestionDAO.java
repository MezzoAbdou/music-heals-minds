package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.TriviaQuestion;

import java.util.List;


public interface QuestionDAO {

    //get all questions
    //get specific question
    //make question
    //updated question
    //delete question
    //CRUD create read update delete

    List<TriviaQuestion> getAllQuestions();
    TriviaQuestion specificQuestion(int questionId);
    void createQuestion(TriviaQuestion question );
    TriviaQuestion updatedQuestion();
    void deleteQuestion();



}
