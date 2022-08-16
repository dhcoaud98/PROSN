<template>
  <v-list>
    <div v-for="(scrapDetail, idx) in scrapDetails" :key="idx">
      <scrap-modal-list-items></scrap-modal-list-items>
    </div>
  </v-list>
</template>

<script>
import ScrapModalListItems from '@/components/Profile/ScrapModalListItems.vue'


export default {
  name: 'ScrapModalList',
  components: {
    ScrapModalListItems,
  },
  props :{
    scrapDetails: Array
  }

}
</script>

<style>

</style>