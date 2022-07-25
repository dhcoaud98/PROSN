<template>
  <v-app>
    <router-view/>
    <nav-bar></nav-bar>
    <side-bar></side-bar>
  </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue'
import SideBar from './components/SideBar.vue'

export default {
  name: 'App',


  data: () => ({
    //
  }),
  components : {
    NavBar,
    SideBar,
  }
};
</script>
