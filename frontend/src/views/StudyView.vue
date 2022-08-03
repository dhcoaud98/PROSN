<template>
  <v-container fluid class="mt-5 pa-0 white">
    <v-row>

      <!-- 메인 스터디 페이지 -->
      <!-- <v-col class="mt-2 white"> -->
        <study-center></study-center>
      <!-- </v-col> -->

      <!-- <v-col md="4" class="d-md-flex d-md-none grey lighten-4">
        <side-bar></side-bar>
      </v-col> -->
      
    </v-row>
  </v-container>
</template>

<script>
import StudyCenter from '../components/Study/StudyCenter.vue'

export default {
  name: 'StudyView',
  components: {
    StudyCenter,
  }
}
</script>

<style>

</style>