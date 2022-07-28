const HOST = 'http://localhost:8080/api/'

const USER = 'user/'




export default {
  user: {
    login: () => HOST + USER +'login/',
    join: () => HOST + USER + 'join/',

  }
}