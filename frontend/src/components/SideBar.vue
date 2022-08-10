<template>
  <!-- 채명왈 : lg 사이즈 이하에서는 사이드바가 보이지 않음! -->
  <!-- sidebar가 작은 화면에서 사라지는 문제: v-navigation-drawer 태그를 안쓰니까 해결됨 (0808 임지민) -->
  <v-container fluid class="bg-grey pa-0 mt-1 ml-3">
    <v-row>
      <!-- 채명왈 : login이랑 logout 나중에 router로 연결하면 됨 -->
      <v-col cols="6" class="justify-center pa-0">
        <li style="list-style: none;" v-if="!isLoggedIn">
          <router-link to="/signup" class="text-decoration-none black--text"><v-btn class="pa-0" rounded-sm color="#a384ff" width="100%" text>signup</v-btn></router-link>
        </li>
        <!-- 08.07 오채명 : 후에 유저 이름을 클릭하면 유저의 프로필로 넘어갈 수 있도록 함. -->
        <li style="list-style: none;" v-if="isLoggedIn">
          <router-link to="/profile" class="text-decoration-none black--text"><v-btn class="pa-0" rounded-sm color="#a384ff" width="100%" text>{{ userName }}</v-btn></router-link>
        </li>
      </v-col>
      
      <v-col cols="6" class="justify-center pa-0">
        <li style="list-style: none;" v-if="!isLoggedIn">
          <router-link to="/login" class="text-decoration-none black--text"><v-btn class="pa-0" rounded-sm color="#a384ff" width="100%" text>login</v-btn></router-link>
        </li>
        <li style="list-style: none;" v-if="isLoggedIn">
          <v-btn class="pa-0" rounded-sm color="#a384ff" width="100%" text @click="logout">logout</v-btn>
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
    <v-card class="mx-auto mb-5 pink-gradation rounded-xl" height ="auto">
      <v-card-text class="pa-5">
        <v-contatiner>
        
          <!-- 전체제목 -->
          <v-row class="mt-2">
            <v-col class="pa-0">
              <p class="d-flex justify-center mb-0 color-magenta font-weight-bold">🎨 이주의 인기 문제</p>
            </v-col>
          </v-row>

          <!-- 상위 3개문제 -->
          <v-row>
            <v-container class="px-5 mb-2">
              <!-- v-for문 돌릴것들 -->
              <!-- 각 추천문제 -->
              <v-row class="ps-2">
                <p class="title-font-size font-weight-bold mb-0">No.1 (문제 제목)</p>
              </v-row>    
              <v-row class="d-flex justify-space-between font-weight-bold mt-1">
                <div class="circle-background pa-0 d-flex justify-center align-center text-center">
                  추천<br>1111
                </div>
                <div class="circle-background pa-0 d-flex justify-center align-center text-center">
                  참여자<br>123명
                </div>
                <div class="circle-background pa-0 d-flex justify-center align-center text-center">
                  정답률<br>50%
                </div>
              </v-row>
              <!-- 여기까지를 v-for문 돌리면 됨 -->
            </v-container>
          </v-row>

          <!-- 실시간 시간 표시 -->
          <v-row class="d-flex justify-end">
            <p class="text-right ma-0">{{nowDate}} {{nowTime}} 실시간</p>
          </v-row>
        </v-contatiner>
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
.color-magenta {
  color: #C2185B;
  font-size: 1.5em;
}
.pink-gradation {
  background: linear-gradient(#E7C0F4, #F0BBCF);
}
.title-font-size {
  font-size: 1.1em;
}
.circle-background {
  background: #FFF4F8;
  height: 65px;
  width: 65px;
  border-radius: 50%;
}
</style>