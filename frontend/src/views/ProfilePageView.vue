<template>
  <v-container class="profile">
    <profile-center></profile-center>
  </v-container>

</template>

<script>
import ProfileCenter from '../components/Profile/ProfileCenter.vue'

export default {
  name: 'ProfilePageView',
  components :{
    ProfileCenter,
  }
}
</script>

<style>
.profile {
  height: 750px;
  background-color: #ffffff;
}
</style>