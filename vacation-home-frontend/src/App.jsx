import './App.css'
import Home from "./component/Home.jsx";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import StayDetail from "./component/StayDetail.jsx";
import Dummy from "./component/Dummy.jsx";

function App() {

    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/stay/:stayId" element={<StayDetail/>}/>
                    <Route path="/dummy" element={<Dummy/>}/>
                </Routes>
            </div>
        </Router>
    )
}

export default App
