import React from 'react'

import { Link } from 'react-router-dom'

import {
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
  } from 'reactstrap';

export default class CustomNavbar extends React.Component{
    


    render(){
        return (
        <Navbar color="light" light expand="md">
            <NavbarBrand href="/">Bloggers</NavbarBrand>
            <NavbarToggler />
            <Nav className="ml-auto" navbar>
            <NavItem>
                    <Link className="nav-link" to='/home'>Home</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/create-new-post'>New Post</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/logout'>Logout</Link>
            </NavItem>
        </Nav>
      </Navbar>
        )
    }
}