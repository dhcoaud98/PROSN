<template>
  <!-- 채명왈 : lg 사이즈 이하에서는 사이드바가 보이지 않음! -->
  <!-- sidebar가 작은 화면에서 사라지는 문제: v-navigation-drawer 태그를 안쓰니까 해결됨 (0808 임지민) -->
  <v-container fluid class="bg-grey pa-0 mt-1 ml-3">
    <v-row>
      <!-- 채명왈 : login이랑 logout 나중에 router로 연결하면 됨 -->
      <v-col cols="6" class="justify-center">
        <li style="list-style: none;" v-if="!isLoggedIn">
          <router-link to="/signup" class="text-decoration-none black--text"><v-btn rounded-sm color="#a384ff" style="width: 120%;" text>signup</v-btn></router-link>
        </li>
        <!-- 08.07 오채명 : 후에 유저 이름을 클릭하면 유저의 프로필로 넘어갈 수 있도록 함. -->
        <li style="list-style: none;" v-if="isLoggedIn">
          <router-link to="/profile" class="text-decoration-none black--text"><v-btn rounded-sm color="#a384ff" style="width: 120%;" text>{{ userName }}</v-btn></router-link>
        </li>
      </v-col>
      
      <v-col cols="6" class="justify-center">
        <li style="list-style: none;" v-if="!isLoggedIn">
          <router-link to="/login" class="text-decoration-none black--text"><v-btn rounded-sm style="width: 120%;" color="#a384ff" text>login</v-btn></router-link>
        </li>
        <li style="list-style: none;" v-if="isLoggedIn">
          <v-btn rounded-sm class="text-decoration-none" style="width: 120%;" color="#a384ff" @click="logout" text>logout</v-btn>
        </li>
      </v-col>
    </v-row>

    <v-row class="pa-0 ma-0">
      <v-col class="px-0 pb-0">
        <search-bar></search-bar>
      </v-col>
    </v-row> 

    <!-- 1. 오늘의 인기 문제 -->
    <!-- icon 찾기 -->
    <v-card class="mx-auto mb-5 rounded-xl" height ="280px" color="#FCE4EC">
      <v-card-text>
        <p class="text-h6 text--primary d-flex justify-center mb-0">{{nowDate}} 인기 문제</p>
        <p class="text-right ma-0 mb-2">{{nowDate}} {{nowTime}} 실시간</p>
        <p class="text-h6 mb-0">No.1 [문제 제목]</p>
        <v-container class="grey lighten-5 mb-4 pa-0" elevation="3">
          <v-row>
            <v-col col="4" class="d-flex justify-center pink darken-2">추천</v-col>
            <v-col col="4" class="d-flex justify-center pink lighten-2">참여자</v-col>
            <v-col col="4" class="d-flex justify-center">정답률</v-col>
          </v-row>
        </v-container>
        <p class="text-h6 mb-0">No.2 [문제 제목]</p>
        <v-container class="grey lighten-5 pa-0">
          <v-row>
            <v-col cols="4" class="d-flex justify-center pink darken-2" color="red">추천</v-col>
            <v-col cols="4" class="d-flex justify-center pink lighten-2">참여자</v-col>
            <v-col cols="4" class="d-flex justify-center">정답률</v-col>
          </v-row>
        </v-container>
      </v-card-text>
    </v-card>

    <!-- 2. 오늘의 유저 -->
    <v-card class="mx-auto mb-5 rounded-xl" height ="330px" color="#EDE7F6">
      <v-card-text class="pb-0">
        <p class="text-h6 text--primary d-flex justify-center mb-0 color--#f3f3f3">{{nowDate}} 유저 랭킹</p>
        <p class="text-right">{{nowDate}} {{nowTime}} 실시간</p>
        <v-row>
          <v-col cols="12">
            <!-- 2022.08.04. flat Invalid type error 수정 -->
            <v-card color="transparent" flat>
              <v-list two-line>
                <template>
                <!-- 2022.08.04. template에서 v-bind:key 쓰지 못하는 문제 해결 -->
                <!-- <template v-for=item in items.slice(0.6)> -->
                  <v-list-item v-for="(item,index) in items.slice(0.6)" :key="index" height="5px">
                  <!-- <v-list-item height="5px"> -->
                    <v-list-item-avatar>
                      <img :src= "item.avatar">
                    </v-list-item-avatar>
                    <v-list-item-content>
                      <v-list-item-title>{{ item.name }}</v-list-item-title>
                      <v-list-item-subtitle>{{ item.total }}</v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>
                </template>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </v-container>
</template>



<script>
import SearchBar from './SearchBar.vue';
import { mapGetters } from 'vuex';

export default {
  name: "SideBar",
  components : {
    SearchBar,
  }, 
  data () {
    return {
      timer: null,
      nowDate: '',
      nowTime: '',
      // inputData: null,
      items: [
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg', name: '채명', total: 538  },
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg', name: '지민', total: 621  },
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg', name: '성은', total: 524  },
      ],
    }
  },
  computed: {
    ...mapGetters(['userName','isLoggedIn',]),
    isSearched() {
      return this.$store.getters['problem/isSearched']
    }
  },
  mounted () {
    this.timer = setInterval(() => {
      //console.log("이름 = ", this.userName);
      //console.log("로그인 확인 : ", this.isLoggedIn)
    this.setNowTimes()
    },1000)

  },
  methods: {
    setNowTimes() {
      let myDate = new Date()
      let mm = myDate.getMonth() + 1
      let dd = String(myDate.getDate() < 10 ? '0' + myDate.getDate() : myDate.getDate())
      let hou = String(myDate.getHours() < 10 ? '0' + myDate.getHours() : myDate.getHours())  
      let min = String(myDate.getMinutes() < 10 ? '0' + myDate.getMinutes() : myDate.getMinutes())  
      let sec = String(myDate.getSeconds() < 10 ? '0' + myDate.getSeconds() : myDate.getSeconds()) 
      this.nowDate = mm + '월 ' + dd + '일'
      this.nowTime = hou + ':' + min + ':' + sec 
    },
    logout () {
      console.log("logout click");
      this.$store.dispatch('removeToken', "")
      this.$store.dispatch('removeName', "")
      sessionStorage.setItem('accessToken', "")
    },
    // 유저 정보 모두 가져와서 문제 많이 푼 횟수로 3개 가져오기
    // sidebarPopularUser() {
    //     axios({
    //             url: drf.accounts.login(),
    //             method: 'post',
    //             data: this.credentials
    //         })
    //         .then(res => {
    //             console.log("res = ",res);
    //             console.log("accessToken = ",res.data.accessToken);
    //             let grantType = res.data.grantType.replace(res.data.grantType.charAt(0), res.data.grantType.charAt(0).toUpperCase());
    //             console.log("grantType:", grantType);
    //             this.$store.dispatch('saveToken', grantType+" "+res.data.accessToken)
    //             this.$store.dispatch('saveName', res.data.name)
    //             this.$router.push({ path: '/'})
    //         })
    //         .catch(err =>{
    //             console.log("에러")
    //             console.log(err)
    //         })
    //   },
  }
}
</script>

<style>
.btn {
  color: aqua;
}
</style>