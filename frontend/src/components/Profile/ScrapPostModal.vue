<template>
  <!-- 2022.07.26 문제 모달 (남성은) -->
  <v-container class="modal" appear>
    <v-container class="modal modal-overlay" @click.self="$emit('close')">
      <v-container class="modal-window pa-0">
        <v-container class="rounded-lg modal-content pa-0">
          <v-card>
            <v-card-title>

            </v-card-title>

            <v-card-text>
              
            </v-card-text>
          </v-card>
        </v-container>
      </v-container>
    </v-container>
  </v-container>
</template>

<script>
export default {

}
</script>

<style>

</style>