<template>
  <!-- 네비게이션 바: xs에서는 안보이고 하단바로 이동 -->
  <v-container fluid class="bg-grey">
    <v-navigation-drawer class="mt-5 ml-3">
      <v-row class="mb-5">
        <v-col>
          <router-link to="/">
            <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="50px" class="mb-5"></v-img>
          </router-link>
        </v-col>
      </v-row>
      <div class="mt-5">
        <v-row>
          <v-col class="left-line ml-4">
            <p class="pl-3">스터디</p>
          </v-col>
        </v-row>
        <v-row>
          <v-col class="left-line ml-4">
            <p class="pl-3">오답노트</p>
          </v-col>
        </v-row>
        <!-- 
          로그인이 된 경우만 보이도록, created될 때 로그인이 되었는 지 확인해서 로그인이 되었으면 loginDisplay 값을 d-flex로 바꾸기 \
          - 지금은 로그인 구현 전이니까 편의상 기본값을 d-flex로 해놓음
          -->
        <v-row :class="loginDisplay">
          <v-col class="left-line ml-4">
            <p class="pl-3">내 프로필</p>
          </v-col>
        </v-row>
      </div>
    </v-navigation-drawer>
  </v-container>

  <!-- 하단바: xs에서 보임; fixed-bottom -->

</template>

<script>
export default {
  data () {
    return {
      loginDisplay: 'd-flex'
    }
  },
  methods: {
    // onClick event 사용: 한번 클릭하면 bold + 보라색, 다시 클릭하면 원상태로 돌아오게
  }
}
</script>

<style>
  /* .left-line-perm {
    border-left: 5px solid #d9d9d9;
  } */
  .left-line {
    border-left: 5px solid #d9d9d9;
  }
  :hover.left-line{
    border-left: solid 5px #A384FF;
    font-weight: bold;
  }
  .v-application--wrap {
    max-width: 280px;
  }
  .v-navigation-drawer__content {
    background-color: #f5f5f5;
  }
</style>