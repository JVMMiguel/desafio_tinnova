import { Link } from 'react-router-dom'
import './styles.css'

export function Header() {
  return (
    <header>
      <div className="vehicle-header-container">
        <h1>Tinnova Test - Listagem de Veículos</h1>
        <nav>
          <ul>
            <Link to="/register-vehicle">
              <li>Registrar veículo</li>
            </Link>
            <Link to="/">
              <li>Todos veículos</li>
            </Link>
            <Link to="/vehicle-by-brand">
              <li>Por Fabricante</li>
            </Link>
            <Link to="/weekly-register">
              <li>Registrados na última semana</li>
            </Link>
            <Link to="/not-sold">
              <li>Não vendidos</li>
            </Link>
          </ul>
        </nav>
      </div>
    </header>
  )
}