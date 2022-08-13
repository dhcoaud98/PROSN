<template>
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <div class="color-FAF0F3 feed-width mx-auto border-a-10 mb-1">
      <v-col cols="12">
        <v-card class="px-5" color="#FAF0F3">
          <v-row>
            <!-- 문제 태그, 문제 제목 --> 
            <v-col cols="10" class="pl-5">
              <v-col cols="12" class="pa-0 mb-1">
                <h4>{{myStudy.title}}</h4>
              </v-col>
              <v-col cols="12" class="problem_title pa-0 pt-1">
                <p>{{myStudy.mainText}}</p>
              </v-col>
            </v-col>
            <v-btn @click="openModal" cols="2" class="problem_detail">
              자세히 보기 >
            </v-btn>
          </v-row>
        </v-card>
      </v-col>
    <study-modal @close="closeModal" v-if="this.modal" :myStudydetail="myStudydetail"></study-modal>
    </div>
    
</template>

<script>
import drf from '@/api/drf'
import axios from 'axios'
import StudyModal from "@/components/Study/StudyModal.vue"
import { mapGetters } from "vuex"

export default {
  namd: 'MyStudyListItems',
  data() {
    return {
      modal: false,
      myStudyId: null,
      myStudydetail: [],
    }
  },
  props: {
    myStudy: Object,
  },
  components: {
    StudyModal,
  },
  computed: {
    ...mapGetters(['accessToken']),
  },
  created() {
    // 나의 스터디마다 정보 조회
    console.log(myStudy)
    this.myStudyId = myStudy.id
    console.log("study id = ",this.myStudyId)

    // api/study/{studyid}에 해당하는 detail study 정보 가져오기
    // axios({
    //   url: drf.study.study() + `${this.studyId}`,
    //   methods: 'get',
    //   headers: {
    //     Authorization : this.accessToken,
    //   },
    // })
    // .then(res => {
    //   // console.log("studydetail =" , res.data)
    //   this.myStudydetail = res.data
    //   console.log("studydetail =",this.myStudydetail)
    // })
  },
  methods: {
    openModal() {
      this.modal = true
      console.log(openModal)
      console.log(this.study.id)
    },
    closeModal() {
      this.modal = false
      console.log('closeModal')
    },
    // doSend() {
    //     alert("스터디 신청이 완료되었습니다.")
    //     this.message = ''
    //     this.closeModal()
    // },
    // refresh() {
    //   this.$emit('refresh')
    // }
  },
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
</style>