<template>
  <v-container>
    <v-row class="d-flex justify-space-between">
      <h2>158. 정보 표현의 기본 장치</h2> 
      <v-btn @click="goBack()" text class="font-weight-bold">뒤로가기</v-btn>
    </v-row>

    <v-row>
      <v-col>
        <v-chip small color="#A384FF" class="white--text">http</v-chip>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
      <h2 class="black--text">다음 설명에 맞는 장치로 적절한 것은 무엇인가요?</h2>
      </v-col>
      <v-col cols="12">
        <h3 class="black--text my-4">
            컴퓨터에는 (       )라고 불리는 굉장히 많은 스위치가 있고,<br>
            on/off 상태를 통해 0과 1을 표현합니다.
          </h3>
      </v-col>
    </v-row>

    <v-row>
      <v-container>
        <!-- 문제보기: 이것도 랜덤으로 for문 돌리기 -->
        <v-form>
          <v-row>
            <v-radio-group column class="ms-5">
              <v-radio label="보기1" color="info" value="보기1"></v-radio>
              <v-radio label="보기2" color="info" value="보기2"></v-radio>
              <v-radio label="보기3" color="info" value="보기3"></v-radio>
              <v-radio label="보기4" color="info" value="보기4"></v-radio>
            </v-radio-group>
          </v-row>
          <!-- 저작권 / 버튼 -->
          <v-row class="d-flex justify-space-between">
            <!-- 출제자 정보 -->
            <v-col>
              <div>출제자 | </div>
              
              <div>출제일 | </div>
            </v-col>
            <!-- 버튼 그룹 if로 자기 문제인 경우랑 아닌 경우 나눠서 보여주기 -->
            <v-col class="col-12 col-lg-6 col-xl-3">
              <!-- 좋아요 버튼 -->
              <v-btn class="ms-2" icon color="blue lighten-2">
                <v-icon>mdi-thumb-up</v-icon>
              </v-btn>
              <!-- 싫어요 버튼 -->
              <v-btn class="ms-2" icon color="red lighten-2">
                <v-icon>mdi-thumb-down</v-icon>
              </v-btn>
              <!-- 스크랩 버튼 -->
              <v-btn class="ms-2" icon color="dark lighten-2">
                <v-icon>mdi-folder-open</v-icon>
              </v-btn>                    
              <!-- 제출 버튼 -->
              <v-btn rounded class="ms-2" color="#F3F3F4">제출</v-btn>
            </v-col>
          </v-row>
        </v-form>
      </v-container>
    </v-row>

    <v-divider color="#A384FF" class="mt-3"></v-divider>
      
    <v-row>
      <!-- 댓글보기 -->
      <v-col cols="12" class="pa-0">
        <problem-reply></problem-reply>
      </v-col>           
    </v-row>  
  </v-container>
</template>

<script>
import ProblemReply from '@/components/ProblemModal/ProblemReply.vue'

export default {
  name: 'Problem',
  
  components: {
    ProblemReply,
  },
  methods: {
    // 2022.08.04. 라우터 경로 연결
    goBack () {
      this.$router.go(-1)
    }
  }
}
</script>

<style>

</style>