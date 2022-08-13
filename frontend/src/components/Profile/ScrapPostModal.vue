<template>
  <!-- 2022.07.26 문제 모달 (남성은) -->
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0">
        <v-container class="rounded-lg modal-content pa-0">
          <v-card>
            <v-card-title>
              <v-container>
                <v-row>
                  네트워크 모음집 버튼들 있고
                </v-row>
              </v-container>
            </v-card-title>

            <v-card-text>
              <v-container>
                <scrap-modal-list></scrap-modal-list>
              </v-container>

            </v-card-text>
          </v-card>
        </v-container>
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