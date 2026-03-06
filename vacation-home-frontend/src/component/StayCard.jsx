import React from 'react';
import {useNavigate} from 'react-router-dom';
import styles from '../styles/StayCard.module.css'; // CSS Module


function StayCard({stay}) {
    const navigate = useNavigate();

    const handleCardClick = () => {
        navigate(`/stay/${stay.id}`);  // ✅ Navigate to detail page
    };

    return (
        <div className={styles.card} onClick={handleCardClick}>
            <div
                className={styles.imageContainer}
                style={{backgroundImage: `url(${stay.imageUrl})`}}
            >
                <div className={styles.priceBadge}>${stay.price}</div>
            </div>

            <div className={styles.content}>
                <h3 className={styles.propertyName}>{stay.name}</h3>
                <p className={styles.address}>{stay.address}</p>
                <div className={styles.details}>
                    <span className={styles.rating}>★ {stay.rating} </span>
                    <span> {stay.occupancy} guests</span>
                </div>
            </div>
        </div>
    );
}

export default StayCard;