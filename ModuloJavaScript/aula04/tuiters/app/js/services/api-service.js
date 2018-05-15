import CONFIG from '../config'
import axios from 'axios'

class ApiService{
    static createAccount(email,name,password){
        return axios.post(
        `${CONFIG.API_URL_BASE}/createAccount`,
        {
            email: email,
            name:name,
            password: password // em todos os casos poderia ser somente: email
        })
    }

    static loginAccount(email,password){
        return axios.post(
        `${CONFIG.API_URL_BASE}/login`,
        {
            email,
            password
        })
    }
}

export default ApiService