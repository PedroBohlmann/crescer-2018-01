import CONFIG from '../config'
import axios from 'axios'

export default class LoginService{
    static login(email,password){
        return axios.post(`${CONFIG.API_URL_BASE}/blogger`,{
            email,
            password
        })
    }
    static logout(token){
        return axios.post(`${CONFIG.API_URL_BASE}/bloggerLogout`,{},{
            headers:{
                'Content-Type': 'application/json',
                authorization: token
            }
        })
    }
}