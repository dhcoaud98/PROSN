<template>
  <v-app>
    <!-- 2022.07.26 정보 모달 (남성은) -->
    <v-container>
      <v-row justify="space-around">
        <v-card width="500">
          <v-card-text class="d-flex justify-space-between">
            <a href="" class="font-weight-bold text-decoration-none black--text">크게보기</a>
            <a href="" class="font-weight-bold text-decoration-none black--text">뒤로가기</a>
          </v-card-text>

          <!-- 정보 제목 -->
          <!-- {{ problem.pk }}. {{ problem.MAIN_TEXT}} -->
          <v-card-title class="font-weight-bold black--text">
            <h2>158. 정보 표현의 기본 장치</h2> 
          </v-card-title>


          <!-- 정보 본문 -->
          <v-card-text>
            <!-- 카테고리 라벨 -->
            <!-- for문으로 돌리면 될듯 -->
            <div>
              <v-chip small color="#A384FF" class="white--text">http</v-chip>
            </div>
          </v-card-text>

          <!-- 내용 -->
          <v-card-text class="font-weight-bold mb-2">
              <v-container>
                
                  <v-row>
                    
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
                    </v-col>
                  </v-row>
              </v-container>

              <hr>
              <!-- 댓글보기 -->
              <v-btn text class="font-weight-bold mt-2">댓글보기</v-btn>           
          </v-card-text>
        </v-card>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
export default {

}
</script>

<style>

</style>