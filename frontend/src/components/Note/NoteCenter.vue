<template>
  <v-container class="mt-5 mx-2 mb-0">
    <!-- row 1. 제목 -->
    <v-row>
      <p class="font-parent-lar">
        <!-- 나중에 유저 이름 받아올 수 있으면 아래 부분 바꿔주기 -->
        <span class="font-weight-bold">임지민</span>
        님의 오답노트
      </p>
    </v-row>

    <!-- 
      row 2. 카테고리들 
      - 클릭하면 내부 텍스트 값을 아래 열로 보내주기
      - 그리고 그 텍스트 값을 notelist로 내려줘야 함
    -->
    <v-row class="bottom-border-grey pb-5 mr-2">
      <v-chip-group column mandatory active-class="clicked-chip">
        <v-chip class="mr-2 my-2 border-grey" @click="selectCategory('전체')" id="whole" small>#전체</v-chip>
        <div v-for="category in categories" :key="category.toDB">
          <v-chip class="mr-2 my-2 border-grey" :id="category.toDB" @click="selectCategory(category.toUser)" small>
            #{{category.toUser}}</v-chip>
        </div>
      </v-chip-group>
    </v-row>

    <!-- row 3: 선택한 카테고리 -->
    <v-row class="mt-2 mr-0">
      <v-col class="bottom-border-grey">
        <p class="font-parent-lar font-weight-bold mb-1">#{{ selected }}</p>
      </v-col>
    </v-row>

    <!-- row4. note list -->
    <v-row class="ml-2">
      <p class="font-parent-mid-l font-weight-bold bottom-border-grey mt-3">작성 전 문제</p>
      <note-list></note-list>
    </v-row>
    <hr class="my-5 border-grey">
    <v-row class="ml-2">
      <p class="font-parent-mid-l font-weight-bold bottom-border-grey">이미 작성한 문제</p>
      <note-list></note-list>
    </v-row>
  </v-container>
</template>

<script>
import NoteList from '@/components/Note/NoteList.vue'

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
    }
  },
  methods: {
    selectCategory(categoryName) {
      this.selected = categoryName
    }
  }
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