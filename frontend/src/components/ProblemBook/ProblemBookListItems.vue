<template>
  <!-- 문제 하나하나 받아오기 -->
  <!-- 화면 크기가 xs 이하일 때는 문제와 노트 작성 칸이 세로로 배치되게 수정하기 0805 임지민 -->
  <v-container fluid>
    <v-row class="mt-3">
        <!-- col 1: 상위의 createnotelist에서 받아온 문제 출력 -->
        <v-col class="pr-5">
            <v-row class="align-center justify-space-between">
                <!-- 출제자 프사 -->
                <v-col cols="6" class="pa-0 mr-0">
                    <router-link to="/profile" class="text-decoration-none black--text">
                    <div class="d-flex align-center">
                        <span class="material-icons mr-2 text-decoration-none black--text">
                            account_circle
                        </span>
                        <!-- 출제자 아이디 -->
                        <span>jimin4661</span>
                    </div>
                    </router-link>
                </v-col>    
                <v-col cols="2" class="pa-0">
                    <span>2022년 8월 5일</span>
                </v-col>
                    
            </v-row>

        <hr class="border-grey my-5">
        <!-- 문제 제목 -->
        <v-row class="justify-space-between">
            <p class="font-parent-lar font-weight-bold mt-5">158. 정보 표현의 기본 장치</p>
        </v-row>

        <!-- 문제 지문 -->
        <v-row class="grey lighten-4 border-a-10 pa-5">
            <v-col class="px-0 py-2 font-weight-bold">
                <p class="font-parent-mid-l">다음 설명에 맞는 장치로 적절한 것은 무엇인가요?</p>
                <p class="font-parent-mid-l">
                    컴퓨터에는 (       )라고 불리는 굉장히 많은 스위치가 있고,
                    on/off 상태를 통해 0과 1을 표현합니다.
                </p>
            </v-col>
        </v-row>
    

        <!-- 문제보기: 이것도 랜덤으로 for문 돌리기/ 체크박스로 라디오 묶는거....ㅠ-->
        <v-row>
            <v-col>
                <v-row>
                    <input type="radio" value="보기1" id="check1" name="bogey">
                    <label for="check1" class="ml-2 font-parent-mid-l">보기 1</label>
                </v-row>
                <v-row>
                    <input type="radio" value="보기2" id="check2" name="bogey">
                    <label for="check2" class="ml-2 font-parent-mid-l">보기 2</label>
                </v-row>
                <v-row>
                    <input type="radio" value="보기3" id="check3" name="bogey">
                    <label for="check3" class="ml-2 font-parent-mid-l">보기 3</label>
                </v-row>
                <v-row>
                    <input type="radio" value="보기4" id="check4" name="bogey">
                    <label for="check4" class="ml-2 font-parent-mid-l">보기 4</label>
                </v-row>
            </v-col>

        </v-row>

        <hr class="my-5 border-grey">
        <!-- 좋아요 싫어요 스크랩 제출버튼 -->
        <v-row class="justify-space-between align-center mb-3 mt-5">
            <button type="submit"
                class="font-weight-bold problem-submit-btn px-3 py-1 border-a-10 border-grey" 
                id="problemSubmit">
                제출
            </button>
            <div class="d-flex justify-end">
                <span class="material-icons mr-4" @click="changeLikeStatus" id="upIcon">
                    {{upText}}
                </span>
                <span class="material-icons mr-4" @click="changeHateStatus" id="downIcon">
                    {{downText}}
                </span>
                <span class="material-icons mr-4" @click="changeScrapStatus" id="scrapIcon">
                    {{scrapText}}
                </span>
            </div>
        </v-row>
        
        </v-col>
    </v-row>
  </v-container>
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
.left-border-grey {
  border-left: 1px solid #d9d9d9;
}

/* 내가 고른 답, 정답이 나오는 드롭다운의 box shadow 없애기 */
.v-menu__content {
  box-shadow: none;
}

.problem-submit-btn:hover {
    /* border: 1px solid #a384ff; */
    background-color: #a384ff;
    color: white;
    font-weight: bold;
    border: 1px solid #a384ff;
}
.material-icons {
    font-size: 2em;
}
</style>