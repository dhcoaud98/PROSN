<template>
  <!-- 전체적인 틀 -->
  <v-container fluid class="white mt-10">
    <!-- 문제 정보 -->
    {{ bookDetails }}
    <v-row class="align-center mx-5 mt-5 border-a-10 px-4 rounded-xl yellow lighten-4">
      <v-col cols="1"><v-icon large color="orange darken-3">mdi-note-edit</v-icon>
      </v-col>
      <v-col>
        <v-row>
          <v-col class="align-center py-1">
            <v-col class="pa-0">
              <h2 class="font-weight-bold mr-3">{{bookDetails.title}}</h2>
            </v-col>
          </v-col>
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
    }
  },
  components: {
    ProblemBookList,
  },
  computed: {
    ...mapGetters(['accessToken'])
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

    })
    .catch(err => {
      console.log(err);
    })
  },
}
</script>

<style>

</style>