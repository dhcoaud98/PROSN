<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <solved-problem-list-items></solved-problem-list-items>
  </v-container>
</template>

<script>
import SolvedProblemListItems from './SolvedProblemListItems.vue'

export default {
  name: 'SolvedProblemList',
  components: {
    SolvedProblemListItems,
  }
}
</script>

<style>

</style>