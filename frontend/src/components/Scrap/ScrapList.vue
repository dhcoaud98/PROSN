<template>
  <v-container>
    <v-checkbox
      label="기본폴더"
      color="info"
      value=""
      hide-details
      class="mt-0 font-weight-bold"
    ></v-checkbox>
    <scrap-list-items></scrap-list-items>
  </v-container>
</template>

<script>
import ScrapListItems from '@/components/Scrap/ScrapListItems.vue'

export default {
  name: 'ScrapList',
  components: {
    ScrapListItems,
  }
}
</script>

<style>

</style>