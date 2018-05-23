import React from 'react'

import PostService from '../../../service/PostService'

import Post from '../../Post/Post'


import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

import './PostList.css'

export default class PostList extends React.Component{

    constructor(){
        super()
        this.state={
            posts:[],
            modal:false,
            idPostToBeDeleted:''
        }
        this.onDelete=this.onDelete.bind(this)
        this.toggle = this.toggle.bind(this)
    }

    componentDidMount(){
        this.loadPostsFromAPI()
    }

    loadPosts(){
        return this.state.posts.map((post,index)=>{
            return <Post post={post} key={index} onDelete={this.toggle}/>
        })
    }

    onDelete(e){
        const id = e.target.id
        PostService.deletePost(this.state.idPostToBeDeleted,localStorage.accessToken)
            .then((result)=>{
                this.loadPostsFromAPI()
            }).catch((error)=>{
                console.log(error)
            })
        this.setState({
            modal:false
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

    toggle(e) {
        this.setState({
          modal: !this.state.modal,
          idPostToBeDeleted:e.target.id
        });
    }

    render(){
        return (
            <div className="posts-container">
                {this.loadPosts()}
                <div>
                    <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}>
                    <ModalHeader toggle={this.toggle}>Are you sure???</ModalHeader>
                    <ModalBody>
                        Are you sure about deleting this post?
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={this.onDelete}>Delete</Button>{' '}
                        <Button color="secondary" onClick={this.toggle}>Cancel</Button>
                    </ModalFooter>
                    </Modal>
                </div>
            </div>
        )
    }
}