<template>
  <nav>
    <NavigationBar/>
  </nav>
  <router-view/>
</template>

<script>
import NavigationBar from "./components/NavigationBar.vue";
export default {
  components: {
    NavigationBar
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #FFFFFF;
}

body {
  background-color: #212121;  
  margin: 0px;

}

nav {
  background-color: #181818;
}


</style>
