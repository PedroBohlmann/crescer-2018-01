import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'
import {Input, Label, Button } from 'reactstrap';

import { Redirect } from 'react-router-dom'

import PostService from '../../../service/PostService'

export default class EditPost extends React.Component{
    
    constructor(){
        super()
        this.state = {
            id:'',
            image:'',
            text:'',
            title:'',
            description:'',
            redirectMyPost:false
        }
        this.handleChange=this.handleChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
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
                    text:result.data.text,
                    description:result.data.description,
                    id: result.data.id
                })
            }).then((error)=>{
                console.log(error)
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
    
    onSubmit(e){
        PostService.editPost(this.props.match.params.id,this.state.title,this.state.description,this.state.img,this.state.text,localStorage.accessToken)
            .then((result)=>{
                console.log(result)
            }).catch((error)=>{
                console.log(error)
            })
    }

    render(){
        return <div>
        <CustomNavbar/>
        <div className="form-container">
            {this.state.redirectMyPost?<Redirect to="/home"/>:undefined}
            <div className="createpost-form">
                <Label for="title">Title</Label>
                <Input type="text" id="title" value={this.state.title} placeholder="title here" name="title" onChange={this.handleChange}/>

                <Label for="description">Description</Label>
                <Input type="text" id="description"value={this.state.description} placeholder="description here" name="description" onChange={this.handleChange}/>

                <Label for="img">Image</Label>
                <Input type="text" id="img" value={this.state.image} placeholder="img url here" name="img" onChange={this.handleChange}/>

                <Label for="text">Text</Label>
                <Input type="textarea" id="text" value={this.state.text} placeholder="your text need to be over here bro!" onChange={this.handleChange} name="text"/>

                <Button color="primary" onClick={this.onSubmit}>Edit post</Button>
            </div>
        </div>
    </div>
    }
}