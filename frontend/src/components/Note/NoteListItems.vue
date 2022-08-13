<template>
  <!-- studylistitems 복붙 0803 임지민 -->
  <div>
  <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <!-- 작성 전 문제 0808 임지민 -->
    <!-- beforeProb에 문제 아이디가 조회가 가능하면 이를 이용해 문제에 접근해서 태그, 제목, 문제 수 등을 출력해오자 -->
    
    <div v-for="beforeProb in beforeProbs" :key="beforeProb.id">
      <!-- 오답노트 상세보기 페이지로 이동  -->
      <!-- <p>{{beforeProb}}</p> -->
      <router-link :to="`/note/pre/${beforeProb.id}`">
        <v-row class="color-FAF0F3 mx-auto border-a-10">
          <v-col cols="12">
            <v-card class="px-5" color="#FAF0F3">
              <v-row class="align-center">
                <!-- col 1: 문제 대표 이미지 -->
                <v-col cols="2"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>

                <!-- col 2: 문제 태그, 문제 제목  -->
                <v-col class="pb-0">
                  <v-row>
                    <div v-for="tag in beforeProb.tags" :key="tag">
                      <span class="category-tag text-center pa-1 mr-2 font-parent-xsml">#{{tag}}</span>
                    </div>
                  </v-row>
                  <v-row>
                    <span class="font-parent-mid-l font-weight-bold mr-2">{{beforeProb.title}}</span>
                  </v-row>
                  
                </v-col>
                
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </router-link>
    </div> 

    <!-- 작성 후 문제 0808 임지민 -->
    <div v-for="afterProb in afterProbs" :key="afterProb.id" class="mb-3">
      <!-- <p>{{afterProb}}</p> -->
      <!-- 여기 이 id값을 notedetaillist, createnotelist에서 받아서 axios로 오답노트 디테일 조회하기 -->
      <router-link :to="`note/post/${afterProb.id}`">
        <v-row class="color-FAF0F3 mx-auto border-a-10">
          <v-col cols="12" class="pa-0">
            <v-card class="px-5" color="#FAF0F3">
              <v-row class="align-center mt-2">
                <!-- col 1: 문제 대표 이미지 -->
                <v-col cols="2"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>

                <!-- col 2: 문제 태그, 문제 제목 --> 
                <v-col>
                  <span class="font-parent-mid-l font-weight-bold mx-2">{{afterProb.title}}</span>
                  <div v-for="tag in afterProb.tags" :key="tag" class="d-inline-block">
                    <span class="category-tag text-center pa-1 mr-2 font-parent-xsml">#{{tag}}</span>
                  </div>
                </v-col>
                
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </router-link>
    </div>
    
  </div>
</template>

<script>
export default {
  data() {
    return {

    }
  },
  props: {
    beforeProbs: Array,
    afterProbs: Array,
  },

}
</script>

<style>
.font-parent-xsml {
  font-size: 0.1em;
}
</style>