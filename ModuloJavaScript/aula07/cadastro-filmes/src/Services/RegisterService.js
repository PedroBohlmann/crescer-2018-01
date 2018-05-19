import CONFIG from '../config'
import axios from 'axios'

export default class RegisterService{
    static register(email,name,password){
        return axios.post(`${CONFIG.API_URL_BASE}/createAccount`, {
            email, 
            name, 
            password
        })
    }
}