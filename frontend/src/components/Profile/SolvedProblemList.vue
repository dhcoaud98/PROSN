<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <solved-problem-list-items></solved-problem-list-items>
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
import SolvedProblemListItems from './SolvedProblemListItems.vue'

export default {
  name: 'SolvedProblemList',
  components: {
    SolvedProblemListItems,
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