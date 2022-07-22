<template>
  <v-app>
    <v-main>
      <!-- 로그인 화면 구성요소들 -->
      <v-contanier class="d-flex align-center " style="height:100%">
        <v-row>
          <!-- 로고랑 서비스 설명 -->
          <v-col class="col-6 d-flex flex-column align-center">
            <img src="@/assets/prosn_logo.png" alt="prosn_logo">
            <div><h3>prosn은 어쩌구 저쩌구 이러쿵 저러쿵</h3></div>
          </v-col>
  
          <!-- 로그인 -->
          <v-col class="col-6 d-flex flex-column align-center">
            <div>
              <h1>Login</h1>
            </div>
              <!-- 로컬 로그인 -->
              <local-login></local-login>

              <!-- 소셜 로그인 -->
              <social-login></social-login>
          </v-col>
        </v-row>
      </v-contanier>
    </v-main>
  </v-app>
</template>

<script>
  import LocalLogin from '@/components/LocalLogin.vue'
  import SocialLogin from '@/components/SocialLogin.vue'

  export default {
    name: 'App',

    data: () => ({
      //
    }),
    components: {
      LocalLogin,
      SocialLogin,
    },
  }
</script>

<style>
  img {
    width: 70%
  }
</style>
