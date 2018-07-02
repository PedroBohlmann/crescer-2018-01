import CONFIG from "../config";

import axios from "axios";

export default class LoginService{

    static login(email,password){
        var data = {
            email:email,
            senha:password,
        }
        return axios.post(`${CONFIG.API_URL_BASE}/public/usuario/login`,data)
    }

    static register(data){
        return axios.post(`${CONFIG.API_URL_BASE}/public/usuario`,data)
    }
}