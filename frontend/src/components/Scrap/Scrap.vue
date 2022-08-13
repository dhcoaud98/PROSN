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
              </v-col>
            </v-row>
          </v-container>
        </v-col>
      </v-row>

      <v-divider class="mx-1 my-2"></v-divider>

      <v-row class="my-2">
        <!-- 리스트 만들기 -->
        <v-col cols="12" class="d-none">
          <v-form ref="form" @submit.prevent="createScrap" id="create-scrap-form"> 
            <v-row>
              <v-col cols="12" lg="8">
                <v-text-field v-model="credentials.scrapTitle" label="문제 리스트 이름을 입력하세요" maxlength="20" counter required dense></v-text-field>
              </v-col>
              <v-col cols="12" lg="4">
                <v-btn type="submit" width="100%">리스트 생성</v-btn>
              </v-col>
            </v-row>
          </v-form>
        </v-col>

        <v-col cols="12" class="py-1">
          <v-btn rounded width="100%" @click="openCreateScrap">
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
import ScrapList from '@/components/Scrap/ScrapList.vue'

export default {
  name: 'Scrap',

  data: () => ({
    credential: {
      scrapTitle: '',
    }
  }),
  components : {
    ScrapList,
  },
  methods: {
    openCrateScrap () {
      const createScrapForm = document.querySelector("#create-scrap-form")
      createScrapForm.classList.remove('d-none')
    },
    createScrap () {
      const createScrapForm = document.querySelector("#create-scrap-form")
      createScrapForm.classList.add('d-none')
    }
  }
}
</script>

<style>

</style>