<template>
  <div id="app">
    <img alt="Music Heals Minds logo" src="./assets/MHMlogo.png">
    <HelloWorld msg="Music Heals Minds Trivia Game"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #521961;
  margin-top: 60px;
}
img {
  width: 10%;
  height: auto;
}

</style>
