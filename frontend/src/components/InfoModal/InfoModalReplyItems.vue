<template>
  <!-- 2022.07.26 댓글창 (남성은) -->
  <!-- <v-card elevation="2" class="rounded ma-2 pa-4 mx-1"> -->
    <v-container class="white mt-2 border-a-10 h-300 overflow-auto">
      <div v-for="comment in commentList.reverse()" :key="comment.id" >
        <v-row class="grey lighten-4 border-a-10">
          <!-- <p>{{commentList}}</p> -->
          <v-col class=" mb-3">{{comment.mainText}}</v-col>
        </v-row>
        <v-row class="justify-space-between" v-if="userId===comment.user.id">
          <v-col cols="4" lg="3" class="align-end secondary--text text--lighten-3 pt-1">{{comment.user.name}}</v-col>
          <div class="d-flex col-8">
            <v-col class="align-end secondary--text text--lighten-3 pt-1">{{comment.created}}</v-col>
            <v-btn @click="deleteComment(comment.id)" small>삭제</v-btn>
          </div>
        </v-row>
        <v-row class="justify-space-between" v-else>
          <v-col cols="3" lg="3" class="align-end secondary--text text--lighten-3 pt-1">{{comment.user.name}}</v-col>
          <v-col cols="5" lg="3" class="align-end secondary--text text--lighten-3 pt-1">{{comment.created}}</v-col>
        </v-row>
      </div>
    </v-container>
  <!-- </v-card> -->
</template>

<script>
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  data() {
    return {

    }
  },
  props: {
    commentList: Array,
    pid: Number,
  },
  computed: {
    ...mapGetters(['userId', 'accessToken']),
  },
  methods: {
    deleteComment(commentId) {
      const check = confirm('정말 삭제하시겠습니까?')
      if (check) {
        axios({
          url: drf.api + 'comment/' + `${commentId}`,
          method: 'delete',
          headers: {
            Authorization: this.accessToken,
          },
        })
          .then((res) => {
            // console.log(this.credentials);
            console.log('res = ', res);
            console.log(this.pid)
            this.$router.go()
            // this.$router.push({path: `/problem/${this.pid}`})
          })
          .catch(err => {
            console.log('댓삭 에러= ', err)
          })
        }
      }
    },
}
</script>

<style>

</style>