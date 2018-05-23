import React from 'react'

import PostService from '../../../service/PostService'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import Markdown from 'react-markdown'

import "./PostDetail.css"

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
        PostService.getPostById(localStorage.accessToken,this.props.match.params.id,localStorage.userName)
            .then((result)=>{
                this.setState({
                    image:result.data.image,
                    title:result.data.title,
                    text:result.data.text
                })
            }).then((error)=>{
                console.log(error)
            })
    }
    
    render(){
        return(
        <div><CustomNavbar/>
            <div className="page-post-container">
                <div className="post-container">
                    <div className="post-title">{this.state.title}</div>
                    <img className="post-image" src={this.state.image} alt=""/>
                    <div className="post-text"><Markdown source={this.state.text}/></div>
                </div>
            </div>
        </div>
        )   
    }
}