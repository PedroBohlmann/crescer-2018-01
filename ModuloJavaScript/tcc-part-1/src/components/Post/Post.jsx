import React from 'react'

import { Card, CardText, CardBody, CardTitle, Button } from 'reactstrap';

import {Link} from 'react-router-dom'

export default class Post extends React.Component{
    render(){
        return (
        <div>
            <Card>
                <CardBody>
                    <CardTitle>{this.props.post.title}</CardTitle>
                </CardBody>
                <img width="200px" height="200px" src={this.props.post.image} alt="Card image cap" />
                <CardBody>
                    <CardText>{this.props.post.description}</CardText>
                    <Button color="danger" id={this.props.post.id} onClick={this.props.onDelete}>Deletar</Button>
                    <Link className="nav-link" to={"/post/"+this.props.post.id}>Details</Link> 
                    <Link className="nav-link" to={"/edit-post/"+this.props.post.id}>Edit</Link>                   
                </CardBody>
            </Card>
          </div>
        )
    }
}