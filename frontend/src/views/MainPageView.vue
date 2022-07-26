<template>
  <v-app>
    <!-- 상단 탭: 문제/문제집, 정보 -->
    <v-container class="mt-2 white mb-5">
      <v-row class="bottom-line justify-center mt-5 mx-5">
        <v-col cols="6" class="tab-hover">
          <p class="text-center mb-0 font-weight-bold text-grey">문제/문제집</p>
        </v-col>
        <v-col cols="6" class="tab-hover">
          <p class="text-center mb-0 font-weight-bold text-grey">정보</p>
        </v-col>
      </v-row>
    </v-container>

    <!-- 메인 피드 1. -- 문제/문제집 -->
    <v-container>
      <recent-problem></recent-problem>
    </v-container>

    <!-- 메인 피드 2. -- 정보 -->
    <v-container>
      <info></info>
    </v-container>
      
    
  </v-app>
</template>

<script>
import RecentProblem from '../components/MainPage/RecentProblem.vue'
import info from '../components/MainPage/info.vue'

export default {
  components : {
    RecentProblem,
    info,
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
</style>