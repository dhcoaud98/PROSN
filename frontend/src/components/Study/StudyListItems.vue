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
      <study-modal @close="closeModal" v-if="this.modal">
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