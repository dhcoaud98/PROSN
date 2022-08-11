<template>
  <v-container>
    <my-study-list-items v-for="(study, idx) in studys" :key="idx" :study="study"></my-study-list-items>
    <br>  
    <v-pagination
      v-model="nowPage"
      :length="endPage"
      color="#A384FF"
      circle
      @input="handlePage()"
    ></v-pagination>
  </v-container>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'
import MyStudyListItems from "./MyStudyListItems.vue"

export default {
  name: 'StudyList',
  components: {
    MyStudyListItems,
  },
  data () {
    return {
      value: null,
      nowPage: 1,
      endPage: 4,
      myStudys: [],
      page: 0,
    }
  },
  // created() {
  //   // 0811 오채명
  //   // 나의 스터디 조회하기
  //   const params = {
  //     page: 0,
  //     size: 5,
  //   }
  //   axios({
  //     url: drf.study.study() + 'me',
  //     method: 'get',
  //     headers: {
  //       Authorization : this.accessToken,
  //     },
  //     params: params
  //   })
  //   .then(res => {
  //     console.log(res.data)
  //     this.myStudys = res.data
  //   })

  // },
  methods: {

  },
}
</script>

<style>

</style>