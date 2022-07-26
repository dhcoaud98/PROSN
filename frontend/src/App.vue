<template>
  <div class="bg-grey">
    <v-container>
      <v-row>
        <v-col cols="3">
          <nav-bar></nav-bar>
        </v-col>
        <v-col cols="6">
          <main-page-view></main-page-view>
        </v-col>
        <v-col cols="3">
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
  </div>
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
