import React from 'react'

import { Input, Label, Button } from 'reactstrap';

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

import PostService from '../../../service/PostService'

import { Redirect } from 'react-router-dom'

import './CreatePost.css'

export default class CreatePost extends React.Component{

    constructor(){
        super()
        this.state = {
            title:'',
            description:'',
            image:'',
            text:'',
            redirectMyPost:false,
            editPost:false
        }
        this.onSubmit=this.onSubmit.bind(this)
        this.handleChange=this.handleChange.bind(this)
    }

    componentDidMount(){
        if(this.props.match.params.id!==undefined){
            this.loadPostFromAPI()
            this.setState({
                editPost:true
            })
        }
    }

    loadPostFromAPI(){
        PostService.getPostById(localStorage.accessToken,this.props.match.params.id,localStorage.userName)
            .then((result)=>{
                this.setState({
                    image:result.data.image,
                    title:result.data.title,
                    text:result.data.text,
                    description:result.data.description
                })
            }).then((error)=>{
                console.log(error)
            })
    }

    onSubmit(){
        if(this.state.editPost==false){
            PostService.createPost(this.state.title,this.state.description,this.state.image,this.state.text,localStorage.accessToken)
                .then((result)=>{
                    console.log(result)
                    this.goMyPosts()
                })
                .catch((error)=>{
                    console.log(error)
                })
        }else{
            PostService.editPost(this.props.match.params.id,this.state.title,this.state.description,this.state.image,this.state.text,localStorage.accessToken)
            .then((result)=>{
                console.log(result)
                this.goMyPosts()
            }).catch((error)=>{
                console.log(error)
            })
        }
    }

    goMyPosts(){
        this.setState({
            redirectMyPost: true
        })
    }    
    
    handleChange(event){
        const target = event.target
        const value = target.value
        const name = target.name
        this.setState({
            [name]: value
        })
    }
    
    render(){
        return (
            <div>
                <CustomNavbar/>
                <div className="form-container">
                    {this.state.redirectMyPost?<Redirect to="/home"/>:undefined}
                    <div className="createpost-form">
                        <Label for="title">Title</Label>
                        <Input type="text" id="title" value={this.state.title} placeholder="title here" name="title" onChange={this.handleChange}/>

                        <Label for="description">Description</Label>
                        <Input type="text" id="description" value={this.state.description} placeholder="description here" name="description" onChange={this.handleChange}/>

                        <Label for="img">Image</Label>
                        <Input type="text" id="image" value={this.state.image} placeholder="img url here" name="image" onChange={this.handleChange}/>

                        <Label for="text">Text</Label>
                        <Input type="textarea" id="text" value={this.state.text} placeholder="your text need to be over here bro!" onChange={this.handleChange} name="text"/>

                        <Button color="primary" onClick={this.onSubmit}>{this.state.editPost?'Edit Post':'Create a new'} post!</Button>
                    </div>
                </div>
            </div>
        )
    }
}