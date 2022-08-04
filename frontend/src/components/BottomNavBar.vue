<template>
  <v-bottom-navigation v-model="icons.value" class="sticky-bottom align-center justify-space-around">
    <div v-for="icon in icons" :key="icon.text">
      <router-link :to="icon.urlName">
        <button type="button" :value="icon.value" class="col-3 pa-0 transparent">
            <span class="material-icons font-30 text-decoration-none black--text">
                {{ icon.text }}
            </span>
        </button>
      </router-link>
    </div>

    <!-- 홈 
    <v-btn value="recent" class="col-3 pa-0 transparent">
        <span class="material-icons font-30">
            home
        </span>
    </v-btn> 

    스터디
    <v-btn value="favorites" class="col-3 pa-0 transparent">
      <span class="material-icons font-30" >
        groups
    </span>
    </v-btn>

    <v-btn value="nearby" class="col-3 pa-0 transparent">
      <span class="material-icons font-30">
        sticky_note_2
    </span>

    </v-btn>

    내 프로필
    <v-btn value="nearby" class="col-3 pa-0 transparent">
      <span class="material-icons font-30">
            person
        </span>
    </v-btn> -->
  </v-bottom-navigation>
</template>

<script>
export default {
  data() {
    return {
      icons: [
        { 
          value: 'recent',
          text: 'home',
          urlName: '/'
        },
        { 
          value: 'favorites',
          text: 'groups',
          urlName: '/study'
        },
        { 
          value: 'nearby',
          text: 'sticky_note_2',
          urlName: '/note'
        },
        { 
          value: 'nearby',
          text: 'person',
          urlName: '/profile'
        },
      ]
    }
  }
}
</script>

<style>
.sticky-bottom {
    position: sticky;
}
.font-30 {
    font-size: 30px;
}

/* box shadow 없애기 */
.v-item-group.v-bottom-navigation {
  box-shadow: none;
}
</style>