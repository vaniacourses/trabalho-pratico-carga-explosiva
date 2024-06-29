import '../css/login.css'
import {useForm} from "react-hook-form";
import {LoginData, loginSchema} from "../schema/LoginData.tsx";
import {zodResolver} from "@hookform/resolvers/zod";

import '../css/login.css'
import {useContext} from "react";
import {AuthContext} from "../contexts/auth/AuthContext.tsx";
import {useLocation, useNavigate} from "react-router-dom";

function Login() {

    const auth = useContext(AuthContext)
    const navigate = useNavigate()
    const local = useLocation();

    const {
        register,
        handleSubmit,
        formState: { errors }}
        = useForm<LoginData>({
        criteriaMode: "all",
        mode: "all",
        resolver: zodResolver(loginSchema),
    })

    function login(data: LoginData){
        try {
            const logado = auth.login(data);
            logado.then(value => {
                if (typeof value === 'string') {
                    alert(value);
                } else if (value) {
                    navigate(local)
                }
            }).catch(error => {
                console.error("Erro inesperado ao realizar o login: ", error)
                alert("Erro inesperado ao realizar o login. Por favor, tente novamente.")
            })
        }catch (error){
            alert("Erro ao tentar realizar o login. Por favor entre em" +
                " contato por email com a nossa empresa.")
        }
    }

    return (
        <main>
            <div className="page-login">
                <div className='container-fluid text-center'>
                    <form onSubmit={handleSubmit(login)}
                          className={"text-center justify-content-center"}>
                        <div className="form-floating mb-3">
                            <input
                                type="email"
                                className="form-control"
                                id="emailInput"
                                placeholder=""
                                {...register("email")}
                            />
                            <label htmlFor="emailInput">
                                Email</label>
                            {errors.email &&
                                <p className="text-error p-0 m-0">{errors.email.message}</p>}
                        </div>
                        <div className="form-floating">
                            <input type="password"
                                   className="form-control"
                                   id="passwordInput"
                                   placeholder=""
                                   {...register("password")}
                            />
                            <label htmlFor="passwordInput">
                                Senha</label>
                            {errors.password &&
                                <p className="text-error p-0 m-0">{errors.password.message}</p>}
                        </div>
                        <div className={"d-flex justify-content-end pt-3"}>
                            <button type="submit"
                                    className="btn btn-outline-info">
                                Entrar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    );
}

export default Login;