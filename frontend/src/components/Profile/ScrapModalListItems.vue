<template>
  <v-container outlined class="pa-0 d-flex flex-row">
    <div class="d-flex justify-space-between scrap-item py-2">
      <div class="d-flex flex-row">
        <v-checkbox info
        :label="`${idx+1}. ${scrapDetail.title}`"
        class="font-weight-bold"
        @change="getSelectedProb(scrapDetail.pid)"></v-checkbox>
        <div class="mt-2 ms-2">
          <!-- {{ scrapDetail }} -->
          <!-- <h2>{{ scrapDetail.title }}</h2> -->
        </div>
      </div>
      <div class="d-flex align-end">
        <v-btn outlined rounded class="red font-weight-bold white--text" small
        @click="deleteFromFolder(scrapDetail.pid)">목록에서 삭제</v-btn>
      </div>
    </div>
  </v-container>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf.js'
import { mapGetters } from 'vuex'

export default {
  name: 'ScrapModalListItems',
  data(){
    return {
      selectedProbList: []
    }
  },
  props: {
    scrapDetail: Object,
    idx: Number,
    lid: Number,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  methods: {
    deleteFromFolder(pid) {
      // 폴더에서 문제 삭제하기 0816 임지민
      const check = confirm('정말 "' + this.scrapDetail.title + '" 문제를 폴더에서 삭제하시겠습니까?')

      if (check) {
        axios({
        url: drf.scrap.scrap() + pid,
        method: 'delete',
        headers: {
          Authorization: this.accessToken,
        },
      })
      .then(res => {
        console.log('폴더에서 문제 삭제=', res) //ok
        this.$emit('re-direct')

      })
      .catch(err => {
        console.log('폴더에서 문제 삭제 에러=',err);
      })
      }
    },
    getSelectedProb(pid) {
      this.$emit('get-selected-prob', pid)
      // console.log('scrapmodallistitems= ', pid);
    }
  }
}
</script>

<style>
.scrap-item {
  width: 100%;
  border-width: 1px;
  border-color: #DEDCDF;
  border-top-style: solid;
  border-bottom-style: solid;
}
</style>