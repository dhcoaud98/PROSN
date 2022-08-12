import axios from 'axios'
import drf from '@/api/drf'


const reissue = (accessToken, refreshToken) => {
  const reaccessToken = accessToken.slice(7)

  axios({
    url: drf.api.USER + 'reissue',
    method: 'post',
    headers: {
      'Access-Token' : reaccessToken, 
      'Refresh-Token' : refreshToken,
    },
    data: this.credentials
  })
  .catch(err =>{
    console.log("에러")
    console.log(err)
  })
}

export default {reissue}
