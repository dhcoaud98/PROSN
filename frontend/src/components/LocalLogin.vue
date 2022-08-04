<template>
  <div>
    <!-- 2022.07.25. 회원 로그인정보 입력란 (남성은) -->
    <v-container class="my-5">
      <v-form ref="form" v-model="valid" lazy-validation @submit.prevent="login" class="ma-0 pa-0">
        <v-row no-gutters>
          <v-col cols="9" class="ma-0 pe-3">
            <!-- 네임룰 추후 설정 필요 -->
            <!-- ID 입력란 -->
            <v-text-field v-model="credentials.userId" label="ID" required></v-text-field>
            <!-- PASSWORD 입력란 -->
            <!-- <v-text-field v-model="password" label="PASSWORD" required></v-text-field>         -->
            <v-text-field
            v-model="credentials.password"
            :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show ? 'text' : 'password'"
            name="input-10-2"
            label="PASSWORD"
            hint="At least 8 characters"
            value=""
            class="input-group--focused"
            @click:append="show = !show"
            ></v-text-field>
          </v-col>

          <!-- 로그인 버튼 -->
          <v-col cols="3">
            <v-btn type="submit" color="#A384FF" class="white--text my-0 mx-5 py-5" height="100%" width="100%" >로그인</v-btn>
          </v-col>
        </v-row>
      </v-form>

      <!-- 회원가입/아이디찾기/비밀번호찾기 --> 
      <v-row class="mt-5">
        <v-col cols="12" class=" d-flex justify-center pa-0">
          <p>아직 계정이 없으신가요?<router-link to="/signup" class="black--text text-decoration-none"> 회원가입</router-link></p>
        </v-col>
      
        <v-col cols="12" class="d-flex justify-space-around pa-0">
          <a href="">아이디 찾기</a>
          <a href="">비밀번호 찾기</a>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
//   export default {
//     // 2022.07.25. 아이디 (남성은)
//     data: () => ({
//       valid: true,
//       id: '',
//       // nameRules: [
//       //   v => !!v || 'Name is required',
//       //   v => (v && v.length <= 10) || 'Name must be less than 10 characters',
//       // ],
//     }),

//     // 2022.07.25. 비밀번호 (남성은)
//     data () {
//       return {
//         show: false,
//         password: '',
//         rules: {
//           required: value => !!value || 'Required.',
//           min: v => v.length >= 8 || 'Min 8 characters',
//         },
//       }
//     },

//     // 2022.07.25. 로그인 버튼 (남성은)
//     methods: {
//       validate () {
//         this.$refs.form.validate()
//       },
//     },
//   }

import axios from 'axios'
import drf from '@/api/drf'
import {mapState, mapActions } from 'vuex'
  const accountStore = "accountStore"

  export default {
    // 2022.07.25. 아이디 (남성은)
    data: () => ({
      valid: true,
      credentials : {
        userId: '',
        password: ''
      },
      show: false,
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Min 8 characters',
      },
    }),

    // 2022.07.25. 로그인 버튼 (남성은)
    methods: {
      validate () {
        this.$refs.form.validate()
      },
      // ...mapActions(['login'])
      login() {
        // axios.post(drf.accounts.login())
        // .then(({res}) => {
        //   console.log(res)
        // })
        axios({
                url: drf.accounts.login(),
                method: 'post',
                data: this.credentials
            })
            .then(res => {
                console.log("res = ",res);
                console.log("accessToken = ",res.data.accessToken);
                let grantType = res.data.grantType.replace(res.data.grantType.charAt(0), res.data.grantType.charAt(0).toUpperCase());
                console.log("grantType:", grantType);
                this.$store.dispatch('saveToken', grantType+" "+res.data.accessToken)
                this.$store.dispatch('saveName', res.data.name)
                this.$router.push({ path: '/'})
                // const token = res.data.key
                // dispatch('saveToken', token)
                // dispatch('fetchCurrentUser')
            
            })
            .catch(err =>{
                console.log("에러")
                console.log(err)
            })
      },

    },
  }

</script>

<style>

</style>