<template>
  <v-row class="justify-space-between mx-0">
    <v-col class="pa-0">
      <v-radio
        :label="scrapFolder.title"
        color="info"
        class="font-weight-bold pa-0 ma-0"
        :id="`scrap${scrapFolder.id}`"
        @change="emitFolderId(scrapFolder.id)"
        name="folders"
      ></v-radio>
    </v-col>
    <v-col cols="5" class="mr-2 pa-0">
      <v-btn small class="mr-2" @click="openModal">이동</v-btn>
      <v-btn small @click="deleteFolder(scrapFolder.id)">삭제</v-btn>
    </v-col>
    <!-- <p>hi</p> -->
    <scrap-post-modal @close="closeModal" v-if="modal" :lid="scrapFolder.id" :scrapFolder="scrapFolder"></scrap-post-modal>

  </v-row>
</template>

<script>
import drf from '@/api/drf'
import axios from 'axios'
import { mapGetters } from 'vuex'
import ScrapPostModal from '@/components/Profile/ScrapPostModal.vue'


export default {
  name: 'ScrapListItems',
  data(){
    return {
      modal: false,
    }
  },
  components: {
    ScrapPostModal
  },
  props: {
    scrapFolder: Object,
    getScrapFolders: Function,
  },
  computed: {
    ...mapGetters(['accessToken'])
  },
  methods: {
    deleteFolder(lid) {
      // axios 보내기
      const check = confirm('정말 삭제하시겠습니까?')
      if (check) {
      axios({
        url: drf.scrap.folder() + lid,
        method: 'delete',
        headers: {
          Authorization: this.accessToken,
        },
        data: {
          id: lid
        }
      })
      .then(res => {
        // 받아온 데이터를 작성 전/후로 구분하는 작업 필요(0808 임지민)
        console.log('스크랩 폴더 삭제= ', res)
        this.getScrapFolders()
      })
      .catch(err => {
        // console.log(this.accessToken)
        // console.log(this.userId)
        console.log('스크랩 폴더 삭제 에러= ',err);
      })
    }
  },
    emitFolderId(lid) {
      this.$emit('checkedFolder', lid)
      // console.log(lid);
    },
    openModal() {
        this.modal = true
        console.log('openModal')
    },
    closeModal() {
        this.modal = false
        console.log('closeModal')
    },
  },
}
</script>

<style>

</style>