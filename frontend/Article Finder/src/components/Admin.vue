<template>
<div class="container">


<h4>Store Article</h4>
    <div class="form-group" id="textAreaForm">
    <div id="labelText">
      <label for="inputTitle" class="col-sm-3 col-form-label">Title</label>
    </div>
      <input class="shadow p-3 mb-4 form-control rounded-10" id="inputTitle" placeholder="Input the desired title of your article">
          <div id="labelText">
      <label for="inputLink" class="col-sm-3 col-form-label">Link</label>
          </div>
      <input class="shadow p-3 mb-4 form-control rounded-10" id="inputLink" placeholder="Input the link for article" >
      <div class="container">
        <button v-if= "!showSpinner" id="postArticleText" @click="createArticleText" class="btn btn-dark btn-rounded" type="button">
          <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-check2-circle" viewBox="0 0 16 16">
  <path d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"/>
  <path d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"/>
</svg> SUBMIT
        </button>

        <button v-else id="postArticleText" class="btn btn-dark btn-rounded"  type="button" disabled>
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
          Processing...
        </button>

      </div>
      </div>
</div>


  
</template>

<script>
import Admin from "./Admin.vue"

export default {
    name: 'Admin',

}
</script>


<style scoped>

#textAreaForm{
  margin: 20px;
  border: 0;
}

#labelText{
  text-align: left;
}



label{
  font-size: 18px;

  font-weight: bold;
}

button{
  margin-top: 0px;
  border: 0px;
  border-radius: 15px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  padding: 15px;
  font-family: 'Open Sans', sans-serif;

}

button:hover{
  border: 0px;
  background-color: #00bfa5;
  box-shadow: 0px 15px 20px rgba(78, 78, 78, 0.4);
  color: #fff;
}


nav-link{
  text-decoration: none;
}

h4{
margin-top: 20px;    
}


</style>