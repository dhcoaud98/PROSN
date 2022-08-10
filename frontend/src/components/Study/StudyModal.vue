<template>
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window">
        <v-container class="modal-content">
          <!-- <slot/> -->
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
                  <!-- <v-virtual-scroll height="300" item-height="64"> -->
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
                  <!-- </v-virtual-scroll> -->
              </v-container>
              
            </v-col>

            <!-- 버튼 -->
            <v-col cols="12">
              <button class="button" @click="doSend">스터디 신청하기</button>
              <button class="button" @click="$emit('close')">창 닫기</button>
            </v-col>
          </v-row>
          
        </v-container>
        </v-container>
      </v-container>
    </v-container>
  </v-container>
</template>  

<script>
export default {
  name: 'StudyModal',
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
      console.log(closeModal)
    },
    doSend() {
        alert("스터디 신청이 완료되었습니다.")
        this.message = ''
        this.closeModal()
    },
  }
}

</script>

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
    background: #F3F1F5;
    border-radius: 4px;
    overflow: hidden;
    height: 80%;
    width: 35%;
  }

  &-content {
    padding: 10px 20px;
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