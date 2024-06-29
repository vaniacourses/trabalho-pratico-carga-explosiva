import { useNavigate } from 'react-router-dom';
import { faExclamationTriangle } from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

const UnauthorizedPage = () => {
    const navigate = useNavigate();

    const handleGoBack = () => {
        navigate('/');
    };

    return (
        <div className="container text-center mt-5">
            <FontAwesomeIcon size={"xl"} color={"#FF0000"} icon={faExclamationTriangle}/>
            <h1 className="mt-3">Acesso Não Autorizado</h1>
            <p className="mt-3">Você não tem permissão para acessar esta página.</p>
            <button className="btn btn-outline-info" onClick={handleGoBack}>
                Voltar para a Página Inicial
            </button>
        </div>
    );
};

export default UnauthorizedPage;