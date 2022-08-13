<template>
  <div>
    <v-row class="pa-0 ma-0" rounded>
      <v-col cols="12" class="pa-0">
        <!-- {{mainProbs}} -->
        <recent-problem-items v-for="(mainProb, idx) in mainProbs" :key="idx" :mainProb="mainProb"></recent-problem-items>
        <infinite-loading @infinite="infiniteHandler"></infinite-loading>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'
import RecentProblemItems from '../MainPage/RecentProblemItems.vue'
import InfiniteLoading from 'vue-infinite-loading'


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
        // 인피니트 스크롤을 위한 변수 0813 임지민
        limit: 0
      }
    },
    components : {
        RecentProblemItems,
        InfiniteLoading
    },
    created() {
      // 0810 오채명 : 밑에 코드 절때로 건들이지 말기
      // 페이지 렌더링 될 때 첫번 째 엑시오스
      // const params = {
      //   page: 0,
      //   size: 4, 
      //   // sort: onUpdated, 'desc'
      // } 
      // axios({
      //   // url:drf.api+'post',
      //   // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함
      //   url: drf.api + 'post' + '/problem',
      //   method: 'get',
      //   headers: {
      //     Authorization : this.accessToken,
      //   },
      //   params: params
      //   //page=0&size=3&sort=updated,desc
      // })
      // .then(res => {
      //   this.mainProbs = res.data.content
      //   console.log("problem = ",this.mainProbs)
      //   this.endPage = res.data.totalPages + 1
      // })
      // .catch(err => {
      //   console.log("에러")
      //   console.log(err)
      // })
    },
    methods: {
      infiniteHandler($state) {
        const params = {
          page: this.page,
          size: 3
        }
        axios({
          // url: drf.api +'post',
          url: drf.api + 'post' + '/problem',
          method: 'get',
          headers: {
            Authorization: this.accessToken
          },
          params: params
        })
        .then(({data})  => {
          console.log(data.content.length) //6개 넘어옴
          // this.mainProbs = data.content
          if (data.content.length) {
            this.page += 1
            this.mainProbs = data.content
            // console.log('infinite=', this.mainProbs)
            $state.loaded()
          } else {
            $state.complete()
          }
          })
       }
    },
}

</script>

<style scoped>

</style>
