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
            img:'',
            text:'',
            redirectMyPost:false
        }
        this.onSubmit=this.onSubmit.bind(this)
        this.handleChange=this.handleChange.bind(this)
    }

    onSubmit(){
        PostService.createPost(this.state.title,this.state.description,this.state.img,this.state.text,localStorage.accessToken)
            .then((result)=>{
                console.log(result)
                this.goMyPosts()
            })
            .catch((error)=>{
                console.log(error)
            })
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
                    {this.state.redirectMyPost?<Redirect to="/posts"/>:undefined}
                    <div className="createpost-form">
                        <Label for="title">Title</Label>
                        <Input type="text" id="title" placeholder="title here" name="title" onChange={this.handleChange}/>

                        <Label for="description">Description</Label>
                        <Input type="text" id="description" placeholder="description here" name="description" onChange={this.handleChange}/>

                        <Label for="img">Image</Label>
                        <Input type="text" id="img" placeholder="img url here" name="img" onChange={this.handleChange}/>

                        <Label for="text">Text</Label>
                        <Input type="textarea" id="text" placeholder="your text need to be over here bro!" onChange={this.handleChange} name="text"/>

                        <Button color="primary" onClick={this.onSubmit}>Create a new post!</Button>
                    </div>
                </div>
            </div>
        )
    }
}