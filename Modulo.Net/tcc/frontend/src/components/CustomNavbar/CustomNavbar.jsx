import React from 'react'

import { Link } from 'react-router-dom'

import {
	Navbar,
	NavbarToggler,
	NavbarBrand,
	Nav,
	NavItem,
} from 'reactstrap';

import UsuarioService from '../../service/UsuarioService'

import './CustomNavbar.css'

export default class CustomNavbar extends React.Component {

	validarAdmin() {
		return UsuarioService.getTokenInfo()["http://schemas.microsoft.com/ws/2008/06/identity/claims/role"] == "Admin"
	}

	render() {
		return (
			<Navbar color="light" light expand="md">
				<NavbarBrand href="/">Aerolito AirLines</NavbarBrand>
				<NavbarToggler />
				<Nav className="ml-auto" navbar>
					<NavItem>
						<Link className="nav-link" to='/home'>Home</Link>
					</NavItem>
					{this.validarAdmin() ? (
						<div className="inline-itens">
							<NavItem>
								<Link className="nav-link" to='/opcionalEditor'>Opcional</Link>
							</NavItem>
							<NavItem>
								<Link className="nav-link" to='/localEditor'>Local</Link>
							</NavItem>
							<NavItem>
								<Link className="nav-link" to='/classeDeVooEditor'>Classe de Voo</Link>
							</NavItem>
							<NavItem>
								<Link className="nav-link" to='/trechoEditor'>Trecho</Link>
							</NavItem>
						</div>
					) : undefined}
					<NavItem>
						<Link className="nav-link" to='/logout'>Logout</Link>
					</NavItem>
				</Nav>
			</Navbar>
		)
	}
}