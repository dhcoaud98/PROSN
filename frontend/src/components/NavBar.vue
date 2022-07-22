<template>
  <v-app>
    <v-navigation-drawer permanent class="mt-5 ml-3 pt-2 pl-2" width="26%">
      <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="50px"></v-img>
      <v-list-item class="mt-5">
        <v-list-item-content class="left-line-perm">
          <v-list-item-title class="left-line pl-5 py-3 mb-2">스터디</v-list-item-title>
          <v-list-item-title class="left-line pl-5 py-3 mb-2">오답노트</v-list-item-title>
          <v-list-item-title class="left-line pl-5 py-3 mb-2">프로필</v-list-item-title>
          <router-link to="/signup">
            <v-list-item-title class="left-line pl-5 py-3 mb-2">회원가입</v-list-item-title>
          </router-link>
        </v-list-item-content>
      </v-list-item>
    </v-navigation-drawer>
  </v-app>
</template>

<script>
export default {

}
</script>

<style>
  /* .left-line-perm {
    border-left: 5px solid #d9d9d9;
  } */
  .left-line {
    border-left: 5px solid #d9d9d9;
  }
  :hover.left-line {
    border-left: solid 5px #A384FF;
  }
</style>