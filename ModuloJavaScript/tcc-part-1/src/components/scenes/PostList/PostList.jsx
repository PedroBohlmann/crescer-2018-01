import React from 'react'

import PostService from '../../../service/PostService'

import Post from '../../Post/Post'

import './PostList.css'

export default class PostList extends React.Component{

    constructor(){
        super()
        this.state={
            posts:[],
        }
        this.onDelete=this.onDelete.bind(this)
    }

    componentDidMount(){
        this.loadPostsFromAPI()
    }

    loadPosts(){
        return this.state.posts.map((post,index)=>{
            return <Post post={post} key={index} onDelete={this.onDelete}/>
        })
    }

    onDelete(e){
        const id = e.target.id
        PostService.deletePost(id,localStorage.accessToken)
            .then((result)=>{
                this.loadPostsFromAPI()
            }).catch((error)=>{
                console.log(error)
            })
    }

    loadPostsFromAPI(){
        PostService.getPosts(localStorage.accessToken,localStorage.userName)
            .then((result)=>{
                this.setState({
                    posts: result.data.posts
                })
            }).catch((error)=>{
                console.log(error)
            })
    }

    render(){
        return (
            <div className="posts-container">
                {this.loadPosts()}
            </div>
        )
    }
}