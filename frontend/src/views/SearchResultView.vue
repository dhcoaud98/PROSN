<template>
    <v-row>
      <!-- col 1: 메인 피드 부분 -->
      <v-col cols="12" md="8" class="mt-2 white">
        
        <!-- row 1-1: 검색 결과에 대해 데이터를 받아옴.(채명) -->
        <v-row>
          <search-bar>
          </search-bar>
          <h1 class="result ml-5" style="color:#A384FF">
            {{ inputChange }}
          </h1> 
          <v-col>
            <span class="pt-5">에 대한 결과 입니다.</span>
          </v-col>

        </v-row>
        <v-divider></v-divider>

        <!-- row 1-2: 검색 결과에 대한 상단 탭; 문제/문제집, 정보 -->
        <v-row class="bottom-line justify-center mt-5 mx-5">
          <v-col xl="4" lg="6" md="6" sm="6" class="tab-hover clicked-main-tab" @click="changeToProblemFeed" id="problemTab">
            <p class="text-center mb-0 font-weight-bold text-grey font-parent-mid">문제/문제집</p>
          </v-col>
          <v-col xl="4" lg="6" md="6" sm="6" class="tab-hover" @click="changeToInfoFeed" id="infoTab">
            <p class="text-center mb-0 font-weight-bold text-grey font-parent-mid">정보</p>
          </v-col>
        </v-row>

        <!-- row 1-3: 피드 컨텐츠 부분 -->
        <v-row>
          <!-- 메인 피드 1. -- 문제/문제집 -->
          <v-col>
            <recent-problem id="problemFeed" :class="`${problemFeedClass}`"></recent-problem>
      
            <!-- 메인 피드 2. -- 정보 -->
            <info id="infoFeed" :class="`${infoFeedClass}`"></info>
          </v-col>
        </v-row>
      </v-col>

      <!-- col 2: 사이드 바 -->
      <v-col md="4" class="d-md-flex d-md-none grey lighten-4">
        <side-bar></side-bar>
      </v-col>
    </v-row>
</template>

<script>
import SideBar from '@/components/SideBar.vue'
import SearchBar from '@/components/SearchBar.vue'
import RecentProblem from '@/components/MainPage/RecentProblem.vue'
import Info from '@/components/MainPage/info.vue'
import { mapGetters } from 'vuex';

export default {
  name: 'SearchResultView',
  components: {
    SideBar,
    SearchBar,
    RecentProblem,
    Info,
  },
  data() {
    return {
      fab: false,
      hidden: false,
      tabs: null,
      input: '',
      feedFlag: 0,
      problemFeedClass: 'd-flex',
      infoFeedClass: 'd-none',
    }
  },
  computed: {
    // activeFab () {
    //   switch (this.tabs) {
    //     case 'one': return { page: '1' }
    //     case 'two': return { page: '2' }
    //     default: return {}
    //   }
    // },
    isSearched() {
      return this.$store.getters['problem/isSearched']
    },
    inputChange() {
      return this.$store.getters['problem/inputChange']
    }
  },
  methods: {
    // onInputChange: function(inputData) {
    //   // console.log(inputData)
    //   this.input = inputData
    // },
    changeToProblemFeed() {
      this.feedFlag = 0
      // console.log(this.feedFlag)
       // 2. 해당 탭에 불 들어오게
        const problemTab = document.querySelector('#problemTab')
        const infoTab = document.querySelector('#infoTab')
        problemTab.classList.add("clicked-main-tab")
        // console.log(problemTab.classList)
        if(infoTab.classList.length > 6){
          infoTab.classList.remove("clicked-main-tab")
        }
        this.problemFeedClass ='d-flex'
        this.infoFeedClass = 'd-none'
    },
    changeToInfoFeed() {
      this.feedFlag = 1
      // console.log(this.feedFlag)

      const problemTab = document.querySelector('#problemTab')
      const infoTab = document.querySelector('#infoTab')
      infoTab.classList.add("clicked-main-tab")
        // console.log(infoTab.classList)
        if(problemTab.classList.length > 6){
          // console.log('hi')
          problemTab.classList.remove("clicked-main-tab")
        }
        this.problemFeedClass ='d-none'
        this.infoFeedClass = 'd-flex'
    },
  }
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
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }
  

</style>