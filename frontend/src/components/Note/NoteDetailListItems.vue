<template>
  <!-- 작성 완료된 문제 요소 하나하나 0807 임지민  -->
  <!-- 문제 하나하나 받아오기 -->
  <!-- 화면 크기가 xs 이하일 때는 문제와 노트 작성 칸이 세로로 배치되게 수정하기 0805 임지민 -->

  <v-row class="mt-3">
    <!-- col 1: 상위의 createnotelist에서 받아온 문제 출력 -->
    <v-col sm="6" cols="12" class="pr-5">
      <!-- 문제 보러가기 버튼: 문제 번호 받아와서 연결 -->
      <v-row class="mt-3 mb-5">
        <router-link to="/problem" class="text-decoration-none ">
          <v-chip small outlined color="#a384ff">문제 다시 풀기</v-chip>
        </router-link>
      </v-row>

      <!-- 문제 제목 -->
      <v-row class="justify-space-between">
        <h2>158. 정보 표현의 기본 장치</h2>
      </v-row>

      <!-- 문제 지문 -->
      <v-row>
        <p class="font-parent-mid-l">다음 설명에 맞는 장치로 적절한 것은 무엇인가요?</p>
      </v-row>
      <v-row>
        <p class="font-parent-mid">
            컴퓨터에는 (       )라고 불리는 굉장히 많은 스위치가 있고,<br>
            on/off 상태를 통해 0과 1을 표현합니다.
        </p>
      </v-row>

      <!-- 문제보기: 이것도 랜덤으로 for문 돌리기/ 체크박스로 라디오 묶는거....ㅠ-->
      <v-row>
        <v-col>
          <v-row>
            <input type="radio" value="보기1" id="check1" name="bogey">
            <label for="check1" class="ml-2 font-parent-mid-l">보기 1</label>
          </v-row>
          <v-row>
            <input type="radio" value="보기2" id="check2" name="bogey">
            <label for="check2" class="ml-2 font-parent-mid-l">보기 2</label>
          </v-row>
          <v-row>
            <input type="radio" value="보기3" id="check3" name="bogey">
            <label for="check3" class="ml-2 font-parent-mid-l">보기 3</label>
          </v-row>
          <v-row>
            <input type="radio" value="보기4" id="check4" name="bogey">
            <label for="check4" class="ml-2 font-parent-mid-l">보기 4</label>
          </v-row>
        </v-col>
      </v-row>
      
      <v-row>
        <!-- 클릭하면 선지에서 보이게 -->
        <div class="text-center">
          <!-- db에서 받아온 내가 고른 답 -->
          <v-btn
            small
            outlined
            color="#a384ff"
            @click="selectMyAnswer"
          >
            내가 고른 답
          </v-btn>
        </div>
        <div class="text-center ml-3">
          <v-btn
            small
            outlined
            color="#a384ff"
            @click="selectRealAnswer"
          >
            정답
          </v-btn>

      </div>
      </v-row>
    </v-col>

    <!-- col 2: 오답노트 양식 -->
    <v-col sm="6" cols="12" class="pl-3 left-border-grey">
      <v-form class="pl-3">
        <!-- 틀린 이유 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">틀린 이유</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea 
            maxlength="150" 
            no-resize counter required dense 
            rows="3" 
            class="font-parent-mid"
            v-model="credentials.reason"> {{ credentials.reason }}</v-textarea>
          </v-col>
        </v-row>
        <!-- 추가로 공부할 것 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">추가로 공부할 것</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea maxlength="150" 
            no-resize counter required dense 
            rows="3" 
            class="font-parent-mid"
            v-model="credentials.studyContent"> {{ credentials.studyContent }} /v-textarea>
          </v-col>
        </v-row>
        <!-- 메모 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">메모</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea maxlength="150" 
            no-resize counter required dense 
            rows="3" 
            class="font-parent-mid"
            v-model="credentials.memo">  {{ credentials.memo }} </v-textarea>
          </v-col>
        </v-row>
        <!-- 수정하기 -->
        <v-row class="justify-end mt-5">
          <v-btn outlined rounded small @submit.prevent="edittNote">수정하기</v-btn>
        </v-row>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>
import axios from 'axios'

export default {
  data(){
    return {
      credentials: {
        reason: '',
        studyContent: '',
        memo: '',
      }
    }
  },
  props: {
    problem: Object,
  },
  methods :{
    selectMyAnswer() {
      // 클릭하면 내 정답에 해당되는 걸 위에 선지에서 표시
      // script에 props로 값이 넘어오니까 this.어쩌구로 받아오기
      // v-model로 스크립트와 템플릿 연결하기
      const myAnswer = this.problem.myAnswer
      const targetMyAnswer = document.querySelector(`#check${myAnswer}`)
      console.log('targetMyAnswer=', targetMyAnswer)
      targetMyAnswer.checked=true
      targetMyAnswer.setAttribute("style", "accent-color: red;")
    },
    selectRealAnswer() {
      const realAnswer = this.problem.realAnswer
      const targetRealAnswer = document.querySelector(`#check${realAnswer}`)
      console.log('targetRealAnswer=', targetRealAnswer)
      targetRealAnswer.checked=true
      targetRealAnswer.setAttribute("style", "accent-color: green;")
    },
    editNote() {
      axios({
          url: drf.note.wronganswer(),
          method: 'patch',
          data: this.credentials
      })
      .then(res => {
          console.log("res = ",res);
          const token = res.data.key
          token 
          // data에 저장해서 띄우기
          this.credentials.reason = res.data.reason
          this.credentials.studyContent = res.data.studyContent
          this.credentials.memo = res.data.memo
          // dispatch('saveToken', token)
          // dispatch('fetchCurrentUser')
      
      })
      .catch(err =>{
          console.log("에러")
          console.log(err)
        })
    }
  },
  created : {
    getNote() {
      axios({
          url: drf.note.wronganswer(),
          method: 'get',
          data: this.credentials
      })
      .then(res => {
          console.log("res = ",res);
          const token = res.data.key
          token 
          // data에 저장해서 띄우기
          this.credentials.reason = res.data.reason
          this.credentials.studyContent = res.data.studyContent
          this.credentials.memo = res.data.memo
          // dispatch('saveToken', token)
          // dispatch('fetchCurrentUser')
      
      })
      .catch(err =>{
          console.log("에러")
          console.log(err)
        })
    }
  }
}
</script>

<style>
  .left-border-grey {
    border-left: 1px solid #d9d9d9;
  }

  /* 내가 고른 답, 정답이 나오는 드롭다운의 box shadow 없애기 */
  .v-menu__content {
    box-shadow: none;
  }

</style>