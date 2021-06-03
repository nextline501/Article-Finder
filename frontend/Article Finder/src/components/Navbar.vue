<template>
  <nav class="navbar navbar-dark bg-dark" >
  <div class="container-fluid">
    <a class="navbar-brand" href="/">
      <img src="/logo-dark.png" alt="" width="30" height="24" class="d-inline-block align-text-top"> Article Finder </a>
    <span class="navbar-text">Login</span>
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
  font-weight: 300;
  font-family: 'Playfair Display', serif;
  font-size: 25px;
}
.navbar-text{
  font-weight: 300;
  margin-right: 20px;
  font-size: 20px;
  font-weight: 300;
  font-family: 'Playfair Display', serif;
}

nav{
  -webkit-box-shadow: 0 8px 6px -6px rgb(124, 124, 124);
  -moz-box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
  box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
}

img{
  margin-right: 5px;
}

</style>