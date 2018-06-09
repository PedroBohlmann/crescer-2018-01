import CONFIG from "../config";

import axios from "axios";

export default class ClasseDeVooService{
    static cadastrar(classeDeVoo,token){
        var data = {
            descricao: classeDeVoo.descricao,
            valorMilha: classeDeVoo.valorMilha,
            valorFixo: classeDeVoo.valorFixo
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.post(`${CONFIG.API_URL_BASE}/ClasseDeVoo`,data,config)
    }
    static listar(token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/ClasseDeVoo`,config)
    }

    static deletar(token, id){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.delete(`${CONFIG.API_URL_BASE}/ClasseDeVoo/${id}`,config)
    }

    static atualizar(id,classeDeVoo,token){
        var data = {
            descricao: classeDeVoo.descricao,
            valorMilha: classeDeVoo.valorMilha,
            valorFixo: classeDeVoo.valorFixo
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.put(`${CONFIG.API_URL_BASE}/ClasseDeVoo/${id}`,data,config)
    }

    static obter(token, id){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/ClasseDeVoo/${id}`,config)
    }
    
}