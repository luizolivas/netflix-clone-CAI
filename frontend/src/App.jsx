import { Home } from './pages/Home/Home'
import  Login  from './pages/Login/Login';

import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';


function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;


