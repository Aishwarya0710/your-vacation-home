import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from 'react-router-dom';
import styles from '../styles/StayDetail.module.css';

function StayDetail() {
    const {stayId} = useParams();
    const navigate = useNavigate();
    const [stay, setStay] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (stayId) {
            fetchStay(parseInt(stayId)); // Convert to number
        }
    }, [stayId]);

    const fetchStay = async (id) => {
        try {
            setLoading(true);
            const response = await fetch(`http://localhost:8080/v1/stays/${Number(id)}`);

            if (!response.ok) {
                throw new Error(`Stay not found (ID: ${id})`);
            }

            const data = await response.json();
            setStay(data);
        } catch (err) {
            setError(err.message);
            console.error('Fetch error:', err);
        } finally {
            setLoading(false);
        }
    };

    const makeReservation = async () => {
        try {
            //TO DO : Add proper logic
            await fetch(`http://localhost:8080/v1/reserve`);
            navigate('/dummy')
        } catch (err) {
            setError(err.message);
            console.error('Fetch error:', err);
        }
    };

    const handleBack = () => navigate('/');

    if (loading) {
        return <div className={styles.loading}>Loading stay details...</div>;
    }

    if (error || !stay) {
        return (
            <div className={styles.error}>
                <h2>Stay Not Found</h2>
                <button onClick={handleBack} className={styles.backButton}>← Back to Stays</button>
            </div>
        );
    }

    return (
        <div className={styles.detailPage}>
            <div className={styles.header}>
                <button onClick={handleBack} className={styles.backButton}>← Back to stays</button>
                <h1>{stay.name}</h1>
            </div>

            <div className={styles.detailContent}>
                <div className={styles.mainImage}>
                    <img
                        src={stay.imageUrl || 'https://via.placeholder.com/800x500?text=No+Image'}
                        alt={stay.name}
                        onError={(e) => {
                            e.target.src = 'https://via.placeholder.com/800x500?text=No+Image';
                        }}
                    />
                </div>

                <div className={styles.infoSection}>
                    <div className={styles.priceRow}>
                        <div>
                            <span className={styles.price}>${stay.price} / night</span>
                            <div className={styles.rating}>★ {stay.rating} ({stay.rating * 20}%)</div>
                        </div>
                        <button onClick={makeReservation} className={styles.bookButton}>Reserve</button>
                    </div>

                    <div className={styles.detailsGrid}>
                        <div className={styles.detailItem}>
                            <strong>{stay.occupancy}</strong> guests
                        </div>
                    </div>

                    <h3>Description</h3>
                    <p className={styles.description}>{stay.description}</p>

                    <h3>Address</h3>
                    <p className={styles.address}>{stay.address}</p>
                </div>
            </div>
        </div>
    );
}

export default StayDetail;
