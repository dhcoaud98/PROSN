<template>
      <!-- 2022.07.22 로그인 화면 구성요소들 (남성은) -->
      <!-- 0805 임지민 
        - 로고, 서비스 설명 부분 grey lighten-4 처리   
        - 가운데 정렬보다 왼쪽 정렬이 깔끔한 것 같아서 바꿨는 데 제 소견일 뿐 화면 보고 이전이 나오면 바꿔도 됩니당
        - prosn 로고가 큰 것 같아 사이즈 조금 작게 수정함   
        - 로고에 홈화면 연결   
      -->
  <v-container class="d-flex align-center grey lighten-4">
    <v-row id="login-page">
      <!-- 로고랑 서비스 설명 -->
      <v-col class="d-flex flex-column justify-center col-md-6 col-12">
        <router-link to="/">
          <img src="@/assets/prosn_logo.png" alt="prosn_logo" class="mb-5" style="width: 50%">
        </router-link>
        <div class="mt-5 d-none d-md-block">
          <h3>Problem과 SNS의 만남인 PROSN은</h3>
          <h3>IT에 관한 문제를 자유롭게 풀고 출제할 수 있는 서비스입니다.</h3>                
        </div>
      </v-col>

      <!-- 로그인 -->
      <v-col 
      class="d-flex flex-column align-center justify-center col-md-6 col-12 white border-a-10">
        <div class="mt-5">
          <p class="font-parent-lar font-weight-bold">L O G I N</p>
        </div>
        <!-- 로컬 로그인 -->
      <v-row class="px-5">
        <v-col class="mx-5">
          <local-login></local-login>

          <!-- 소셜 로그인 -->
          <social-login></social-login>
        </v-col>
      </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import LocalLogin from '@/components/LocalLogin.vue'
import SocialLogin from '@/components/SocialLogin.vue'


export default {
  name: 'LoginView',
  data: () => ({
    //
  }),
  components : {
    LocalLogin,
    SocialLogin,
  }
};
</script>

<style>
html {
  background-color: #f9f9f9;
}
img {
  width: 70%
}
</style>