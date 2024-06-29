import React, {useState} from 'react'
import {createItemEstoque} from "../services/ListaItensEstoqueService.tsx";
import {useNavigate} from "react-router-dom";

const ItensEstoque = () => {

    const [nome, setNome] = useState()
    const [tipo, setTipo] = useState()
    const [marca, setMarca] = useState()

    const navigator = useNavigate();

    function saveItem(e){
        e.preventDefault();

        const item = {nome, tipo, marca};
        console.log(item);

        createItemEstoque(item).then((response) => {
            console.log(response.data);
            navigator('/estoque')
        })

    }

    return(
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2 className='text-center'>Adicionar Item</h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className="form-label">Nome:</label>
                                <input
                                    type='text'
                                    placeholder='Nome do Item'
                                    name='nome'
                                    value={nome}
                                    className='form-control'
                                    onChange={(e) => setNome(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className="form-label">Tipo:</label>
                                <input
                                    type='text'
                                    placeholder='Tipo do Item'
                                    name='tipo'
                                    value={tipo}
                                    className='form-control'
                                    onChange={(e) => setTipo(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className="form-label">Marca:</label>
                                <input
                                    type='text'
                                    placeholder='Marca do Item'
                                    name='marca'
                                    value={marca}
                                    className='form-control'
                                    onChange={(e) => setMarca(e.target.value)}
                                />
                            </div>
                            <button className='btn btn-success' onClick={saveItem}>Adicionar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ItensEstoque