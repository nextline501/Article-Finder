<template>
  <div>
    <div v-if="!submitted">

      <textarea 
        placeholder="Text" 
        class="ArticleTextFeed"
        id="ArticleTextFeed"
        required v-model="textFeedModel.textFeed"
        name="ArticleTextFeed"
      ></textarea>

      <button id="postArticleText" @click="createArticleText" class="postArticleText">Post</button>
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
          articleText: this.textFeedModel.textFeed,
        }

        DataServices.sendArticleText(articleData).then(response => {
          console.log(response);
        })
      }
    }, 

  }
</script>

<style scoped>

h1{
  color: #42b983;
}

.ArticleTextFeed {
  height:400px;
  width:600px;
}

</style>
