import CONFIG from '../config'
import axios from 'axios'

export default class MovieService{
    static getMovies(token){
        return axios.get(`${CONFIG.API_URL_BASE}/movies`,{
            headers:{
                'Content-Type': 'application/json',
                authorization: token
            }
        })
    }

    static getCategories(){
        return axios.get(`${CONFIG.API_URL_BASE}/categories`,{})
    }

    static createMovie(title,description,category,image,token){
        return axios.post(`${CONFIG.API_URL_BASE}/createMovieNew`,{
            title,
            description,
            category,
            image
        },
        {
        headers:{
            'Content-Type': 'application/json',
            authorization: token
        }})
    }

    static deleteMovie(id,token){
        return axios.post(`${CONFIG.API_URL_BASE}/deleteMovie`,{
            id
        },
        {
        headers:{
            'Content-Type': 'application/json',
            authorization: token
        }})
    }
}