<template>
<div class="container" id="summaryContainer">
  <div class="col">
    <div class="row" id="titleColumn">
      <h4>{{currentArticle.title}}</h4>
    </div>
    <div class="col" id="summaryColumn">
        <p id="summaryArea"> {{currentArticle. summary}}  </p>
    </div>
  </div>
    <!-- <div class="col">
      <div class="row" id="readingTips"><ReadingTips></ReadingTips></div> 
    </div>-->
     <div class="row-1"><a :href="currentArticle.path" target="_blank"><button class="btn-dark">VIEW FULL VERSION</button></a></div>
  </div>



</template>

<script>
  import ReadingTips from "./ReadingTips.vue"
  
export default {
  name: "Summary",

  computed: {
    currentArticle(){
      return this.$store.state.currentArticle;
    },
  },
  
  methods: {
    getArticleData(){
      DataServices.getSummarizedArticle().then(response => {
        this.SummarizedArticle = response.data;
      })
    }
  },
  components: {
    ReadingTips
  }

}
</script>

<style scoped>


h4{
  float: left;
  margin-top: 40px;
  font-size: 30px;
  font-weight: bold;
}


button{
  margin-top: 20px;
  font-size: 12px;
  border: 0px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  padding: 15px;
  font-family: 'Open Sans', sans-serif;
  float: left;
  margin-bottom: 20px;

}

button:hover{
  border: 0px;
  background-color: #00bfa5;
  box-shadow: 0px 15px 20px rgba(78, 78, 78, 0.4);
  color: #fff;
}

#summaryArea{
  margin-top: 20px;
  margin-right: 60px;

}

#summaryColumn{
  text-align: left;
}

#titleColumn{
  text-align: left;
}

.nav-link{
  float: left;
}

#readingTips{
  text-align: left;
}

#summaryContainer{
  margin: 20px;
}









</style>