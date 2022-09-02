<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      This is where we will create the trivia game for <br>
      
      <a href="https://www.mhmla.org/" target="_blank" rel="noopener">Music Heals Minds</a>.
    </p>
   
    <h3>Social Media</h3>
    <ul>
      <li><a href="https://www.linkedin.com/company/music-heals-minds/" target="_blank" rel="noopener">Linkedin</a></li>
      <li><a href="https://twitter.com/healsminds" target="_blank" rel="noopener">Twitter</a></li>
      <li><a href="https://www.instagram.com/music.heals.minds/" target="_blank" rel="noopener">Instagram</a></li>
      <li><a href="https://www.facebook.com/Music-Heals-Minds-105089208246110" target="_blank" rel="noopener">Facebook</a></li>
      
    </ul>
    <ul v-for="question in allQuestions" v-bind:key ="question.questionId">
      <li>{{question.question}}</li>
    </ul>
    <form>
    <label for="question">Type your question</label>
    <input type="text" v-model="question.question" /> 
    <button type="submit" v-on:click ="createQuestion()">Submit</button>
    </form>
    <ul v-for="answer in allAnswers" v-bind:key ="answer.answerId">
      <li>{{answer.answer}}</li> 
    </ul>
  
  </div>
</template>

<script>
import QuestionsService from "../services/QuestionsService";
import AnswerService from "../services/AnswerService";
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data(){
    return{
      allQuestions: [], 
      allAnswers: [], //added the answer array with a comma but not sure if its right?
      question:{
        question:""
      }
    }
  },
  created(){
    QuestionsService.getAll().then((response) => {this.allQuestions = response.data;}).catch((error) => {console.error(error+" error in questions ");});
    AnswerService.getAll().then((response) => {this.allAnswers = response.data;}).catch((error) => {console.error(error+"error in answer");}); //added this method?
  },
  methods: {
    createQuestion(){
      const postQuestion = {
        question: this.question.question
      };
      QuestionsService.createQuestion(postQuestion).then((response) => {
        if (response.status === 201){
          alert("Success"); 
          location.reload();
          }
          }).catch((error) => {
            console.error(error + "error in question");
            });
    }
  }
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #b94242;
}
</style>
