<template>
  <v-bottom-navigation v-model="icons.value" class="fixed-bottom align-center justify-space-around">
    <div v-for="icon in icons" :key="icon.text">
      <!-- url이 같은 상태에서는 상단으로 이동하고, 다른 상태에서는 지정된 url로 이동하기 (0808 임지민 완료)-->
      <div @click="checkUrl(icon.urlName)">
          <button type="button" :value="icon.value" class="col-3 pa-0 transparent">
              <span class="material-icons font-30 text-decoration-none color-purple" color="#A384FF">
                  {{ icon.text }}
              </span>
          </button>
      </div>
    </div>
  </v-bottom-navigation>
</template>
""
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
      ],

    }
  },
  methods : {
    checkUrl(urlName) {
      if (window.location.href.endsWith(urlName)) {
        // console.log(true)
        window.scrollTo({
          top: 0,
          left: 0,
          behavior: 'smooth'
        })
      } else {
        this.$router.push({ path: urlName})
      }
    }
  }
}
</script>

<style>
.fixed-bottom {
    position: fixed;
    bottom: 0;

}
.font-30 {
    font-size: 30px;
}

/* box shadow 없애기 */
.v-item-group.v-bottom-navigation {
  box-shadow: none;
}

.color-purple {
  color: #6776fa;
}
</style>