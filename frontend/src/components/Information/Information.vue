<template>
  <!-- 2022.08.04 정보 페이지 -->
  <v-container>
    <v-row class="d-flex justify-space-between">
      {{infoDetail}}
      <h2>{{ infoDetail.title }}</h2> 
      <v-btn @click="goBack()" text class="font-weight-bold">뒤로가기</v-btn>
    </v-row>

    <v-row>
      <v-col>
        <span v-for="tag in infoDetail.tags" :key="tag">
          <v-chip small color="#A384FF" class="white--text mr-2">#{{ tag }}</v-chip>
        </span>
      </v-col>
    </v-row>

    <v-row>
      <v-card outlined class="mx-3 mb-2 pa-3 overflow-y-auto" max-height="500px" width="100%">
        <v-card-text>
          {{ infoDetail.mainText }}
        </v-card-text>
      </v-card>
    </v-row>

    <!-- 저작권 / 버튼 -->
    <v-row class="d-flex justify-space-between">
      <!-- 출제자 정보 -->
      <v-col>
        <div class="me-4 d-flex align-center font-weight-mid">Created By. {{ infoDetail.writer.name }}</div>
      </v-col>
      <!-- 버튼 그룹 if로 자기 문제인 경우랑 아닌 경우 나눠서 보여주기 -->
      <v-col cols="8" class="pa-0 justify-end d-flex align-center">
        <!-- 좋아요 버튼 -->
        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeLikeStatus" id="upIcon" large>
          <v-icon>{{upText}}</v-icon>
        </v-btn>
        <!-- 싫어요 버튼 -->
        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeHateStatus" id="downIcon" large>
          <v-icon>{{downText}}</v-icon>
        </v-btn>
        <!-- 스크랩 버튼 -->
        <v-btn class="ms-2" icon color="dark lighten-2" @click="changeScrapStatus" id="scrapIcon" large>
          <v-icon>{{scrapText}}</v-icon>
        </v-btn>    
      </v-col>   
    </v-row>             

    <v-divider color="#A384FF" cla ss="mt-3"></v-divider>
    
    <v-row>
      <!-- 댓글 -->
      <v-col cols="12" class="pa-0">
        <info-modal-reply :commentList="commentList"></info-modal-reply>
      </v-col>           
    </v-row>  
  </v-container>
</template>

<script>
import InfoModalReply from '@/components/InfoModal/InfoModalReply.vue'
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  name: 'Information',
  data() {
    return {
      infoDetail: [],
      commentList: []
    }
  },
  components: {
    InfoModalReply,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  methods: {
    // 2022.08.04. 라우터 경로 연결
    goBack () {
      this.$router.go(-1)
    }
  },
  created() {
    // console.log('problem ')
    const infoId = this.$route.params.cid
    // console.log('probid=', probId)

    axios({
      url: drf.api + 'post/' + `${infoId}`,
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
    })
    .then(res => {
      console.log(res) //ok
      this.infoDetail = res.data
      this.commentList = res.data.comments.reverse()

    })
    .catch(err => {
      console.log(err);
    })
    },
}
</script>

<style>

</style>