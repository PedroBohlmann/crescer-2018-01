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

    static newPost(token,title,text){
        const data={title,text}
        const config={
            headers:{
                'Content-Type': 'application/json',
                'Authorization': token
            }
        }
        return axios.post(
            `${CONFIG.API_URL_BASE}/createPost`,data,config)        

    }

    static loadAllPosts(token){
        const config={
            headers:{
                'Content-Type': 'application/json',
                'Authorization': token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/myPosts`,config)
    }
}

export default ApiService