import { useEffect, useState } from 'react'
import { listaItensEstoque } from '../services/ListaItensEstoqueService.tsx'
import { useNavigate} from "react-router-dom";

const ListaItensEstoque = () => {

    const [itens, setItens] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        listaItensEstoque().then((response) => {
            setItens(response.data);
        }).catch(error => {
            console.error(error);
        })

    }, [])

    function addNovoItem(){
        navigator('/add-item')
    }

  return (
    <div className="container">
        <h2 className="text-center">Estoque</h2>
        <button className='btn btn-primary mb-2' onClick={addNovoItem}>Adicionar item</button>
        <table className="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Marca</th>
                    <th>Nome</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            <tbody>
                {
                    itens.map(estoque =>
                        <tr key={estoque.nome}>
                            <td>{estoque.marca}</td>
                            <td>{estoque.nome}</td>
                            <td>{estoque.tipo}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListaItensEstoque