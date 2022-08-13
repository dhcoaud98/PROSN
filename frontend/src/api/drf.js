const HOST = 'http://i7a705.p.ssafy.io:8080/api/'

// 유저 관련
const USER = 'user/'
// 스터디 관련
const STUDY = 'study/'
// 댓글 관련
const COMMENT = 'comment/'
// 문제, 정보 관련
const POSTFEED = 'post/'
// 오답노트 관련
const WRONGANSWER = 'wrongAnswer/'
// 문제 풀이 현황 관련
const SOLVING = 'solving/'

export default {
  accounts: {
    login: () => HOST + USER +'login/',
    join: () => HOST + USER + 'join/',
  },
  api: HOST,
  study : {
    STUDY
  },
  comment : {
    COMMENT
  },
  postFeed : {
    problem: () => HOST + POSTFEED + 'problem/',
    information: () => HOST + POSTFEED + 'information/'
  },
  wrongAnswer : {
    wrongAnswer: () => HOST + WRONGANSWER,
  },
  solving: {
    SOLVING
  }
}
