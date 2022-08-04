<template>
  <v-container>
    <!-- 
      v-for 사용하기 
      - note center에서 어떤 것이 선택됐는 지 toDB 받아와서 그것에 맞게 쿼리 보내기
      - 상세페이지로 이동
    -->
    <router-link to="/createnote" class="text-decoration-none">
      <note-list-items></note-list-items>
    </router-link>

    <v-div class="text-center">
      <v-pagination
        v-model="page"
        :length="5"
        color="#A384FF"
        class="mt-3"
      ></v-pagination>
    </v-div>
  </v-container>
</template>

<script>
import NoteListItems from '@/components/Note/NoteListItems.vue'

export default {
  data () {
    return {
      page: 1,
    }
  },
  components :{
    NoteListItems,
  }
}
</script>

<style>

</style>