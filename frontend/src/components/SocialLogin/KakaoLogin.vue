<template>

</template>

<script>
import axios from 'axios';

export default {
created() {
    const kakaoCode = new URL(window.location.href).searchParams.get("code");
    console.log("vue에서 출력하는 kakaoCode ==", kakaoCode)
    if (kakaoCode) {
      axios({
        url:'http://localhost:8080/login/oauth2/code/kakao' + `?code=${kakaoCode}`,
        method: 'get',
      })
      .then(res =>{
        console.log(res.data)
        /*
        accessToken: "EWpduMJ8S1-JROOFJYwtuUSfLBPqwAxP1J8Ou6VdCj102wAAAYKq1JQz"
        email: "dhcoaud98@gmail.com"
        name: "오채명"
        oauthId: 2392181117
        platform: "KAKAO"
        refreshToken: "71QJsxvUXvvfdwrb2WUb6g4ZdktUYu4Sebpjuz2pCj102wAAAYKq1JQx"
        */
        // this.$store.dispatch(
        //   'saveToken',
        //   grantType + ' ' + res.data.accessToken
        // );
        // this.$store.dispatch('saveId', res.data.id);
        // this.$store.dispatch('saveRefreshToken', res.data.refreshToken);
        // this.$store.dispatch('saveName', res.data.name);
        this.$router.push({path:"/"})
      })
      .catch(err => {
        console.log("에러",err)
      })
    }
  }

}
</script>

<style>

</style>