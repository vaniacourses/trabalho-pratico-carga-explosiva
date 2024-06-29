import '../css/navbar.css'
import {Link, useLocation} from "react-router-dom";
import { faTruck, faUser,  faHouse, faUsersGear, faHammer} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {
    pageFuncionarios,
    pageHome, pageMinhaPagina,
    pageOficina,
    pageVeiculos
} from "../router/PageLink.tsx";

function Navbar() {

    const location = useLocation();

    return (
        <header>
            <nav className="navbar">
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <Link
                            className={`nav-link ${location.pathname === pageHome || location.pathname.includes('/home') ? 'active' : ''}`}
                            to={pageHome}>
                            <FontAwesomeIcon className="icon" icon={faHouse}/>
                            <p>Home</p>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link
                            className={`nav-link ${location.pathname.includes(pageVeiculos) ? 'active' : ''}`}
                            to={pageVeiculos}>
                            <FontAwesomeIcon className="icon" icon={faTruck}/>
                            <p>Veículos</p>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link
                            className={`nav-link ${location.pathname.includes(pageFuncionarios) ? 'active' : ''}`}
                            to={pageFuncionarios}>
                            <FontAwesomeIcon className="icon"
                                             icon={faUsersGear}/>
                            <p>Funcionários</p>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link
                            className={`nav-link ${location.pathname.includes(pageOficina) ? 'active' : ''}`}
                            to={pageOficina}>
                            <FontAwesomeIcon className="icon" icon={faHammer}/>
                            <p>Oficina</p>
                        </Link>
                    </li>
                    <li className="nav-item">
                        <Link
                            className={`nav-link ${location.pathname.includes(pageMinhaPagina) ? 'active' : ''}`}
                            to={pageMinhaPagina}>
                            <FontAwesomeIcon className="icon" icon={faUser}/>
                            <p>Meu Perfil</p>
                        </Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default Navbar;