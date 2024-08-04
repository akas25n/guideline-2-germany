import React, { useState, ChangeEvent, FormEvent } from 'react';
import axios from 'axios';

interface User {
    firstName: string;
    lastName: string;
    mobileNumber: string;
    email: string;
    password: string;
}

const Register: React.FC = () => {
    const [user, setUser] = useState<User>({
        firstName: '',
        lastName: '',
        mobileNumber: '',
        email: '',
        password: ''
    });

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setUser(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        axios.post('http://localhost:8010/api/register', user)
            .then(response => {
                console.log('Registration successful', response);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    };

    return (
        <div className="bg-gray-100 flex items-center justify-center min-h-screen">
            <div className="bg-white p-6 md:p-8 lg:p-10 rounded-lg shadow-md w-full max-w-sm md:max-w-md lg:max-w-lg">
                <h1 className="text-xl md:text-2xl lg:text-3xl font-bold text-center mb-4 md:mb-6 lg:mb-8">Register</h1>
                <form onSubmit={handleSubmit}>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">First Name:</label>
                        <input type="text" name="firstName" value={user.firstName} onChange={handleChange} required className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" />
                    </div>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Last Name:</label>
                        <input type="text" name="lastName" value={user.lastName} onChange={handleChange} required className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" />
                    </div>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Mobile Number:</label>
                        <input type="text" name="mobileNumber" value={user.mobileNumber} onChange={handleChange} required className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" />
                    </div>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Email:</label>
                        <input type="email" name="email" value={user.email} onChange={handleChange} required className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" />
                    </div>
                    <div className="mb-4 md:mb-6 lg:mb-8">
                        <label className="block text-gray-700">Password:</label>
                        <input type="password" name="password" value={user.password} onChange={handleChange} required className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500" />
                    </div>
                    <button type="submit" className="w-full bg-indigo-500 text-white py-2 md:py-3 lg:py-4 rounded-lg hover:bg-indigo-600">Register</button>
                </form>
            </div>
        </div>
    );
}

export default Register;
