<template>
<div>
  <h4>Matches</h4>
  <div> 
    <template v-if="!dataFromServer.length">
      <p>No matches found on your search</p>
    </template>
    <template v-else>
      <table class="table">
        <thead class="shadow p-3 mb-5">
          <tr>
            <th scope="col"></th>
            <th scope="col">Title</th>
            <th scope="col">Link</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(article,i) in dataFromServer" :key="i">
            <th scope="row">{{i+1}}</th>
            <td>
              <router-link to="/Summary" @click="setCurrentArticle(dataFromServer[i].article)" class="nav-link">{{ dataFromServer[i].article.title }}</router-link>
            </td>
            <td><a class="nav-link" v-bind:href="''+dataFromServer[i].article.path+''">FULL VERSION</a></td>
            <!---->
          </tr>
        </tbody>
      </table>
    </template>
  </div>
</div>
</template>

<script>
export default {
  name: "Results",

  computed: {
    articles(){
      return this.$store.state.articles
    }
  },
  methods: {
    setCurrentArticle(article){
      this.$store.commit('setCurrentArticle', article);
    }
  },

  props: [
    'dataFromServer'
  ]
}
</script>

<style scoped>
h4{
  margin-top: 30px;
  font-size: 22px;
  float: center;
  margin-bottom: 20px;
  font-weight: bold;
  font-family: 'Playfair Display', serif;
}

thead{
  background: rgb(42, 44, 46);
  color: white;
}

.nav-link{
  text-decoration: none;
  color: black;
}
.nav-link:hover{
  color:#00bfa5;
}

table{
  text-align: left;
}

</style>
