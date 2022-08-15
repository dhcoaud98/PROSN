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

      <!-- 버튼: 남이 작성한 정보 -->
      <v-col v-if="currentUser != infoDetail.writer.id" cols="8" class="pa-0 justify-end d-flex align-center">
        <!-- 좋아요 버튼 -->
        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeLikeStatus" id="upIcon" large>
          <v-icon>{{upText}}</v-icon>
        </v-btn>
        <!-- 싫어요 버튼 -->
        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeHateStatus" id="downIcon" large>
          <v-icon>{{downText}}</v-icon>
        </v-btn>
        <!-- 스크랩 버튼 -->
        <v-btn class="ms-2" icon color="dark lighten-2" @click="openScrapModal" id="scrapIcon" large>
          <v-icon>{{scrapText}}</v-icon>
        </v-btn>    
        <scrap @close="closeScrapModal" v-if="scrapModal" :pid="infoDetail.id"></scrap>                    
      </v-col>   

      <!-- 내가 작성한 정보 -->
      <v-col v-else cols="8" class="pa-0 justify-end d-flex align-center">
        <!-- 스크랩 버튼 -->
        <v-btn class="ms-2" icon color="dark lighten-2" @click="openScrapModal" id="scrapIcon" large>
          <v-icon>{{scrapText}}</v-icon>
        </v-btn> 
        <!-- 삭제 -->
        <v-btn type="submit" color="red" rounded outlined class="ms-1" large @click="deleteinfo">삭제</v-btn>
      </v-col>
    </v-row>             

    <v-divider color="#A384FF" cla ss="mt-3"></v-divider>
    
    <v-row>
      <!-- 댓글 -->
      <v-col cols="12" class="pa-0">
        <info-modal-reply :commentList="commentList" :cid="infoDetail.id"></info-modal-reply>
      </v-col>           
    </v-row>  
  </v-container>
</template>

<script>
import InfoModalReply from '@/components/InfoModal/InfoModalReply.vue'
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'
import Scrap from '@/components/Scrap/Scrap.vue'


export default {
  name: 'Information',
  data() {
    return {
      scrapModal: false,
      infoDetail: [],
      commentList: []
    }
  },
  components: {
    InfoModalReply,
    Scrap,
  },
  computed: {
    ...mapGetters(['accessToken', 'currentUser'])
  },
  methods: {
    // 2022.08.04. 라우터 경로 연결
    goBack () {
      this.$router.go(-1)
    },
    openScrapModal() {
        this.scrapModal = true
        console.log('openModal')
    },
    closeScrapModal() {
        this.scrapModal = false
        console.log('closeModal')
    },

    // 내가 작성한 정보 삭제하기(0815 오채명)
    deleteprob() {
      const userDecision = confirm('정말로 삭제하시겠습니까?')
      if (userDecision) {
        axios({
          url: drf.api + 'post' + `/${this.infoDetail.id}`,
          method: 'delete',
          headers: {
            Authorization: this.accessToken,
          },
        })
        .then(res => {
          console.log("res.data = ",res.data)
          // console.log("삭제 되었습니다. ", res)
          this.$router.push('/')
        })
        .catch(err =>{
          console.log("에러")
          console.log(err)
        })
        // this.$router.go(); // 새로고침
      }
    },
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