import $ from 'jquery'
import jqueryValidation from 'jquery-validation'
import LoginService from '../services/login-service'

class FormLogin{

    configure(){
        //frmLogin
        // const form=document.getElementById('frmLogin')
        const $frmLogin =$('#frmLogin')

        $frmLogin.validate({
            rules:{
                txtEmail:{
                    required: true,
                    email:true
                },
                txtPassword:{
                    required: true,
                }
            },
            submitHandler: formSubmitted =>{
                this._authenticate()
            }
        })
    }
    _authenticate(){
        LoginService.authenticate(
            txtEmail.value,
            txtPassword.value,
            loggedUser =>{
                alert('User logged')
            },
            error =>{
                alert(error.message)
            }
        )
    }
}

export default FormLogin