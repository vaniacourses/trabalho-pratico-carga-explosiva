import '../css/navbar.css'
import {Link} from "react-router-dom";

function Navbar() {
    return (
        <header>
            <nav className="navbar">
                <ul className={"navbar-nav"}>
                    <li className={"nav-item"}>
                        <Link className={"nav-link"} to={""}>
                            Veiculo
                        </Link>
                    </li>
                    <li className={"nav-item"}>
                        <Link className={"nav-link"} to={""}>
                            Motoristas
                        </Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default Navbar;