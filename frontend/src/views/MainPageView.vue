<template>
  <v-container fluid class="pa-0 pt-0 pt-md-10 mt-0">
    <!-- row 1: 메인 피드와 sidebar 모두를 감싸는 줄 -->
    <v-row v-if="!isSearched">
      <!-- col 1: 메인 피드 부분 -->
      <v-col cols="12" md="7" lg="8" class="mt-0 mt-md-2 white pt-0 px-0 rounded-lg">
        <!-- row 1-1: 상단 탭; 문제/문제집, 정보 -->
        <v-row class="d-flex mt-8 ms-8">
          <img src="@/assets/prosn_logo_sm.png" alt="..." class="small-logo">
          <h2 class="ms-3 dark--text font-weight-regular">F E E D</h2>
        </v-row>    


        <v-toolbar dark class="mt-10 mx-4">
          <v-tabs background-color="#CCA5FE" grow>
            <v-tab class="pa-0" @click="changeToProblemFeed" id="problemTab">
              <p class="font-weight-regular text-center mb-0" style="font-size: 1.2rem">Problem / Book</p>
            </v-tab>
              
            <v-tab class="pa-0" @click="changeToInfoFeed" id="infoTab">
              <p class="font-weight-regular text-center mb-0" style="font-size: 1.2rem">INFORMATION</p>
            </v-tab>         
          </v-tabs>
        </v-toolbar>

        <!-- row 1-2: 피드 컨텐츠 부분 -->
        <v-row>
          <!-- 메인 피드 1. -- 문제/문제집 -->
          <v-col>
            <recent-problem id="problemFeed" :class="`${problemFeedClass}`" :mainProbs="mainProbs"></recent-problem>
      
            <!-- 메인 피드 2. -- 정보 -->
            <info id="infoFeed" :class="`${infoFeedClass}`" :mainInfos="mainInfos"></info>
          </v-col>
        </v-row>
      </v-col>

      <!-- col 2: 사이드 바 -->
      <v-col md="5" lg="4" class="d-md-flex d-none grey lighten-4">
        <side-bar></side-bar>
      </v-col>
    </v-row>

    <!-- row 2: 메인 피드와 sidebar 모두를 감싸는 줄 (검색 결과가 있을 경우 검색 페이지) -->
    <v-row v-if="isSearched">
      <search-result-view ></search-result-view>
    </v-row> 
  
  </v-container>
      
</template>

<script>
import RecentProblem from '../components/MainPage/RecentProblem.vue'
import info from '../components/MainPage/info.vue'
import SideBar from '@/components/SideBar.vue'
// import problem from '@/store/modules/problem'
import SearchResultView from '@/views/SearchResultView.vue'
import InfiniteLoading from 'vue-infinite-loading'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  name: 'MainPageView',
  data(){
    return {
      feedFlag: 0,
      problemFeedClass: 'd-flex',
      infoFeedClass: 'd-none',
      mainInfos : [],
      mainProbs: [],
    }
  },
  components : {
    RecentProblem,
    info,
    SideBar,
    SearchResultView,
    InfiniteLoading,
  },
  computed : {
    isSearched() {
      return this.$store.getters['problem/isSearched']
    }
  },
  methods : {
    changeToProblemFeed() {
      this.feedFlag = 0
      // console.log(this.feedFlag)
       // 2. 해당 탭에 불 들어오게
        const problemTab = document.querySelector('#problemTab')
        const infoTab = document.querySelector('#infoTab')
        // problemTab.classList.add("clicked-main-tab")
        // console.log(problemTab.classList)
        if(infoTab.classList.length >= 5){
          // infoTab.classList.remove("clicked-main-tab")
        }
        this.problemFeedClass ='d-flex'
        this.infoFeedClass = 'd-none'
    },
    changeToInfoFeed() {
      this.feedFlag = 1
      // console.log(this.feedFlag)

      const problemTab = document.querySelector('#problemTab')
      const infoTab = document.querySelector('#infoTab')
      // infoTab.classList.add("clicked-main-tab")
        // console.log(infoTab.classList)
        if(problemTab.classList.length >= 5){
          // console.log('hi')
          // problemTab.classList.remove("clicked-main-tab")
        }
        this.problemFeedClass ='d-none'
        this.infoFeedClass = 'd-flex'
    },
  },
  created() {
      axios({
        url: drf.postFeed.information(),
        method: 'get',
      })
      .then(res => {
        this.mainInfos = res.data.content
      })
      .catch(err => {
        console.log(err);
      })

    
      axios({
        url: drf.postFeed.problem(),
        method: 'get',
      })
      .then(res => {
        this.mainProbs = res.data.content
      })
      .catch(err => {
        console.log(err);
      })
    },
}
</script>

<style>
  .bottom-line {
    border-bottom: #a384ff 3px solid;
  }
  .v-application--wrap {
  max-width: none;
  }
  
  /* before로 색을 지정해주니까 hover 했을 때 색이 흰색으로 정상적으로 바뀜 */
  .tab-hover::before {
    color: #616161;
  }
  :hover.tab-hover,
  .clicked-main-tab
   {
    background: #a384ff;
    color: white;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: pointer;
  }
  .border-white {
    border: 1px solid white;
  }
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }
  

  /* 2022.08.02. 커스텀 스크롤바 */
  /* 필요한 다른 view에서 가져다 쓰면 됨 */
  ::-webkit-scrollbar {
      width: 8px;  /* 스크롤바의 너비 */
  }

  ::-webkit-scrollbar-thumb {
      height: 30%; /* 스크롤바의 길이 */
      background: #A384FF; /* 스크롤바의 색상 */

      border-radius: 10px;
  }

  ::-webkit-scrollbar-track {
      background: rgba(172, 35, 252, 0.2);  /*스크롤바 뒷 배경 색상*/
  }
  .small-logo {
    height: 40px;
    width: 40px;
  }  
</style>
