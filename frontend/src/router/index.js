import Vue from 'vue'
import VueRouter from 'vue-router'
import SignUpView from '../views/SignUpView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/signup', 
    component: SignUpView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
