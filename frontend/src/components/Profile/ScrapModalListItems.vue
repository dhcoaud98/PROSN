<template>
  <v-container outlined class="pa-0 d-flex flex-row">
    <div class="d-flex justify-space-between scrap-item py-2">
      <div class="d-flex flex-row">
        <v-checkbox info></v-checkbox>
        <div class="mt-2 ms-2">
          <h2>게시글 제목</h2>
          <div>게시글 내용</div>
        </div>
      </div>
      <div class="d-flex align-end">
        <v-btn text class="font-weight-bold">자세히 보기 ></v-btn>
      </div>
    </div>
  </v-container>
</template>

<script>
export default {
  name: 'ScrapModalListItems',
}
</script>

<style>
.scrap-item {
  width: 100%;
  border-width: 1px;
  border-color: #DEDCDF;
  border-top-style: solid;
  border-bottom-style: solid;
}
</style>