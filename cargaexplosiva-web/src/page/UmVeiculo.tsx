import {useNavigate, useParams} from "react-router-dom";
import {useAPI} from "../hooks/useApi.tsx";
import {useEffect, useState} from "react";
import "../css/um-veiculo.css"
import {
    formatarValorParaExibicao,
    GetVeiculoData,
    getVeiculoSchema
} from "../schema/GetVeiculoData.tsx";
import {pageVeiculos, setIDDesignarMotorista} from "../router/PageLink.tsx";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrashAlt } from '@fortawesome/free-solid-svg-icons';

function UmVeiculo() {

    const {id} = useParams()
    const api = useAPI()
    const navigate = useNavigate()

    const [veiculo, setVeiculo] = useState<GetVeiculoData | null>(null!)

    const getVeiculo = async () => {
        if(id){
            try {
                const response = await api.getOneVeiculo(id)
                if(response.error){
                    navigate("*")
                }
                const validResponse = getVeiculoSchema.safeParse(response)
                if(!validResponse.success){
                    navigate("*")
                }else {
                    setVeiculo(validResponse.data)
                    return
                }
            }catch (e){
                navigate("*")
            }
        }else{
            navigate("*")
        }
    }

    function designarMotorista() {
        if (veiculo && veiculo.id_veiculo && typeof veiculo?.id_motorista == "string") {
            navigate(setIDDesignarMotorista(veiculo.id_veiculo));
        } else {
            alert("Erro ao solicitar designar motorista.");
        }
    }

    const exluir = async (id: string) =>{
        try {
            const response = await api.exluirVeiculo(id)
            if (typeof response === 'number') {
                navigate(pageVeiculos)
            } else if (response && 'error') {
                alert("Erro ao excluir veículo");
            } else {
                alert("Erro inesperada ao excluir veículo");
            }
        }catch (e){
            alert("Erro ao excluir veiculo.")
        }
    }

    useEffect(() => {
        getVeiculo()
    }, []);

    return (
        <main>
            {veiculo &&
                <div className="container-fluid mt-4 mb-5">
                    <h1 className="text-center">Veiculo</h1>
                    <div className="table-container">
                        <table className="custom-table">
                            <tbody>
                            <tr>
                                <th>Placa</th>
                                <td>{veiculo.placa}</td>
                            </tr>
                            <tr>
                                <th>Marca</th>
                                <td>{veiculo.marca}</td>
                            </tr>
                            <tr>
                                <th>Modelo</th>
                                <td>{veiculo.modelo}</td>
                            </tr>
                            <tr>
                                <th>Ano de Fabricação</th>
                                <td>{veiculo.anoFabricacao}</td>
                            </tr>
                            <tr>
                                <th>Ano do Modelo</th>
                                <td>{veiculo.anoModelo}</td>
                            </tr>
                            <tr>
                                <th>Tipo</th>
                                <td>{veiculo.tipo}</td>
                            </tr>
                            <tr>
                                <th>Número Renavan</th>
                                <td>{veiculo.numRenavan}</td>
                            </tr>
                            <tr>
                                <th>Capacidade de Carga</th>
                                <td>{formatarValorParaExibicao(veiculo.capacidadeCarga)}</td>
                            </tr>
                            <tr>
                                <th>Número do Chassi</th>
                                <td>{veiculo.numChassi}</td>
                            </tr>
                            <tr>
                                <th>Total KM</th>
                                <td>{formatarValorParaExibicao(veiculo.totalKM)}</td>
                            </tr>
                            <tr>
                                <th>Status</th>
                                <td>{veiculo.status ? 'Ativo' : 'Inativo'}</td>
                            </tr>
                            <tr>
                                <th>Data de Compra</th>
                                <td>{veiculo.dataCompra}</td>
                            </tr>
                            <tr>
                                <th>Valor</th>
                                <td>{formatarValorParaExibicao(veiculo.valor)}</td>
                            </tr>
                            {veiculo.motorista &&
                                <tr>
                                    <th>Motorista</th>
                                    <td>{veiculo.motorista || 'N/A'}</td>
                                </tr>
                            }
                            </tbody>
                        </table>
                    </div>
                    {veiculo && !veiculo.id_motorista &&
                        <div className="d-flex justify-content-between">
                            <button className="btn btn-outline-info mt-3"
                                    onClick={designarMotorista}>
                                Designar Motorista
                            </button>
                            <button className="btn btn-outline-danger mt-3"
                                    onClick={() => exluir(veiculo.id_veiculo)}>
                                <FontAwesomeIcon icon={faTrashAlt}/>
                            </button>
                        </div>
                    }
                </div>
                ||
                <div>
                    Carregando...
                </div>}
        </main>
    );
}

export default UmVeiculo;