import React from 'react'

import { InputGroup, InputGroupAddon, InputGroupText, Input, Label, Button } from 'reactstrap';

import './CreatePost.css'

export default class CreatePost extends React.Component{

    render(){
        return (
            <div className="form-container">
                <div className="createpost-form">
                <Label for="title">Title</Label>
                <Input type="text" id="title" placeholder="title here" name="title"/>

                <Label for="img">Image</Label>
                <Input type="text" id="img" placeholder="img url here" name="img"/>

                <Label for="text">Text</Label>
                <Input type="textarea" id="text" placeholder="your text need to be over here bro!"/>

                <Button color="primary">Create a new post!</Button>

                </div>
            </div>
        )
    }
}