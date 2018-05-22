import CONFIG from '../config'
import axios from 'axios'

export default class PostService{
    static createPost(title,description,image,text,token){
        return axios.post(`${CONFIG.API_URL_BASE}/post`,
        {
            title,
            description,
            image,
            text
        },
        {
        headers:{
            'Content-Type': 'application/json',
            authorization: token
        }
        }
        )
    }

    static getPosts(token,userEmail){
        return axios.get(`${CONFIG.API_URL_BASE}/posts/${userEmail}`,
        {
        headers:{
            'Content-Type': 'application/json',
            authorization: token
        }
        }
        )
    }

    static deletePost(id,token){
        return axios.delete(`${CONFIG.API_URL_BASE}/post/${id}`,{
            headers:{
                'Content-Type': 'application/json',
                authorization: token  
            }
        })
    }
}