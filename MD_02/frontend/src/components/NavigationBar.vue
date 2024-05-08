<template>
    <div class = "navBar"> 
        <ul>
            <li><router-link to="/">HOME</router-link></li>
            <li><router-link to="/driver">DRIVER</router-link></li>
        </ul>
    </div>
</template>

<script>
export default {
  name: 'NavigationBar',
  components: {

  }
}
</script>

<style>
.navBar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
}

.navBar li {
  float: left;
}

.navBar li a {
  display: block;
  padding: 8px;
  background-color: #181818;
}

.navBar a{
    font-weight: bold;
    text-decoration: none;
    color: #FFFFFF;
}

.navBar a.router-link-exact-active{
    color: #8840fc;
}
</style>