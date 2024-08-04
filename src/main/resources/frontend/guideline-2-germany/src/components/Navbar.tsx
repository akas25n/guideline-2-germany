import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from './AuthContext';

const Navbar: React.FC = () => {
    const { user, logout } = useAuth();

    return (
        <nav className="bg-indigo-500 p-4">
            <div className="container mx-auto flex justify-between items-center">
                <div className="text-white font-bold text-lg">
                    <Link to="/">Guideline2Germany</Link>
                </div>
                <div className="space-x-4">
                    {user ? (
                        <>
                            <span className="text-white">Hello, {user.firstName} {user.lastName}</span>
                            <button onClick={logout} className="text-white">Logout</button>
                        </>
                    ) : (
                        <>
                            <Link to="/login" className="text-white">Login</Link>
                            <Link to="/register" className="text-white">Register</Link>
                        </>
                    )}
                </div>
            </div>
        </nav>
    );
}

export default Navbar;
