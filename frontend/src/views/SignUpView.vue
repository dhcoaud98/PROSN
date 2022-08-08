<template>
    <v-container class="mt-3">
        <v-row>
            <!-- 메인 기둥: 가운데에 얇게 배치하기 위함 -->
            <v-col offset="3" cols="6" class="white border-a-10">
                <!-- 로고, signup -->
                <v-row>
                    <v-col class="text-center">
                        <router-link to="/" class="d-inline-block">
                            <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="80px"></v-img>
                        </router-link>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>
                        <p class="text-center display-1">SIGN UP</p>
                    </v-col>
                </v-row>
                <!-- form -->
                <v-row>
                    <v-col>
                        <v-form
                            ref="form"
                            class="col-6 mx-auto"
                            @submit.prevent="submitSignUp"
                        >
                        <!-- 각 text field 내부 속성들은 추후에 수정하기 -->

                            <!-- 아이디 필드 -->
                            <v-row class="justify-center align-center pa-0">
                                <v-col cols="8" class="pa-0">
                                    <v-text-field
                                    v-model="credentials.userId"
                                    :rules="idRules"
                                    :counter="12"
                                    name="userId"
                                    label="아이디"
                                    required
                                    ></v-text-field>
                                </v-col>
                                <v-col class="pa-0 ml-4">
                                    <v-btn 
                                    @click="idDoubleCheck" 
                                    color="#d9d9d9" 
                                    class="grey--text font-weight-bold pa-0 id-double-check offset-1">
                                    중복확인
                                    </v-btn>
                                </v-col>
                            </v-row>
                            <!-- 
                                비밀번호 필드
                                - 힌트: 최소 n자 이상(hint)
                                - 8자 이상 입력되지 않으면 빨간 텍스트가 뜸
                                - 눈 모양 아이콘 누르면 작성한 비번이 보였다 안보였다 함
                            -->
                            <v-row class="pa-0">
                                <v-col class="pa-0">
                                <v-text-field
                                    v-model="credentials.password"
                                    :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                                    :rules="[rules.required, rules.min]"    
                                    :type="show1 ? 'text' : 'password'"
                                    name="password1"
                                    label="비밀번호"
                                    hint="최소 8자 이상 입력하세요"
                                    counter
                                    @click:append="show1 = !show1"
                                ></v-text-field>
                                </v-col>
                            </v-row>

                            <!-- 비밀번호 확인 필드-->
                            <v-row class="pa-0">
                                <v-col class="pa-0">
                                <v-text-field
                                    v-model="credentials.passwordCheck"
                                    :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
                                    :rules="[rules.required, checkPassword]"    
                                    :type="show2 ? 'text' : 'password'"
                                    name="password2"
                                    label="비밀번호 확인"
                                    counter
                                    @click:append="show2 = !show2"
                                ></v-text-field>
                                </v-col>
                            </v-row>

                            <!-- 사용자 이름 필드 -->
                            <v-row class="pa-0">
                                <v-col class="pa-0">
                                    <v-text-field
                                    v-model="credentials.name"
                                    :rules="nameRules"
                                    :counter="8"
                                    label="사용자 이름"
                                    name="name"
                                    required
                                    ></v-text-field>
                                </v-col>
                            </v-row>

                            <v-row class="mb-2 pa-0">
                                <v-col class="pa-0">
                                    <v-text-field
                                    v-model="credentials.email"
                                    label="이메일"
                                    name="email"
                                    :rules="emailRules"
                                    required
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            
                            <!-- 회원가입 버튼: 유효성 검사 + submit -->
                            <v-row class="mt-5 mb-1 justify-center pa-0">
                                <!-- 아래에 submitSignup 메서드를 정의; axios로 db에 사용자 정보를 저장하기 -->
                                  <v-btn
                                    :disabled="!valid"
                                    @click="validate();"     
                                    type="submit"
                                    color="#A384FF"
                                    class="mt-3 mr-4 white--text font-weight-bold"
                                    >
                                    회원가입
                                    </v-btn>
                            <!-- 취소: 뒤로 가기 -->
                                <v-btn
                                color="#A384FF"
                                class=" mt-3 mr-4 white--text font-weight-bold"
                                @click="$router.push('/')"
                                >
                                취소
                                </v-btn>
                            </v-row>
                        </v-form>
                    </v-col>
                </v-row>
                
                <!-- 이미 계정이 있으신가요?  -->
                <v-row>
                    <v-col>
                        <p class="text-center">이미 계정이 있으신가요? 
                            <router-link to="/login" class="font-weight-bold ml-2 hover-login">로그인</router-link>
                        </p>
                    </v-col>
                </v-row>
            </v-col>

        </v-row>
    </v-container>

</template>

<script>
// import { mapActions } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf'

export default {
    name: 'SignUpView',
    data: () => ({
        valid: true,
        credentials : {
            userId: '',
            name: '',
            password: '',
            email: '',
        },
        id: '',
        idRules: [
            v => !!v || '아이디는 필수 입력값입니다.',
            v => (v && v.length <= 12) || '아이디는 12자 이하로 입력하세요',
        ],
        email: '',
        emailRules: [
            v => !!v || '이메일은 필수 입력값입니다.',
            v => /.+@.+\..+/.test(v) || '이메일이 유효하지 않습니다.',
        ],
        name: '',
        nameRules: [
            v => !!v || '사용자 이름은 필수 입력값입니다.',
            v => (v && v.length <= 12) || '사용자 이름은 10자 이하로 입력하세요',
        ],
        show1: false,
        show2: false,
        password: '',
        passwordCheck: '',
        rules: {
          required: value => !!value || '필수 입력값입니다.',
          min: v => v.length >= 8 || '최소 8자 이상을 입력하세요',
        }
    }),

    methods: {
        // ...mapActions(['accounts/signUp']),

        reset () {
            this.$refs.form.reset()
        },
        checkPassword() {
            if (this.password === this.passwordCheck) {
                return true
            } else {
                return '비밀번호가 일치하지 않습니다.'
            }
        },
        idDoubleCheck () {
            return true
        },
        validate () {
            this.$refs.form.validate()
        },
        submitSignUp () {
            console.log('axios = ', axios)
            // console.log('submit') --- ok
            // submit했을 때 axios로 db에 사용자 정보를 저장해주면 된다.
            // console.log("클릭")
            // console.log("credentials = ", this.credentials)
            axios({
                url: drf.accounts.join(),
                method: 'post',
                data: this.credentials
            })
            .then(res => {
                // console.log("res = ",res);
                // 회원가입이 완료되면 바로 로그인을 시켜주기 위함
                let grantType = res.data.grantType.replace(res.data.grantType.charAt(0), res.data.grantType.charAt(0).toUpperCase());
                console.log("grantType:", grantType);
                this.$store.dispatch('saveToken', grantType+" "+res.data.accessToken)
                this.$store.dispatch('saveName', res.data.name)
                
                // 회원가입이 완료되면 메인 페이지로 이동
                this.$router.push({ path: '/'})
            
            })
            .catch(err =>{
                // console.log("에러")
                console.log(err)
            })
        }

    },
    }
</script>

<style>
    .border-grey {
        border: 1px solid #d9d9d9;
        border-radius: 5%
    }
    .id-double-check:hover {
        background: #a384ff;
        color: white;
        font-weight: bold;
    }
    .hover-login:hover {
        color: #a384ff;
        text-decoration: underline;
    }

    /* router-link 기본 글자 색 검정색, 밑줄 없애기 0805 임지민 */
    .v-application a {
        color: black;
    }
    a:-webkit-any-link {
        text-decoration: none;
    }
</style>