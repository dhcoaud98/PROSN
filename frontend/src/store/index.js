import Vue from 'vue'
import Vuex from 'vuex'

import accounts from '@/store/modules/accounts.js'
import info from '@/store/modules/info.js'
import note from '@/store/modules/note.js'
import problem from '@/store/modules/problem.js'
import search from '@/store/modules/search.js'
import study from '@/store/modules/study.js'

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

