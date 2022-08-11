<template>
  <v-container class="ma-0 pa-0">
    <v-row class="d-flex mt-5 ms-5">
      <v-icon large color="#926DFF">groups</v-icon>
      <h2 class="ms-3 dark--text">S T U D Y</h2>
    </v-row>    
    
    <v-row>
        <!-- 1. 프로필 상단 -->
        <v-row class="justify-center mt-10 mx-5 mb-0 ">
          <!-- 뱃지, 이름 -->
          <v-col cols="3" class="rank_box d-flex justify-center py-0">
            <p class="font-weight-bold text-grey ma-0 white--text">Prosn</p>
          </v-col>
          <v-col cols="8" class="pa-0 pl-3">
            <p class="font-weight-bold text-grey ma-0">오채명</p>
          </v-col>
          <v-col cols="1" class="pa-0">
            <!-- <v-img src="@/assets/account-multiple-plus.png" sm class="ma-0" id="mainPage" type="button" @click="event()"></v-img> -->
            <!-- <v-icon type="button" @click="event()"></v-icon> -->
            <span class="material-icons" type="button" @click="event()" style="color:#A384FF">group_add</span>

          </v-col>

          <v-col cols="3">
            <v-avatar size="100px" class="d-flex justify-center ml-3">
              <img src="data:image/jpeg;base64,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">
            </v-avatar>
          </v-col>

          <v-col cols="9">
            <v-container class="">
              <p class="detail_text ma-0">문제 풀이 500문제</p>
              <p class="detail_text ma-0">문제 제출 300문제</p>
              <p class="detail_text ma-0">정답률 68%</p>
            </v-container>
          </v-col>
          
          <v-col cols="12" class="pl-0">
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
          <v-toolbar dark tabs flat color="#ffffff" class="toolbar" height="45px">
            <template>
              <v-tabs v-model="tabs">
                <v-col>
                  <v-tab class="pa-0 tab--text" href="#one">스터디 구하기</v-tab>
                </v-col>
                <v-col>
                  <v-tab class="pa-0 tab--text" href="#two">나의 스터디</v-tab>
                </v-col>
                <v-tabs-slider color="#A384FF"></v-tabs-slider>
              </v-tabs>
            </template>
          </v-toolbar>
        
          <!-- <v-card-text class="d-flex ma-0">
            <v-tabs-items v-model="tabs">
              <v-tab-item v-for="content in ['one', 'two', 'three']" :key="content" :value="content">
              </v-tab-item>
            </v-tabs-items>
          </v-card-text> -->
          
          <v-container class="ma-0 pa-0" v-if="activeFab.page === '1'">
            <study-list></study-list>
          </v-container>
          <v-container class="ma-0 pa-0" v-if="activeFab.page === '2'">
            <my-study-list></my-study-list>
          </v-container>

        </v-row>
    </v-row>
  </v-container>
</template>

<script>
import StudyList from "./StudyList.vue"
import MyStudyList from "./MyStudyList.vue"
import router from "@/router"


export default {
  name: 'ProfileCenter',
  components: {
    StudyList,
    MyStudyList,
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
      pass: '',
    }
  },
  computed: {
    activeFab () {
      switch (this.tabs) {
        case 'one': return { page: '1' }
        case 'two': return { page: '2' }
        default: return {}
      }
    },
  },
  methods:{
    event () {
      router.push({ path: 'createstudy' })
    }
  }
}
</script>


<style>
.rank_box{
  border-radius: 10px;
  border: 1px solid rgb(142, 68, 173);
  background-color: rgb(142, 68, 173);
  height: 25px;
  width: 80%;
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
.tab--text {
  color: #000000 !important;
}
</style>

