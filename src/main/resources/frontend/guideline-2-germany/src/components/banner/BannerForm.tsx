import React, { useState, ChangeEvent, FormEvent } from 'react';
import axios from 'axios';

const BannerForm: React.FC = () => {
    const [url, setUrl] = useState('');

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        const fileId = url.split('/d/')[1].split('/')[0];
        const directUrl = `https://drive.google.com/uc?export=view&id=${fileId}`;

        axios.post('http://localhost:8010/api/banner/image', { url: directUrl })
            .then(response => {
                console.log('Banner image uploaded');
                setUrl('');
                window.location.reload(); // Refresh to show the new banner
            })
            .catch(error => {
                console.error('Error uploading banner image:', error);
            });
    };

    return (
        <div className="bg-white p-6 md:p-8 lg:p-10 rounded-lg shadow-md w-full max-w-sm md:max-w-md lg:max-w-lg">
            <h1 className="text-xl md:text-2xl lg:text-3xl font-bold text-center mb-4 md:mb-6 lg:mb-8">Upload Banner Image</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-4 md:mb-6 lg:mb-8">
                    <label className="block text-gray-700">Image URL:</label>
                    <input
                        type="text"
                        value={url}
                        onChange={(e: ChangeEvent<HTMLInputElement>) => setUrl(e.target.value)}
                        required
                        className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
                    />
                </div>
                <button type="submit" className="w-full bg-indigo-500 text-white py-2 md:py-3 lg:py-4 rounded-lg hover:bg-indigo-600">Upload</button>
            </form>
        </div>
    );
};

export default BannerForm;
