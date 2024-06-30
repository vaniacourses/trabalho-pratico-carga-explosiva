import {Link, useNavigate} from "react-router-dom";
import {pageCadastraVeiculo, setIDOneVeiculo} from "../router/PageLink.tsx";
import {useAPI} from "../hooks/useApi.tsx";
import {useLayoutEffect, useState} from "react";
import {GetVeiculoData, getVeiculoSchema} from "../schema/GetVeiculoData.tsx";
import '../css/veiculos.css'

function Veiculos() {

    const navigate = useNavigate();
    const api = useAPI()

    const [veiculos, setVeiculos] = useState<GetVeiculoData[]>([]);

    const handleGoToCadastroVeiculo = () => {
        navigate(pageCadastraVeiculo); // Redireciona para a página de cadastro de veículo
    };

    const getVeiculos = async () => {
        try {
            const response = await api.getAllVeiculo();
            if(response.error){
                alert("Erro ao buscar veiculos.")
            }
            const veiculoslist: GetVeiculoData[] = []
            response.forEach((veiculo: GetVeiculoData) => {
                const vaidVeiculo = getVeiculoSchema.safeParse(veiculo)
                if(vaidVeiculo.success){
                    veiculoslist.push(vaidVeiculo.data)
                }
            })
            setVeiculos(veiculoslist)
        }catch (e){
            alert("Erro ao buscar veículos.")
        }
        console.log(veiculos)
    }

    useLayoutEffect(() => {
        getVeiculos()
    }, []);

    return (
        <main>
            <div className="page-veiculos container text-center pt-4 pb-4">
                <h1>Veículos</h1>
                <div className="d-flex justify-content-end">
                    <button className="btn btn-outline-info mt-3"
                            onClick={handleGoToCadastroVeiculo}>
                        Cadastrar Veículo
                    </button>
                </div>
                {veiculos.length != 0 &&
                    <div className="mt-4">
                        <div className="veiculos-container">
                            {veiculos.map(veiculo => (
                                <Link
                                    key={veiculo.id_veiculo}
                                    to={setIDOneVeiculo(veiculo.id_veiculo)}
                                    className="veiculo-card-link"
                                >
                                    <div className="veiculo-card">
                                        <h3 className="veiculo-card-title">{veiculo.marca} {veiculo.modelo}</h3>
                                        <p className="veiculo-card-info">Placa: {veiculo.placa}</p>
                                        <p className="veiculo-card-info">Ano: {veiculo.anoModelo}</p>
                                        <p className="veiculo-card-info">Tipo: {veiculo.tipo}</p>
                                    </div>
                                </Link>
                            ))}
                        </div>
                    </div>
                    ||
                    <div className="container mt-4">
                        <h5>Nenhum veiculo encontrado.</h5>
                    </div>
                }
            </div>
        </main>
    );
}

export default Veiculos;