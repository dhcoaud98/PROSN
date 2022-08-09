<template>
  <div>
    <v-row class="pa-0 ma-0" rounded>
      <v-col cols="12" class="pa-0">
        <recent-problem-items v-for="(mainProb, idx) in mainProbs" :key="idx" :mainProb="mainProb"></recent-problem-items>
        <v-pagination
          v-model="nowPage"
          :length="endPage"
          color="#A384FF"
          circle
          @input="handlePage()"
        ></v-pagination>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'
import RecentProblemItems from '../MainPage/RecentProblemItems.vue'

export default {
    data() {
      return {
        totalProbs: [],
        mainProbs: [],
        nowPage: 1,
        clickPage: null,
        endPage: 0,
        value: null,
        page: 0,
      }
    },
    components : {
        RecentProblemItems,
    },
    props: {
      mainProbs: Array,
    },
    created() {
      // 1. 페이지 렌더링 될 때 첫번 째 엑시오스
      axios({
        url: drf.api+'post',
        // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함!
        // url: drf.api+'get' + '/probelm',
        method: 'get',
        headers: {
          Authorization: this.accessToken,
        },
      })
        .then(res => {
          this.totalProbs = res.data.content
          console.log(this.totalProbs)
          this.endPage = this.totalProbs.length%4 > 0  ? parseInt(this.totalProbs.length/4) + 1 : this.totalProbs.length/4
        })
      // 2. 페이지 렌더링 될 때 두번 째 엑시오스
      const params = {
        page: 0,
        size: 4, 
        // sort: onUpdated, 'desc'
      } 
      axios({
        url:drf.api+'post',
        // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함
        // url: drf.api + 'post' + '/problem',
        method: 'get',
        headers: {
          Authorization : this.accessToken,
        },
        params: params
        //page=0&size=3&sort=updated,desc
      })
      .then(res => {
        this.mainProbs = res.data.content
        console.log(this.mainProbs)
      })
      .cathch(err => {
        console.log("에러")
        console.log(err)
      })
    },
    methods: {
      handlePage() {
        console.log("event = ", Number(event.target.ariaLabel.slice(-1)))
        this.page = Number(event.target.ariaLabel.slice(-1))

        const params ={
          page: this.page -1,
          size: 4
          //sort: onUpdated, 'desc'
        }
        axios({
          url: drf.api +'post',
          method: 'get',
          headers: {
            Authorization: this.accessToken
          },
          params: params
        })
        .then(res => {
          console.log("넘어온 data = ", res.data.content)
          this.mainProbs = res.data.content
          console.log(this.mainProbs)
        })
        .catch(err => {
          console.log("에러")
          console.log(err)
        })
      }
    }
}

</script>

<style scoped>

</style>
