import React, { useState, ChangeEvent, FormEvent } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './AuthContext';

interface Credentials {
    email: string;
    password: string;
}

interface User {
    email: string;
    firstName: string;
    lastName: string;
}

const Login: React.FC = () => {
    const [credentials, setCredentials] = useState<Credentials>({
        email: '',
        password: ''

    });
    const navigate = useNavigate();
    const { login } = useAuth();

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setCredentials(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        axios.post('http://localhost:8010/api/login', credentials, { withCredentials: true })
            .then(response => {
                login(response.data);
                navigate('/'); // Redirect to home page after successful login
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    };

    return (
        <div className="bg-gray-100 flex items-center justify-center min-h-screen">
            <div className="bg-white p-6 md:p-8 lg:p-10 rounded-lg shadow-md w-full max-w-sm md:max-w-md lg:max-w-lg">
                <h1 className="text-xl md:text-2xl lg:text-3xl font-bold text-center mb-4 md:mb-6 lg:mb-8">Login</h1>
                <form onSubmit={handleSubmit}>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Email:</label>
                        <input
                            type="email"
                            name="email"
                            value={credentials.email}
                            onChange={handleChange}
                            required
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        />
                    </div>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Password:</label>
                        <input
                            type="password"
                            name="password"
                            value={credentials.password}
                            onChange={handleChange}
                            required
                            className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                        />
                    </div>
                    <button type="submit" className="w-full bg-indigo-500 text-white py-2 md:py-3 lg:py-4 rounded-lg hover:bg-indigo-600">Login</button>
                </form>
            </div>
        </div>
    );
};

export default Login;
