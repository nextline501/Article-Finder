<template>
<div class="container-fluid">
  <div class="row">
    <div class="col-1">
      <router-link to="/results" class="nav-link">
        <button class="btn-dark">←</button>
      </router-link>
    </div>
    <div class="col-11">
      <h4>{{title}}</h4>
    </div>
  </div>
  <div class="row">
    <div class="col-8">
      <p id="summaryArea">Lorem ipsum dolor sit amet consectetur adipisicing elit. Non ipsa veniam, ex officiis aliquam iste esse itaque provident optio aspernatur quia est temporibus quas eius obcaecati reprehenderit nemo odio deleniti? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ullam in consequatur libero modi cumque, animi facilis et maxime ut corporis omnis praesentium? Quis vitae cupiditate voluptatibus, veniam dicta ex tenetur.</p>
    </div>
    <div class="col-2">
        <div class="row"><ReadingTips></ReadingTips></div>
    </div>
     <a href="https://www.diva-portal.org/smash/get/diva2:858003/FULLTEXT01.pdf" target="_blank"><div class="row-1"><button class="btn-dark">FULL VERSION</button></div></a>
  </div>
</div>



</template>

<script>
  import ReadingTips from "./ReadingTips.vue"
  
export default {
  name: "Summary",

  computed: {
    summary(){
      return this.$store.state.articles[0].summary
    },
    title(){
      return this.$store.state.articles[0].title
    }
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


h1{
  float: left;
}


button{
  margin-top: 20px;
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







</style>