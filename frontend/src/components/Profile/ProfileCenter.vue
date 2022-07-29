<template>
  <v-container class="mt-2 white mb-5">
    <!-- 1. 프로필 상단 -->
    <v-row class="justify-center mt-10 mx-5 mb-0">
      <!-- 뱃지, 이름 -->
      <v-col cols="3" class="rank_box d-flex justify-center py-0">
        <p class="font-weight-bold text-grey ma-0">Prosn</p>
      </v-col>
      <v-col cols="8" class="pa-0 pl-3">
        <p class="font-weight-bold text-grey ma-0">오채명</p>
      </v-col>
      <v-col cols="1" class="pa-0">
        <v-icon>mdi-plus</v-icon>
      </v-col>

      <v-col cols="3">
        <v-avatar size="100px" class="d-flex justify-center">
          <img src="https://avatars0.githubusercontent.com/u/9064066?v=4&s=460">
        </v-avatar>
      </v-col>

      <v-col cols="9">
        <v-container class="detail">
          <p class="detail_text ma-0 text-bold">문제 풀이 - 500</p>
          <p class="detail_text ma-0">문제 제출 - 300</p>
          <p class="detail_text">정답률 ----- 68%</p>
        </v-container>
      </v-col>
      
      <v-col cols="12">
          <!-- lg 사이즈 이하에서는 태그 사라짐 -->
          <!-- 카테고리 개수 따라서 col바뀌도록 바인딩하기 :class="col-n 이런 식" -->
          <span class="category-tag text-center pa-1">#알고리즘</span>
          <span class="category-tag pa-1">#최고</span>
          <span class="category-tag pa-1">#CS</span>
          <span class="category-tag pa-1">#어려워</span>
          <span class="category-tag pa-1">#배고파</span>
      </v-col>

    </v-row>

    <!-- 2. 프로필 하단 -->
    <v-row class="profile_tab d-flex justify-center mt-10 mx-5 mb-0">
      <v-toolbar dark tabs flat color="#A384FF" class="toolbar" height="45px">
        <template>
          <v-tabs v-model="tabs">
            <v-col>
              <v-tab class="pa-0" href="#one">문제 풀이 현황</v-tab>
            </v-col>
            <v-col>
              <v-tab class="pa-0" href="#two">스크랩</v-tab>
            </v-col>
            <v-col>
              <v-tab class="pa-0" href="#three">내가 쓴 게시글</v-tab>
            </v-col>
            <v-tabs-slider color="#A384FF"></v-tabs-slider>
          </v-tabs>
        </template>
      </v-toolbar>
      <v-card-text>
        <v-tabs-items v-model="tabs">
          <v-tab-item v-for="content in ['one', 'two', 'three']" :key="content" :value="content">
          </v-tab-item>
        </v-tabs-items>
      </v-card-text>
        <solved-problem-list></solved-problem-list>
        <!-- {{ activeFab.page }} -->
    </v-row>
  </v-container>
</template>

<script>
import SolvedProblemList from "./SolvedProblemList.vue"

export default {
  name: 'ProfileCenter',
  components: {
    SolvedProblemList,
  },
  data () {
    return {
      ranking : [
        {rank_name: 'Prosn', rank_color: 'rgb(142,68,173)', rank_solve_problem: 1000},
        {rank_name: 'Master', rank_color: 'rgb(231,76,60)', rank_solve_problem: 500},
        {rank_name: 'Gold', rank_color: 'rgb(255, 215, 0)', rank_solve_problem: 200},
        {rank_name: 'Silver', rank_color: 'rgb(192, 192, 192)', rank_solve_problem: 100},
        {rank_name: 'Bronze', rank_color: 'rgb(176, 141, 87)', rank_solve_problem: 50},
        {rank_name: 'Green', rank_color: 'rgb(0, 128, 0)', rank_solve_problem: 10},
        {rank_name: 'Seed', rank_color: 'rgb(0, 207, 87)', rank_solve_problem: 0},
      ],
      fab: false,
      hidden: false,
      tabs: null,
    }
  },
  computed: {
    activeFab () {
      switch (this.tabs) {
        case 'one': return { page: 'SolvedProblemList' }
        case 'two': return { page: 'ScrapPostList' }
        case 'three': return { page : 'MyPostList' }
        default: return {}
      }
    },
  },
}
</script>


<style>
.rank_box{
  border-radius: 10px;
  border: 1px solid rgb(142, 68, 173);
  background-color: rgb(142, 68, 173);
  height: 25px;
  width: 20px;
}
.rank {
  font-size: 18px;
  color: white;
  font-weight: bold;
}
.v-application--wrap {
  max-width: none;
}
.category-tag {
  border-radius: 20px;
  border: 1px solid #A384FF;
  background-color: #A384FF;
  font-size: 5px;
  color: white;
  font-weight: bold;
  height: 25px;
  margin: 1px;
}
.detail{
  border-radius : 5px;
  border: 1px dashed #000000;
  height : 100px;
}
.detail_text {
  font-size: 16px;
  font-weight: 500;
}
</style>

