import CONFIG from "../config";

import axios from "axios";

export default class LocalService{
    static cadastrar(local,token){
        var data = {
            cidade:local.cidade,
            aeroporto:local.aeroporto,
            latitude:local.latitude,
            longitude:local.longitude
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.post(`${CONFIG.API_URL_BASE}/Local`,data,config)
    }
    static listar(token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/Local/lista`,config)
    }
}