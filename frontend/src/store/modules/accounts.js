// import axios from 'axios';
// import drf from '@/api/drf.js';
// import router from '@/router';

const accountStore = {
	// namespaced: true,

	// state는 직접 접근 금지!
	state: {
		accessToken: sessionStorage.getItem('token') || '',
		userName: '',
		authError: null,
		refreshToken: sessionStorage.getItem('reToken') || '',
	},
	getters: {
		isLoggedIn: (state) => !!state.accessToken,
		authError: (state) => state.authError,
		userName: (state) => state.userName,
		accessToken: (state) => state.accessToken,
		refreshToken: (state) => state.refreshToken
	},
	mutations: {
		SET_TOKEN: (state, accessToken) => {
			console.log('mutations accessToekn = ', accessToken)
			state.accessToken = accessToken;
		},
		SET_AUTH_ERROR: (state, error) => (state.authError = error),
		SET_USER_NAME: (state, userName) => (state.userName = userName),
		SET_REFRESH_TOKEN: (state, refreshToken) => (state.refreshToken = refreshToken)
	},
	actions: {
		saveToken({ commit }, accessToken, refreshToken) {
			console.log('accessToken save : ', accessToken)
			/* 
      state.token 추가 
      localStorage에 token 추가
      */
			commit('SET_TOKEN', accessToken)
			commit('SET_REFRESH_TOKEN', refreshToken)
			// sessionStorage.setItem('token', accessToken)/
			// commit('SET_CURRENT_USER', accessToken)
		},
		removeToken({ commit }) {
			/* 
      state.token 삭제
      localStorage에 token 추가
      */
			commit('SET_TOKEN', '')
			localStorage.setItem('token', '')
		},
		removeName({ commit }) {
			commit('SET_USER_NAME', null)
			// sessionStorage.setItem('userName')
		},
		saveName({ commit }, userName) {
			commit('SET_USER_NAME', userName)
			console.log('current username =', userName) //ok

			// localStorage.setItem('userName', userName)
		},

		// removeToken({ commit }) {
		//   /*
		//   state.token 삭제
		//   localStorage에 token 추가
		//   */
		//   commit('SET_TOKEN', '')
		//   localStorage.setItem('token', '')
		// },
	},
	modules: {},
};
export default accountStore
