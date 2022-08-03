<template>
  <!-- studylistitems 복붙 0803 임지민 -->

  <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <v-div class="color-FAF0F3 mx-auto border-a-10">
      <v-col cols="12">
        <v-card class="px-5" color="#FAF0F3">
          <v-row class="align-center">
            <!-- col 1: 문제 대표 이미지 -->
            <v-col cols="2"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>

            <!-- col 2: 문제 태그, 문제 제목 --> 
            <v-col class="pb-0">
              <v-row>
                <span class="category-tag text-center pa-1 mr-2 font-parent-xsml">#네트워크</span>
                <span class="category-tag text-center pa-1 mr-2 font-parent-xsml">#알고리즘</span>
              </v-row>
              <v-row>
                <span class="font-parent-mid-l font-weight-bold mr-2">HTTP 포트</span>
                <p>(
                  <span class="red--text font-weight-bold">5</span>/<span class="font-weight-bold">10</span>
                )</p>
              </v-row>
              
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
.font-parent-xsml {
  font-size: 0.1em;
}
</style>