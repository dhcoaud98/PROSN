import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default ({
  namespaced: true,
  state: {
    componentName: '',
    inputChange: null,
  },
  getters: {
    // isSearched는 현재 검색창에 단어를 검색했는지를 판별하기 위함!
    isSearched: (state) => !!state.inputChange,
    inputChange: (state) => state.inputChange
  },
  mutations: {
    SET_COMPONENT_NAME: (state, componentName) => state.componentName = componentName,
    SET_SEARCH_WORD: (state, inputChange) => state.inputChange = inputChange
  },
  actions: {
    changeComponentName ({commit}, componentName) {
      commit
      console.log(componentName)
      // commit('SET_COMPONENT_NAME', componentName)
      // localStorage.setItem('componentName', componentName)
    },
    searchKeyword ({commit}, inputChange) {
      console.log('searchKeyword : ', inputChange)
      commit('SET_SEARCH_WORD', inputChange)

    }
  }
})
