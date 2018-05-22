import React from 'react'

import CONFIG from '../config'
import axios from 'axios'

export default class LoginService extends React.Component{
    static login(email,password){
        return axios.post(`${CONFIG.API_URL_BASE}/blogger`,{
            email,
            password
        })
    }
}