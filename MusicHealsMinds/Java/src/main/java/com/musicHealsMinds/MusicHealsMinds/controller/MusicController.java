package com.musicHealsMinds.MusicHealsMinds.controller;


import com.musicHealsMinds.MusicHealsMinds.dao.AnswersDAO;
import com.musicHealsMinds.MusicHealsMinds.dao.QuestionChoicesDAO;
import com.musicHealsMinds.MusicHealsMinds.dao.QuestionDAO;
import com.musicHealsMinds.MusicHealsMinds.model.Answers;
import com.musicHealsMinds.MusicHealsMinds.model.QuestionChoices;
import com.musicHealsMinds.MusicHealsMinds.model.TriviaQuestion;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class MusicController {
    private QuestionDAO questionDAO;
    private AnswersDAO answersDAO;
    private QuestionChoicesDAO choicesDAO;

    public MusicController (QuestionDAO questionDAO, AnswersDAO answersDAO, QuestionChoicesDAO choicesDAO){
        this.questionDAO = questionDAO;
        this.answersDAO = answersDAO;
        this.choicesDAO = choicesDAO;
    }

    @RequestMapping (value = "/questions", method = RequestMethod.GET)
    public List<TriviaQuestion> getAllQuestions (){
        return questionDAO.getAllQuestions();
    }
    @RequestMapping (value = "/questions/{questionId}", method = RequestMethod.GET)
    public TriviaQuestion getQuestionById (@PathVariable int questionId){
        return questionDAO.specificQuestion(questionId);
    }
    @RequestMapping (value = "/questions", method = RequestMethod.POST)
    public void createQuestion (@RequestBody TriviaQuestion question){
        questionDAO.createQuestion(question);
    }
    @RequestMapping (value = "/answers", method = RequestMethod.GET)
    public List<Answers> getAllAnswers() {
        return answersDAO.getAllAnswers();
    }
    @RequestMapping (value = "/answers/{answerId}", method = RequestMethod.GET)
    public Answers getAnswer (@PathVariable int answerId){
        return answersDAO.getAnswer(answerId);
    }
    @RequestMapping (value = "/choices", method = RequestMethod.GET)
    public List<QuestionChoices> getAllChoices() {return choicesDAO.getAllChoices();}
    @RequestMapping (value = "/choices/{choiceId}", method = RequestMethod.GET)
    public QuestionChoices getChoice(@PathVariable int choiceId){
        return choicesDAO.getChoice(choiceId);
    }
    @RequestMapping (value = "/choices", method = RequestMethod.POST)
    public void createChoice (@RequestBody QuestionChoices questionChoices) { choicesDAO.createChoice(questionChoices);}
}
