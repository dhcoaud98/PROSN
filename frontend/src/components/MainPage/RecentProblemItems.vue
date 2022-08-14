<template>
  <v-card outlined elevation="3" class="rounded-xl purple-outlined-card ma-8">
    <!-- 카드 타이틀 (그라데이션 입혀진 부분) -->
    <v-card-title class="pa-0 bg-gradation">
      <v-container class="pa-0">
        <!-- 게시글 제목 / 좋아요와 싫어요 개수 -->
        <v-row class="d-flex justify-space-between ma-3">
          <!-- 제목 -->
          <v-col class="pa-0" cols="6">
            <v-row class="align-center">
              <p class="my-0 ms-5 dark--text font-weight-bold pa-0" style="font-size: 1em; color: #585757;">
                {{mainProb.title}}
              </p>
              <div v-for="tag in mainProb.tags" :key="tag" class="ms-2 mb-3">
                <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#{{tag}}</span>
              </div>
            </v-row>
          </v-col>
          <v-col class="py-0">
            <v-row class="justify-end py-1">
              <div>
                <v-icon class="me-2">thumb_up_off_alt</v-icon>
                <span class="me-3">{{ mainProb.numOfLikes }}</span>
              </div>
              <div>
                <v-icon class="me-2">thumb_down_off_alt</v-icon>
                <span class="me-3">{{ mainProb.numOfDislikes }}</span>
              </div>
            </v-row>
          </v-col>
          <!-- 좋아요 싫어요 정보 -->
        </v-row>
      </v-container>
    </v-card-title>

    <!-- 카드 본문 -->
    <v-card-text>
      <v-row>
      </v-row>

      <!-- 내용 -->
      <!-- textoverflow 지정해 놓기 0812 임지민 -->
      <v-row class="pa-0 ma-4 mx-5 mt-5 black--text font-weight-medium">
        <div class="mb-4" style="font-size: 1.1em">
          {{ probdetail.mainText }}
          <!-- {{ probdetail}} -->
        </div>
      </v-row>

      <v-row class="ma-4 mb-2 d-flex justify-space-between">
        <!-- 출제자 -->
          <div class="me-4 d-flex align-center" style="font-size: 1.2em">Created By. {{ mainProb.writerName }}</div>
        <!-- 모달 띄우기 버튼 -->
          <!-- 화면 사이즈 md 이상 -->
          <v-btn @click="openModal" text small rounded height="45px" class="d-none d-md-flex">
            <div class="show-up-btn font-weight-regular">SHOW UP</div>
          </v-btn>
          <!-- 화면 사이즈 md 이하 -->
          <v-btn @click="openModal" text small rounded height="45px" class="d-md-none mt-3" width="100%">
            <div class="show-up-btn font-weight-regular">SHOW UP</div>
          </v-btn>
      </v-row>

    </v-card-text>

    <!-- 모달 -->
    <problem-modal @close="closeModal" v-if="modal" :mainProb="mainProb" :probdetail="probdetail"></problem-modal>
  </v-card>
</template>

<script>
import axios from 'axios'
import ProblemModal from '@/components/ProblemModal/ProblemModal.vue'
import drf from '@/api/drf.js'
import {mapGetters} from 'vuex'

export default {
    data() {
        return {
            upText: 'thumb_up_off_alt',
            downText: 'thumb_down_off_alt',
            scrapText: 'bookmark_border',
            modal: false,
            probId: 0,
            probdetail: [],
        }
    },
    components: {
      ProblemModal,
    },
    props: {
      mainProb: Object,
    },
    // 0811 : 엑시오스 통신 코드
    created() {
      console.log("problem = ", this.mainProb.id)
      this.probId = this.mainProb.id

      axios({
        url: drf.api + 'post' + `/${this.probId}`,
        methods: 'get',
        headers: {
          Authorization : this.accessToken,
        },      
      })
      .then(res => {
        console.log(res.data)
        this.probdetail = res.data
      })
      .catch(err => {
        console.log("에러")
        console.log(err)
      })
    
    },
    computed: {
      ...mapGetters(['accessToken'])
    },
    methods: {
        changeLikeStatus() {
            /* 
            버튼 클릭하면 색이 바뀌도록
            thumb up --> thumb up off alt
            thumb down --> thumb down off alt
            bookmark border --> bookmark
            */
            /* 싫어요가 눌려 있는 상태에서 좋아요를 누르면 싫어요가 취소되는 것도 추가 */

           if (this.upText === "thumb_up_off_alt") {
               // 좋아요를 눌러야 하는데 이미 싫어요가 눌려져 있는 상태
            if (this.downText === "thumb_down") {
                // console.log(this.downText)
                this.downText = "thumb_down_off_alt"
            }
            this.upText = "thumb_up"

           } else {
            this.upText = "thumb_up_off_alt"
           }

        },
        changeHateStatus() {
            /* 좋아요가 눌려 있는 상태에서 싫어요를 누르면 좋아요가 취소되는 것도 추가 */
            if (this.downText === "thumb_down_off_alt") {
                this.downText = "thumb_down"
                // 싫어요를 눌렀는데 이미 좋아요가 눌러져 있는 상태
                if (this.upText === "thumb_up") {
                    this.upText = "thumb_up_off_alt"
                }
           } else {
                this.downText = "thumb_down_off_alt"
           }
        },
        changeScrapStatus() {
           if (this.scrapText === "bookmark_border") {
                this.scrapText = "bookmark"
           } else {
                this.scrapText = "bookmark_border"
           }
        },
        openModal() {
            this.modal = true
            console.log('openModal')
        },
        closeModal() {
            this.modal = false
            console.log('closeModal')
        },
        // event () {
        //   this.$router.push({ path: 'problem' })
        // },
    },
    created() {
      const probId = this.mainProb.id

      axios({
      url: drf.api + 'post' + `/${probId}`,
      methods: 'get',
      headers: {
        Authorization : this.accessToken,
      },      
    })
    .then(res => {
      console.log(res.data)
      this.probdetail = res.data
      console.log('probdetail=', this.probdetail)
    })
    .catch(err => {
      console.log("에러")
      console.log(err)
    })

    },
}
</script>

<style>
.border-a-10 {
    border-radius: 10px;
}
.color-FAF0F3 {
    background-color: #FAF0F3;
}
.color-D9D9D9 {
    background-color: #d9d9d9;
}
.tmp-border {
    border: 1px solid #a384ff;
    background: #a384ff;
    border-radius: 20px;
    color: white;
}
.category-tag {
    border-radius: 20px;
    border: 1px solid #a384ff;
    background-color: #a384ff;
    color: white;
    font-weight: bold;
}
.font-parent-lar {
    font-size: 1.5em;
}
.font-parent-mid {
    font-size: 0.9em;
}
.font-parent-sml {
    font-size: 0.3em;
}
:hover.material-icons {
    cursor: pointer;
}
.w-100 {
    width: 100%;
}
</style>