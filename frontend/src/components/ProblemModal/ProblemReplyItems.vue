<template>
  <!-- 2022.07.26 댓글창 (남성은) -->
  <!-- <v-card elevation="2" class="rounded ma-2 pa-4 mx-1"> -->
    <v-container class="white mt-2 border-a-10 h-300 overflow-auto">
      <div v-for="comment in commentList.reverse()" :key="comment.id" >
        <v-row class="grey lighten-4 border-a-10">
          <!-- <p>{{commentList}}</p> -->
          <v-col class=" mb-3">{{comment.mainText}}</v-col>
        </v-row>
        <v-row class="justify-space-between">
          <v-col cols="3" class="align-end secondary--text text--lighten-3 pt-1">{{comment.user.name}}</v-col>
          <v-col cols="5" class="align-end secondary--text text--lighten-3 pt-1">{{comment.created}}</v-col>
        </v-row>
      </div>
    </v-container>
  <!-- </v-card> -->
</template>

<script>
export default {
  props: {
    commentList: Array,
  }
}
</script>

<style>

</style>