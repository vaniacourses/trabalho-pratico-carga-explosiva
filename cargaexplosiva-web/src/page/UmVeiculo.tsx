import {useParams} from "react-router-dom";

function UmVeiculo() {
    const {id} = useParams();
    return (
        <div>{id}</div>
    );
}

export default UmVeiculo;