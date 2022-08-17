<template>
  <!-- 문제 하나하나 받아오기 -->
  <!-- 화면 크기가 xs 이하일 때는 문제와 노트 작성 칸이 세로로 배치되게 수정하기 0805 임지민 -->
  <v-container fluid>
    <v-row class="mt-3">
        <!-- col 1: 상위의 createnotelist에서 받아온 문제 출력 -->
        <p>hi {{probDetail}}</p>
        <v-col class="pr-5">
            <v-row class="align-center justify-space-between">
                <!-- 출제자 프사 -->
                <v-col cols="6" class="pa-0 mr-0">
                    <router-link to="/profile" class="text-decoration-none black--text">
                    <div class="d-flex align-center">
                        <span class="material-icons mr-2 text-decoration-none black--text">
                            account_circle
                        </span>
                        <!-- 출제자 아이디 -->
                        <span>{{ probDetail.writer.name}}</span>
                    </div>
                    </router-link>
                </v-col>    
            </v-row>

        <hr class="border-grey my-5">
        <!-- 문제 제목 -->
        <v-row class="justify-space-between">
            <p class="font-parent-lar font-weight-bold mt-5">{{ probDetail.title }}</p>
        </v-row>

        <!-- 문제 지문 -->
        <v-row class="grey lighten-4 border-a-10 pa-5">
            <v-col class="px-0 py-2 font-weight-bold">
                <p class="font-parent-mid-l">
                    {{probDetail.mainText}}
                </p>
            </v-col>
        </v-row>
    

       <!-- 문제보기: 이것도 랜덤으로 for문 돌리기 -->
        <v-form @submit.prevent="submitProblem">
          <v-row>
            <v-col>
              <div v-for="example in examples" :key="example.id" class="my-3">
                <input type="radio" :value="`보기${example.id}`" :id="example.id" name="bogey">
                <label :for="`check${example.id}`" 
                class="ml-2 font-parent-mid-l">
                {{example.example}} </label>
              </div>
            </v-col>
          </v-row>
          <!-- 저작권 / 버튼 -->

          <v-row class="d-flex justify-space-between">
            <!-- 출제자 정보 -->
            <v-col class="pa-0" >
              <span class="grey--text mr-2 mb-1">Created by.
                <v-btn class="px-0 mb-1 font-weight-bold" plain @click=profileEvent(probDetail.writer.id)>                        
                  {{probDetail.writer.name}} 
                </v-btn>
              </span>
            </v-col>

            <!-- 버튼: 남이 낸 문제 -->
            <v-col v-if="currentUser != probDetail.writer.id" cols="8" class="pa-0 justify-end d-flex align-center">
              <!-- 좋아요 버튼 -->
              <div>
                <v-btn class="ms-1" icon color="dark lighten-2" @click="changeLikeStatus" id="upIcon" large>
                  <v-icon>{{upText}}</v-icon>
                </v-btn>
                <span>{{probDetail.numOfLikes}}</span>
              </div>
              <!-- 싫어요 버튼 -->
              <div>
                <v-btn class="ms-1" icon color="dark lighten-2" @click="changeHateStatus" id="downIcon" large>
                  <v-icon>{{downText}}</v-icon>
                </v-btn>
                <span>{{probDetail.numOfDislikes}}</span>
              </div>
              <!-- 스크랩 버튼 -->
              <v-btn class="ms-2" icon color="dark lighten-2" @click="openScrapModal" id="scrapIcon" large>
                <v-icon>{{scrapText}}</v-icon>
              </v-btn>
              <scrap @close="closeScrapModal" v-if="scrapModal" :pid="probDetail.id"></scrap>                    
              <!-- 제출 버튼 -->
              <v-btn type="submit" rounded outlined class="ms-1" large>제출</v-btn>
            </v-col>

            <!-- 내가 낸 문제 -->
            <v-col v-else cols="8" class="pa-0 justify-end d-flex align-center">
              <!-- 스크랩 버튼 -->
              <v-btn class="ms-2" icon color="dark lighten-2" @click="openScrapModal" id="scrapIcon" large>
                <v-icon>{{scrapText}}</v-icon>
                <scrap @close="closeScrapModal" v-if="scrapModal" :pid="probDetail.id"></scrap>                    
              </v-btn>
            </v-col>

          </v-row>
        </v-form>
        
        </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'
import Scrap from '@/components/Scrap/Scrap.vue'

export default {
  data() {
        return {
            scrapModal: false,
            upText: 'thumb_up_off_alt',
            downText: 'thumb_down_off_alt',
            scrapText: 'bookmark_border',
            examples: [],
            myCorrectStatus: [],
            credentials: {
                pid: this.probDetail.id,
                right: '',
                wrongAnswer: '',
            },
        }
    },
    props: {
        probDetail: Object,
    },
    components: {
        Scrap
    },
    computed: {
        ...mapGetters(['accessToken', 'currentUser'])
    },
    methods: {
    changeLikeStatus() {
        /* 
        버튼 클릭하면 색이 바뀌도록
        thumb up --> thumb up off alt
        thumb down --> thumb down off alt
        bookmark border --> bookmark
        */
          // 좋아요 엑쇼스 0815 임지민
        // axios 보내기
          axios({
            url: drf.postFeed.likeordis(),
            method: 'post',
            headers: {
              Authorization: this.accessToken,
            },
            data: {
              pid: this.probDetail.id,
              type: true
            }
          })
          .then(res => {
            console.log(res.data);
            this.probDetail.numOfLikes = res.data.numOfLikes
            if(res.data.numOfLikes === 1) {
              this.upText = 'thumb_up'
            } else {
              this.upText = 'thumb_up_off_alt'
            }

          })
          .catch(err => {
            // console.log(this.accessToken)
            // console.log(this.userId)
            console.log(err);
          })
        /* 싫어요가 눌려 있는 상태에서 좋아요를 누르면 싫어요가 취소되는 것도 추가 */

        if (this.upText === "thumb_up_off_alt") {
          // 좋아요를 눌러야 하는데 이미 싫어요가 눌려져 있는 상태
          if (this.downText === "thumb_down") {
              // console.log(this.downText)
              this.changeHateStatus()
              this.downText = "thumb_down_off_alt"
          }
          this.upText = "thumb_up"
          } else {
            this.upText = "thumb_up_off_alt"
          }
    },
    changeHateStatus() {
       // 싫어요 엑쇼스 0815 임지민
        // axios 보내기
          axios({
            url: drf.postFeed.likeordis(),
            method: 'post',
            headers: {
              Authorization: this.accessToken,
            },
            data: {
              pid: this.probDetail.id,
              type: false
            }
          })
          .then(res => {
            console.log(res.data);
            this.probDetail.numOfDislikes = res.data.numOfDislikes
          })
          .catch(err => {
            // console.log(this.accessToken)
            // console.log(this.userId)
            console.log(err);
          })
        /* 좋아요가 눌려 있는 상태에서 싫어요를 누르면 좋아요가 취소되는 것도 추가 */
        if (this.downText === "thumb_down_off_alt") {
            this.downText = "thumb_down"
            // 싫어요를 눌렀는데 이미 좋아요가 눌러져 있는 상태
            if (this.upText === "thumb_up") {
                this.changeLikeStatus()
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
    openScrapModal() {
        this.scrapModal = true
        console.log('openModal')
    },
    closeScrapModal() {
        this.scrapModal = false
        console.log('closeModal')
    },
    profileEvent(uid) {
      this.$router.push({ path: `../profile/${uid}`})
    },
    
    // 문제 풀기; 문제 푼 후 결과 저장(0811 임지민)
    submitProblem() {
    // 문제 맞는 지 틀린 지 먼저 확인하고
    // 이게 null이면 답을 선택하라는 alert 창 띄우기
    const selectedAnswer = document.querySelector('input[name="bogey"]:checked')
    if (selectedAnswer === null){
        // console.log('not selectedd')
        this.$swal({
            icon: 'warning',
            text: '답을 선택해주세요'
        })
    } else {
        this.credentials.wrongAnswer = selectedAnswer.id
        if (selectedAnswer === "1") {
            this.credentials.right = true
            this.myCorrectStatus = true
            // alert('정답입니다.')
            this.$swal({
            icon: 'success',
            text: '정답입니다'
            })
        } else {
            this.credentials.right = false
            // alert('오답입니다.')
            this.$swal({
            icon: 'warning',
            text: '오답입니다.'
            })
            this.myCorrectStatus = false
        }
        // console.log(this.credentials)
        // axios 보내기
        // console.log('문제 풀이 현황 = ', this.credentials);
        axios({
            url: drf.solving.solving(),
            method: 'post',
            headers: {
            Authorization: this.accessToken,
            },
            data: this.credentials
        })
        .then(res => {
            // 받아온 데이터를 작성 전/후로 구분하는 작업 필요(0808 임지민)
            console.log(res)
        })
        .catch(err => {
            // console.log(this.accessToken)
            // console.log(this.userId)
            console.log(err);
            })
        }
    }
    },
    created() {
        if (this.examples.length===0) {
            const nums  = [1,2,3,4]
            const shuffled = nums.sort(() => Math.random() - 0.5)
            // const noteDetail = this.noteDetail
            // this.shuffledNum = shuffled
            nums.forEach(num => {
            // console.log(num);
            // console.log(this.probdetail[`example${num}`])
            this.examples.push({'id': num, 'example': this.probDetail[`example${num}`]})
            })
        }
    },
}
</script>

<style>
.left-border-grey {
  border-left: 1px solid #d9d9d9;
}

/* 내가 고른 답, 정답이 나오는 드롭다운의 box shadow 없애기 */
.v-menu__content {
  box-shadow: none;
}

.problem-submit-btn:hover {
    /* border: 1px solid #a384ff; */
    background-color: #a384ff;
    color: white;
    font-weight: bold;
    border: 1px solid #a384ff;
}
.material-icons {
    font-size: 2em;
}
</style>