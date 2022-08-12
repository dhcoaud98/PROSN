<template>
  <!-- 2022.07.26 문제 모달 (남성은) -->
  <!-- 2022.08.03 댓글보기 버튼 활성화 (남성은) -->
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0">
        <v-container class="rounded-lg modal-content pa-0">
          <v-row class="d-flex justify-center px-3 problem-modal-white">
            <!-- 문제부분 (항상 떠있음) -->
            <v-col width="600" class="pa-0">
              <!-- <slot name="btns">
              </slot>               -->
              <v-card-text class="d-flex justify-space-between align-center px-0">
                <v-btn @click="event(probdetail.id)" text class="font-weight-bold pr-0 pl-3" small>자세히</v-btn>
                <v-btn @click="$emit('close')" text class="font-weight-bold pa-0">X</v-btn>
              </v-card-text>    

              <!-- 문제 제목 -->
              <!-- {{ problem.pk }}. {{ problem.MAIN_TEXT}} -->
              <v-card-title class="font-weight-bold">
                <p class="font-parent-lar mb-0">{{probdetail.title}}</p> 
                <div class="d-inline-block ms-3">
                  <v-btn v-if="myCorrectStatus" rounded small outlined color="green">정답</v-btn>
                  <v-btn v-else rounded small outlined color="red">오답</v-btn>
                </div>
              </v-card-title>

              <!-- 문제 본문 -->
              <v-card-text>
                <!-- 카테고리 라벨 -->
                <div class="d-inline-block mb-4" v-for="(tag, idx) in probdetail.tags" :key="idx">
                  <span class="category-tag text-center pa-1">#{{ tag }}</span>
                </div>
                <!-- for문으로 돌리면 될듯 -->
              </v-card-text>

              <!-- 문제 -->
              <v-card-text class="font-weight-bold">
                <!-- <h2 class="black--text">
                다음 설명에 맞는 장치로 적절한 것은 무엇인가요?
                </h2>
                문제지문
                <h3 class="black--text my-4">
                  컴퓨터에는 (       )라고 불리는 굉장히 많은 스위치가 있고,<br>
                  on/off 상태를 통해 0과 1을 표현합니다.
                </h3> -->
                <!--  문제가 길어지면 모달이 화면 전체만큼 커져서 크기를 450px로 고정함 0811 임지민 -->
                <div>
                  <!-- <p>{{probdetail}}</p> -->
                  <p>{{probdetail.mainText}}</p>
                </div>

                <div>
                  <v-container>
                    <!-- 문제보기: 이것도 랜덤으로 for문 돌리기/ 체크박스로 라디오 묶는거....ㅠ-->
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
                    <v-row>
                      <!-- 출제자 정보 -->
                      <v-col cols="12" class="pa-0">
                        <p class="font-parent-mid-l">
                        <span class="grey--text mr-2 mb-1">created by.</span>
                          {{probdetail.writer.name}} 
                        </p>
                      </v-col>
                      <v-col cols="12" class="pa-0 justify-end d-flex align-center">
                        <!-- 좋아요 버튼 -->
                        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeLikeStatus" id="upIcon">
                          <v-icon>{{upText}}</v-icon>
                        </v-btn>
                        <!-- 싫어요 버튼 -->
                        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeHateStatus" id="downIcon">
                          <v-icon>{{downText}}</v-icon>
                        </v-btn>
                        <!-- 스크랩 버튼 -->
                        <v-btn class="ms-1" icon color="dark lighten-2" @click="changeScrapStatus" id="scrapIcon">
                          <v-icon>{{scrapText}}</v-icon>
                        </v-btn>                    
                        <!-- 제출 버튼 -->
                        <v-btn type="submit" rounded outlined class="ms-1" small>제출</v-btn>
                      </v-col>
                    </v-row>
                      <!-- 버튼 그룹 if로 자기 문제인 경우랑 아닌 경우 나눠서 보여주기 -->
                  </v-form>
                </v-container>

                <v-divider></v-divider>

                <!-- 댓글보기 -->
                <v-btn @click="showReplies" id="show-replies-btn" class="font-weight-bold mt-2" text>댓글보기</v-btn>
                <v-btn @click="noShowReplies" id="no-show-replies-btn" class="d-none font-weight-bold mt-2" text>댓글접기</v-btn>
              </div>            
            </v-card-text>
          </v-col>
    
            <!-- 평소에는 안보이는 세로선 -->
            <v-divider id="show-divider" class="my-5 d-none" vertical></v-divider>
    
            <!-- 평소에는 안보이는 댓글창 -->
            <v-col width="600" id="show-replies" class="pa-0 d-none">
              <problem-reply></problem-reply>
            </v-col>
          </v-row>
        </v-container>
      </v-container>
    </v-container>
  </v-container>
</template>

<script>
import drf from '@/api/drf'
import axios from 'axios'
import ProblemReply from './ProblemReply.vue'
import { mapGetters } from 'vuex'

export default {
  name: 'ProblemModal',
  components: {
    ProblemReply
  },
  data () {
    return {
      upText: 'thumb_up_off_alt',
      downText: 'thumb_down_off_alt',
      scrapText: 'bookmark_border',
      probId: 0,
      examples: [],
      credentials: {
        pid: '',
        right: '',
        wrongAnswer: '',
      },
      myCorrectStatus: null,
    }
  },
  props: {
    probdetail: Object,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  // 0811 : 엑시오스 통신 코드
  // recentproblemitems에서 axios 통신하고 prop으로 내려서 보기만 셔플함 0812 암지민
  created() {
      const nums  = [1,2,3,4]
      const shuffled = nums.sort(() => Math.random() - 0.5)
      // const noteDetail = this.noteDetail
      // this.shuffledNum = shuffled
      nums.forEach(num => {
        // console.log(num);
        // console.log(this.probdetail[`example${num}`])
        this.examples.push({'id': num, 'example': this.probdetail[`example${num}`]})
      })
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

    // 2022.08.03. 댓글보기 버튼 누를 때
    showReplies: function (event) {
      const showRepliesBtn = document.querySelector("#show-replies-btn")
      const noShowRepliesBtn = document.querySelector("#no-show-replies-btn")
      const showDivider = document.querySelector("#show-divider")
      const showReplies = document.querySelector("#show-replies")

      showRepliesBtn.setAttribute("class", "d-none")
      noShowRepliesBtn.setAttribute("class", "font-weight-bold mt-2 v-btn v-btn--text theme--light v-size--default")
      showDivider.setAttribute("class", "my-5 v-divider v-divider--vertical theme--light")
      showReplies.setAttribute("class", "pa-0 col col-6 info-modal-white")
    },
    // 2022.08.03. 댓글접기 버튼 누를 때
    noShowReplies: function (event) {
      const showRepliesBtn = document.querySelector("#show-replies-btn")
      const noShowRepliesBtn = document.querySelector("#no-show-replies-btn")
      const showDivider = document.querySelector("#show-divider")
      const showReplies = document.querySelector("#show-replies")

      showRepliesBtn.setAttribute("class", "font-weight-bold mt-2 v-btn v-btn--text theme--light v-size--default")
      noShowRepliesBtn.setAttribute("class", "d-none")
      showDivider.setAttribute("class", "d-none")
      showReplies.setAttribute("class", "d-none")    
    },
    // 2022.08.04. 라우터 경로 연결
    event(pid) {
      // console.log('pid=', pid)
      this.$router.push({ path: `problem/${pid}`})
    },
    // goBack () {
    //   this.$router.go(-1)
    // }

    // 문제 풀기; 문제 푼 후 결과 저장(0811 임지민)
    submitProblem() {
      // 문제 맞는 지 틀린 지 먼저 확인하고
      // 이게 null이면 답을 선택하라는 alert 창 띄우기
      const selectedAnswer = document.querySelector('input[name="bogey"]:checked').id
      // console.log(selectedAnswer)
      this.credentials.wrongAnswer = selectedAnswer
      if (selectedAnswer === "1") {
        this.credentials.right = true
        this.myCorrectStatus = true
        alert('정답입니다.')
      } else {
        this.credentials.right = false
        alert('오답입니다.')
        this.myCorrectStatus = false
        this.$router
      }
      // console.log(this.credentials)
      // axios 보내기
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
}
</script>

<style>
.problem-modal-white {
  background-color: #EDE7F6;
}
</style>

<style lang="stylus" scoped>
.modal {
  &.modal-overlay {
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    z-index: 30;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.8);
  }

  &-window {
    background: whitesmoke;
    border-radius: 4px;
    overflow: hidden;
    width: auto;
  }

  &-content {
    padding: 10px;
    width: 100%;
    height: 100%
  }
}

// 오버레이 트랜지션
.modal-enter-active, .modal-leave-active {
  transition: opacity 0.4s;

  // 오버레이에 포함되어 있는 모달 윈도의 트랜지션
  .modal-window {
    transition: opacity 0.4s, transform 0.4s;
  }
}

// 딜레이가 적용된 모달 윈도가 제거된 후에 오버레이가 사라짐
.modal-leave-active {
  transition: opacity 0.6s ease 0.4s;
}

.modal-enter, .modal-leave-to {
  opacity: 0;

  .modal-window {
    opacity: 0;
    transform: translateY(-20px);
  }
}
</style>