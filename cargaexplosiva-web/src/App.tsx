import Navbar from "./component/Navbar.tsx";
import {Outlet} from "react-router-dom";

function App() {

  return (
    <div className="App">
        <Navbar />
        <Outlet />
    </div>
  )
}

export default App
