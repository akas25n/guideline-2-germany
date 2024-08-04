import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface Banner {
    url: string;
}

const BannerDisplay: React.FC = () => {
    const [banner, setBanner] = useState<Banner | null>(null);

    useEffect(() => {
        fetchBanner();
    }, []);

    const fetchBanner = () => {
        axios.get<Banner>('http://localhost:8010/api/banner/image')
            .then(response => {
                setBanner(response.data);
            })
            .catch(error => {
                console.error('Error fetching banner:', error);
            });
    };

    return (
        <div className="bg-gray-100 flex items-center justify-center min-h-64">
            {banner ? (
                <img src={banner.url} alt="Banner" className="w-full h-full object-cover" />
            ) : (
                <div>No banner image available</div>
            )}
        </div>
    );
};

export default BannerDisplay;
