<template>
  <v-container class="overflow-y-auto" style="height: 200px;">
    <!-- <v-checkbox
      label="기본폴더"
      color="info"
      value=""
      hide-details
      class="mt-0 font-weight-bold"
    ></v-checkbox> -->
    <div v-for="scrapFolder in scrapFolders" :key="scrapFolder.id">
      <!-- <p>{{scrapFolder.title}}</p> -->
      <v-radio-group>
        <scrap-list-items :scrapFolder="scrapFolder" :getScrapFolders="getScrapFolders" @checkedFolder="catchFolderId"></scrap-list-items>
      </v-radio-group>
    </div>
    <div>
      <!-- <p>hi</p> -->
      <!-- <p>{{lid}}</p> -->
    </div>
  </v-container>
</template>

<script>
import ScrapListItems from '@/components/Scrap/ScrapListItems.vue'

export default {
  name: 'ScrapList',
  data() {
    return {
      lid: null,
    }
  },
  components: {
    ScrapListItems,
  },
  props: {
    scrapFolders: Array,
    getScrapFolders: Function,
  },
  methods: {
    catchFolderId(lid) {
      // console.log('hihi')
      this.lid = lid
      // console.log('캐치했다=', this.lid);
      this.$emit('emit-folder', lid)
    }
  }
}
</script>

<style>

</style>