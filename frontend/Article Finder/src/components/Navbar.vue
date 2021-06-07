<template>
  <nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">
        <img
          src="/logo-dark.png"
          alt=""
          width="30"
          height="24"
          class="d-inline-block align-text-top"
        />
        Article Finder
      </a>
      <span>
        <router-link to="/admin" class="nav-link">ADMIN</router-link></span
      >
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
};
</script>

<style scoped>
a {
  font-weight: 300;
  font-family: "Playfair Display", serif;
  font-size: 25px;
}

nav {
  -webkit-box-shadow: 0 8px 6px -6px rgb(124, 124, 124);
  -moz-box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
  box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
}

img {
  margin-right: 5px;
}

.nav-link {
  text-decoration: none;
  color: rgb(255, 255, 255);
  font-family: "Open Sans", serif;
  font-size: 18px;
  margin-right: 20px;
}
.nav-link:hover {
  color: #00bfa5;
}
</style>
