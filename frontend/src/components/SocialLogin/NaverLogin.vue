<template>

</template>

<script>
import axios from 'axios';

export default {
created() {
    const naverCode = new URL(window.location.href).searchParams.get("code");
    console.log("vue에서 출력하는 naverCode ==", naverCode)
    if (naverCode) {
      axios({
        url: 'http://localhost:8080/login/oauth2/code/naver' + `?code=${naverCode}`,
        method: 'get',
      })
      .then(res =>{
        console.log(res)
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