import $ from 'jquery'
import _ from 'jquery-validation'

import RegisterService from './services/register-service'
import RegisterError from './errors/register-error'
import LoginService from './services/login-service';


class RegisterForm {
    configure() {
        // const self = this
        const submitHandler = form => {
            this._createAccount()
        }

        $('#frmRegister').validate({
            rules: {
                txtEmail: {
                    required: true,
                    email: true
                },
                txtName: {
                    required: true
                },
                txtPassword: {
                    required: true
                },
                txtConfirmPassword: {
                    equalTo: '#txtPassword'
                }
            },
            submitHandler: submitHandler.bind(this)
        })
    }

    _createAccount() {
        const email = txtEmail.value
        const name = txtName.value
        const password = txtPassword.value

        RegisterService.register(email, name, password)
            .then(result => {
                return result
            })
            .then(result=>{
                console.log(result)
            })
            .catch(error => {
                console.log(error.message)
            })
    }
}

const registerForm = new RegisterForm()
registerForm.configure()
