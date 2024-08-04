import React from 'react';
import Footer from './Footer';

const Home: React.FC = () => {
    return (
        <div>
            <div className="bg-gray-100 flex items-center justify-center min-h-screen">
                <div className="bg-white p-6 md:p-8 lg:p-10 rounded-lg shadow-md w-full max-w-4xl">
                    <h1 className="text-xl md:text-2xl lg:text-3xl font-bold text-center mb-4 md:mb-6 lg:mb-8">Welcome to the Home Page</h1>
                    <p className="text-center">You have successfully logged in!</p>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default Home;
