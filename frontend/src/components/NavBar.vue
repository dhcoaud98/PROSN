<template>
  <v-card 
      height="400"
      width="256"
      class="mx-auto"
      color="transparent"
    >
      <v-navigation-drawer permanent class="mt-2">
        <v-list-item class="mt-5">
          <v-list-item-content>
            <v-list-item-title>
              <router-link to="/">
                <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="50px" class="mb-5" id="mainPage" @click="searchCleard()"></v-img>
              </router-link>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list nav>
          <v-list-item>
            <v-list-item-content class="py-0 font-parent-mid">
              <router-link :to="`/study`" class="text-decoration-none black--text mb-0">
                <v-list-item-title class="left-line ml-5 ms-0 mb-0 py-5 pl-5" :id="items[0].urlName">{{ items[0].text }}</v-list-item-title>
              </router-link>         
            
              <router-link :to="`/note`" class="text-decoration-none black--text mb-0">
                <v-list-item-title class="left-line ml-5 ms-0 mb-0 py-5 pl-5" :id="items[1].urlName">{{ items[1].text }}</v-list-item-title>
              </router-link>     
              
              <router-link :to="`/profile/${currentUser}`" class="text-decoration-none black--text mb-0">
                <v-list-item-title class="left-line ml-5 ms-0 mb-0 py-5 pl-5" :id="items[2].urlName">{{ items[2].text }}</v-list-item-title>
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
import { mapGetters } from 'vuex'

export default {
  name: 'NavBar',
  data () {
    return {
      tmp: '',
      loginDisplay: 'd-flex',
      items: [
        { 
          text: 'S T U D Y',
          url: 'study',
          urlName: 'study',
        },
        { 
          text: 'N O T E S',
          url: 'note',
          urlName: 'note',
        },
        { 
          text: 'P R O F I L E',
          url: `profile/${this.tmp}`,
          urlName: 'profile',
        },
      ]
    }
  },
  computed: {
    ...mapGetters(['currentUser'])
  },
  watch: {
    // url이 바뀔 때마다 감시해서 nav바 상태 바꿔주기
    $route(to, from) {
      //console.log(to) // 도착지
      //console.log(from) // 출발지
      if(to.name !== 'mainPage') {
        // 도착지의 name에 해당하는 태그는 clicked-tab을 넣고
        const toTag = document.querySelector(`#${to.name}`)
        toTag.classList.add('clicked-tab')
      }
      // 출발지의 name에 해당하는 태그는 clicked-tab을 빼기
      const fromTag = document.querySelector(`#${from.name}`)
      fromTag.classList.remove('clicked-tab')
    }
  },
  methods: {
    searchCleard: function(event) {
            this.$store.dispatch('problem/searchKeyword', "")
    },
  },
  created () {
    // console.log(`profile/${this.currentUser}`)
    // console.log(typeof(this.currentUser))
    this.tmp = this.currentUser
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
  .clicked-tab {
    border-left: solid 5px #A384FF;
    font-weight: bold;
    color: #774BFA;
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