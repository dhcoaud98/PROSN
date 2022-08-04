<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <scrap-post-list-items></scrap-post-list-items>
    <br>  
    <v-div class="text-center ">
      <v-pagination
        v-model="page"
        :length="5"
        color="#A384FF"
      ></v-pagination>
    </v-div>
  </v-container>
</template>

<script>
import ScrapPostListItems from './ScrapPostListItems.vue'


export default {
  name: 'ScrapPostList',
  components: {
    ScrapPostListItems,
  },
  data () {
    return {
      page: 1,
    }
  },
}
</script>

<style>

</style>