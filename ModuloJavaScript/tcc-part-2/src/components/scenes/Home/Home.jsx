import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'
import PostList from '../PostList/PostList'
import { Switch, Route, Redirect} from 'react-router-dom'

export default class Home extends React.Component{

    constructor(){
        super()
        this.state={
            username:localStorage.userName
        }
    }


    componentDidMount(){
        const usernameByURL= this.props.match.params.username
        if(usernameByURL!==undefined&& usernameByURL!=this.state.username){
            this.setState({
                username:usernameByURL
            })
        }
    }

    render(){
        return <div>
            <CustomNavbar/>
            <PostList username={this.state.username}/>
        </div>
    }
}