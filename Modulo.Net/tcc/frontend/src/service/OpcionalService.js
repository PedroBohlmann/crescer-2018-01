import CONFIG from "../config";

import axios from "axios";

export default class OpcionalService{
    static cadastrar(opcional,token){
        var data = {
            nome:opcional.nome,
            descricao:opcional.descricao,
            valorPorcentagem:opcional.valorPorcentagem
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.post(`${CONFIG.API_URL_BASE}/Opcional`,data,config)
    }

    static listar(token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/Opcional/lista`,config)
    }

    static deletar(token, id){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.delete(`${CONFIG.API_URL_BASE}/Opcional/${id}`,config)
    }
    static obter(token, id){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.get(`${CONFIG.API_URL_BASE}/Opcional/${id}`,config)
    }

    static atualizar(id,opcional,token){
        var data = {
            nome: opcional.nome,
            descricao: opcional.descricao,
            valorPorcentagem: opcional.valorPorcentagem
        }
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }
        return axios.put(`${CONFIG.API_URL_BASE}/Opcional/${id}`,data,config)
    }
}