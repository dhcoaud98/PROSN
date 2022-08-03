<template>
  <v-container fluid>
    <!-- row 1: 메인 피드와 sidebar 모두를 감싸는 줄 -->
    <v-row>

      <!-- col 1: 메인 피드 부분 -->
      <v-col class="mt-2 white">
        <note-center></note-center>    
      </v-col>

      <!-- col 2: 사이드 바 -->
      <v-col md="4" class="d-md-flex d-md-none grey lighten-4">
        <side-bar></side-bar>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import NoteCenter from '@/components/Note/NoteCenter.vue'
import SideBar from '@/components/SideBar.vue'

export default {
  name: 'NoteView',
  components: {
    NoteCenter,
    SideBar,
  }
}
</script>

<style>

</style>