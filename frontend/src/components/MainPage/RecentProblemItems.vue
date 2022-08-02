<template>
  <!-- 피드 하나하나 디자인 하고 그 자리에 받아온 데이터 띄우기 -->
  <v-app class="my-3 pa-5">
    <!-- 크기 550px로 고정하지 말고 반응형으로 작동할 수 있도록 수정하기; margin 사용 등 -->
    <div class="color-FAF0F3 mx-auto border-a-10">
        <v-container class="px-5">
            <!-- 첫번째 v-row: 프사, 사용자 이름, 사용자 등급, 팔로우 버튼 -->
            <v-row class="align-center">
                <div class="d-flex col-10">
                    <v-col cols="2" class="pt-3">
                        <span class="material-icons">
                            account_circle
                        </span>
                    </v-col>
                    <v-col cols="8" class="px-0 align-center">
                        <span class="font-weight-bold text-caption text-lg-body-2">jimin4661</span>
                        <span class="ml-2 tmp-border py-1 font-weight-bold font-12">PROSN</span>
                    </v-col>
                </div>
                
                <v-col cols="2">
                    <v-btn class="pa-0 color-D9D9D9 font-weight-bold">팔로우</v-btn>
                </v-col>
            </v-row>

            <!-- 두번째 row: 본문 -->
            <v-row class="white border-a-10">
                <!-- 카테고리 태그 -->
                <v-row class="col-12">
                    <!-- 카테고리 개수 따라서 col바뀌도록 바인딩하기 :class="col-n 이런 식" -->
                    <v-col cols="2" class="pr-0 text-truncate">
                        <p class="category-tag text-center pa-1 d-inline-block">#네트워크</p>
                    </v-col>
                    <v-col cols="2" class="px-0 text-truncate">
                        <p class="category-tag pa-1 d-inline-block">#알고리즘</p>
                    </v-col>
                    <v-col cols="2" class="px-0 text-truncate">
                        <p class="category-tag pa-1 d-inline-block">#CS</p>
                    </v-col>
                </v-row>
                <!-- 본문 -->
                <v-col>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio accusantium facere voluptate a ad non quis quos quam, veniam suscipit consectetur reprehenderit aperiam porro dolorem! Consectetur mollitia quasi enim illum.</p>
                </v-col>
            </v-row>

            <!-- 세번째 row: 좋아요, 싫어요, 스크랩 -->
            <v-row>
                <v-col cols="1" offset="9">
                    <span class="material-icons">
                        thumb_up_off_alt
                    </span>
                </v-col>
                <v-col cols="1">
                    <span class="material-icons">
                        thumb_down
                    </span>
                </v-col>
                <v-col cols="1">
                    <span class="material-icons">
                        bookmark_border
                    </span>
                </v-col>
            </v-row>
        </v-container>
    </div>
  </v-app>
</template>

<script>
export default {

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
    font-size: 0.8rem;
    color: white;
    font-weight: bold;
}
.font-12 {
    font-size: 12px;
}
.font-30 {
    font-size: 30px;
}
</style>