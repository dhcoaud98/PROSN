<template>
  <v-app>
    <v-container class="mt-3">
        <div>
            <v-row class="pb-0 justify-center">
                <v-col cols="12" sm="6" offset="4">
                    <v-img src="../assets/prosn_logo.png" max-width="200px" max-height="80px"></v-img>
                </v-col>
                <v-col cols="12" sm="6" offset="5" class="justify-center mb-3">
                    <span class="text-center display-1">SIGN UP</span>
                </v-col>
            </v-row>

            <v-form
                ref="form"
                class="col-6 mx-auto"
                @submit.prevent
            >
            <!-- 각 text field 내부 속성들은 추후에 수정하기 -->

                <!-- 아이디 필드 -->
                <v-row class="offset-3 col-12 justify-center align-center pa-0">
                    <v-col class="col-7 pa-0">
                        <v-text-field
                        v-model="id"
                        :rules="idRules"
                        :counter="12"
                        name="id"
                        label="아이디"
                        required
                        ></v-text-field>
                    </v-col>
                    <v-col class="pa-0">
                        <v-btn 
                        @click="idDoubleCheck" 
                        color="#d9d9d9" 
                        class="grey--text font-weight-bold pa-0 id-double-check offset-1" 
                        large>
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
                <v-row class="col-12 pa-0 offset-3">
                    <v-col class="col-9 pa-0">
                    <v-text-field
                        v-model="password"
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
                <v-row class="col-12 pa-0 offset-3">
                    <v-col class="col-9 pa-0">
                    <v-text-field
                        v-model="passwordCheck"
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
                <v-row class="offset-3 col-12 pa-0">
                    <v-col class="col-9 pa-0">
                        <v-text-field
                        v-model="name"
                        :rules="nameRules"
                        :counter="8"
                        label="사용자 이름"
                        name="uname"
                        required
                        ></v-text-field>
                    </v-col>
                </v-row>

                <v-row class="mb-2 col-12 pa-0 offset-3">
                    <v-col class="col-9 pa-0">
                        <v-text-field
                        v-model="email"
                        label="이메일"
                        name="email"
                        :rules="emailRules"
                        required
                        ></v-text-field>
                    </v-col>
                </v-row>
                
                <!-- 회원가입 버튼: 유효성 검사 + submit -->
                <v-row class="mt-5 mb-1 col-12 col-sm-6 offset-4 justify-center pa-0">
                    <!-- 아래에 submitSignup 메서드를 정의; axios로 db에 사용자 정보를 저장하기 -->
                    <v-btn
                    :disabled="!valid"
                    @click="validate(); submitSignUp()"     
                    type="submit"
                    color="#A384FF"
                    class="mr-4 white--text font-weight-bold"
                    >
                    회원가입
                    </v-btn>
                <!-- 취소: 뒤로 가기 -->
                    <v-btn
                    color="#A384FF"
                    class="mr-4 white--text font-weight-bold"
                    @click="$router.go(-1)"
                    >
                    취소
                    </v-btn>
                </v-row>
            </v-form>
            
            <v-row class="mt-4 col-12 col-sm-6 mx-auto">
                <v-col class="col-9 offset-2">
                    <p class="text-center">이미 계정이 있으신가요? <a href="#" class="font-weight-bold ml-2">로그인</a></p>
                </v-col>
            </v-row>
        </div>
    </v-container>
  </v-app>
</template>

<script>
export default {
    name: 'SignUpView',
    data: () => ({
        valid: true,
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
            // console.log('submit') --- ok
            // submit했을 때 axios로 db에 사용자 정보를 저장해주면 된다.
        }

    },
    }
</script>

<style>
    .border-grey {
        border: 1px solid #d9d9d9;
        border-radius: 5%
    }
    :hover.id-double-check {
        background: #a384ff;
        color: white;
        font-weight: bold;
    }
</style>