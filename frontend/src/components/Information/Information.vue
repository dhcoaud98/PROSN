<template>
  <!-- 2022.08.04 정보 페이지 -->
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
      <v-card outlined class="mx-3 mb-2 pa-3 overflow-y-auto" max-height="500px" width="100%">
        <v-card-text>
          <div>
            아<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>제발좀 되라 좀 제발
          </div>                
        </v-card-text>
      </v-card>
    </v-row>

    <v-row>
      <v-container>
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
          </v-col>
        </v-row>
      </v-container>
    </v-row>

    <v-divider color="#A384FF" class="mt-3"></v-divider>
      
    <v-row>
      <!-- 댓글 -->
      <v-col cols="12" class="pa-0">
        <info-modal-reply></info-modal-reply>
      </v-col>           
    </v-row>  
  </v-container>
</template>

<script>
import InfoModalReply from '@/components/InfoModal/InfoModalReply.vue'

export default {
  name: 'Information',
  components: {
    InfoModalReply,
  },
  methods: {
    // 2022.08.04. 라우터 경로 연결
    goBack () {
      this.$router.go(-1)
    }
  },
}
</script>

<style>

</style>