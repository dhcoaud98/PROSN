<template>
  <!-- <v-app :class="bgColor" @resize="selectBgColor"> -->
  <v-app :class="bgColor" @resize="selectBgColor">
    <v-container>
      <!-- sm 이하일 때 로고 나오도록 -->
      <v-row class= "d-flex d-md-none pb-0 justify-space-between px-5">
        <v-col class="d-flex d-md-none pb-0">
          <router-link to="/">
            <v-img src="./assets/prosn_logo.png" max-width="150px" max-height="50px"></v-img>
          </router-link>
        </v-col>
        <v-col class="d-flex d-md-none">
          <search-bar></search-bar>
        </v-col>
      </v-row>

      <v-row class="mt-0">
        <v-col cols="2" :class="`${navDisplayCol}`">
          <nav-bar id="navBarTag" :class="navDisplay"></nav-bar>
        </v-col>

        <v-col class="pt-0">
          <!-- url이 변경됨에 따라 계속 바뀌는 위치(0729 임지민) -->
          <!-- router/index.js에서 정의한 components의 컴포넌트를 띄워줌(0801 임지민) -->
          <router-view></router-view>

        <!-- sm 이하 일때: 아래 쪽에 네비게이션 바 -->
          <bottom-nav-bar class="d-flex d-md-none"></bottom-nav-bar>
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
import NavBar from '@/components/NavBar.vue'
import BottomNavBar from '@/components/BottomNavBar.vue'
import SideBar from '@/components/SideBar.vue'
import MainPageView from '@/views/MainPageView.vue'
import SearchBar from '@/components/SearchBar.vue'
// import { mapGetters, mapState } from 'vuex'


export default {
  name: 'App',

  data () {
    return{
      bgColor: 'bg-grey',
      navDisplay: 'd-flex',
      navDisplayCol: 'd-md-flex d-none',
    }
  },
  components : {
    NavBar,
    BottomNavBar,
    SideBar,
    MainPageView,
    SearchBar,
  },
  watch: {
    /* 0805 임지민
      login, signup일 때는 navbar 안띄움
      아래 created까지 써줘야 새로 고침하면 navbar가 생기는 현상이 사라짐
    */
    $route(to) {
      // console.log(to) // 도착지 login
      // console.log(from) // 출발지 signUp
      // .v-application .d-sm-flex
      // const hiddenClass = document.querySelector('.v-application')
      if(to.name === 'login' || to.name === 'signUp') {
        this.navDisplay = 'd-none'
        this.navDisplayCol = 'd-none'

      } else {
        this.navDisplay = 'd-flex'
        this.navDisplayCol = 'd-md-flex d-none'
      }
      
      // 안보일 때는 router-view의 cols를 12로 하기
      },
    },
    methods: {
      /*selectBgColor(){      
        // sm 이하에서는 배경색 흰색으로 바꾸기
        if (screen.innerWidth < 960){
          console.log('sml')
          this.bgColor = "white"
        } else {
          this.bgColor = "bg-grey"
        } 
      }, */
    },
    created() {
      // if($vuetify.breakpoint.sm) {console.log(true)}
        let currentUrl = location.href
        if (currentUrl.endsWith('login') || currentUrl.endsWith('signup')) {
          this.navDisplay = 'd-none'
          this.navDisplayCol = 'd-none'
        } else {
          this.navDisplay = 'd-flex'
          this.navDisplayCol = 'd-none d-md-flex'
        }
    
    },
  
  } 
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