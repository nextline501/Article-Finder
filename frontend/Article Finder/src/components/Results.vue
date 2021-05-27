<template>
  <h4>Your matches</h4>
  <table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Title</th>
      <th scope="col">Summary</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>{{articles[0].title}}</td>
      <td>{{articles[0].path}}</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Article 2</td>
      <td>DOCX</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Article 3</td>
      <td>HTML</td>
    </tr>
  </tbody>
</table>
</template>

<script>
export default {
  data(){
     name: "Results"
  },
  computed: {
    articles(){
      return this.$store.state.articles
    }
  }
}
</script>

<style scoped>
h4{
  margin-top: 30px;
  font-size: 25px;
  float: left;
}

</style>


