import {useContext} from "react";
import {AuthContext} from "../contexts/auth/AuthContext.tsx";

function MinhaPagina() {
    const auth = useContext(AuthContext)

    return (
        <main>
            {auth.funcionario?.nome}
        </main>
    );
}

export default MinhaPagina;