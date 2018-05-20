import React from 'react'

import './Loading.css'

export default class Loading extends React.Component{
    render(){
        return <div>
        {this.props.showLoading?<div className="loader"></div>:undefined}
        </div>
    }
}