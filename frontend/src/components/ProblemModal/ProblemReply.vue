<template>
  <v-card-text>
    <!-- 2022.08.03.댓글창 -->
    <v-container fluid class="rounded-lg replies" >
      <!-- 댓글창제목 -->
      <v-row class="ma-1">
        <v-col cols="12">
          <h2>댓글</h2>
        </v-col>
      </v-row>

      <v-divider color="#A384FF"></v-divider>

      <!-- 2022.08.03. 댓글 목록 -->
      <!-- 추후에 더미 데이터 넣고 버추얼스크롤 넣어서 확인하기-->
      <!-- 여기서 for문 돌려서 ProblemReplyItems 하나씩 띄우기 -->
      <v-row>
        <v-col class="pa-0">
          <problem-reply-items></problem-reply-items>
        </v-col>
      </v-row>
    </v-container>

    <!-- 댓글 입력란 -->
    <v-container fluid class="rounded-lg replies mt-3">
      <v-form>
        <v-textarea background-color="#f5f5f5" rows="1" placeholder="댓글을 작성해주세요" no-resize dense></v-textarea>
        <v-btn type="submit" color="#A384FF" text>
          댓글달기
        </v-btn>
      </v-form>

    </v-container>
  </v-card-text>
</template>

<script>
import ProblemReplyItems from '@/components/ProblemModal/ProblemReplyItems.vue'

export default {
  name: 'ProblemReply',
  components: {
    ProblemReplyItems,
  }
}
</script>

<style>
  .replies {
    background-color: #f5f5f5;
  }
</style>