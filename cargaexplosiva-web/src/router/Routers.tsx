import {createBrowserRouter} from "react-router-dom";
import App from "../App.tsx";
import Login from "../page/Login.tsx";

export const Routers = createBrowserRouter([
    {
        element: <App />,
        children:[
            {
                path: '/',
                element: <Login />
            }
        ]
    }
])