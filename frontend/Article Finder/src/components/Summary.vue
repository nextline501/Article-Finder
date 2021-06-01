<template>
<div class="container-fluid">
  <div class="row">
    <div class="col-3">
      <router-link to="/results" class="nav-link">
        <button class="btn-dark">BACK</button>
      </router-link>
    </div>
    <div class="col-9" id="titleColumn">
      <h4>{{currentArticle.title}}</h4>
    </div>
  </div>
  <div class="row">
    <div class="col" id="summaryColumn">
        <p id="summaryArea"> {{currentArticle. summary}}  </p>
    </div>
    <div class="col">
        <div class="row" id="readingTips"><ReadingTips></ReadingTips></div>
    </div>
     <a href="https://www.diva-portal.org/smash/get/diva2:858003/FULLTEXT01.pdf" target="_blank"><div class="row-1"><button class="btn-dark">VIEW FULL VERSION</button></div></a>
  </div>
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

.nav-link{
  float: left;
}

#readingTips{
  border-left: 1px solid lightgrey;
  text-align: left;
}

.container-fluid{
  margin: 30px;
}








</style>