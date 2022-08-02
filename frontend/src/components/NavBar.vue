<template>
  <v-card 
      height="400"
      width="256"
      class="mx-auto"
      color="transparent"
      d-none
      d-md-flex
    >
      <v-navigation-drawer permanent class="mt-2">
        <v-list-item class="mt-5">
          <v-list-item-content>
            <v-list-item-title>
              <router-link to="/">
                <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="50px" class="mb-5"></v-img>
              </router-link>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list nav>
          <v-list-item v-for="(item, i) in items" :key="i">

            <v-list-item-content class="py-0 font-parent-mid">
              <!-- <네브바만 남기고 오른쪽 영역 갈아끼기> 0729 임지민
                클릭하면 to 속성 변경-> app.vue에서 해야하는데 컴포넌트 구조가 복잡해서 prop하고 emit하기가 어려울 것 같다.
                그래서 vuex를 활용해서 특정 요소를 클릭하면 app.vue의 router-view/link의 name/to 속성을 바꾼다.
                  - 클릭하면 vuex로 fetch해서 요소를 바꾸고
                그래서 app.vue가 created될 때 vuex에서 state를 가져와서 띄운다.
               -->
              <router-link :to="item.urlName" class="text-decoration-none black--text">
                <v-list-item-title class="left-line ml-5 mb-0 py-5 pl-5" v-text="item.text"></v-list-item-title>
              </router-link>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </v-card>
    
  <!-- <v-app class="bg-grey d-none d-sm-flex">
    네비게이션 바: xs에서는 안보이고 하단바로 이동
    <v-container fluid class="bg-grey d-none d-sm-flex">
      <v-navigation-drawer class="mt-5 ml-3 d-none d-sm-flex">
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
          
            로그인이 된 경우만 보이도록, created될 때 로그인이 되었는 지 확인해서 로그인이 되었으면 loginDisplay 값을 d-flex로 바꾸기 \
            - 지금은 로그인 구현 전이니까 편의상 기본값을 d-flex로 해놓음

          <v-row :class="loginDisplay">
            <v-col class="left-line ml-4">
              <p class="pl-3">내 프로필</p>
            </v-col>
          </v-row>
        </div>
      </v-navigation-drawer>
    </v-container>

    <하단바: xs에서 보임; fixed-bottom 
  </v-app> -->
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'NavBar',
  data () {
    return {
      loginDisplay: 'd-flex',
      items: [
        { 
          text: '스터디',
          urlName: '/study'
        },
        { 
          text: '오답노트',
          urlName: '/note'
        },
        { 
          text: '내 프로필',
          urlName: '/profile'
        },

      ]
    }
  },
  methods: {
    // onClick event 사용: 한번 클릭하면 bold + 보라색, 다시 클릭하면 원상태로 돌아오게

  },
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
  .v-navigation-drawer__border {
    background-color: #f5f5f5;
  }

  /* 네브바 box shadow, 선 없애기 */
  .v-sheet.v-card:not(.v-sheet--outlined) {
    box-shadow: none;
  }
  .theme--light.v-navigation-drawer:not(.v-navigation-drawer--floating) .v-navigation-drawer__border {
    background-color: transparent;
  }

  /* 각 탭 아래에 생기는 마진 없애기 */
  .v-list--nav .v-list-item:not(:last-child):not(:only-child), .v-list--rounded .v-list-item:not(:last-child):not(:only-child) {
    margin-bottom: 0;
  }
</style>