import React from 'react'

import Post from '../../Post/Post'

export default class PostList extends React.Component{

    getPosts(){
        return {title:'titulo',img:'/Users/pedrobohlmann/Public/foto-show.jpeg',text:'alou alou'}
    }

    render(){
        return <Post post={this.getPosts()}/>
    }
}