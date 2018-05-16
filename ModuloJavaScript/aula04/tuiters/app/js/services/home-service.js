import NewPostError from '../errors/login-error'
import ApiService from './api-service'
import LoginService from './login-service'

class HomeService{

    static loadAllPosts(){
        return ApiService.loadAllPosts(LoginService.loggedUser())
    }

    static createPost(title,text){
        return ApiService.newPost(LoginService.loggedUser(),title,text)
    }
}

export default HomeService