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
              <span class="ml-4" style="font-size:X-large;color:#512DA8;">{{studydetail.title}}</span>
            </v-col>

            <!-- 중간 정보 -->
            <v-col cols="12">
              <v-divider class="info-divider mb-2"></v-divider>
              <p class="ma-0 px-2" style="color:#512DA8">현재원 / 총원 : {{studydetail.currentPerson}} / {{studydetail.maxPerson}} </p>
              <!-- 내가 만든 스터디일 경우 마감일 필드가 안 넘어옴 -->
              <!-- <p class="ma-0 px-2">마감일 : {{studydetail.expiredDate}}</p> -->
              <p class="ma-0 px-2">장소 : {{studydetail.place}}</p>
              <v-divider class="info-divider mt-2"></v-divider>
            </v-col>

            <!-- 태그 -->
            <div class="pl-3" v-for="(tag, idx) in studydetail.tags" :key="idx">
              <span class="category-tag text-center pa-1">{{ tag.type }}</span>
            </div>

            <!-- 메인 정보 -->
            <v-col cols="12">
              <v-container class="study-detail-info">
                <v-row>
                  <v-col cols="12">
                    <h3> Reader : {{ studydetail.masterName }}</h3>
                  </v-col>
                  <v-col cols="12">
                    {{ studydetail.mainText }}
                  </v-col>
                  <v-col v-if="myStudydetail">
                   {{ myStudydetail}}

                  </v-col>

                </v-row>
              </v-container>
            </v-col>

            <!-- 내가 만든 스터디일 때 버튼 -->
            <v-col v-if="currentUser == studydetail.masterId" cols="12">
            <button class="button_update" @click="editStudy">스터디 수정하기</button>
              <button class="button_delete" @click="deletedoSend">스터디 삭제하기</button>
              <button class="button" @click="$emit('close')">창 닫기</button>
            </v-col>
            <!-- 남이 만든 스터디일 대 버튼 -->
            <v-col v-else cols="12">
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
    // console.log(`${drf.api.study()+this.pageId}`)

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