import LoginError from '../errors/login-error'
import ApiService from './api-service'

class LoginService{
    static login(email,password){
        return ApiService.loginAccount(email,password)
    }
}

export default LoginService