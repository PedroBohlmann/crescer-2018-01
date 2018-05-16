import LoginError from '../errors/login-error'
import ApiService from './api-service'
import HomeService from './home-service'

class LoginService{
    static login(email,password){
        return ApiService.loginAccount(email,password)
    }

    static loggedUser(){
        return localStorage.accessToken
    }

    static hasAValidToken(){
        return HomeService.loadAllPosts()
    }
}

export default LoginService