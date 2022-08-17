<template>
  <!-- 전체적인 틀 -->
  <v-container fluid class="white mt-10">
    <!-- 문제 정보 -->
    {{ bookDetails }}
    <v-row class="align-center mx-5 mt-5 border-a-10 px-4 rounded-xl yellow lighten-4">
      <v-col cols="1"><v-icon large color="orange darken-3">mdi-note-edit</v-icon>
      </v-col>
      <v-col>
        <v-row class="align-center py-1 justify-space-between">
          <!-- <v-col class="align-center py-1"> -->
            <v-col class="pa-0">
              <h2 class="font-weight-bold mr-3">{{bookDetails.title}}</h2>
            </v-col>
            <v-col class="text-end pa-0">
              <v-btn text v-if="!toggleTitleEdit" @click="showTitleEdit">제목 수정</v-btn>
              <v-form v-else @submit.prevent="editBookTitle">
                <v-text-field 
                label="수정할 제목을 입력하세요" 
                class="d-inline-block"
                v-model="credentials.title">></v-text-field>
                <v-btn type="submit" text class="ml-2">수정하기</v-btn>
              </v-form>
            </v-col>
          <!-- </v-col> -->
        </v-row>
      </v-col>
    </v-row>

    <!-- 문제 부분 -->
    <v-row class="mt-0">
      <v-col>
        <problem-book-list :bookDetails="bookDetails"></problem-book-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ProblemBookList from '@/components/ProblemBook/ProblemBookList.vue'
import axios from 'axios'
import drf from '@/api/drf.js'
import { mapGetters } from 'vuex'

export default {
  data() {
    return {
      bookDetails: null,
      toggleTitleEdit: false,
      credentials: {
        wid: '',
        title: ''
      },
    }
  },
  components: {
    ProblemBookList,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  methods: {
  showTitleEdit() {
    this.toggleTitleEdit = true
  },
  editBookTitle(){
    if(this.credentials.title.trim() === '') {
        this.$swal({
          icon: 'warning',
          text: '문제집 이름을 입력해주세요'
        })
      } else {
      axios({
        url: drf.api+'post/workbook/',
        method: 'patch',
        headers: {
          Authorization: this.accessToken,
        },
        data: this.credentials
      })
      .then(res => {
        // console.log(res) //ok
        // this.noteDetail = res.data
        // console.log(res)
        this.$swal({
          icon: 'success',
          text: '문제집 제목 수정이 완료되었습니다'
        })
        this.$router.go()

      })
      .catch(err => {
        console.log(err);
      })
    }
  },
  },
  created() {
    const bookId = this.$route.params.bid
    // console.log(noteId)

    axios({
      url: drf.api+'post/' + bookId,
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
    })
    .then(res => {
      console.log(res) //ok
      this.bookDetails = res.data
      this.credentials.wid = this.bookDetails.id
      // console.log('wid 저장되었나여', this.credentials.wid);
    })
    .catch(err => {
      console.log(err);
    })
  },
}
</script>

<style scoped>
.v-label, .v-input {
  font-size: 0.8em;
}
</style>