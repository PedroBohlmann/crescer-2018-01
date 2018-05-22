import React from 'react'

import CustomNavbar from '../../CustomNavbar/CustomNavbar'
import PostList from '../PostList/PostList'
import { Switch, Route, Redirect} from 'react-router-dom'

export default class Home extends React.Component{
    render(){
        return <div>
            <CustomNavbar/>
            <PostList/>
        </div>
    }
}