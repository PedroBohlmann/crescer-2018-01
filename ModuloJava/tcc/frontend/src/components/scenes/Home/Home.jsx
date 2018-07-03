import React from 'react';

import UsuarioService from "../../../service/UsuarioService";
import PostService from "../../../service/PostService"

import Post from "../../Post/Post";

import { Input, Label, Button } from "reactstrap";

import { Redirect } from "react-router-dom";

import "./Home.css"

export default class Home extends React.Component{

    constructor(){
        super()
        this.state ={
            id: 0,
            name: "",
            email: "",
            nickname: "",
            dateOfBirth: "",
            imageUrl: "",
            isPublic:false,
            posts:[],
            text:"",
            toLogin:false
        }
        this.loadLoggedUserDataFromApi = this.loadLoggedUserDataFromApi.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.toggleIsPublic = this.toggleIsPublic.bind(this)
        this.onCreatePost = this.onCreatePost.bind(this)
        this.onLogout = this.onLogout.bind(this)
    }

    loadLoggedUserDataFromApi(){
        UsuarioService.getLoggedUserData(localStorage.token)
            .then((result)=>{
                this.setState({
                    id:result.data.id,
                    name: result.data.nome,
                    email:result.data.email,
                    nickname: result.data.apelido,
                    dateOfBirth: result.data.dataDeNascimento,
                    imageUrl:result.data.imagemUrl
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    onCreatePost(){
        let visibility = this.state.isPublic? "PUBLICO":"PRIVADO"
        let data = {
            texto:this.state.text,
            visibilidade:visibility
        }

        PostService.createPost(data,localStorage.token)
            .then((result)=>{
                this.loadTimeForTheLoggedUser()
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    loadTimeForTheLoggedUser(){
        UsuarioService.getTimeline(localStorage.token)
            .then((result)=>{
                this.setState({
                    posts:result.data.content
                })
            })
            .catch((error)=>{
                console.log(error)
            })
    }

    renderPosts() {
        return this.state.posts.map((post, index) => {
            return <Post userCreator={post.nomeCriador} text={post.texto}/>
        })
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        this.setState({
          [name]: value
        });
    }

    toggleIsPublic(event) {
        let visibility = this.state.isPublic
        visibility = !visibility
        this.setState({
            isPublic:visibility
        })
    }

    componentDidMount(){
        this.loadLoggedUserDataFromApi()
        this.loadTimeForTheLoggedUser()
    }

    onLogout(){
        localStorage.token = ""
        this.setState({
            toLogin:true
        })
    }

    render(){
        return(
            <div className="home-container">
                {this.state.toLogin ? (<Redirect to="/"/>): (undefined)}
                <div className="home-container-user-data">
                    <div className="home-container-user-data-line"><img  className="user-image" src={this.state.imageUrl} alt=""/></div>
                    <div className="home-container-user-data-line">Name :{this.state.name}</div>
                    <div className="home-container-user-data-line">Email :{this.state.email}</div>
                    <div className="home-container-user-data-line">Nickname :{this.state.nickname}</div>
                    <div className="home-container-user-data-line">Date of Birth :{this.state.dateOfBirth}</div>
                    <div className="home-container-user-data-line"><img  className="user-image" src="https://cdn.discordapp.com/attachments/361913998851178507/463174007521411083/logo_do_petter.png"/></div>
                    <Button color="danger" onClick={this.onLogout}>
                        Logout
                    </Button>
                </div>
                <div className="home-posts-container">
                    <div className="home-new-post-container">
                    <Label for="text">Post text</Label>
                        <Input
                            type="textarea"
                            id="text"
                            placeholder="Post text here"
                            onChange={this.handleChange}
                            name="text"
                        />
                    <Label for="isPublic">Is this post public?</Label>
                        <Input
                            type="checkbox"
                            id="isPublic"
                            onChange={this.toggleIsPublic}
                            name="isPublic"
                        />
                        <Button color="success" onClick={this.onCreatePost}>
                                Create
                        </Button>
                    </div>
                    <div className="home-posts-list">
                        {this.renderPosts()}
                    </div>
                </div>
                <div className="home-friends-container">
                    amigos in column
                </div>
            </div>
        )
    }
}