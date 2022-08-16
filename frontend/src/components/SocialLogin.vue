<template>
  <div>
    <!-- 2022.07.25. 소셜로그인 (남성은) -->
    <v-container class="px-0">
      <v-row>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn rounded color="#FFEB3B" class="col-12 mt-2 d-flex justify-space-between" height="45px">
            <!-- <img src="@/assets/kakaotalk_logo.png" alt="..." class="social-logo"> -->
            <p class="pa-0 ma-0 font-weight-bold social-kakao">Kakao로 시작</p>
            <div class="pa-2"></div>
          </v-btn>
        </v-col>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn rounded color="#EEEEEE" class="col-12 d-flex justify-space-between" height="45px">
            <!-- <img src="@/assets/google_logo.png" alt="..." class="social-logo"> -->
            <p class="pa-0 ma-0 font-weight-bold social-google">GOOGLE 로 시작</p>
            <div class="pa-2"></div>
          </v-btn>
        </v-col>
        <v-col cols="12" class="d-flex justify-center">
          <v-btn rounded color="#33CA00" class="col-12 mb-2 d-flex justify-space-between" height="45px">
            <!-- <img src="@/assets/naver_logo.png" alt="..." height="40px" width="40px"> -->
            <p class="pa-0 ma-0 font-weight-bold social-naver">NAVER로 시작</p>
            <div class="pa-2"></div>
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
.social-naver {
  color:white;
  font-size: 1.2rem;
}
.social-logo {
  margin-left: 10px;
  height: 25px;
  width: 25px;
}
</style>