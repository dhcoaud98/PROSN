<template>
  <!-- 상단 탭: 문제/문제집, 정보 -->
  <v-container fluid class="mt-2 white">
    <v-row class="bottom-line justify-center mt-5 mx-5">
      <v-col  xl="6" lg="6" md="6" sm="6" class="tab-hover">
        <p class="text-center mb-0 font-weight-bold text-grey">문제/문제집</p>
      </v-col>
      <v-col xl="6" lg="6" md="6" sm="6" class="tab-hover">
        <p class="text-center mb-0 font-weight-bold text-grey">정보</p>
      </v-col>
    </v-row>

    <!-- 메인 피드 1. -- 문제/문제집 -->
      <recent-problem></recent-problem>

    <!-- 메인 피드 2. -- 정보 -->
      <info></info>
  </v-container>
      
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
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }
</style>