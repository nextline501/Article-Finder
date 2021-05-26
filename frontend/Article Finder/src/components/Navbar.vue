<template>
  <nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="">
      <img src="/logo-dark.png" alt="" width="30" height="24" class="d-inline-block align-text-top"> Article Finder </a>
    <span class="navbar-text">matching your needs</span>
  </div>
</nav>
</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>
a{
  font-family: 'Julius Sans One', sans-serif;
  font-size: 25px;
}
.navbar-text{
  color: rgb(51, 51, 51);
  font-family: 'Montserrat', sans-serif;
  font-weight: 300;
  font-size: 20px;
}

nav{
  -webkit-box-shadow: 0 8px 6px -6px rgb(124, 124, 124);
  -moz-box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
  box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
}

</style>