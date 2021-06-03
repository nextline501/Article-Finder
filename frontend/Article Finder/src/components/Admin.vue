<template>
<div class="container">


    <div class="form-group shadow " id="textAreaForm">
      <div class="container" id="titleDescr">
      <h4>Admin</h4>
      <h5>Add article to database</h5>
      </div>
        <div class="form-group row" id="adminForm">
    <label for="inputTitle" class="col-sm-1 col-form-label">Title</label>
    <div class="col-sm">
      <input class="form-control p-2 mb-4" id="inputTitle" placeholder="Article Title">
    </div>
            <div class="form-group row">
    <label for="inputURL" class="col-sm-1 col-form-label">URL</label>
    <div class="col-sm">
      <input class="form-control p-2 mb-4" id="inputURL" placeholder="Article URL">
    </div>
    </div>
    
    </div>
      
      <div class="container d-grid gap-2" id="buttonArea">
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



#labelText{
  text-align: left;
}

#titleDescr{
  margin-bottom: 40px;
}

label{
  font-size: 18px;

}

button{
  border: 0px;
  border-radius: 15px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease 0s;
  padding: 10px;
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

  font-size: 28px;   
  font-weight: bold;
}

#textAreaForm{
  margin-top: 40px;
  border: 1px solid rgb(223, 223, 223);
  border-radius: 20px;
  padding: 40px;
}

#buttonArea{
  margin-bottom: 40px;
}

#inputTitle{
  
}


</style>