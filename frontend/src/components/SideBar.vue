<template>

  <v-app >
    <v-navigation-drawer permanent right>
      <v-toolbar flat>
        <v-list>
          <v-list-tile>
            <v-list-tile-title class="title">
              여긴 검색창 자리
            </v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-toolbar>

      <!-- <v-divider></v-divider> -->

      <v-sheet
          class="d-flex"
          color="#FCE4EC"
          height="250"
        >
          <sheet-footer>
            <!-- #1: (3r x 2c) -->
            <h1>여긴 인기 문제</h1>
          </sheet-footer>

      </v-sheet>

      <p>마진 자리</p>

      <v-sheet
          class="d-flex"
          color="#EDE7F6"
          height="250"
        >
          <sheet-footer>
            <!-- #1: (3r x 2c) -->
            <h1>여긴 인기 유저</h1>
          </sheet-footer>
      </v-sheet>
      
    </v-navigation-drawer>
  </v-app>

</template>

<script>
export default {

}
</script>

<style>

</style>