import { Link } from 'react-router-dom'
import './styles.css'

export function Header() {
  return (
    <header>
      <div className="vehicle-logo-container">
        <h1>Tinnova Test - Veículos</h1>
        <nav>
          <ul>
            <Link to="/">
              <li>Lista todos veículos</li>
            </Link>
            <Link to="/vehicle-by-brand">
              <li>Lista veículos por Fabricante</li>
            </Link>
            <Link to="/weekly-register">
              <li>Lista veículos registrados na última semana</li>
            </Link>
          </ul>
        </nav>
      </div>
    </header>
  )
}