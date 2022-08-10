<template>
  <!-- 2022.07.27 스크랩 (남성은) -->
  <v-card width="400">
    <v-container>
      <v-row>
        <v-col cols="12" class="d-flex justify-space-between">
          <v-icon large>mdi-folder-open</v-icon>
          <v-btn icon><v-icon>mdi-close</v-icon></v-btn>
        </v-col>
      </v-row>

      <v-divider class="mx-1 my-2"></v-divider>

      <v-row>
        <v-col>
          <v-container>
            <v-row>
              <v-col cols="12">
                <!-- 여기에 ScarpList가 들어갈 예정 -->
                <scrap-list></scrap-list>

                <v-checkbox
                    v-model="ex4"
                    label="기본폴더"
                    color="info"
                    value=""
                    hide-details
                    class="mt-0 font-weight-bold"
                  ></v-checkbox>
              </v-col>
            </v-row>
          </v-container>
        </v-col>
      </v-row>

      <v-divider class="mx-1 my-2"></v-divider>

      <!-- 평소에는 안보이다가 새로운 목록 추가 버튼 클릭시 보이는 부분 -->
      <!-- 새 목록 생성란 -->
      <v-row class="d-none">
        <v-form>
          <!-- 새 목록 이름 입력란  -->
          <v-col cols="9">
            <v-text-field label="새로운 목록 이름을 입력하세요" 
              maxlength="20" 
              counter required dense
              v-model="credentials.title"></v-text-field>
          </v-col>
          <v-col cols="3">
            <v-btn>
              생성
            </v-btn>
          </v-col>
        </v-form>
      </v-row>

      <v-row class="my-2">        
        <v-col cols="12" class="py-1">
          <v-btn rounded width="100%">
            새로운 목록 추가
          </v-btn>
        </v-col>
        <v-col cols="12" class="py-1">
          <v-btn rounded color="#A384FF" class="white--text" width="100%">
            스크랩
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>  

<script>
import ScarpList from '@/components/Scrap/ScrapList.vue'

export default {
  name: 'Scrap',

  data: () => ({
    //
  }),
  components : {
    ScrapList,
  },
}
</script>

<style>

</style>