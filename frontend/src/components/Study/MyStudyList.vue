<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <my-study-list-items></my-study-list-items>
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
import MyStudyListItems from "./MyStudyListItems.vue"

export default {
  name: 'StudyList',
  components: {
    MyStudyListItems,
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