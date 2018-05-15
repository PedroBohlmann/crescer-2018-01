import RegisterError from '../errors/register-error'
import ApiService from './api-service'

class RegisterService {
    static register(email, name, password) {
        return ApiService.createAccount(email,name,password)
    }
}

export default RegisterService
