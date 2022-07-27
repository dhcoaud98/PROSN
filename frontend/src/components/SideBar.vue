<template>
  <v-container fluid class="bg-grey">
    <!-- 채명왈 : lg 사이즈 이하에서는 사이드바가 보이지 않음! -->
    <v-navigation-drawer right class="ma-0 pa-0 d-none d-lg-block">
      <v-row>
        <!-- 채명왈 : login이랑 logout 나중에 router로 연결하면 됨 -->
        <v-col col="6" class="d-flex justify-center">setting</v-col>
        <v-col col="6" class="d-flex justify-center">login</v-col>
      </v-row>

      <v-row>
        <v-col>
          <!-- 문제 길이 문제 해결하기!-->
          <!-- <search-bar></search-bar> -->
        </v-col>
      </v-row> 

      <!-- 1. 오늘의 인기 문제 -->
      <!-- icon 찾기 -->
      <v-card class="mx-auto mb-5" height ="280px" color="#FCE4EC">
        <v-card-text>
          <p class="text-h6 text--primary d-flex justify-center mb-0">{{nowDate}} 인기 문제</p>
          <p class="text-right ma-0 mb-2">{{nowDate}} {{nowTime}} 실시간</p>
          <p class="text-h6 mb-0">No.1 [문제 제목]</p>
          <v-container class="grey lighten-5 mb-4" elevation="3">
            <v-row>
              <v-col col="4" class="d-flex justify-center pink darken-2">추천</v-col>
              <v-col col="4" class="d-flex justify-center pink lighten-2">참여자</v-col>
              <v-col col="4" class="d-flex justify-center">정답률</v-col>
            </v-row>
          </v-container>
          <p class="text-h6 mb-0">No.2 [문제 제목]</p>
          <v-container class="grey lighten-5">
            <v-row>
              <v-col cols="4" class="d-flex justify-center pink darken-2" color="red">추천</v-col>
              <v-col cols="4" class="d-flex justify-center pink lighten-2">참여자</v-col>
              <v-col cols="4" class="d-flex justify-center">정답률</v-col>
            </v-row>
          </v-container>
        </v-card-text>
      </v-card>

      <!-- 2. 오늘의 유저 -->
      <v-card class="mx-auto mb-5" height ="330px" color="#EDE7F6">
        <v-card-text>
          <p class="text-h6 text--primary d-flex justify-center mb-0">{{nowDate}} 유저 랭킹</p>
          <p class="text-right">{{nowDate}} {{nowTime}} 실시간</p>
          <v-row>
            <v-col cols="12">
              <v-card color="transparent"  flat="true">
                <v-list two-line>
                  <template v-for="item in items.slice(0, 10)">
                    <v-list-item>
                      <v-list-item-avatar>
                        <img :src="item.avatar">
                      </v-list-item-avatar>
                      <v-list-item-content>
                        <v-lst-item-name>{{ item.name }}</v-lst-item-name>
                        <v-list-item-total>{{ item.total }}</v-list-item-total>
                      </v-list-item-content>
                    </v-list-item>
                  </template>
                </v-list>
              </v-card>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>

    </v-navigation-drawer>
  </v-container>
</template>

<script>
import SearchBar from './SearchBar.vue';

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
      items: [
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg', name: '성은', total: 524 + ' 개' },
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg', name: '채명', total: 538 + ' 개' },
        { avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg', name: '지민', total: 621 + ' 개' },
      ],
    }
  },
  mounted () {
    this.timer = setInterval(() => {
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
    }
  }
}
</script>

<style>
.v-navigation-drawer__content{
  background-color: #f5f5f5;
}
</style>