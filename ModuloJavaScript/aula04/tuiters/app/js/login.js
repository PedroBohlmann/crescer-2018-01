import $ from 'jquery'
import _ from 'jquery-validation'

import LoginService from './services/login-service'
import HomeService from './services/home-service'

class LoginForm {
    configure() {
        this._isLogged()
        $('#frmLogin').validate({
            rules: {
                txtEmail: {
                    required: true,
                    email: true
                },
                txtPassword: {
                    required: true
                }
            },
            submitHandler: function(form) {
                this._login()
            }.bind(this)
        })
    }

    _login() {
        const email = txtEmail.value
        const password = txtPassword.value

        LoginService.login(email,password)
            .then(result =>{
                localStorage.accessToken=result.data.accessToken
                window.location = "./home.html"
            })
            .catch(error=>{
                console.log(error)
            })
    }

    _isLogged(){
        LoginService.hasAValidToken()
            .then(result=>{
                window.location='./home.html'
            })
            .catch(error=>{
                console.log(error)
            })
    }
}

const loginForm = new LoginForm()
loginForm.configure()
