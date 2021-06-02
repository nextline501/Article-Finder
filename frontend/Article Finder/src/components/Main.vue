<template>
<div class="container">
  <div v-if="!submitted">
    <div class="form-group" id="textAreaForm">
      <label for="textArea">Match</label>
      <textarea placeholder="Input text that you want to match" 
        class="shadow p-3 mb-5 form-control rounded-10" rows="15" id="textArea" required v-model="textFeedModel.textFeed">
      </textarea>

      <div class="d-grid gap-2">
        <button v-if= "!showSpinner" id="postArticleText" @click="createArticleText" class="btn btn-dark btn-rounded" type="button">
          SUBMIT
        </button>

        <button v-else id="postArticleText" class="btn btn-dark btn-rounded"  type="button" disabled>
          <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
          Processing...
        </button>

      </div>
    </div>
  </div>
  <div v-if="submitted">
    <div>
      <!--<li><a v-bind:href="''+storeResponse+''">{{ storeResponse }}</a></li>-->
      <Results :dataFromServer="storeResponse"/>
    </div>
  </div>
  
</div>
</template>

<script>
  import "../services/DataServices";
  import DataServices from '../services/DataServices';
  import Results from '../components/Results.vue'

  export default {
  components: { Results },
    name: "Main",


    data() {
      return {
        textFeedModel: {
          textFeed: "", 
        }, 
        storeResponse: [],
        submitted: false,
        showSpinner: false
      }
    },

    componets: {
      Results
    },

    methods: {
      createArticleText(){
        
        this.showSpinner = true 
        let articleData = {
          searchText: this.textFeedModel.textFeed,
        }

        DataServices.sendArticleText(articleData.searchText).then(response => {
          console.log(response)
          this.storeResponse = response.data.result;
          // Data will be available later in store, but not direct for render in this event
          this.$store.commit("setArticles", response.data.result)
          this.submitted = true
        });

      }
    },
  }
</script>

<style scoped>

#textAreaForm{
  margin: 20px;
  border: 0;
}

label{
  font-size: 28px;

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

textarea{
  margin-top: 30px;

}

nav-link{
  text-decoration: none;
}



</style>
