<template>
<div class ="matches">
  <h4>Matches</h4>

    <tr v-for="article in $store.state.articles" :key="article.title">{{Articles.title}}
    <th scope="row">{{i+1+"."}}</th>

  </tr>

</div>

</template>

<script>

export default {
 name: "Matches",

 computed: {
   Articles(){
    return this.$store.state.articles;
    },
  },
}

</script>

<style>

</style>