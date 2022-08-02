<template>
  <v-container class="mt-2 white mb-5">
    <v-row class="justify-center mt-10 mx-5">
      <!-- 프로필 사진 -->
      <v-col cols="3 lg-2">
        <v-avatar size="100px" class="d-flex justify-center">
          <img src="https://avatars0.githubusercontent.com/u/9064066?v=4&s=460">
        </v-avatar>
        <!-- 채명: 본인에 대한 태그는 최대 4개를 넘지 않도록!-->
        <!-- lg 사이즈 이하에서는 태그 사라짐 -->
        <v-col cols="12" class="mt-2 d-none d-lg-block">
          <v-row>
            <!-- 카테고리 개수 따라서 col바뀌도록 바인딩하기 :class="col-n 이런 식" -->
            <span class="category-tag text-center pa-1">#알고리즘</span>
            <span class="category-tag pa-1">#최고</span>
            <span class="category-tag pa-1">#CS</span>
            <span class="category-tag pa-1">#어려워</span>
          </v-row>
        </v-col>
      </v-col>
      <!-- 뱃지, 이름 -->
      <v-col cols="9">
        <v-row class="ma-0">
          <v-col class="rank_box" cols="5">
            <!-- 채명 : user 정보에서 문제 푼 갯수 받아서 비교 후 뱃지 색상과 뱃지 글자 정하면 됨. -->
            <p class="rank mb-0">Prosn</p>
          </v-col>
          <v-col cols="5" class="pa-0 pl-4 pt-2">
            <p class="font-weight-bold text-grey">오채명</p>
          </v-col>
          <v-col cols="2" class="pa-0 pl-4 pt-2">
            <!-- 채명 : 정보랑 문제 생성 라우터로 연결, 플러스 버튼 수정-->
            <v-icon>+</v-icon>
          </v-col>            
        </v-row>
        <v-container class="detail">
          <p class="detail_text ma-0 text-bold">문제 풀이 - 500</p>
          <p class="detail_text ma-0">문제 제출 - 300</p>
          <p class="detail_text">정답률 ----- 68%</p>
        </v-container>
      </v-col>
    </v-row>
  </v-container>
  
</template>

<script>
export default {
  name: 'ProfileCenter',
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
      ]
    }
  },
}
</script>


<style>
.rank_box{
  border-radius: 20px;
  border: 1px solid rgb(142, 68, 173);
  background-color: rgb(142, 68, 173);
  height: 40px;
  width: 40px;
  display: flex;
  justify-content: center;
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
  border: 1px solid #a384ff;
  background-color: #a384ff;
  font-size: 5px;
  color: white;
  font-weight: bold;
  height: 25px;
  margin: 1px;
}
.detail{
  border-radius : 5px;
  border: 1px solid #000000;
  height : 100px;
}
.detail_text {
  font-size: 16px;
  font-weight: 500;
}
</style>

