import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
// import 'vuetify/dist/vuetify.min.css'
// import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.config.productionTip = false

// iconfont 인스턴스화 중에 옵션 추가
// export default new Vuetify({
//   icons: {
//     iconfont: 'md' // 'md' || 'mdi' || 'fa' || 'fa4'
//   }
// })

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
