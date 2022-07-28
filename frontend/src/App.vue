<template>
  <v-app class="bg-grey">
    <login-view></login-view>


    <!-- <div class="nav">
      <nav-bar></nav-bar>
    </div>
    <div class="side">
      <side-bar></side-bar>
    </div> -->
  </v-app>
</template>

<script>
//import NavBar from './components/NavBar.vue'
//import BottomNavBar from './components/BottomNavBar.vue'
//import SideBar from './components/SideBar.vue'
//import MainPageView from './views/MainPageView.vue'
// import ProfilePageView from './views/ProfilePageView.vue'
import LoginView from './views/LoginView.vue'


export default {
  name: 'App',


  data: () => ({
    //
  }),
  components : {
    //NavBar,
    //BottomNavBar,
    //SideBar,
    //MainPageView,
    // ProfilePageView,
    LoginView,
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
/* .container에 최대 최소길이가 묶여있어서 마진이 많이 생겨서 조절해줌 */
.container {
  max-width: 1300px;
  min-width: none;
  /* border: 1px solid black; */
}
.bg-grey {
  background-color: #f5f5f5;
}

</style>
