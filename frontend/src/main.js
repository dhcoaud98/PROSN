import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import VueSweetalert2 from 'vue-sweetalert2'
import 'sweetalert2/dist/sweetalert2.min.css'
// import 'vuetify/dist/vuetify.min.css'
// import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.config.productionTip = false
Vue.use(VueSweetalert2)

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


window.Kakao.init("6ed2b72fdabc00402337b642bd55e31c")