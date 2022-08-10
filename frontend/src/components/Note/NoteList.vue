<template>
  <v-container>
    <!-- 
      v-for 사용하기 
      - note center에서 어떤 것이 선택됐는 지 toDB 받아와서 그것에 맞게 쿼리 보내기
      - 상세페이지로 이동
    -->
    <!-- 
      to="/note/{id}" : 후에 통신해서 id 받아서 넘기기
     -->
    <note-list-items :beforeProbs="beforeProbs" :afterProbs="afterProbs"></note-list-items>
    <v-row class="text-center justfy-center">
      <v-col>
        <v-pagination
          v-model="page"
          :length="5"
          color="#A384FF"
          class="mt-3"
        ></v-pagination>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import NoteListItems from '@/components/Note/NoteListItems.vue'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  data () {
    return {
      page: 1,
      beforeProbs: [],
      afterProbs: [],
    }
  },
  components :{
    NoteListItems,
  },
  created() {
    }
  }
</script>

<style>

</style>