<template>
  <v-container fluid>
    <!-- row 1: 메인 피드와 sidebar 모두를 감싸는 줄 -->
    <v-row>

      <!-- col 1: 메인 피드 부분 -->
      <v-col cols="12" md="8" class="mt-2 white">
        <!-- row 1-1: 상단 탭; 문제/문제집, 정보 -->
        <v-row class="bottom-line justify-center mt-5 mx-5">
          <v-col xl="4" lg="6" md="6" sm="6" class="tab-hover">
            <p class="text-center mb-0 font-weight-bold text-grey font-parent-mid">문제/문제집</p>
          </v-col>
          <v-col xl="4" lg="6" md="6" sm="6" class="tab-hover">
            <p class="text-center mb-0 font-weight-bold text-grey font-parent-mid">정보</p>
          </v-col>
        </v-row>

        <!-- row 1-2: 피드 컨텐츠 부분 -->
        <v-row>
          <!-- 메인 피드 1. -- 문제/문제집 -->
          <recent-problem></recent-problem>

          <!-- 메인 피드 2. -- 정보 -->
            <info></info>
        </v-row>
      </v-col>

      <!-- col 2: 사이드 바 -->
      <v-col md="4" class="d-md-flex d-md-none grey lighten-4">
        <side-bar></side-bar>
      </v-col>
    </v-row>
  </v-container>
      
</template>

<script>
import RecentProblem from '../components/MainPage/RecentProblem.vue'
import info from '../components/MainPage/info.vue'
import SideBar from '@/components/SideBar.vue'

export default {
  name: 'MainPageView',
  components : {
    RecentProblem,
    info,
    SideBar,
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
  :hover.tab-hover {
    background: #a384ff;
    color: white;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
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
</style>