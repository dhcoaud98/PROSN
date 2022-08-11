<template>
  <div>
    <!-- 2022.07.25. 소셜로그인 (남성은) -->
    <v-container class="px-0">
      <v-row>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn rounded color="#FFEB3B" class="col-12 my-2" height="45px">
            <img src="./assets/kakaotalk_logo.png" alt="...">
            <p class="pa-0 ma-0 font-weight-bold social-kakao">카카오로 시작</p>
          </v-btn>
        </v-col>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn rounded color="#EEEEEE" class="col-12 my-2" height="45px">
            <img src="./assets/google_logo.png" alt="...">
            <p class="pa-0 ma-0 font-weight-bold social-google">구글로 시작</p>
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
.social-kakao {
  color: #825050;
  font-size: 1.2rem;
}
.social-google {
  color: #585757;
  font-size: 1.2rem;
}
</style>