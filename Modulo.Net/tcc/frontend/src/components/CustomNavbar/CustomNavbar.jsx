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
            <NavbarBrand href="/">Aerolito AirLines</NavbarBrand>
            <NavbarToggler />
            <Nav className="ml-auto" navbar>
            <NavItem>
                    <Link className="nav-link" to='/home'>Home</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/'>Reserva - Não funciona</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/'>Opcional</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/localEditor'>Local</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/classeDeVooEditor'>Classe de Voo</Link>
            </NavItem>
            <NavItem>
                    <Link className="nav-link" to='/logout'>Logout</Link>
            </NavItem>
        </Nav>
      </Navbar>
        )
    }
}