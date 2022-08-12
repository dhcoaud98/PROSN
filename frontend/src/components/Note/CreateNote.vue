<template>
  <!-- 전체적인 틀 -->
  <v-container fluid class="white">
    <!-- 문제 정보 -->
    <v-row>{{noteDetail}}</v-row>
    <v-row class="align-center mx-5 mt-5 color-FAF0F3 border-a-10 px-4">
      <v-col cols="1"><v-icon large color="black darken-2">mdi-group</v-icon></v-col>
        <v-col>
          <v-row class="align-center">
            <v-col cols="3" class="pa-0">
              <div v-for="tag in noteDetail.tags" :key="tag.id">
                <span class="category-tag text-center pa-1 mt-0 mr-2 font-parent-xsml">#{{tag.type}}</span>
              </div>
            </v-col>
            <v-col class="pa-0">
              <span class="font-parent-mid-l font-weight-bold mr-3">{{noteDetail.title}}</span>
            </v-col>
          </v-row>
          
        </v-col>
    </v-row>

    <!-- 문제 부분 -->
    <v-row class="mt-0">
      <create-note-list :noteDetail="noteDetail"></create-note-list>
    </v-row>
  </v-container>
</template>

<script>
import CreateNoteList from '@/components/Note/CreateNoteList.vue'
import { mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf.js'

export default {
  data() {
    return {
      noteDetail: null,
    }
  },
  components: {
    CreateNoteList,
  },
  methods : {
    
  },
  computed: {
    ...mapGetters(['userName', 'accessToken'])
  },
  created() {
    const noteId = this.$route.params.noteId
    // console.log('noteId=', noteId)
     axios({
      url: drf.wrongAnswer.wrongAnswer() + noteId,
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
    })
    .then(res => {
      // console.log(res) //ok
      this.noteDetail = res.data
      // console.log(this.noteDetail)

    })
    .catch(err => {
      console.log(err);
    })

  }
}
</script>

<style>

</style>