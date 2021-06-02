<template>
  <div class ="container-fluid">
    <div class="col">
      <h4>Similar articles</h4>
      <div v-for="(article,i) in similarArticles" :key="i">
        <router-link to="/Summary" @click="setCurrentArticle(similarArticles[i].article)" class="nav-link">
          {{similarArticles[i].article.title}}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import DataServices from '../services/DataServices';

export default {
    name: "ReadingTips",

    computed: {
      similarArticles(){
        return this.$store.state.similarArticles;
      }
    },
    methods: {
      setCurrentArticle(article){
        this.$store.commit('setCurrentArticle', article);
        this.$store.commit('setSimilarArticles', [])
        this.sendArticleId(article)
      },
      sendArticleId(article){
      DataServices.sendArticleId(article.id.toString()).then(response => {
        console.log(response)
        this.storeResponse = response.data.result;
        // This can't be used for render since it will take a couple of seconds to
        // for data to come. Maybe with actions (async ability) it will handle the delay??
        this.$store.commit("setSimilarArticles", response.data.result)
      });
    },
    }
  
}
</script>

<style scoped>

h4{
  margin-top: 20px;
}

div{
  margin-left: 50px;
}

</style>