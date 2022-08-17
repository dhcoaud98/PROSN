<template>

</template>

<script>
import axios from 'axios';

export default {
created() {
    const naverCode = new URL(window.location.href).searchParams.get("code");
    const naverState = new URL(window.location.href).searchParams.get("state");
    console.log("vue에서 출력하는", new URL(window.location.href))
    console.log("vue에서 출력하는", new URL(window.location.href).searchParams.get("state"))
    console.log("vue에서 출력하는 naverCode ==", naverCode)
    if (naverCode) {
      axios({
        url: 'http://localhost:8080/login/oauth2/code/naver' + `?code=${naverCode}` + `?state=${naverState}`,
        method: 'get',
      })
      .then(res =>{
        console.log("naverres=", res)
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