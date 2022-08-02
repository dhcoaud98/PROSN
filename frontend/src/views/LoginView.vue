<template>
  <v-app>
    <v-main>
      <!-- 2022.07.22 로그인 화면 구성요소들 (남성은) -->
      <v-container class="d-flex align-center " style="height:100%">
        <v-row>
          <!-- 로고랑 서비스 설명 -->
          <v-col class="d-flex flex-column align-center justify-center col-md-6 col-12">
            <img src="@/assets/prosn_logo.png" alt="prosn_logo">
            <div class="text-center mt-5 d-none d-md-block">
              <h3>Problem과 SNS의 만남인 PROSN은</h3><br>
              <h3>IT에 관한 문제를 자유롭게 풀고 출제할 수 있는 서비스입니다.</h3>                
            </div>
          </v-col>
  
          <!-- 로그인 -->
          <v-col class="d-flex flex-column align-center justify-center col-md-6 col-12">
            <div>
              <h1>L O G I N</h1>
            </div>
            <!-- 로컬 로그인 -->
            <local-login></local-login>

            <!-- 소셜 로그인 -->
            <social-login></social-login>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
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
    color: #f9f9f9;
  }

  img {
    width: 70%
  }
</style>