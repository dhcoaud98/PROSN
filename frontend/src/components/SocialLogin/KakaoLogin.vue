<!-- redirect URL : http://localhost:3000/login/oauth2/code/kakao -->
<template>
</template>

<script>
import axios from 'axios';

export default {
  name: 'KakaoLogin',
  created() {
    const kakaoCode = new URL(window.location.href).searchParams.get("code");
    console.log("vue에서 출력하는 code =", kakaoCode)
    if (kakaoCode) {
      axios({
        url: `http://localhost:8080` + '/login/oauth2/code/kakao',
        method: 'get',
        "code" : this.kakaoCode
      })
      .then(res =>{
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    }

  }
}
</script>

<style>

</style>