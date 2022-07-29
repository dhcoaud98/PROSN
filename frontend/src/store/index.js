import Vue from 'vue'
import Vuex from 'vuex'

import accounts from './modules/accounts.js'
import info from './modules/info.js'
import note from './modules/note.js'
import problem from './modules/problem.js'
import search from './modules/search.js'
import study from './modules/study.js'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    accounts,
    info,
    note,
    problem,
    search,
    study
  }
})

