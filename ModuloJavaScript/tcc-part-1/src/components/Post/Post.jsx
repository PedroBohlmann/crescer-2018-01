import React from 'react'

import { Card, CardText, CardBody, CardTitle } from 'reactstrap';

export default class Post extends React.Component{
    render(){
        return (
        <div>
            <Card>
                <CardBody>
                    <CardTitle>{this.props.post.title}</CardTitle>
                </CardBody>
                <img width="200px" height="200px" src={this.props.post.img} alt="Card image cap" />
                <CardBody>
                    <CardText>{this.props.post.text}</CardText>
                </CardBody>
            </Card>
          </div>
        )
    }
}