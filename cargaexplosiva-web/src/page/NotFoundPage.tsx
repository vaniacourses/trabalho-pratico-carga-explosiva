import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faExclamationTriangle } from '@fortawesome/free-solid-svg-icons'; // Importe os ícones que deseja usar

const NotFoundPage = () => {
    return (
        <div className="container text-center mt-5">
            <FontAwesomeIcon icon={faExclamationTriangle} size="6x" color="#FF0000" />
            <h1 className="mt-3">404 - Página não encontrada</h1>
            <p className="mt-3">A página que você está tentando acessar não existe.</p>
            <Link to="/" className="btn btn-outline-info mt-3">
                Voltar para a Página Inicial
            </Link>
        </div>
    );
};

export default NotFoundPage;