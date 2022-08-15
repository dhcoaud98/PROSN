<template>
  <div>
    <a href="custom-login-btn" @click="kakaoLogin()">
      <img 
        src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
        width="222"
        />
    </a>
  </div>
</template>

<script>
export default {
  methods: {
    kakaoLogin() {
      console.log(window.Kakao)
      window.Kakao.Auth.login({
        redirect_uri: 'http://localhost:8080/login/oauth2/code/kakao&response_type=code',
        // scope: 'profile_nickname, account_email',
        // success: this.getKakaoAccount,
      })
    },
    // getKakaoAccount() {
    //   window.Kakao.API.request({
    //     url: '/v2/user/me',
    //     success: res => {
    //       const kakao_account = res.kaka0_account;
    //       const nickname = kakao_account.nickname;
    //       const email = kakao_account.email;
    //       console.log('nickname', nickname)
    //       console.log('email', email)

    //       alert("로그인 성공!");
    //     },
    //     fail: error => {
    //       console.log(error);
    //     }s
    //   })
    // }
  }
}

</script>
<style>
</style>