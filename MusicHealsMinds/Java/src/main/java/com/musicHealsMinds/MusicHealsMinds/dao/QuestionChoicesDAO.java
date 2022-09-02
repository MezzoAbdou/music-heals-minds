package com.musicHealsMinds.MusicHealsMinds.dao;

import com.musicHealsMinds.MusicHealsMinds.model.QuestionChoices;


import java.util.List;

public interface QuestionChoicesDAO {
    List<QuestionChoices> getAllChoices();
   QuestionChoices getChoice (int choiceId);
   void createChoice(QuestionChoices choice);
   QuestionChoices updatedChoice();
   void deleteChoice();

}
