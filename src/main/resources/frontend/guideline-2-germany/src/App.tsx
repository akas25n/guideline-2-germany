import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Register from './components/Register';
import Login from './components/Login';
import BannerDisplay from './components/banner/BannerDisplay';
import { AuthProvider } from './components/AuthContext';

const App: React.FC = () => {
    return (
    <AuthProvider>
        <Router>
            <div>
            <Navbar />
            <BannerDisplay />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/home" element={<Home />} />
                </Routes>
            </div>
        </Router>
        </AuthProvider>
    );
}


export default App;
