<template>
  <!-- 2022.07.26 정보 모달 (남성은) -->
  <!-- 2022.08.04 댓글보기 버튼 활성화 (남성은) -->
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0" width="500px">
        <v-container class="rounded-lg modal-content pa-0">
          <v-row class="d-flex justify-center">
            <!-- 정보부분 (항상 떠있음) -->
            <v-col max-width="600" class="pa-0 info-modal-white">            
              <v-card-text class="d-flex justify-space-between">
                <v-btn @click="event()" text class="font-weight-bold">크게보기</v-btn>
                <v-btn @click="$emit('close')" text class="font-weight-bold">뒤로가기</v-btn>
              </v-card-text>

              <!-- 정보 제목 -->
              <!-- {{ info.pk }}. {{ info.MAIN_TEXT}} -->
              <v-card-title class="font-weight-bold black--text">
                <h2>{{ infodetail.id }}. {{ info.title }}</h2> 
              </v-card-title>

              <!-- 정보 본문 -->
              <v-card-text>
                <!-- 카테고리 라벨 -->
                <div class="pl-3" style="display:inline;" v-for="(tag, idx) in infodetail.tags" :key="idx">
                  <span class="category-tag text-center pa-1">{{ tag }}</span>
                </div>
              </v-card-text>

              <!-- 내용 error: 스크롤 안생김-->
              <v-card-text class="font-weight-bold">
                  <v-container>
                    <v-row>
                      <v-card outlined class="mx-3 mb-2 pa-3 overflow-y-auto" max-height="500px" width="100%">
                        <!-- <v-virtual-scroll height="300"> -->
                        <v-card-text>
                          <div>
                            {{ infodetail.mainText }}
                          </div>                
                        </v-card-text>
                      </v-card>
                    </v-row>
                    <!-- 저작권 / 버튼 -->
                    <v-row class="d-flex justify-space-between">
                      <!-- 출제자 정보 -->
                      <v-col class="col-12 col-md-8">
                        <div>출제자 | {{ infodetail.writer.name}}</div>              
                        <div>출제일 | {{ info.created.slice(0,10) }}</div>
                      </v-col>

                      <!-- 남이 작성한 정보일 경우 -->
                      <v-col v-if="currentUser != infodetail.writer.id" class="d-flex justify-end col-12 col-md-4">
                        <!-- 좋아요 버튼 -->
                        <v-btn class="ms-2" icon color="blue lighten-2" @click="changeLikeStatus" id="upIcon">
                          <v-icon>{{upText}}</v-icon>{{ infodetail.numOfLikes }}
                        </v-btn>
                        <!-- 싫어요 버튼 -->
                        <v-btn class="ms-2" icon color="red lighten-2" @click="changeHateStatus" id="downIcon">
                          <v-icon>{{downText}}</v-icon>{{ infodetail.numOfDislikes }}
                        </v-btn>
                        <!-- 스크랩 버튼 -->
                        <v-btn class="ms-2" icon color="dark lighten-2" @click="changeScrapStatus" id="scrapIcon">
                          <v-icon>{{scrapText}}</v-icon>
                        </v-btn>                    
                      </v-col>

                      <!-- 내가 작성한 정보일 경우 -->
                      <v-col v-else class="d-flex justify-end col-12 col-md-4">
                        <!-- 수정 버튼 -->
                        <v-btn class="ms-2" rounded outlined small color="green" @click="editInfo">수정</v-btn>
                        <!-- 삭제 버튼 -->
                        <v-btn class="ms-2" rounded outlined small color="red" @click="deleteInfo">삭제</v-btn>
                      </v-col>
                    </v-row>
                  </v-container>
                  
                  <v-divider></v-divider>

                  <!-- 댓글보기 -->
                  <v-btn @click="showReplies" id="show-replies-btn" class="font-weight-bold mt-2" text>댓글보기</v-btn>
                  <v-btn @click="noShowReplies" id="no-show-replies-btn" class="d-none font-weight-bold mt-2" text>댓글접기</v-btn>
              </v-card-text>
            </v-col>

            <!-- 평소에는 안보이는 세로선 -->
            <v-divider id="show-divider" class="my-5 d-none" vertical></v-divider>

            <!-- 평소에는 안보이는 댓글창 -->
            <v-col width="600" id="show-replies" class="pa-0 d-none">
              <info-modal-reply></info-modal-reply>
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
import { mapGetters } from "vuex"
import InfoModalReply from './InfoModalReply.vue'

export default {
  name: "InfoModal",
  components: {
    InfoModalReply,
  },
  props: {
    infodetail: Object,
    info: Object,
  },
  data () {
    return {
      upText: 'thumb_up_off_alt',
      downText: 'thumb_down_off_alt',
      scrapText: 'bookmark_border',
    }
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
    event () {
      this.$router.push({ path: 'information' })
    },
    onScroll () {
        this.scrollInvoked++
      },
    // 0815 삭제 버튼
    deleteInfo () {
      const userDecision = confirm('정말로 삭제하시겠습니까?')
      if (userDecision) {
        axios({
          url: drf.api + 'post' + `/${this.infodetail.id}`,
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
        this.$router.go(); // 새로고침      
      }
    },
    // 0815 수정
    editInfo () {
      console.log('수정')
    }
  },
  computed: {
    ...mapGetters(['accessToken','currentUser']),
  }
}
</script>

<style>
.info-modal-white {
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
    background: white;
    border-radius: 4px;
    overflow: hidden;
    width: auto;
    max-height:100%
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