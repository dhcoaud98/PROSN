import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default ({
  namespaced: true,
  state: {
    componentName: '',
  },
  getters: {
  },
  mutations: {
    SET_COMPONENT_NAME: (state, componentName) => state.componentName = componentName
  },
  actions: {
    changeComponentName ({commit}, componentName) {
      commit
      console.log(componentName)
      // commit('SET_COMPONENT_NAME', componentName)
      // localStorage.setItem('componentName', componentName)
    }
  }
})
