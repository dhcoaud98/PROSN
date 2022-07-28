import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUp from '@/views/SignUpView.vue'
import LoginView from '@/views/LoginView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/signup',
    component: SignUp
  },
  {
    path: '/login',
    component: LoginView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
