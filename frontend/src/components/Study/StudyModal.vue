<template>
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0">
        <v-card class="modal-content rounded-lg pa-4">
          <!-- <slot/> -->
          <v-card-title class="pb-0">
            <v-container class="pa-0">
              <v-row class="d-flex justify-space-between">
                <h2 class="font-weight-medium grey--text text--darken-2 pt-1">STUDY</h2>
                <v-btn @click="$emit('close')" icon class="pa-0"><v-icon>mdi-close</v-icon></v-btn>
              </v-row>

              <v-row class="mt-6 ml-1" v-if="myStudydetail">
                <h2 class="purple--text text--darken-4 font-weight-medium">{{myStudydetail.title}}</h2>
              </v-row>
              <v-row class="mt-6 ml-1" v-else>
                <h2 class="purple--text text--darken-4 font-weight-medium">{{studydetail.title}}</h2>
              </v-row>

              <v-row v-if="myStudydetail">
                <v-col class="d-flex justify-end pe-0" cols="12">
                  <v-btn rounded class="ms-2 font-weight-bold" @click="deleteStudy">스터디 탈퇴하기</v-btn>
                </v-col>
              </v-row>

              <v-row v-else>
                <!-- 내가 만든 스터디일 때 버튼 -->
                <v-col class="d-flex justify-end pe-0" v-if="currentUser == studydetail.masterId" cols="12">
                  <v-btn rounded class="ms-2 font-weight-bold" @click="editStudy">스터디 수정하기</v-btn>
                  <v-btn rounded class="ms-2 font-weight-bold white--text" color="red lighten-1" @click="deletedoSend">스터디 삭제하기</v-btn>
                </v-col>
                <!-- 남이 만든 스터디일 때 버튼 -->
                <v-col class="d-flex justify-end pe-0" v-else cols="12">
                  <v-btn rounded class="ms-2 font-weight-bold" @click="doSend">스터디 신청하기</v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-card-title>

          <v-divider color="#A384FF" class="mx-2"></v-divider>

          <v-card-text class="py-2" v-if="myStudydetail">
            <div class="mx-2 my-1">
              <h3 class="ma-0 px-1 font-weight-bold grey--text text--darken-3">현재원 / 총원 : {{myStudydetail.currentPerson}} / {{myStudydetail.maxPerson}} </h3>
              <h3 class="ma-0 px-1 font-weight-bold grey--text text--darken-3">장소 : {{myStudydetail.place}}</h3>
              <!-- 내가 만든 스터디일 경우 마감일 필드가 안 넘어옴 -->
              <!-- <p class="ma-0 px-2">마감일 : {{myStudydetail.expiredDate}}</p> -->
            </div>
          </v-card-text>
          <v-card-text class="py-2" v-else>
            <div class="mx-2 my-1">
              <h3 class="ma-0 px-1 font-weight-bold grey--text text--darken-3">현재원 / 총원 : {{studydetail.currentPerson}} / {{studydetail.maxPerson}} </h3>
              <h3 class="ma-0 px-1 font-weight-bold grey--text text--darken-3">장소 : {{studydetail.place}}</h3>
              <!-- 내가 만든 스터디일 경우 마감일 필드가 안 넘어옴 -->
              <!-- <p class="ma-0 px-2">마감일 : {{studydetail.expiredDate}}</p> -->
            </div>
          </v-card-text>

          <v-divider color="#A384FF" class="mx-2"></v-divider>

          <v-card-text>
            <div class="d-flex" v-if="myStudydetail">
              <div class="pl-2" v-for="(tag, idx) in myStudydetail.tags" :key="idx">
                <v-chip small color="#A384FF" class="white--text font-wieght-bold">{{ tag.type }}</v-chip>
              </div>
            </div>
            <div class="d-flex" v-else>
              <div class="pl-2" v-for="(tag, idx) in studydetail.tags" :key="idx">
                <v-chip small color="#A384FF" class="white--text font-wieght-bold">{{ tag.type }}</v-chip>
              </div>
            </div>

            <v-container class="my-4 study-detail-info">
              <v-row>
                <v-col cols="12" v-if="myStudydetail">
                  <h3> Reader : {{ myStudydetail.masterName }}</h3>
                </v-col>
                <v-col cols="12" v-else>
                  <h3> Reader : {{ studydetail.masterName }}</h3>
                </v-col>
                <v-col v-if="myStudydetail">
                  {{ myStudydetail.mainText }}
                </v-col>
                <v-col cols="12" v-else>
                  {{ studydetail.mainText }}
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
        </v-card>
      </v-container>
    </v-container>
  </v-container>
</template>  

<script>
import drf from '@/api/drf'
import axios from 'axios'
import { mapGetters } from "vuex"

export default {
  name: 'StudyModal',
  data() {
    return {
      modal: false,
      studyId: 0,
      studydetail: [],
    }
  },
  props: {
    study: Object,
    myStudydetail: Object,
  },
  created() {
    this.studyId = this.study.id
    console.log("study id = ",this.studyId)

    //api/study/{studyid}에 해당하는 detail study 정보 가져오기
    axios({
      url: drf.study.study() + `${this.studyId}`,
      methods: 'get',
      headers: {
        Authorization : this.accessToken,
      },
    })
    .then(res => {
      // console.log("studydetail =" , res.data)
      this.studydetail = res.data
      console.log("studydetail =",this.studydetail)
    })
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
    
    // 스터디 신청하기 (0813 오채명) 신청 후 새로고침
    doSend() {
      axios({
        url: drf.study.study() + 'me/' + `${this.studyId}`,
        method: 'post',
        headers: {
          Authorization: this.accessToken,
        },  
      })
      .then(res => {
        console.log("스터디 신청 =", res)
      })
      .catch(err =>{
        console.log("에러")
        console.log(err)
      })
      alert("스터디 신청이 완료되었습니다.")
      this.$router.go();
    },

    // 스터디 삭제 (0812 오채명) 삭제 후 새로고침
    deletedoSend() { 
      const userDecision = confirm('정말로 삭제하시겠습니까?')
      if (userDecision) {
        axios({
          url: drf.api + 'study' + `/${this.studydetail.id}`,
          method: 'delete',
          headers: {
            Authorization: this.accessToken,
          },        
        })
        this.$router.go();
      }
    },

    // 나의 스터디 탈퇴 (0815 오채명) 삭제 후 새로고침
    deleteStudy () {
      const userDecision = confirm('정말로 탈퇴하시겠습니까?')
      if (userDecision) {
        axios({
          url: drf.study.study() + 'me' + `/${this.myStudydetail.id}`,
          method: 'delete',
          headers: {
            Authorization : this.accessToken,
          },
        })
        this.$router.go();  
      }
    },

    // 스터디 수정하기
    editStudy () {
      const userDecision = confirm('스터디를 수정하시겠습니까?')
      if (userDecision) {
        this.$router.push({path: '/editstudy',
        // query: { id: this.study.id,
        //           title:this.study.title,
        //           maxPerson: this.study.maxPerson,
        //           expiredDate:this.studydetail.expiredDate,
        //           place:this.studydetail.place,
        //           mainText: this.studydetail.mainText,
        //           secretText: this.studydetail.secretText,
        //           tags: this.studydetail.tags}
                  })
      }
      // if (userDecision) {
      //   axios({
      //     url: drf.study.study(),
      //     method: 'put',
      //     headers: {
      //       Authorization: this.accessToken,
      //     },
      //   })
      //   .then(res => {
      //       console.log("res = ",res);
      //       this.$router.push({path: '/createstudy'})
      //       // data에 저장해서 띄우기
      //       // dispatch('saveToken', token)
      //       // dispatch('fetchCurrentUser')
      //   })
      //   .catch(err =>{
      //       console.log("에러")
      //       console.log(err)
      //     })
      // }
    },


  },
  computed: {
    ...mapGetters(['accessToken', 'currentUser']),
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
.category-tag {
  border-radius: 20px;
  border: 1px solid #A384FF;
  background-color: #A384FF;
  font-size: 5px;
  color: white;
  font-weight: bold;
  height: 25px;
  margin: 1px;
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
.button_update {
  background-color:green;
  padding-right: 2%;
  padding-left: 2%;
  padding-top: 1%;
  padding-bottom: 1%;
  margin: 1%;
  color: white;
  border-radius: 5px;
}
.button_delete {
  background-color:red;
  padding-right: 2%;
  padding-left: 2%;
  padding-top: 1%;
  padding-bottom: 1%;
  margin: 1%;
  color: white;
  border-radius: 5px;
}
</style>