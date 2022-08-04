<template>
  <!-- 전체적인 틀 -->
  <v-container fluid class="white">
    <!-- 문제 정보 -->
    <v-row class="align-center">
      <v-col cols="1"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>
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

    <!-- 문제 부분 -->
    <v-row>
      <create-note-list></create-note-list>
    </v-row>
  </v-container>
</template>

<script>
import CreateNoteList from '@/components/Note/CreateNoteList.vue'
export default {
  components: {
    CreateNoteList,
  }
}
</script>

<style>

</style>