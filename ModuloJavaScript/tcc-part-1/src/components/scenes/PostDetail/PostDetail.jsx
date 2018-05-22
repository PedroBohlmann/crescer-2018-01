import React from 'react'

import PostService from '../../../service/PostService'

export default class PostDetail extends React.Component{
    
    constructor(){
        super()
        this.state = {
            image:'',
            text:'',
            title:''
        }
    }

    componentDidMount(){
        this.loadPostFromAPI()
    }

    loadPostFromAPI(){
        PostService.getPostById(localStorage.accessToken,localStorage.userName,this.props.match.params.id)
            .then((result)=>{
                console.log(result)
            }).then((error)=>{
                console.log(error)
            })
    }
    
    render(){
        return(
        <div>
            post details
        </div>
        )   
    }
}