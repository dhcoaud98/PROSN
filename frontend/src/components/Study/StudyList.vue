<template>
  <v-container>
    <!-- v-for 사용하기 -->
    <study-list-items></study-list-items>
    <br>  
    <v-row class="d-flex justify-center text-center ">
      <v-pagination
        v-model="page"
        :length="5"
        color="#A384FF"
      ></v-pagination>
    </v-row>
  </v-container>
</template>

<script>
import StudyListItems from "./StudyListItems.vue"

export default {
  name: 'StudyList',
  components: {
    StudyListItems,
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