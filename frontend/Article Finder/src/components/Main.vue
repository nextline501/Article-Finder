<template>


  <div>
    <div v-if="!submitted">

      <div class="form-group">

        <label for="textArea">Input</label>
        <textarea 
          placeholder="Input text that you want to match" 
          class="form-control rounded-10"
          rows="15"
          id="textArea"
          required v-model="textFeedModel.textFeed"
          name="form-control rounded-10">
        </textarea>

        <div class="d-grid gap-2">

          <button id="postArticleText" 
            @click="createArticleText" 
            type="button" 
            class="btn btn-dark btn-elegant btn-rounded" 
          >Submit</button>

        </div>
      </div>
    </div>
  </div>

</template>

<script>
  import "../services/DataServices";
  import DataServices from '../services/DataServices';

  export default {
    name: "Main",

    data() {
      return {
        textFeedModel: {
          textFeed: "", 
        }
      }
    },

    methods: {
      createArticleText(){
        let articleData = {
          searchText: this.textFeedModel.textFeed,
        }
        
        DataServices.sendArticleText(articleData).then(response => {
          console.log(response);
        })
      }
    }, 

  }
</script>

<style scoped>

.form-group{
  width: 95%;
  float: none;
  margin-left: 20px;
}

label{
  font-size: 20px;
  margin-top: 30px;
  margin-bottom: 15px;
  float: left;
}

button{
  margin-top: 20px;
}

textarea{
  margin-top: 30px;
}

</style>
