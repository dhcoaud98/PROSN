<template>
<!-- 
  틀린 문제들 받아오기 
  - 문제 개수대로 탭 띄우기
  - 탭 모양: 동그라미 숫자  
-->
  <v-container>
    <v-row>
      <v-col>
        <v-toolbar
          flat
        >
          <!-- <template v-slot:extension> -->
            <v-tabs
              v-model="tab"
              align-with-title
            >
              <v-tabs-slider color="#A384FF"></v-tabs-slider>

              <!-- 여기에 오답노트 개수 세서 넣어놓기 -->
              <v-tab
                v-for="i in (0, 5)"
                :key="i"
              >
                {{ i }}
              </v-tab>
            </v-tabs>
          <!-- </template> -->
        </v-toolbar>

        <!-- 여기는 위에처럼 오답노트 개수 세서 넣어놓기 -->
        <v-tabs-items v-model="tab">
          <v-tab-item
            v-for="i in (0, 5)"
            :key="i"
          >
            <!-- 여기다가 notelist로 받아서 v-for로 돌려주기 -->
            <v-card>
              <v-card-text>
                <!-- hello world: ok -->
                <!-- create-note-list-items도 정상적으로 작동함 -->
                <create-note-list-items :problem="problems"></create-note-list-items>
              </v-card-text>
            </v-card>
          </v-tab-item>
        </v-tabs-items>
      </v-col>
    </v-row>
  </v-container>

</template>

<script>
import CreateNoteListItems from '@/components/Note/CreteNoteListItems.vue'

export default {
  components: {
    CreateNoteListItems,
  },
  data() {
    return {
      tab: null,
      problems: {
        myAnswer: 2,
        realAnswer: 4,
      }
    }
  }
}
</script>

<style>

</style>