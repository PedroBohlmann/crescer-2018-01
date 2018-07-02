import CONFIG from "../config";

import axios from "axios";

export default class PostService{
    static createPost(data,token){
        return axios.post(`${CONFIG.API_URL_BASE}/post`,data,{headers:{
            'Content-Type': 'application/json',
            authorization: token
        }})
    }
}