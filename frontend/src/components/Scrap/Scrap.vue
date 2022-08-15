<template>
  <!-- 모달을 위한 요소들 -->
  <v-container class="scrap-modal" appear>
    <v-container class="scrap-modal scrap-modal-overlay" @click.self="$emit('close')">
      <v-container class="scrap-modal-window pa-0 mx-0 d-flex justify-center">

        <!-- 2022.07.27 스크랩 (남성은) -->
        <v-card width="400" class="rounded-lg scrap-modal-content pa-0">
          <v-container>
            <v-row>
              <v-col cols="12" class="d-flex justify-space-between">
                <div class="d-flex flex-row align-center">
                  <v-icon large>mdi-folder-open</v-icon>
                  <h3 class="ms-2">Scrap</h3>
                </div>
                <v-btn @click="$emit('close')" icon><v-icon>mdi-close</v-icon></v-btn>
              </v-col>
            </v-row>

            <v-divider class="mx-1 my-2"></v-divider>

            <v-row>
              <v-col class="pa-0">
                <v-container>
                  <v-row>
                    <v-col class="pa-0">
                      <!-- 여기에 ScarpList가 들어갈 예정 -->
                      <scrap-list></scrap-list>
                    </v-col>
                  </v-row>
                </v-container>
              </v-col>
            </v-row>

            <v-divider class="mx-1 my-2"></v-divider>

            <v-row class="my-2">

              <!-- 리스트 만들기 -->
              <!-- 2. 새로운 리스트를 만들수 있는 폼 -->
              <!-- 새로운 리스트를 만들고 생성 버튼을 누르면 다시 사라짐 -->
              <v-col cols="12" class="d-none" id="create-scrap-form">
                <v-form ref="form" @submit.prevent="createScrap"> 
                  <v-row>
                    <v-col cols="12" class="py-1">
                      <v-text-field label="문제 리스트 이름을 입력하세요" maxlength="20" counter required dense></v-text-field>
                    </v-col>
                    <v-col cols="12" class="py-1">
                      <v-btn rounded type="submit" width="100%">리스트 생성</v-btn>
                    </v-col>
                  </v-row>
                </v-form>
              </v-col>

              <!-- 새로운 목록 추가 버튼과 스크랩 버튼 -->
              <v-col cols="12" class="py-1">
                <!-- 새로운 목록 추가 버튼 -->
                <!-- 1. 버튼을 누르면 새로운 리스트를 만들 수 있는 폼이 나옴. 위에 있음 -->
                <v-btn rounded width="100%" @click="openCreateScrap">
                  새로운 목록 추가
                </v-btn>
              </v-col>
              <v-col cols="12" class="py-1">

                <!-- 체크한 리스트에 해당 문제를 스크랩 할 수 있는 버튼 -->
                <v-btn rounded color="#A384FF" class="white--text" width="100%">
                  스크랩
                </v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-card>
      </v-container>
    </v-container>
  </v-container>  
</template>  

<script>
import ScrapList from '@/components/Scrap/ScrapList.vue'

export default {
  name: 'Scrap',

  data: () => ({
    credential: {
    }
  }),
  components : {
    ScrapList,
  },
  methods: {
    // 새로운 리스트를 생성할 수 있는 폼
    openCreateScrap () {
      console.log('열려라 참깨');
      const createScrapForm = document.querySelector("#create-scrap-form")
      console.log(createScrapForm.classList);
      createScrapForm.classList.remove('d-none')
    },
    // 새로운 리스트를 작성한 후 내보내기
    createScrap () {
      const createScrapForm = document.querySelector("#create-scrap-form")
      createScrapForm.classList.add('d-none')
    }
  }
}
</script>

<style>

</style>

<style lang="stylus" scoped>
.scrap-modal {
  &.scrap-modal-overlay {
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

  &-scrap-window {
    background: whitesmoke;
    border-radius: 4px;
    overflow: hidden;
    width: auto;
  }

  &-scrap-content {
    padding: 10px;
    width: 100%;
    height: 100%
  }
}

// 오버레이 트랜지션
.scrap-modal-enter-active, .scrap-modal-leave-active {
  transition: opacity 0.4s;

  // 오버레이에 포함되어 있는 모달 윈도의 트랜지션
  .scrap-modal-window {
    transition: opacity 0.4s, transform 0.4s;
  }
}

// 딜레이가 적용된 모달 윈도가 제거된 후에 오버레이가 사라짐
.scrap-modal-leave-active {
  transition: opacity 0.6s ease 0.4s;
}

.scrap-modal-enter, .scrap-modal-leave-to {
  opacity: 0;

  .scrap-modal-window {
    opacity: 0;
    transform: translateY(-20px);
  }
}
</style>