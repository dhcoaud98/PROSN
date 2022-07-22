<template>
  <v-app>
    <v-container>
        <v-layout row>
           <v-img src="../assets/prosn_logo.png" max-width="300px" max-height="100px"></v-img>
        </v-layout>
        <v-layout row class="col-12">
            <div class="text-center">SIGN UP</div>
        </v-layout>
        <form action="#">
            <input type="text" placeholder="아이디" class="col-12 border-grey my-2">
            <input type="password" placeholder="비밀번호" class="col-12 border-grey my-2">
            <input type="password" placeholder="비밀번호 확인" class="col-12 border-grey my-2">
            <input type="text" placeholder="사용자 이름" class="col-12 border-grey my-2">
            <input type="email" placeholder="이메일" class="col-12 border-grey my-2">
            <v-btn>가입하기</v-btn>
            <v-btn>취소</v-btn>
        </form>
        <v-layout>
            <p>이미 계정이 있으신가요?</p>
            <span>
                <a href="#">로그인</a>
            </span>
        </v-layout>

    </v-container>
  </v-app>
</template>

<script>
export default {

}
</script>

<style>
    .border-grey {
        border: 1px solid #d9d9d9;
        border-radius: 5%
    }
</style>