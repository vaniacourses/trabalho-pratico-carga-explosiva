import {useNavigate, useParams} from "react-router-dom";
import {useAPI} from "../hooks/useApi.tsx";

function DesignarMotorista() {
    const {id} = useParams();
    const api = useAPI()
    const navigate = useNavigate()
    return (
        <main>
            <div className="container">
                <p>Id do veiculo: {id}</p>
                <p>Esse é o ID do veiculo, vai ter que procurar os motoritas que
                    NÃO tem veiculos cadastrado e da opção de escolher um
                    deles.</p>
            </div>
        </main>
    );
}

export default DesignarMotorista;