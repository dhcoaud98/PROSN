<template>
  <v-col cols="12" class="pa-0">
    <v-text-field
      label="검색어를 입력하세요"
      solo
      class="ma-0"
      @keyup.enter="onInputKeyword"
    ></v-text-field>
  </v-col>

</template>

<script>
export default {
  name: 'SearchBar',
  methods: {
    onInputKeyword: function(event) {
      // this.$emit('input-change', event.target.value)
      // console.log(event.target.value)
      this.$store.dispatch('problem/searchKeyword', event.target.value)
    },

  },

}
</script>

<style>

</style>