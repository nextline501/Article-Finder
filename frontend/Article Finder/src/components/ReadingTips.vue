<template>
<div>
  <h4>Similar articles</h4>
  <ul>{{title}}</ul>
  <ul>{{title}}</ul>

</div>
</template>

<script>

export default {
    name: "ReadingTips",

    computed: {
       title(){
      return this.$store.state.articles[0].title
    }
  }
}
</script>

<style scoped>

h4{
  margin-top: 20px;
}

</style>