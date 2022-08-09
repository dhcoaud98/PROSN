<template>
  <v-card outlined class="rounded-xl card-component">
    <v-card-title class="d-flex justify-space-between mx-3 mt-1">
      <!-- 문제냐 정보글이냐에 따라 변경 -->
      <div class="d-flex align-center font-weight-regular grey--text" style="font-size: 1em">
        <v-icon color="#F355F6" class="me-2">mdi-circle</v-icon><p class="mb-0">I N F O</p></div>
      <div class="mt-1">
        <v-chip color="#A384FF" class="white--text ms-3">알고리즘</v-chip>
        <v-chip color="#A384FF" class="white--text ms-3">네트워크</v-chip>
      </div>
    </v-card-title>

    <v-divider class="mx-5" color="#817EF4"></v-divider>

    <v-card-text>
      <v-row class="pa-0 ma-3">
        <div class=" card-title text-purple">제목제목제목</div>
      </v-row>

      <v-row class="pa-0 ma-4 mt-5 black--text font-weight-medium">
        <div style="font-size: 1.2em">
          간장공장공장장은 강공장장이고 된장 공장공장장은 공공장장이다. 경찰청 쇠창살은 외쇠창살이고 검찰청 쇠창살을 쌍쇠창살이다.
        </div>
      </v-row>

      <v-row class="d-flex justify-end ma-4">
        <div class="me-4 mb-3" style="font-size: 1.2em">Created By. 아무개</div>
      </v-row>

      <v-row class="ma-3">
        <v-btn elevation="3" large rounded width="100%" height="50px">
          <div class="show-up-btn font-weight-regular">
            SHOW INFO
          </div>
        </v-btn>

      </v-row>
    </v-card-text>


  </v-card>

    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <!-- <v-card class="color-FAF0F3 feed-width mx-auto border-a-10"> -->
      <!-- 문제/문제집 -->
      <!-- <v-col cols="12">
        <h3>문제/문제집</h3>
      </v-col>
      <v-col cols="12" class="mb-2">
        <v-card class="px-5" color="#FAF0F3">
          <v-row> -->
            <!-- 문제 대표 이미지 -->
            <!-- <v-col cols="1" class="pb-2 pt-5"><v-icon middle color="green darken-2">mdi-domain</v-icon></v-col> -->
            <!-- 문제 태그, 문제 제목 --> 
            <!-- <v-col cols="9" class="pl-5">
              <v-col cols="12" class="pa-0 mb-1">
                <span class="category-tag text-center pa-1">#알고리즘</span>
                <span class="category-tag text-center pa-1">#네트워크</span>
              </v-col>
              <v-col cols="12" class="problem_title pa-0 pt-1">
                하드 디스크 (20)
              </v-col>
            </v-col>
            <v-col cols="2" class="problem_detail">
              더보기 >
            </v-col>
          </v-row>
        </v-card>
      </v-col>
      <v-container class="text-center ">
        <v-pagination
          v-model="page1"
          :length="5"
          color="#A384FF"
        ></v-pagination>
      </v-container>
      <br>
      <v-divider color="#FAF0F3"></v-divider> -->
      <!-- <br> -->
      <!-- IT 정보 -->
      <!-- <v-col cols="12"> -->
        <!-- <h3>IT 정보</h3> -->
      <!-- </v-col> -->
      <!-- <v-col cols="12" class="mb-2"> -->
        <!-- <v-card class="px-5" color="#FAF0F3"> -->
          <!-- <v-row> -->
            <!-- 스크랩 제목, 첫번째 스크랩 제목 --> 
            <!-- <v-col cols="10" class="pl-5">
              <v-col cols="12" class="pa-0 ma-0 mb-1"> -->
                <!-- 카테코리 for문 사용하기-->
                <!-- <span class="category-tag text-center pa-1">#알고리즘</span>
                <span class="category-tag text-center pa-1">#네트워크</span>
                <span class="pa-1">네트워크란 무엇인가?</span>
              </v-col>
              <v-col cols="12" class="my_it pa-0 pt-1">
                하나에 내 하나에 하나에 계절이 어머님...
              </v-col>
            </v-col>
            <v-col cols="2" class="problem_detail">
              펼쳐보기 >
            </v-col>
          </v-row>
        </v-card>
      </v-col>
      <v-container class="text-center">
        <v-pagination
          v-model="page2"
          :length="5"
          color="#A384FF"
        ></v-pagination>
      </v-container>
    </v-card> -->

</template>

<script>
export default {
  data () {
    return {
      page1: 1,
      page2: 2,
    }
  },
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
  border-radius: 10px;
  border: 1px solid #E7C0F4;
  background-color: #E7C0F4;
  font-size: 1px;
  color: white;
  font-weight: bold;
  height: 10px;
  margin: 1px;
}
.problem_detail {
  font-size: 0.5px;
  text-align: right;
}
.problem_title {
  font-size: 2px;
  font-weight: bold;
}
.my_it {
  font-size: 2px;
  font-weight: bold;
}
.card-title {
  font-size: 2em;
  font-weight: medium;
}
.text-purple {
  color: #774BFA;
}
.show-up-btn {
  color: #774BFA;
  font-size: 1.7em;
}
</style>