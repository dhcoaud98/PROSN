<template>
  <div>
    <!-- <p>info</p> -->
    <info-items v-for="mainInfo in mainInfos" :key="mainInfo.id"></info-items>
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
    props: {
      mainInfos: Array,
    },
    created() {
      // 정보 전체 최신 순으로 가져오기
       axios({
        url: drf.postFeed.information(),
        method: 'get',
        headers: {
					Authorization: this.accessToken,
				},
        })
        .then(res => {
          // 잘 넘어오는 지 확인하기!! 0807 임지민
            // console.log("res = ",res);
            console.log("넘어온 data= ", res.data)

            // 여기서 토큰은 어떻게 쓰이는 거징?? 0807 임지민
            const token = res.data.key
            token
            // data의 infos에 넣기 0807 임지민
            this.infos = res.data
        
        })
        .catch(err =>{
            console.log("에러")
            console.log(err)
        })
        }
  }
</script>

<style>

</style>