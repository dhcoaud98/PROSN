<template>
  <div>
    <!-- <p>info</p> -->
    <v-row class="pa-0 ma-0" rounded>
      <v-col cols="12" class="pa-0">
        <info-items v-for="(info, idx) in infos" :key="idx" :info="info"></info-items>
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
import infoItems from '@/components/MainPage/infoItems.vue'

export default {
    data() {
      return {
        totalInfos: [],
        infos: [],
        nowPage: 1,
        clickPage: null,
        endPage: 0,
        value: null,
        page: 0,
      }
    },
    components: {
      infoItems,
    },
    created() {
      // 1. 페이지 렌더링 될 때 첫번 째 엑시오스
      axios({
        url: drf.api+'post',
        // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함!
        // url: drf.api+'post' + '/information',
        method: 'get',
        headers: {
          Authorization: this.accessToken,
        },
      })
        .then(res => {
          this.totalInfos = res.data.content
          this.endPage = this.totalInfos.length%4 > 0  ? parseInt(this.totalInfos.length/4) + 1 : this.totalInfos.length/4
        })

​      const params = {
​        page: 0,
​        size: 4,
​        // sort: onUpdated, 'desc'
​      }
​      //2
​      axios({
​        url: drf.api+'post',
​        // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함!
​        // url: drf.api+'post' + '/information',
​        method: 'get',
​        headers: {
​          Authorization: this.accessToken,
​        },
​        params: params
​        // /page=0&size=3&sort=updated,desc
​      })
​        .then(res => {
​          // 잘 넘어오는 지 확인하기!! 0807 임지민
​          // console.log("res = ",res);
​          console.log("넘어온 data= ", res.data.content)
​          // 여기서 토큰은 어떻게 쓰이는 거징?? 0807 임지민
​          const token = res.data.key
​          token
​          // data의 infos에 넣기 0807 임지민
​          this.infos = res.data.content
​          console.log(this.infos)
​        })
​        .catch(err =>{
​          console.log("에러")
​            console.log(err)
​        })
​        },
​        methods: {
​          handlePage() {
​            // console.log("event=", event)
​            // console.log("event=", event.target['ariaLabel'])
​            // console.log("event=", event.target)
​            console.log("event=", Number(event.target.ariaLabel.slice(-1)))
​            this.page = Number(event.target.ariaLabel.slice(-1))
​            const params = {
​              page: this.page - 1,
​              size: 4,
​              // sort: onUpdated, 'desc'
​            }
​            axios({
​              url: drf.api+'post',
​              method: 'get',
​              headers: {
​                Authorization: this.accessToken,
​              },
​              params: params
​            })
​              .then(res => {
​                console.log("넘어온 data= ", res.data.content)
​                const token = res.data.key
​                token
​                this.infos = res.data.content
​                console.log(this.infos)
​              })
​              .catch(err =>{
​                console.log("에러")
​                  console.log(err)
​              })
​            }
​        },

  }
</script>

<style>

</style>