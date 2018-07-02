import React from 'react'

import "./Post.css"

export default class Post extends React.Component{

    render(){
        return (
            <div className="post-container">
                <div className="post-container-line">Criador por :{this.props.userCreator}</div>
                <div className="post-container-line">{this.props.text}</div>
            </div>
        )
    }
}