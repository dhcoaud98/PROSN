<template>
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <v-div class="color-FAF0F3 feed-width mx-auto border-a-10">
      <v-col cols="12">
        <v-card class="px-5" color="#FAF0F3">
          <v-row>
            <!-- 문제 대표 이미지 -->
            <v-col cols="1" class="pb-2 pt-5"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>
            <!-- 문제 태그, 문제 제목 --> 
            <v-col cols="9" class="pl-5">
              <v-col cols="12" class="pa-0 mb-1">
                <h4>8/19 넥슨 기술 면접 스터디원 구함</h4>
              </v-col>
              <v-col cols="12" class="problem_title pa-0 pt-1">
                인원 : 오채명, 남성은, 임지민, 박성은, 정여명, 고유라
              </v-col>
            </v-col>
            <v-col cols="2" class="problem_detail">
              자세히 보기 >
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-div>

</template>

<script>
export default {

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