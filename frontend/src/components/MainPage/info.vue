<template>
  <div>
    <!-- <p>info</p> -->
    <v-row class="pa-0 ma-0" rounded>
      <v-col cols="12" class="pa-0">
        <!-- {{ infos }} -->
        <info-items v-for="(info, idx) in infos" :key="idx" :info="info"></info-items>
        <v-container class="text-center ">
          <v-pagination
            v-model="nowpage"
            :length="4"
            color="#A384FF"
            circle
            @input="handelPage"
          ></v-pagination>
      </v-container>
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
        infos: [],
        nowpage: 1,
      }
    },
    components: {
      infoItems,
    },
    methods: {
      
    },
    props: {
      mainInfos: Array,
    },
    created() {
      // for (i in this.totalinfo) {
        // 정보 전체 최신 순으로 가져오기
        // const params = {
        //   page: i,
        //   size: 3,
        //   // sort: onUpdated, 'desc'
        // }
         axios({
          url: drf.api+'post',
          // 0808 오채명 : 모든 게시글, 문제 가져올 때 확인하려고 위의 주소로 했는데, 밑에꺼로 해야함!
          // url: drf.api+'post' + '/information',
          method: 'get',
          headers: {
            Authorization: this.accessToken,
          },
          // params: params
  
          // /page=0&size=3&sort=updated,desc
          })
          .then(res => {
            // 잘 넘어오는 지 확인하기!! 0807 임지민
              // console.log("res = ",res);
              console.log("넘어온 data= ", res.data.content)
              // 여기서 토큰은 어떻게 쓰이는 거징?? 0807 임지민
              const token = res.data.key
              token
              // data의 infos에 넣기 0807 임지민
              this.infos = res.data.content
              // console.log(this.infos.content)
          })
          .catch(err =>{
              console.log("에러")
              console.log(err)
          })
          }
      // }
  }
</script>

<style>

</style>