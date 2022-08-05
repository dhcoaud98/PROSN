<template>
  <!-- 전체적인 틀 -->
  <v-container fluid class="white">
    <!-- 문제 정보 -->
    <v-row class="align-center mx-5 mt-5 color-FAF0F3 border-a-10 px-4">
      <v-col cols="1"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>
        <v-col>
          <v-row class="align-center">
            <v-col cols="3" class="pa-0">
              <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#컴퓨터구조</span>
              <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#CS</span>
            </v-col>
            <v-col class="pa-0">
              <span class="font-parent-mid-l font-weight-bold mr-3">하드 디스크</span>
              <span>(
                <span class="red--text font-weight-bold">5</span>/<span class="font-weight-bold">20</span>
              )</span>
            </v-col>
          </v-row>
          
        </v-col>
    </v-row>

    <!-- 문제 부분 -->
    <v-row class="mt-0">
      <problem-book-list></problem-book-list>
    </v-row>
  </v-container>
</template>

<script>
import ProblemBookList from '@/components/ProblemBook/ProblemBookList.vue'

export default {
  components: {
    ProblemBookList,
  }
}
</script>

<style>

</style>