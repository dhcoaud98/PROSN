import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from '@/views/SignUpView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/signup',
    component: SignUp
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
