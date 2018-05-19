import CONFIG from '../config'
import axios from 'axios'

export default class LoginServices{
    static login(email,password){
        return axios.post(`${CONFIG.API_URL_BASE}/login`,{
            email,
            password
        })
    }
}