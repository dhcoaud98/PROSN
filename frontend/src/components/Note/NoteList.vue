<template>
  <v-container>
    <!-- 
      v-for 사용하기 
      - note center에서 어떤 것이 선택됐는 지 toDB 받아와서 그것에 맞게 쿼리 보내기
      - 상세페이지로 이동
    -->
    <!-- 
      to="/note/{id}" : 후에 통신해서 id 받아서 넘기기
     -->
    <note-list-items :beforeProbs="beforeProbs" :afterProbs="afterProbs"></note-list-items>
    <v-row class="text-center justfy-center">
      <v-col>
        <v-pagination
          v-model="page"
          :length="5"
          color="#A384FF"
          class="mt-3"
        ></v-pagination>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import NoteListItems from '@/components/Note/NoteListItems.vue'

export default {
  data () {
    return {
      page: 1,
      beforeProbs: [],
      afterProbs: [],
    }
  },
  components :{
    NoteListItems,
  },
  created() {
    axios({
      // 오답노트 전체 불러오기
      url: drf.note.wronganswer(),
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
      })
      .then(res => {
          console.log("res = ",res);
          const wholeProbs = res.data.content
          wholeProbs.forEach(prob => {
            if (prob.keys().length) {
              // 각 요소의 length가 4 미만이면 작성 전
              this.beforeProbs.push(prob)
            } else {
              // length가 4 이상이면 작성 후
              this.afterProbs.push(prob)
            }  
          });
          
      
      })
      .catch(err =>{
          console.log("에러")
          console.log(err)
        })
    }
  }
</script>

<style>

</style>