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
            <td>{{dataFromServer[i].article.title}}</td>
            <td><a v-bind:href="''+dataFromServer[i].article.path+''">{{dataFromServer[i].article.path}}</a></td>
            <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
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
  color: rgb(0, 0, 238);
}
.nav-link:hover{
  color:darkblue;
}

</style>
