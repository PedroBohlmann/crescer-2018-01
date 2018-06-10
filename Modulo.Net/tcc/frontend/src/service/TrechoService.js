import CONFIG from "../config";

import axios from "axios";

export default class TrechoService{
    static listar(token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/Trecho/lista`,config)
    }
}