<template>
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <v-container class="color-FAF0F3 feed-width mx-auto border-a-10">
      <v-col cols="12">
        <v-card class="px-5" color="#FAF0F3">
          <v-row>
            <!-- 스크랩 제목, 첫번째 스크랩 제목 --> 
            <v-col cols="10" class="pl-5">
              <v-col cols="12" class="pa-0 mb-1">
                <h4>네트워크 모음집</h4>
              </v-col>
              <v-col cols="12" class="problem_title pa-0 pt-1">
                하나에 내 하나에 하나에 계절이 어머님...
              </v-col>
            </v-col>
            <v-col cols="2" class="problem_detail">
              더보기 >
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-container>

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