<template>
  <v-app class="app">
    <v-container>
      <v-row>
        <nav-bar></nav-bar>
        <h1>메인 넣자</h1>
        <h3>대신 메인은 width 지정해야할 듯ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅊㄴㅇ</h3>
        <side-bar></side-bar>
      </v-row>
    </v-container>
    <!-- <div class="nav">
      <nav-bar></nav-bar>
    </div>
    <div class="side">
      <side-bar></side-bar>
    </div> -->
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

<style scoped>
.app{
  height: 700px;
}
/* .nav{
  position: sticky; 
  float: left;
}
.side{
  float: right;
} */


</style>
