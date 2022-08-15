<template>
  <v-container class="mt-5 px-0 px-md-3">
    <!-- v-for 사용하기 -->
    {{ scrapFolders}}
    <div v-for="scrapFolder in scrapFolders" :key="scrapFolder.id">
      <scrap-post-list-items :scrapFolder="scrapFolder"></scrap-post-list-items>
    </div>
    <br>  
    <v-container class="text-center ">
      <v-pagination
        v-model="page"
        :length="5"
        color="#A384FF"
      ></v-pagination>
    </v-container>
  </v-container>
</template>

<script>
import ScrapPostListItems from './ScrapPostListItems.vue'
import drf from '@/api/drf'
import axios from 'axios'
import { mapGetters } from 'vuex'


export default {
  name: 'ScrapPostList',
  components: {
    ScrapPostListItems,
  },
  data () {
    return {
      page: 1,
      scrapFolders: [],
    }
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  created() {
     // 내 폴더 목록 조회 0815 임지민
    axios({
      url: drf.scrap.folder(),
      method: 'get',
      headers: {
        Authorization: this.accessToken,
      },
      })
      .then(res => {
        console.log('스크랩 폴더 조회=', res.data);
        this.scrapFolders = res.data
      })
      .catch(err => {
        console.log('스크랩 폴더 조회 에러', err);
      })
  }
}
</script>

<style>

</style>