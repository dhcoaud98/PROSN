<template>
  <v-container fluid class="mt-2 white">
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
  /* .v-application--wrap {
  max-width: none;
  }
  .container {
    max-width: none;
  }
  .w-100 {
    width: 100%;
  }  
  .tab-hover::before {
    color: #616161;
  } */
</style>