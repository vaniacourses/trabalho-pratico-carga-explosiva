import {RouterProvider} from "react-router-dom";
import {Routers} from "./Routers.tsx";

function Router() {
    return (
        <>
            <RouterProvider router={Routers} />
        </>
    );
}

export default Router;