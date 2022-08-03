<template>
  <v-container>
    <!-- 
      v-for 사용하기 
      - note center에서 어떤 것이 선택됐는 지 toDB 받아와서 그것에 맞게 쿼리 보내기
    -->
    <note-list-items></note-list-items>

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