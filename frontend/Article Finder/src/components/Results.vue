<template>
<div>
  <h4>Matches</h4>
  <table class="table">
  <thead class="shadow p-3 mb-5">
    <tr>
      <th scope="col"></th>
      <th scope="col">Title</th>
      <th scope="col">Link</th>
    </tr>
  </thead>
  <tbody>
    
    <tr>
      <th scope="row">1</th>
      <td>{{ dataFromServer[0].article.title }}</td>
      <td><a v-bind:href="''+dataFromServer[0].article.path+''">{{ dataFromServer[0].article.path }}</a></td>
      <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
    </tr>

    <tr>
      <th scope="row">2</th>
      <td>{{ dataFromServer[1].article.title }}</td>
      <td><a v-bind:href="''+dataFromServer[1].article.path+''">{{ dataFromServer[1].article.path }}</a></td>
      <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
    </tr>

    <tr>
      <th scope="row">3</th>
      <td>{{ dataFromServer[2].article.title }}</td>
      <td><a v-bind:href="''+dataFromServer[2].article.path+''">{{ dataFromServer[2].article.path }}</a></td>
      <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
    </tr>

    <tr>
      <th scope="row">4</th>
      <td>{{ dataFromServer[3].article.title }}</td>
      <td><a v-bind:href="''+dataFromServer[3].article.path+''">{{ dataFromServer[3].article.path }}</a></td>
      <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
    </tr>
    
    <tr>
      <th scope="row">5</th>
      <td>{{ dataFromServer[4].article.title }}</td>
      <td><a v-bind:href="''+dataFromServer[4].article.path+''">{{ dataFromServer[4].article.path }}</a></td>
      <!--<router-link to="/Summary" class="nav-link">{{ dataFromServer[0].article.path }}</router-link>-->
    </tr>

  </tbody>
</table>
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
