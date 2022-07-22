import Vue from 'vue'
import Vuex from 'vuex'
import accounts from './modules/accounts'
import info from './modules/info'
import note from './modules/note'
import problem from './modules/problem'
import search from './modules/search'
import study from './modules/study'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    accounts,
    info,
    note,
    problem,
    search,
    study
  }
})

export default store
