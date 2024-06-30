import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import {
    CadastrarVeiculoData,
    cadastrarVeiculoSchema, convertToYYYYMMDD
} from "../schema/CadastrarVeiculoData.tsx";
import {useAPI} from "../hooks/useApi.tsx";
import {useNavigate} from "react-router-dom";
import {setIDOneVeiculo} from "../router/PageLink.tsx";

function CadastrarVeiculo() {

    const api = useAPI()
    const navigate = useNavigate()

    const {
        register,
        handleSubmit,
        formState: { errors }}
        = useForm<CadastrarVeiculoData>({
        criteriaMode: "all",
        mode: "all",
        resolver: zodResolver(cadastrarVeiculoSchema),
    })

    const cadastrarVeiculo = async (data: CadastrarVeiculoData) =>{
        try {
            data.dataCompra = convertToYYYYMMDD(data.dataCompra);
            const response = await api.cadastrarVeiculo(data)
            if(response.error){
                alert(response.error)
            }else{
                navigate(setIDOneVeiculo(response));
            }
        }catch (e){
            alert("Erro ao cadastrar veiculo. Entre em contato com o setor" +
                " de TI.")
        }
    }

    return (
        <main>
            <div className="mb-4 mt-4 container">
                <div className='container-fluid text-center'>
                    <h1 className="m-4">Cadastrar Veículo</h1>
                    <form onSubmit={handleSubmit(cadastrarVeiculo)}
                          className="text-center justify-content-center">
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.placa ? 'is-invalid' : ''}`}
                                id="placaInput"
                                placeholder=""
                                {...register("placa")}
                            />
                            <label htmlFor="placaInput">Placa</label>
                            {errors.placa &&
                                <p className="invalid-feedback">{errors.placa.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.marca ? 'is-invalid' : ''}`}
                                id="marcaInput"
                                placeholder=""
                                {...register("marca")}
                            />
                            <label htmlFor="marcaInput">Marca</label>
                            {errors.marca &&
                                <p className="invalid-feedback">{errors.marca.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.modelo ? 'is-invalid' : ''}`}
                                id="modeloInput"
                                placeholder=""
                                {...register("modelo")}
                            />
                            <label htmlFor="modeloInput">Modelo</label>
                            {errors.modelo &&
                                <p className="invalid-feedback">{errors.modelo.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                className={`form-control ${errors.anoFabricacao ? 'is-invalid' : ''}`}
                                id="anoFabricacaoInput"
                                placeholder=""
                                {...register("anoFabricacao", {valueAsNumber: true})}
                            />
                            <label htmlFor="anoFabricacaoInput">Ano de
                                Fabricação</label>
                            {errors.anoFabricacao &&
                                <p className="invalid-feedback">{errors.anoFabricacao.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                className={`form-control ${errors.anoModelo ? 'is-invalid' : ''}`}
                                id="anoModeloInput"
                                placeholder=""
                                {...register("anoModelo", {valueAsNumber: true})}
                            />
                            <label htmlFor="anoModeloInput">Ano do
                                Modelo</label>
                            {errors.anoModelo &&
                                <p className="invalid-feedback">{errors.anoModelo.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.tipo ? 'is-invalid' : ''}`}
                                id="tipoInput"
                                placeholder=""
                                {...register("tipo")}
                            />
                            <label htmlFor="tipoInput">Tipo</label>
                            {errors.tipo &&
                                <p className="invalid-feedback">{errors.tipo.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                className={`form-control ${errors.numRenavan ? 'is-invalid' : ''}`}
                                id="numRenavanInput"
                                placeholder=""
                                {...register("numRenavan", {valueAsNumber: true})}
                            />
                            <label htmlFor="numRenavanInput">Renavam</label>
                            {errors.numRenavan &&
                                <p className="invalid-feedback">{errors.numRenavan.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                step="0.01"
                                className={`form-control ${errors.capacidadeCarga ? 'is-invalid' : ''}`}
                                id="capacidadeDeCargaInput"
                                placeholder=""
                                {...register("capacidadeCarga", {valueAsNumber: true})}
                            />
                            <label htmlFor="capacidadeDeCargaInput">Capacidade
                                de Carga (Kg)</label>
                            {errors.capacidadeCarga &&
                                <p className="invalid-feedback">{errors.capacidadeCarga.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.numChassi ? 'is-invalid' : ''}`}
                                id="numChassiInput"
                                placeholder=""
                                {...register("numChassi")}
                            />
                            <label htmlFor="numChassiInput">Número do
                                Chassi</label>
                            {errors.numChassi &&
                                <p className="invalid-feedback">{errors.numChassi.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                step="0.01"
                                className={`form-control ${errors.totalKM ? 'is-invalid' : ''}`}
                                id="totalKMInput"
                                placeholder=""
                                {...register("totalKM", {valueAsNumber: true})}
                            />
                            <label htmlFor="totalKMInput">KM</label>
                            {errors.totalKM &&
                                <p className="invalid-feedback">{errors.totalKM.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="text"
                                className={`form-control ${errors.dataCompra ? 'is-invalid' : ''}`}
                                id="dataCompraInput"
                                placeholder="DD-MM-YYYY"
                                {...register('dataCompra', {required: true})}
                            />
                            <label htmlFor="dataCompraInput">Data de
                                Compra</label>
                            {errors.dataCompra &&
                                <p className="invalid-feedback">{errors.dataCompra.message}</p>}
                        </div>
                        <div className="form-floating mb-2">
                            <input
                                type="number"
                                step="0.01"
                                className={`form-control ${errors.valor ? 'is-invalid' : ''}`}
                                id="valorInput"
                                placeholder=""
                                {...register("valor", {valueAsNumber: true})}
                            />
                            <label htmlFor="valorInput">Valor</label>
                            {errors.valor &&
                                <p className="invalid-feedback">{errors.valor.message}</p>}
                        </div>
                        <div className="form-check mb-2">
                            <input
                                type="checkbox"
                                className={`form-check-input ${errors.status ? 'is-invalid' : ''}`}
                                id="statusInput"
                                {...register("status", {required: true})}
                            />
                            <label
                                className="form-check-label d-flex align-items-center"
                                htmlFor="statusInput">
                                Ativo
                            </label>
                            {errors.status &&
                                <p className="invalid-feedback">{errors.status.message}</p>}
                        </div>
                        <div className="d-flex justify-content-end pt-3">
                            <button type="submit"
                                    className="btn btn-outline-info">
                                Cadastrar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    );
}

export default CadastrarVeiculo;