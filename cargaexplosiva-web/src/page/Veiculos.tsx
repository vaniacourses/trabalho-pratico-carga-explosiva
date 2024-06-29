import {useNavigate} from "react-router-dom";
import {pageCadastraVeiculo} from "../router/PageLink.tsx";

function Veiculos() {

    const navigate = useNavigate();

    const handleGoToCadastroVeiculo = () => {
        navigate(pageCadastraVeiculo); // Redireciona para a página de cadastro de veículo
    };

    return (
        <div>
            <button className="btn btn-outline-info mt-3"
                    onClick={handleGoToCadastroVeiculo}>
                Cadastrar Veículo
            </button>
        </div>
    );
}

export default Veiculos;