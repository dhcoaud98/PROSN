<template>
  <!-- 문제 하나하나 받아오기 -->

  <v-row class="mt-3">
    <!-- col 1: 상위의 createnotelist에서 받아온 문제 출력 -->
    <v-col cols="6" class="pr-5">
      <!-- 문제 보러가기 버튼: 문제 번호 받아와서 연결 -->
      <v-row class="mt-3 mb-5">
        <v-chip x-small outlined color="#a384ff">문제보러가기</v-chip>
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
        <v-form>
          <v-row>
            <v-radio-group column class="ms-5" v-model="active">
              <v-radio label="보기1" color="info" value="보기1"></v-radio>
              <v-radio label="보기2" color="info" value="보기2" off-icon="$radioOn"></v-radio>
              <v-radio label="보기3" color="info" value="보기3"></v-radio>
              <v-radio label="보기4" color="info" value="보기4"></v-radio>
            </v-radio-group>
          </v-row>
        </v-form>
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
    <v-col cols="6" class="pl-3 left-border-grey">
      <v-form class="pl-3">
        <!-- 틀린 이유 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">틀린 이유</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea maxlength="150" no-resize counter required dense></v-textarea>
          </v-col>
        </v-row>
        <!-- 추가로 공부할 것 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">추가로 공부할 것</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea maxlength="150" no-resize counter required dense></v-textarea>
          </v-col>
        </v-row>
        <!-- 메모 -->
        <v-row class="mx-2 my-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold font-parent-mid-l mb-0">메모</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea maxlength="150" no-resize counter required dense></v-textarea>
          </v-col>
        </v-row>
        <!-- 저장히기 -->
        <v-row class="justify-end mt-5">
          <v-btn outlined rounded>저장하기</v-btn>
        </v-row>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data(){
    return {
      myAnswer: '',
      realAnswer: '',
    }
  },
  methods :{
    selectMyAnswer() {
      // 클릭하면 내 정답에 해당되는 걸 위에 선지에서 표시
      // v-model로 스크립트와 템플릿 연결하기
    },
    selectRealAnswer() {

    },
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