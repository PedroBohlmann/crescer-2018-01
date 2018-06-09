import React from "react"

import CustomNavbar from '../../CustomNavbar/CustomNavbar'

export default class Home extends React.Component{
    render(){
        return (
            <div>
                <CustomNavbar/>
                <div>reservas</div>
            </div>
        )
    }
}