<template>
  <v-container>
    <my-study-list-items v-for="(myStudy, idx) in myStudys" :key="idx" :myStudy="myStudy"></my-study-list-items>
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
import { mapGetters } from 'vuex'

export default {
  name: 'StudyList',
  components: {
    MyStudyListItems,
  },
  data () {
    return {
      value: null,
      nowPage: 1,
      endPage: 1,
      myStudys: [],
      page: 0,
    }
  },
  computed: {
    ...mapGetters(['accessToken']),
  },
  created() {
    console.log("study accessToken",this.accessToken)
    // 0813 오채명
    // 전체 스터디 조회
    // const params = {
    //   page: 0,
    //   size: 5,
    // }
    axios({
      url: drf.study.study() + 'me',
      method: 'get',
      headers: {
        Authorization : this.accessToken,
      },
      // params: params
    })
    .then(res => {
      console.log("res=",res.data.content)
      this.myStudys = res.data.content
      this.endPage = res.data.totalPages
      // console.log("totalPages =",res.data.totalPages)
    })
    .cathch(err => {
      console.log("에러")
      console.log(err)
    })

  },
  methods: {

  },
}
</script>

<style>

</style>