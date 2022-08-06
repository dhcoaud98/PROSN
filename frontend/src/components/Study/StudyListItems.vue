<template>
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <v-row class="color-FAF0F3 feed-width mx-auto border-a-10">
      <v-col cols="12">
        <v-card class="px-5" color="#FAF0F3">
          <v-row>
            <!-- 문제 대표 이미지 -->
            <!-- <v-col cols="1" class="pb-2 pt-5"><v-icon large color="black darken-2">mdi-group</v-icon></v-col> -->
            <!-- 문제 태그, 문제 제목 --> 
            <v-col cols="10">
              <v-col cols="12" class="pa-0 mb-1">
                <h4>8/19 넥슨 기술 면접 스터디원 구함</h4>
              </v-col>
              <v-col cols="12" class="problem_title pa-0 pt-1">
                2/5
              </v-col>
            </v-col>
            <v-col cols="2" class="problem_detail">
              <p type="button" @click="openModal">자세히 ></p>
            </v-col>
          </v-row>
        </v-card>
      </v-col>

      <!-- 08.04 모달 (오채명) -->
      <study-modal @click="closeModal" v-if="this.modal">
                <v-container class="study-content">
            <v-row>
              <!-- 제목 -->
              <v-col cols="12">
                <v-icon class="mb-3 ml-2">mdi-group</v-icon>
                <span class="ml-4" style="font-size:X-large;color:#512DA8;">8/19 넥슨 기술 면접 구합니다.</span>
              </v-col>
              
              <!-- 중간 정보 -->
              <v-col cols="12">
                <v-divider class="info-divider mb-2"></v-divider>
                <p class="ma-0 px-2" style="color:#512DA8">현재원/총원 : 2/5명</p>
                <p class="ma-0 px-2">마감일 : 2022년 08월 05일 까지</p>
                <p class="ma-0 px-2">온/오프 : 오프라인 매주 일요일 1시 강남역</p>
                <v-divider class="info-divider mt-2"></v-divider>
              </v-col>
              <v-col cols="12">
                <v-container class="study-detail-info">
                  <v-row>

                    <p>
                      [소개] 
                      8월 19일 있는 넥슨 기술 면접 스터디원을 모집합니다.
                    </p>
                    <p>
                      [규칙]
                      시간 약속을 잘 지킵니다.
                      주어진 과제는 반드시 해야합니다.
                      성실하게 임해주셨으면 좋겠습니다.
                    </p>
                    <p>
                      [기타]
                      강남역 10번 출구 OO카페에서 매주 1시 ~ 4시까지 진행될 예정입니다.
                      카페 사용료에 대한 금액은 개인이 준비해주시면 됩니다.
                    </p>
                    <p style="color:red;"> 
                      [상세]
                      카카오톡 오픈 채팅방 이름 : 8/19 넥슨 기술 면접 스터디원
                      카카오톡 오픈 채팅방 비번 : *5454
                    </p>
                  </v-row>
                </v-container>
                
              </v-col>

              <!-- 버튼 -->
              <v-col cols="12">
                <button class="button" @click="doSend">스터디 신청하기</button>
                <button class="button" @click="closeModal">창 닫기</button>
              </v-col>
            </v-row>
            
          </v-container>
      </study-modal>
    </v-row>
</template>

<script>
import StudyModal from "@/components/Study/StudyModal.vue"

export default {
  name: 'StudyListItems',
  components: {
    StudyModal,
  },
  data() {
    return {
      modal: false,
    }
  },
  methods: {
    openModal() {
      this.modal = true
      console.log(openModal)
    },
    closeModal() {
      this.modal = false
      console.log('closeModal')
    },
    doSend() {
        alert("스터디 신청이 완료되었습니다.")
        this.message = ''
        this.closeModal()
    }
  }
}
</script>

<style>
.feed-width {
    width: auto;
}
.border-a-10 {
  border-radius: 5px;
}
.color-FAF0F3 {
  background-color: #FAF0F3;
}
.category-tag {
  border-radius: 20px;
  border: 1px solid #E7C0F4;
  background-color: #E7C0F4;
  font-size: 3px;
  color: white;
  font-weight: bold;
  height: 20px;
  margin: 1px;
}
.problem_detail {
  font-size: 2px;
  text-align: right;
}
.problem_title {
  font-size: 2px;
}
.study-content {
  width : 100%;
  height: 100%;
}
.button {
  background-color:#A384FF;
  padding-right: 2%;
  padding-left: 2%;
  padding-top: 1%;
  padding-bottom: 1%;
  margin: 1%;
  color: white;
  border-radius: 5px;
}
.info-divider {
  background-color:#A384FF;
}
.study-detail-info {
  background-color: #EDE7F6;
  height: 100%;
}
</style>