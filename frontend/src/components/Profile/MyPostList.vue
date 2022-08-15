<template>
  <v-container class="mt-5">
    <!-- v-for 사용하기 -->
    <my-post-list-items 
      v-for="(myPost, idx) in myPosts"
      :key="idx"
      :myPost="myPost"
    ></my-post-list-items>
    <br>  
    <v-pagination
      v-model="nowPage"
      :length="endPage"
      color="#A384FF"
      circle
      @input="handlePage()"
    ></v-pagination>
  </v-container>
</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'
import MyPostListItems from './MyPostListItems.vue'
import { mapGetters } from 'vuex';

export default {
  name: 'MyPostList',
  components: {
    MyPostListItems,
  },
  data() {
    return {
      // infos: [],
      // probs: [],
      myPosts: [],
      userPost: [],
      nowPage: 1,
      clickPage: null,
      endPage1: 0,
      endPage2: 0,
      endPage: 2,
      value: null,
      page: 0,
    }
  },
  computed: {
    ...mapGetters(['accessToken', 'currentUser'])
  },
  created() {
    const params ={
      page: 0,
      size: 4,
      sort: 'updated,DESC',
    }
    // 유저의 포스트 조회
    axios({
      url: drf.api + 'user/' + 'post/' + `${this.currentUser}`,
      method: 'get',
      headers: {
        Authorization : this.accessToken,
      },
      params: params
    })
    .then(res => {
      console.log(res.data)
    })
    axios({
      url: drf.api + 'user/' + 'info/' + `${this.currentUser}`,
      method: 'get',
      headers: {
        Authorization : this.accessToken,
      },
      params: params
    })
    .then(res => {
      console.log(res.data)
    })
    // 0815 오채명 : 내가 쓴 모든 게시글 가져오기
    // const params ={
    //   page: 0,
    //   size: 2,
    //   sort: 'updated,DESC',
    // }
    // axios({
    //   url: drf.api + 'post' + '/information',
    //   method: 'get',
    //   headers: {
    //     Authorization : this.accessToken,
    //   },
    //   // params: params
    // })
    // .then(res => {
    //   // 내가 작성한 글이면
    //   res.data.content.forEach(element => {
    //     if (element.writer.id === this.currentUser) {
    //       this.myPosts.push(element)
    //       // this.endPage1 = res.data.elementPages // 정보에 대한 값 
    //     }
    //   })

    // })
    // .catch(err => {
    //   console.log("에러")
    //   console.log(err)
    // })

    // // 0815 오채명 내가 작성한 문제 가져오기
    // axios({
    //   url: drf.api + 'post' + '/problem',
    //   method: 'get',
    //   headers: {
    //     Authorization : this.accessToken,
    //   },
    //   // params: params
    // })
    // .then(res => {
    //   // 내가 작성한 문제이면
    //   res.data.content.forEach(element => {
    //     // console.log(element)
    //     if(element.writerId === this.currentUser) {
    //       this.myPosts.push(element)
    //       // this.endPage2 = res.data.elementPages // 문제에 대한 값
    //     }
    //   })
    //   console.log("myPosts = ", this.myPosts)
    // })
    // .catch(err => {
    //   console.log("에러")
    //   console.log(err)
    // })
    
    // 섞어야 함
    // console.log("myPost = ", myPost)
    // if ((this.myPost)%4 > 0) {
    //   this.endPage = parseInt(this.endPage1 + this.endPage2) + 1
    // } else {
    //   this.endPage = (this.endPage1 + this.endPage2)/4
    // }
    // console.log("myPost =")
  }

}
</script>

<style>

</style>