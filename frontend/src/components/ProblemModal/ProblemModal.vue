<template>
  <div>
    <v-container>
      <v-row justify="space-around">
        <v-card width="500">
          <v-card-text class="d-flex justify-space-between">
            <a href="">크게보기</a>
            <a href="">뒤로가기</a>
          </v-card-text>

          <!-- 문제 제목 -->
          <!-- {{ problem.pk }}. {{ problem.MAIN_TEXT}} -->
          <v-card-title class="font-weight-bold black--text">
            <h2>158. 정보 표현의 기본 장치</h2> 
          </v-card-title>


          <!-- 문제 본문 -->
          <v-card-text>
            <!-- 카테고리 라벨 -->
            <!-- for문으로 돌리면 될듯 -->
            <div>
              <v-chip small color="#A384FF" class="white--text">http</v-chip>
            </div>
          </v-card-text>

          <!-- 문제 -->
          <v-card-text class="font-weight-bold mb-2">
            <h2 class="black--text">
            다음 설명에 맞는 장치로 적절한 것은 무엇인가요?
            </h2>

            <!-- 문제지문 -->
            <h3 class="black--text my-4">
              컴퓨터에는 (       )라고 불리는 굉장히 많은 스위치가 있고,<br>
              on/off 상태를 통해 0과 1을 표현합니다.
            </h3>

            <div>
              <v-container>
                <!-- 문제보기: 이것도 랜덤으로 for문 돌리기/ 체크박스로 라디오 묶는거....ㅠ-->
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
                    <v-col>
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

              <hr>
              <!-- 댓글보기 -->
              <v-btn text>댓글보기</v-btn>
            </div>
          </v-card-text>
        </v-card>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>