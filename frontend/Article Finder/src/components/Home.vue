<template>
  <div class="container-fluid">
  <div class="row">
    <div class="col-sm">
      <Main></Main>
    </div>
    <div class="col-sm">
      <Results ></Results>
    </div>
  </div>
</div>
</template>



<script>

import Results from "./Results.vue"
import Main from "./Main.vue"

export default {
    name: 'Home',

}
</script>

<style >

</style>