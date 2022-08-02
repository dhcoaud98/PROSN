<template>
  <v-container fluid class="mt-2 rounded-lg create-something" >
    <!-- 정보게시하기 -->
    <v-row>
      <v-col cols="12" class="ma-3">
        <h2 class="px-3 font-weight-regular">정보 게시하기</h2>
      </v-col>
    </v-row>

    <v-divider class="mx-5" color="#A384FF"></v-divider>

    <!-- INFO글 정보 작성란 -->
      <v-form class="px-5">
        <!-- 카테고리 -->
        <v-row class="mx-2 mt-5">
          <v-col class="col-12 pa-0 mb-2"><p class="mb-0 font-weight-bold">카테고리</p></v-col>
          <v-col class="col-12 pa-0">
            <!-- 이거 다시 따져볼 필요성이 있음 -->
            <v-autocomplete :items="categoriesItems" label="주제를 선택하세요 (복수선택 가능)" required dense chips small-chips multiple></v-autocomplete>          
          </v-col>
        </v-row>

        <!-- 게시글제목 -->
        <v-row class="mx-2 mt-5">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold mb-0">제목</p></v-col>
          <v-col class="col-12 pa-0">
            <v-text-field label="글 제목을 입력하세요 (최대 20자)" maxlength="20" counter required dense></v-text-field>
          </v-col>
        </v-row>

        <!-- 지문 -->
        <v-row class="mx-2 mt-5 mb-2">
          <v-col class="col-12 pa-0 mb-2"><p class="font-weight-bold mb-0">지문</p></v-col>
          <v-col class="col-12 pa-0">
            <v-textarea label="글 내용을 입력하세요" rows="15" counter required dense></v-textarea>
          </v-col>
        </v-row>

        <v-divider color="#A384FF"></v-divider>
        
        <!-- 게시버튼 -->
        <v-row class="my-2 ">
          <v-col cols="12" class="d-flex justify-end pa-0">
            <!-- router - 1  -->
            <v-btn large rounded color="#EA4C89" class="white--text font-weight-bold me-5 mt-2 py-5">취소하기</v-btn>
            <!-- submit -->
            <v-btn large rounded type="submit" color="#A384FF" class="white--text font-weight-bold me-3 mt-2 py-5">게시하기</v-btn>
          </v-col>
        </v-row>
      </v-form>
  </v-container> 
</template>

<script>
import RecentProblem from '../components/MainPage/RecentProblem.vue'
import info from '../components/MainPage/info.vue'
import SideBar from '@/components/SideBar.vue'

export default {
  name: 'MainPageView',
  components : {
    RecentProblem,
    info,
    SideBar,
  }
}
</script>

<style>
  .bottom-line {
    border-bottom: #a384ff 3px solid;
  }
  .v-application--wrap {
  max-width: none;
  }
  
  /* before로 색을 지정해주니까 hover 했을 때 색이 흰색으로 정상적으로 바뀜 */
  .tab-hover::before {
    color: #616161;
  }
  :hover.tab-hover {
    background: #a384ff;
    color: white;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
  }
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }
</style>

<style>
  .v-application--wrap {
  max-width: none;
  }
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }
  .create-something {
    background-color: #EDE7F6;
  }
</style>