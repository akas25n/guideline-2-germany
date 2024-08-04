import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface User {
    firstName: string;
    lastName: string;
    mobileNumber: string;
    email: string;
}

const UserList: React.FC = () => {
    const [users, setUsers] = useState<User[]>([]);

    useEffect(() => {
        axios.get('http://localhost:8010/api/users')
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the users!', error);
            });
    }, []);

    return (
        <div className="bg-gray-100 flex items-center justify-center min-h-screen">
            <div className="bg-white p-6 md:p-8 lg:p-10 rounded-lg shadow-md w-full max-w-4xl">
                <h1 className="text-xl md:text-2xl lg:text-3xl font-bold text-center mb-4 md:mb-6 lg:mb-8">User List</h1>
                <table className="min-w-full bg-white border border-gray-300">
                    <thead className="bg-gray-800 text-white">
                        <tr>
                            <th className="w-1/4 py-2 px-4">First Name</th>
                            <th className="w-1/4 py-2 px-4">Last Name</th>
                            <th className="w-1/4 py-2 px-4">Mobile Number</th>
                            <th className="w-1/4 py-2 px-4">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user) => (
                            <tr key={user.email} className="even:bg-gray-100 odd:bg-white">
                                <td className="border px-4 py-2">{user.firstName}</td>
                                <td className="border px-4 py-2">{user.lastName}</td>
                                <td className="border px-4 py-2">{user.mobileNumber}</td>
                                <td className="border px-4 py-2">{user.email}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default UserList;
