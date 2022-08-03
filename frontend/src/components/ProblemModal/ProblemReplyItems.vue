<template>
  <!-- 2022.07.26 댓글창 (남성은) -->
  <v-card rounded elevation="2" class="ma-2 pa-4 mx-1">
    <v-container>
      <v-row>
        <v-col class="pa-0 mb-3">댓글내용</v-col>
      </v-row>
      <v-row>
        <v-col cols="4" class="d-flex align-end secondary--text text--lighten-3 pa-0">작성자 |</v-col>
        <v-col cols="5" class="d-flex align-end secondary--text text--lighten-3 pa-0">최종작성일시 |</v-col>
        <v-col cols="3" class="d-flex justify-end py-0 font-weight-bold #817EF4--text" style="color:#817EF4"><h3>답글</h3></v-col>
        <!-- 2022.08.03. 답글 누르면 답글 입력란 보이게 하기 -->
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
export default {

}
</script>

<style>

</style>