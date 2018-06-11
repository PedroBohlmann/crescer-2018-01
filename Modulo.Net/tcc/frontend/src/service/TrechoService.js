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

    static cadastrar(trecho,token){
        var data={
            idOrigem:trecho.origem,
            idDestino:trecho.destino
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.post(`${CONFIG.API_URL_BASE}/Trecho`,data,config)
    }

    static deletar(id,token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.delete(`${CONFIG.API_URL_BASE}/Trecho/${id}`,config)
    }

    static atualizar(id,trecho,token){
        var data={
            idOrigem:trecho.origem,
            idDestino:trecho.destino
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.put(`${CONFIG.API_URL_BASE}/Trecho/${id}`,data,config)
    }

    static obter(id,token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/Trecho/${id}`,config)
    }

    static obterDistancia(trecho,token){
        var data={
            idOrigem:trecho.origem,
            idDestino:trecho.destino
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.post(`${CONFIG.API_URL_BASE}/Trecho/distancia`,data,config)
    }
}