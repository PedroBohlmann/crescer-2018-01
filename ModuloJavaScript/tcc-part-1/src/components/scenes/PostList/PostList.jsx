import React from 'react'

import PostService from '../../../service/PostService'

import Post from '../../Post/Post'

export default class PostList extends React.Component{

    constructor(){
        super()
        this.state={
            posts:[]
        }
    }

    componentDidMount(){
        this.loadPostsFromAPI()
    }

    loadPosts(){
        return this.state.posts.map((post,index)=>{
            return <Post post={post} key={index}/>
        })
    }


    loadPostsFromAPI(){
        PostService.getPosts(localStorage.accessToken,localStorage.userEmail)
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
            <div>
                {this.loadPosts()}
            </div>
        )
    }
}