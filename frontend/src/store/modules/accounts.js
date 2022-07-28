import axios from 'axios'
import drf from '@/api/drf'


export default {
  namespaced: true,

  // state는 직접 접근 금지!
  state: {
    accessToken: localStorage.getItem('token') || '' ,
    authError: null,
  },
  getters: {
    authError: state => state.authError,
  },
  mutations: {
    SET_TOKEN: (state, accessToken) => state.accessToken = accessToken,
    SET_AUTH_ERROR: (state, error) => state.authError = error,
  },
  actions: {
    saveToken({ commit }, accessToken) {
      /* 
      state.token 추가 
      localStorage에 token 추가
      */
      commit('SET_TOKEN', accessToken)
      localStorage.setItem('token', accessToken)
    },

    // removeToken({ commit }) {
    //   /* 
    //   state.token 삭제
    //   localStorage에 token 추가
    //   */
    //   commit('SET_TOKEN', '')
    //   localStorage.setItem('token', '')
    // },

    login({ commit, dispatch }, credentials) {
      /* 
      POST: 사용자 입력정보를 login URL로 보내기
        성공하면 현재 사용자 정보 받기
        실패하면 에러 메시지 표시
      */
      axios({
        url: drf.user.login(),
        method: 'post',
        data: credentials
      })
      .then(res => {
        console.log("axios complete")
        dispatch('saveToken', res.accessToken)
      })
      .catch(err => {
        commit('SET_AUTH_ERROR', err.response.data)
      })

    }
  },
  modules: {
  }
}
