<template>
  <!-- 피드 하나하나 디자인 하고 그 자리에 받아온 데이터 띄우기 -->
  <div class="my-3 pa-5 w-100">
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <div class="color-FAF0F3 mx-auto border-a-10">
        <v-container class="px-5">
            <!-- 첫번째 v-row: 프사, 사용자 이름, 사용자 등급, 팔로우 버튼 -->
            <v-row class="align-center justify-space-between">
                <div class="d-flex align-center mx-2 my-4">
                    <!-- profile 뒤에 개인 username 붙이기 0802 임지민 -->
                    <router-link to="/profile">
                        <span class="material-icons mr-2 font-parent-lar text-decoration-none black--text pt-2">
                            account_circle
                        </span>
                    </router-link>
                    <span class="font-weight-bold font-parent-mid">jimin4661</span>
                    <span class="ml-2 tmp-border py-1 font-weight-bold font-parent-sml">PROSN</span>
                </div>
                
                <!-- 크기가 작아지면 버튼 크기도 작아지게; 부모 크기 상속받도록? -->
                <button type="button" class="pa-2 border-a-10 color-D9D9D9 font-weight-bold font-parent-mid">팔로우</button>
            </v-row>

            <!-- 두번째 row: 본문 -->
            <v-row class="white border-a-10 mb-4">
                <!-- 카테고리 태그 -->
                <v-row class="col-12 mt-2 ml-2">
                    <!-- 0801 임지민
                        카테고리 개수 따라서 col바뀌도록 바인딩하기 :class="col-n 이런 식" 
                        나중에 for문으로 돌리기
                    -->
                    <span class="category-tag text-center pa-1 d-inline-block mr-2 font-parent-sml">#네트워크</span>
                    <span class="category-tag text-center pa-1 d-inline-block mr-2 font-parent-sml">#알고리즘</span>
                    <span class="category-tag text-center pa-1 d-inline-block mr-2 font-parent-sml">#CS</span>
                </v-row>
                <!-- 0801 임지민
                    본문 
                    - 1~2줄만 보여주고 나머지는 text-overflow: ellipsis 처리하기
                -->
                <v-row class="px-4 mb-4">
                    <p class="px-4 mb-4 ">
                        정보정보정보
                    </p>
                </v-row>
            </v-row>

            <!-- 
                세번째 row: 좋아요, 싫어요, 스크랩 
                - 클릭하면 색이 바뀌도록 처리
            -->
            <v-row class="justify-end mb-3">
                    <span class="material-icons mr-4" @click="changeLikeStatus" id="upIcon">
                        {{upText}}
                    </span>
                    <span class="material-icons mr-4" @click="changeHateStatus" id="downIcon">
                        {{downText}}
                    </span>
                    <span class="material-icons mr-4" @click="changeScrapStatus" id="scrapIcon">
                        {{scrapText}}
                    </span>
            </v-row>
        </v-container>
    </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            upText: 'thumb_up_off_alt',
            downText: 'thumb_down_off_alt',
            scrapText: 'bookmark_border',
        }
    },
    methods: {
        changeLikeStatus() {
            /* 
            버튼 클릭하면 색이 바뀌도록
            thumb up --> thumb up off alt
            thumb down --> thumb down off alt
            bookmark border --> bookmark
            */
            /* 싫어요가 눌려 있는 상태에서 좋아요를 누르면 싫어요가 취소되는 것도 추가 */

           if (this.upText === "thumb_up_off_alt") {
               // 좋아요를 눌러야 하는데 이미 싫어요가 눌려져 있는 상태
            if (this.downText === "thumb_down") {
                // console.log(this.downText)
                this.downText = "thumb_down_off_alt"
            }
            this.upText = "thumb_up"

           } else {
            this.upText = "thumb_up_off_alt"
           }

        },
        changeHateStatus() {
            /* 좋아요가 눌려 있는 상태에서 싫어요를 누르면 좋아요가 취소되는 것도 추가 */
            if (this.downText === "thumb_down_off_alt") {
                this.downText = "thumb_down"
                // 싫어요를 눌렀는데 이미 좋아요가 눌러져 있는 상태
                if (this.upText === "thumb_up") {
                    this.upText = "thumb_up_off_alt"
                }
           } else {
                this.downText = "thumb_down_off_alt"
           }
        },
        changeScrapStatus() {
           if (this.scrapText === "bookmark_border") {
                this.scrapText = "bookmark"
           } else {
                this.scrapText = "bookmark_border"
           }
        },
    }
}
</script>

<style>
.border-a-10 {
    border-radius: 10px;
}
.color-FAF0F3 {
    background-color: #FAF0F3;
}
.color-D9D9D9 {
    background-color: #d9d9d9;
}
.tmp-border {
    border: 1px solid #a384ff;
    background: #a384ff;
    border-radius: 20px;
    color: white;
}
.category-tag {
    border-radius: 20px;
    border: 1px solid #a384ff;
    background-color: #a384ff;
    color: white;
    font-weight: bold;
}
.font-parent-lar {
    font-size: 1.5em;
}
.font-parent-mid {
    font-size: 0.9em;
}
.font-parent-sml {
    font-size: 0.3em;
}
:hover.material-icons {
    cursor: pointer;
}
</style>