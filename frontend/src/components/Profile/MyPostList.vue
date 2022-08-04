<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <my-post-list-items></my-post-list-items>
    <br>  
  </v-container>
</template>

<script>
import MyPostListItems from './MyPostListItems.vue'

export default {
  name: 'MyPostList',
  components: {
    MyPostListItems,
  },

}
</script>

<style>

</style>