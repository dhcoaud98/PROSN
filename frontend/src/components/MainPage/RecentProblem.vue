<template>
  <div>
    <!-- 여기서 최신 피드들을 받아서 v-for로 recent problem items로 내려주기 -->
    <recent-problem-items></recent-problem-items>
  </div>
</template>

<script>
import RecentProblemItems from '../MainPage/RecentProblemItems.vue'

export default {
    components : {
        RecentProblemItems,
    }
}
</script>

<style>

</style>