<template>
  <div>
    <!-- <p>info</p> -->
    <info-items></info-items>
  </div>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'
import infoItems from '@/components/MainPage/infoItems.vue'

export default {
    data() {
      return {
        infos: {},
      }
    },
    components: {
        infoItems,
    },

  }
</script>

<style>

</style>