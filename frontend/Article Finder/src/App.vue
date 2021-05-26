<template>

  <Navbar></Navbar>
  
  <div class="container-fluid">
  <div class="row">
    <div class="col-sm">
      <Main></Main>
    </div>
    <div class="col-sm">
      <Results ></Results>
    </div>
  </div>
</div>


  
</template>

<script setup>
import Main from './components/Main.vue'
import Navbar from './components/Navbar.vue'
import Results from './components/Results.vue'

// This starter template is using Vue 3 experimental <script setup> SFCs
// Check out https://github.com/vuejs/rfcs/blob/script-setup-2/active-rfcs/0000-script-setup.md
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Julius+Sans+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600&display=swap');


#app {
  font-family: 'Open Sans', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}





</style>
