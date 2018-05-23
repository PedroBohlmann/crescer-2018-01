import React from 'react'

import { Card, CardText, CardBody, CardTitle, Button } from 'reactstrap';

import {Link} from 'react-router-dom'

import './Post.css'

export default class Post extends React.Component{
    render(){
        return (
        <div>
            <Card>
                <CardBody>
                    <CardTitle>{this.props.post.title}</CardTitle>
                </CardBody>
                <img className="post-sub-image" src={this.props.post.image} alt="Card image cap" />
                <CardBody>
                    <CardText>{this.props.post.description}</CardText>
                    <Link className="post-link" to={"/post/"+this.props.username+"/"+this.props.post.id}>Read more here!</Link> 
                    {this.props.username===localStorage.userName?<div>
                        <Link className="post-link" to={"/post-editor/"+this.props.post.id}>Edit</Link>
                        <Button color="danger" id={this.props.post.id} onClick={this.props.onDelete}>Deletar</Button>
                    </div>:undefined}        
                </CardBody>
            </Card>
          </div>
        )
    }
}