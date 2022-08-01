import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPageView from '@/views/MainPageView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import StudyView from '@/views/StudyView.vue'
import NoteView from '@/views/NoteView.vue'
import ProfilePageView from '@/views/ProfilePageView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'mainPage',
    component: MainPageView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/signup',
    name: 'signUp',
    component: SignUpView
  },
  {
    path: '/study',
    name: 'study',
    component: StudyView
  },
  {
    path: '/note',
    name: 'note',
    component: NoteView
  },
  // 회원가입, 로그인 구현 후 username 받을 수 있으면 path 뒤에 /:username 붙이기(1/3 0729임지민)
  {
    path: '/profile',
    name: 'profile',
    component: ProfilePageView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router