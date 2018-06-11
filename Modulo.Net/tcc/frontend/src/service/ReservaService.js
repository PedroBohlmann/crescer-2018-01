import CONFIG from "../config";

import axios from "axios";

export default class ReservaService{
    static cadastrar(reserva,token){
        var data = {
            idClasseDeVoo: reserva.idClasseDeVoo,
            idUsuario: reserva.idUsuario,
            idTrecho: reserva.idTrecho,
            idOpcionais: reserva.idOpcionais
        }

        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }

        return axios.post(`${CONFIG.API_URL_BASE}/Reserva`,data,config)
    }
    static listar(id,token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }

        return axios.get(`${CONFIG.API_URL_BASE}/Reserva/lista/${id}`,config)
    }

    static deletar(id,token){
        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }

        return axios.delete(`${CONFIG.API_URL_BASE}/Reserva/${id}`,config)
    }

    static valor(reserva,token){
        var data = {
            idClasseDeVoo: reserva.idClasseDeVoo,
            idUsuario: reserva.idUsuario,
            idTrecho: reserva.idTrecho,
            idOpcionais: reserva.idOpcionais
        }

        var config={
            headers:{
                'Content-Type': 'application/json',
                authorization: "Bearer "+token
            }
        }

        return axios.post(`${CONFIG.API_URL_BASE}/Reserva/valor`,data,config)
    }
}