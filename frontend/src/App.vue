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
        <v-col cols="2" class="d-none d-sm-flex">
          <nav-bar :class="navDisplay" id="navBarTag"></nav-bar>
        </v-col>
        <v-col cols="10">
          <!-- url이 변경됨에 따라 계속 바뀌는 위치(0729 임지민) -->
          <!-- router/index.js에서 정의한 components의 컴포넌트를 띄워줌(0801 임지민) -->
          <router-view></router-view>

        <!-- sm 이하 일때: 아래 쪽에 네비게이션 바 -->
          <bottom-nav-bar class="d-flex d-sm-none"></bottom-nav-bar>
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
// import { mapGetters, mapState } from 'vuex'


export default {
  name: 'App',

  data () {
    return {
      navDisplay: 'd-flex'
    }
  },
  components : {
    NavBar,
    BottomNavBar,
    SideBar,
    MainPageView,
  },
  watch: {
    // url이 바뀔 때마다 감시해서 nav바 상태 바꿔주기
    $route(to, from) {
      //console.log(to) // 도착지
      //console.log(from) // 출발지
      if(to.name === 'login') {
        // 도착지의 name에 해당하는 태그는 clicked-tab을 넣고
        const navBarTag = document.querySelector('#navBarTag')
        navBarTag
        
      }
      // 출발지의 name에 해당하는 태그는 clicked-tab을 빼기
      const fromTag = document.querySelector(`#${from.name}`)
      fromTag.classList.remove('clicked-tab')
    }
  },
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