import React from 'react'

import { Switch, Route, Redirect, Link } from 'react-router-dom'

import {
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
  } from 'reactstrap';

export default class CustomNavbar extends React.Component{
    
    render(){
        return (
        <Navbar color="light" light expand="md">
            <NavbarBrand href="/">Bloggers</NavbarBrand>
            <NavbarToggler />
            <Nav className="ml-auto" navbar>
            <NavItem>
                <NavLink>
                    <Link className="" to='/'>Home</Link>
                </NavLink>
            </NavItem>
            <NavItem>
                <NavLink>
                    <Link className="" to='/posts'>My Posts</Link>
                </NavLink>
            </NavItem>
            <NavItem>
                <NavLink>
                    <Link className="" to='/create-new-post'>New Post</Link>
                </NavLink>
            </NavItem>
        </Nav>
      </Navbar>
        )
    }
}