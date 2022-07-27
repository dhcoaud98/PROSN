<template>
  <v-app class="bg-grey">
    <v-container>
      <!-- sm 이하일 때 로고 나오도록 -->
      <v-row>
        <v-col class="d-flex d-sm-none">
          <v-img src="./assets/prosn_logo.png" max-width="200px" max-height="50px" class="mb-1"></v-img>
        </v-col>
      </v-row>

      <v-row>
        <v-col xl="3" lg="3" md="3" sm="3" class="d-none d-sm-flex">
          <nav-bar></nav-bar>
        </v-col>
        <!-- sm일 때 위에 로고 뜨고 아래에 네비게이션 바 보이게 -->
        <v-col xl="6" lg="6" md="9" sm="9">
          <main-page-view></main-page-view>
          <bottom-nav-bar class="d-flex d-sm-none"></bottom-nav-bar>
        </v-col>
        <v-col xl="6" lg="3" class="d-none d-lg-block">
          <side-bar></side-bar>
        </v-col>
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
import BottomNavBar from './components/BottomNavBar.vue'
import SideBar from './components/SideBar.vue'
import MainPageView from './views/MainPageView.vue'


export default {
  name: 'App',


  data: () => ({
    //
  }),
  components : {
    NavBar,
    BottomNavBar,
    SideBar,
    MainPageView,
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
