import React from 'react'

import { Card, CardImg, CardText, CardBody, CardLink,CardTitle, CardSubtitle } from 'reactstrap';

export default class Post extends React.Component{
    render(){
        return (
        <div>
            <Card>
                <CardBody>
                    <CardTitle>{this.props.post.title}</CardTitle>
                </CardBody>
                <img width="100%" src={this.props.post.img} alt="Card image cap" />
                <CardBody>
                    <CardText>{this.props.post.text}</CardText>
                </CardBody>
            </Card>
          </div>
        )
    }
}