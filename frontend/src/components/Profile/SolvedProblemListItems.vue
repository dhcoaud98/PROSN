<template>
  <v-card outlined elevation="3" class="rounded-xl purple-outlined-card mb-8">
    <!-- 카드 타이틀 (그라데이션 입혀진 부분) -->
    <v-card-title class="pa-0 bg-gradation">
      <v-container class="pa-0">
        <!-- 게시글 제목 / 좋아요와 싫어요 개수 -->

        <v-row class="d-flex justify-space-between ma-3 mt-4">
          <!-- 제목 -->
          <div class="ms-5 d-flex align-center font-weight-regular dark--text" style="font-size: 1.3em; color: #585757;">
            문제 제목
          </div>
          <!-- 좋아요 싫어요 정보 -->
          <div class="d-flex me-3">
            <v-icon class="me-2">thumb_up_off_alt</v-icon>
            <div class="me-3">30</div>
            <v-icon class="me-2">thumb_down_off_alt</v-icon>
            <div class="me-3">4</div>
          </div>
        </v-row>
      </v-container>
    </v-card-title>

    <!-- 카드 본문 -->
    <v-card-text>
      <v-row>
        <!-- v-for문 사용해서 태그 띄우기 -->
        <div class="mt-5">
          <v-chip small color="#926DFF" class="white--text ms-3">알고리즘</v-chip>
          <v-chip small color="#926DFF" class="white--text ms-3">네트워크</v-chip>
        </div>
      </v-row>

      <!-- 내용 -->
      <v-row class="pa-0 ma-4 mx-5 mt-5 black--text font-weight-medium">
        <div class="mb-4" style="font-size: 1.1em">
          문제 메인텍스트
        </div>
      </v-row>

      <v-row class="ma-4 mb-2 d-flex justify-space-between">
        <!-- 출제자 -->
          <div class="me-4 d-flex align-center" style="font-size: 1.2em">Created By. 출제자이름</div>
        <!-- 문제로 이동하기 버튼 -->
          <!-- 화면 사이즈 md 이상 -->
          <v-btn @click='showUp()' text large rounded height="45px" class="d-none d-md-flex">
            <div class="show-up-btn font-weight-regular">SHOW UP</div>
          </v-btn>
          <!-- 화면 사이즈 md 이하 -->
          <v-btn @click='showUp()' text large rounded height="45px" class="d-md-none mt-3" width="100%">
            <div class="show-up-btn font-weight-regular">SHOW UP</div>
          </v-btn>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'SolvedProblemListItems',
  methods: {
    showUp () {
      console.log('어쩌구');
      this.$router.push({ path: 'problem' })
    },
  }
}
</script>

<style>
.feed-width {
    width: auto;
}
.border-a-10 {
  border-radius: 5px;
}
.color-FAF0F3 {
  background-color: #FAF0F3;
}
.category-tag {
  border-radius: 20px;
  border: 1px solid #E7C0F4;
  background-color: #E7C0F4;
  font-size: 3px;
  color: white;
  font-weight: bold;
  height: 20px;
  margin: 1px;
}
.problem_detail {
  font-size: 2px;
  text-align: right;
}
.problem_title {
  font-size: 2px;
}
</style>