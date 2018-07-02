import CONFIG from "../config";

import axios from "axios";

import jwt_decode from 'jwt-decode';

export default class UserService{
    static getLoggedUserData(token){
        let decoded;

        if(token!==null||token!==""){
            decoded = jwt_decode(localStorage.token);
        }

        let headers={
            'Content-Type': 'application/json',
            'Authorization': token 
        }

        return axios.get(`${CONFIG.API_URL_BASE}/public/usuario/${decoded["id"]}`,
        {
            headers:{
                'Content-Type': 'application/json',
                authorization: token
            }
        }
        )
    }

    static getTimeline(token){
        let decoded;

        if(token!==null||token!==""){
            decoded = jwt_decode(localStorage.token);
        }

        let headers={
            'Content-Type': 'application/json',
            'Authorization': token 
        }

        return axios.get(`${CONFIG.API_URL_BASE}/post/timeline/${decoded["id"]}`,
        {
            headers:{
                'Content-Type': 'application/json',
                authorization: token
            }
        }
        )
    }
}