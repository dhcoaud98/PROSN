<template>
  <v-app>
    <router-view/>
    <nav-bar></nav-bar>
      
  </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue'

export default {
  name: 'App',

  data: () => ({
    //
  }),
  components : {
    NavBar,
  }
};
</script>
