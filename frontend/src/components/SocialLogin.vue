<template>
  <div>
    <!-- 2022.07.25. 소셜로그인 (남성은) -->
    <v-container class="px-0">
      <v-row>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn x-large text class="pa-0">
            <img elevation="3" id="kakao-login" src="@/assets/kakao_login.png" alt="...">
          </v-btn>
        </v-col>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn x-large text class="pa-0">
            <img id="google-login" src="@/assets/google_login.png" alt="...">
          </v-btn>
        </v-col>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn x-large text class="pa-0">
            <img id="naver-login" src="@/assets/naver_login.png" alt="...">
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
}
</script>

<style>
#kakao-login {
  height: 60px;
  width: 250px;
}
#google-login {
  height: 64px;
  width: 256px;
}
#naver-login {
  height: 60px;
  width: 250px;
}
</style>