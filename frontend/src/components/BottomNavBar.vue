<template>
  <v-bottom-navigation v-model="value" class="sticky-bottom align-center">
    <!-- 홈 -->
    <v-btn value="recent" class="col-3 pa-0 transparent">
        <span class="material-icons font-30">
            home
        </span>
    </v-btn>

    <!-- 스터디 -->
    <v-btn value="favorites" class="col-3 pa-0 transparent">
      <span class="material-icons font-30" >
        groups
    </span>
    </v-btn>

    <v-btn value="nearby" class="col-3 pa-0 transparent">
      <span class="material-icons font-30">
        sticky_note_2
    </span>

    </v-btn>

    <!-- 내 프로필 -->
    <v-btn value="nearby" class="col-3 pa-0 transparent">
      <span class="material-icons font-30">
            person
        </span>
    </v-btn>
  </v-bottom-navigation>
</template>

<script>
export default {

}
</script>

<style>
.sticky-bottom {
    position: sticky;
}
.font-30 {
    font-size: 30px;
}
</style>