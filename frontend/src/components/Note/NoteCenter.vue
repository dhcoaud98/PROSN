<template>
  <v-container class="ma-0 pa-0">
    <v-row class="d-flex mt-5 ms-5">
      <v-icon large color="#926DFF">sticky_note_2</v-icon>
      <h2 class="ms-3 dark--text">N O T E</h2>
    </v-row>  

    <!-- row 1. 제목 -->
    <v-row class="mt-10 mx-5 mb-0">
      <p class="font-parent-lar">
        <!-- 나중에 유저 이름 받아올 수 있으면 아래 부분 바꿔주기 -->
        <span class="font-weight-bold">{{userName}}</span>
        님의 오답노트
      </p>
      <!-- <p>{{userId}}</p> -->
      <!-- <p>{{accessToken}}</p> -->
      <!-- <p>{{ accessToken }}</p> -->
    </v-row>

    <!-- 
      row 2. 카테고리들 
      - 클릭하면 내부 텍스트 값을 아래 열로 보내주기
      - 그리고 그 텍스트 값을 notelist로 내려줘야 함
    -->
    <v-row class="bottom-border-grey pb-5 mr-2 mx-5 mb-0">
      <v-chip-group column mandatory active-class="clicked-chip">
        <v-chip class="mr-2 my-2 border-grey" @click="selectCategory('전체')" id="whole" small>#전체</v-chip>
        <div v-for="category in categories" :key="category.toDB">
          <v-chip class="mr-2 my-2 border-grey" :id="category.toDB" @click="selectCategory(category.toDB)" small>
            #{{category.toUser}}</v-chip>
        </div>
      </v-chip-group>
    </v-row>

    <!-- row 3: 선택한 카테고리 -->
    <v-row class="mt-2 mr-0 mx-5">
      <v-col class="bottom-border-grey">
        <p class="font-parent-lar font-weight-bold mb-1">#{{ selected }}</p>
      </v-col>
    </v-row>

    <!-- row4. note list -->
    <v-row class="ml-2 mx-5">
      <p class="font-parent-mid-l font-weight-bold bottom-border-grey mt-3 mx-5">작성 전 문제</p>
      <note-list :beforeProbs="beforeProbs"></note-list>
    </v-row>
    <hr class="my-5 border-grey mx-5">
    <v-row class="ml-2">
      <p class="font-parent-mid-l font-weight-bold bottom-border-grey mx-5">이미 작성한 문제</p>
      <note-list :afterProbs="afterProbs"></note-list>
    </v-row>
  </v-container>
</template>

<script>
import NoteList from '@/components/Note/NoteList.vue'
import axios from 'axios'
import drf from '@/api/drf.js'
import { mapGetters } from 'vuex'

export default {
  components: {
    NoteList
  },
  data() {
    return {
      selected : '전체',
      categories: [
        {toDB:"NW", toUser: "네트워크"},
        {toDB:"OS", toUser: "운영체제"},
        {toDB:"DS", toUser: "자료구조"},
        {toDB:"DB", toUser: "데이터베이스"},
        {toDB:"AL", toUser: "알고리즘"},
        {toDB:"OOP", toUser: "객체지향"},
        {toDB:"PL", toUser: "프로그래밍 언어"},
        {toDB:"CS", toUser: "컴퓨터 구조"},
        {toDB:"TC", toUser: "기술동향"},
        {toDB:"SC", toUser: "보안"},
        {toDB:"ETC", toUser: "기타"},
      ],
      beforeProbs : [],
      afterProbs: [],
    }
  },
  methods: {
    selectCategory(categoryName) {
      this.selected = categoryName
    }
  },
  computed: {
    ...mapGetters(['accessToken', 'userId', 'userName'])
  },
  created() {
    const params = {
        // pageable: 0,
        isWrite: 'true',
        // sort: onUpdated, 'desc'
      } 
    axios({
      url: drf.api + 'wrongAnswer/' + 'all',
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
      params: params,
    })
    .then(res => {
      // 받아온 데이터를 작성 전/후로 구분하는 작업 필요(0808 임지민)
      this.afterProbs = res.data.content
      // this.afterProbs.push(res.data.content)
      // console.log('in'); //ok
    })
    .catch(err => {
      // console.log(this.accessToken)
      // console.log(this.userId)
      console.log(err);
    })
  },
}
</script>

<style>
.clicked-chip {
  background-color: #a394ff !important;
  color: white !important;
  border: none;
}
.bottom-border-grey {
  border-bottom: 1px solid #d9d9d9;
}
.theme--light.v-chip:not(.v-chip--active) {
  background: white;
}
.row {
  margin: auto;
}
.font-parent-mid-l {
  font-size: 1em;
}
</style>