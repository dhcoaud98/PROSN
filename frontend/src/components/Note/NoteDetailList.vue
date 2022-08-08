<template>
  <!-- 작성 완료된 오답노트 0807 임지민 -->
  <v-container fluid class="white">
    <!-- 문제 정보 -->
    <v-row class="align-center mx-5 mt-5 color-FAF0F3 border-a-10 px-4">
      <v-col cols="1"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>
        <v-col>
          <v-row class="align-center">
            <v-col cols="3" class="pa-0">
              <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#네트워크</span>
              <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#알고리즘</span>
            </v-col>
            <v-col class="pa-0">
              <span class="font-parent-mid-l font-weight-bold mr-3">HTTP 포트</span>
              <span>(
                <span class="red--text font-weight-bold">5</span>/<span class="font-weight-bold">10</span>
              )</span>
            </v-col>
          </v-row>
          
        </v-col>
    </v-row>

    <!-- 문제 부분 -->
    <v-row class="mt-0">
      <note-list></note-list>
    </v-row>
  </v-container>
</template>


<script>
import NoteList from '@/components/Note/NoteList.vue'

export default {
  components: {
    NoteList
  },
}
</script>

<style>

</style>