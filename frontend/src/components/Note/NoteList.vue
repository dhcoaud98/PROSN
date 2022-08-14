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
     <v-row>
      <!-- {{afterProbs}} -->
      <note-list-items :beforeProbs="beforeProbs" :afterProbs="afterProbs"></note-list-items>
     </v-row>
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
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  data () {
    return {
      page: 1,
      beforeProbs: null,
      afterProbs: null,
    }
  },
  components :{
    NoteListItems,
  },
  props: {
    selectedDB: String,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  watch: {
    selectedDB: function () {
     // console.log(this.selectedDB) // ok
      // methods에 axios 코드 정의하고 불러오기
      if (this.selectedDB==="whole") {
        this.wholeNote()
      } else {
        this.tagNote(this.selectedDB)
      }
    }
  },
  methods: {
    wholeNote() {
      const isWriteParams = ['true', 'false']
  
      isWriteParams.forEach(oneParam => {
        const params = {
          page: this.page,
          size: 3,
          isWrite: oneParam,
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
          // console.log(res)
          if (oneParam === 'false'){
            this.beforeProbs = res.data.content
            // console.log('before=', this.beforeProbs)
          } else {
            this.afterProbs = res.data.content
            // console.log('after=',this.afterProbs)
          }
          // console.log('in'); //ok
        })
        .catch(err => {
          // console.log(this.accessToken)
          // console.log(this.userId)
          console.log(err);
        })
      })

    },
    tagNote(toDB) {
      // console.log('toDB= ', toDB);
      const isWriteParams = ['true', 'false']
      isWriteParams.forEach(oneParam => {
        const params = {
          page: this.page,
          size: 3,
          tag: toDB,
          isWrite: oneParam
        }
        axios({
          url: drf.api + 'wrongAnswer/' + 'tag',
          method: 'get',
          headers: {
            Authorization: this.accessToken,
          },
          params: params,
        })
        .then(res => {
          // 받아온 데이터를 작성 전/후로 구분하는 작업 필요(0808 임지민)
          // console.log(res.data)
          if (oneParam === 'false'){
            this.beforeProbs = res.data.content
            // console.log('tagbefore');
            // console.log('tagbefore=', this.beforeProbs)
          } else {
            this.afterProbs = res.data.content
            // console.log('tagafter');
            // console.log('tagafter=',this.afterProbs)
          }
          // console.log('in'); //ok
        })
        .catch(err => {
          // console.log(this.accessToken)
          // console.log(this.userId)
          console.log(err);
        })
      })
    },
  },
  created() {
    // 처음에 created될 때 전체 다 받아오기
    this.wholeNote()
    // console.log('selected= ', this.selectedDB)
    },
  }
</script>

<style>

</style>