import React from 'react'

import { Alert } from 'reactstrap';

export default class Error extends React.Component{
    render(){
        return <Alert color="danger">{this.props.text}</Alert>
    }
}