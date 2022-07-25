<template>
  <v-app>
    <v-text-field
        v-model="search"
        label="Search Company Directory"
        dark
        flat
        solo-inverted
        hide-details
        clearable
        clear-icon="mdi-close-circle-outline"
      ></v-text-field>
  </v-app>
</template>

<script>
export default {
  name: 'SearchBar',
}
</script>

<style>

</style>