import CONFIG from '../config'
import axios from 'axios'

export default class LoginServices{
    static login(email,password){
        return axios.post(`${CONFIG.API_URL_BASE}/login`,{
            email,
            password
        })
    }

    static logout(token){
        return axios.post(`${CONFIG.API_URL_BASE}/logout`,{},
        {
        headers:{
            'Content-Type': 'application/json',
            authorization: token
        }})
    }
}