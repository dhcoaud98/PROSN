<template>
  <v-app class="bg-grey">
    <v-container>
      <v-row>
        <v-col xl="3" lg="3" md="3" sm="1" class="d-none d-md-flex">
          <nav-bar></nav-bar>
        </v-col>
        <!-- sm일 때 위에 로고 뜨고 아래에 네비게이션 바 보이게 -->
        <v-col xl="6" lg="6" md="9" sm="11">
          <main-page-view></main-page-view>
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
import SideBar from './components/SideBar.vue'
import MainPageView from './views/MainPageView.vue'

export default {
  name: 'App',


  data: () => ({
    //
  }),
  components : {
    NavBar,
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
