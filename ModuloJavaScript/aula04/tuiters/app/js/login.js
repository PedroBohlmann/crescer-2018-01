import $ from 'jquery'
import _ from 'jquery-validation'

import LoginService from './services/login-service'
import ApiService from './services/api-service';


class LoginForm {
    configure() {
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
                window.location = "http://localhost:3000/html/home.html"
            })
            .catch(error=>{
                console.log(error)
            })
    }
}

const loginForm = new LoginForm()
loginForm.configure()
