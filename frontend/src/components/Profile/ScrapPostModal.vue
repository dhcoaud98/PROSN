<template>
  <!-- 2022.07.26 문제 모달 (남성은) -->
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0">
        <v-card class="rounded-lg modal-content pa-4">

          <!-- 카드 타이틀 -->
          <v-card-title>
            <v-container class="pa-0">
              <!-- 각 개별 리스트의 이름 -->
              <v-row class="d-flex justify-space-between">
                <h2>리스트의 이름</h2>
                <v-btn @click="$emit('close')" icon class="pa-0"><v-icon>mdi-close</v-icon></v-btn>
              </v-row>

              <!-- 버튼들 -->
              <v-row class="mt-5">
                <v-col class="pa-0 d-flex justify-space-between">
                  <div>
                    <v-btn rounded color="pink lighten-3" class="font-weight-bold white--text">선택항목 삭제</v-btn>
                    <v-btn rounded color="red lighten-1" class="font-weight-bold white--text ms-3">폴더 삭제</v-btn>
                  </div>
                  <div>
                    <v-btn rounded class="font-weight-bold">문제집 만들기</v-btn>
                  </div>
                </v-col>
              </v-row>
            </v-container>
          </v-card-title>

          <v-divider color="#A384FF" class="mx-3"></v-divider>

          <v-card-text class="py-0">
            <v-container class="pa-0">
              <scrap-modal-list></scrap-modal-list>
            </v-container>
          </v-card-text>

          <v-divider color="#A384FF" class="mx-3"></v-divider>

          <v-card-footer class="d-flex-row justify-center">
            <v-container class="pt-5 pb-0">
              <v-row class="d-flex justify-center">문제집 추출은 문제의 경우에만 가능합니다.</v-row>
              <v-row class="d-flex justify-center">정보가 포함되어 있을 경우 자동으로 걸러져서 문제집이 추출되오니 참고해주시기 바랍니다.</v-row>
            </v-container>
          </v-card-footer>

        </v-card>
      </v-container>
    </v-container>
  </v-container>
</template>

<script>
import ScrapModalList from '@/components/Profile/ScrapModalList.vue'


export default {
  name: 'ScrapPostModal',
  components: {
    ScrapModalList,
  }
}
</script>

<style>

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