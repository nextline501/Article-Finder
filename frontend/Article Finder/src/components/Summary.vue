<template>
<div>
  <h1>Summaries</h1>
  <p>{{summary}}</p>
  
</div> 
</template>

<script>

export default {
  name:"Summary",

  computed: {
    summary(){
      return this.$store.state.articles[0].summary
    }
  },
  

  methods: {
    getArticleData(){
      DataServices.getSummarizedArticle().then(response => {
        this.SummarizedArticle = response.data;
      })
    }
  }

}
</script>

<style>

</style>