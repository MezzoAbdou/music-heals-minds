package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.Answers;

import java.util.List;

public interface AnswersDAO {
    List<Answers> getAllAnswers();
    Answers getAnswer(int answerId);
    void createAnswer(Answers answer);
    Answers updatedAnswer(Answers updatedAnswer);
    void deleteAnswer(int answerId);
}
