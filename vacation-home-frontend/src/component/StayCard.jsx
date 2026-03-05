import React from 'react';

function StayCard({ stay }) {
    return (
        <div style={{
            border: '1px solid #ddd',
            padding: '16px',
            borderRadius: '8px',
            boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
        }}>
            <h3>{stay.name || 'Vacation Stay'}</h3>
            <p><strong>ID:</strong> {stay.id}</p>

            <p><strong>Property:</strong> {stay.name}</p>
            {stay.address && <p><strong>Address:</strong> {stay.address}</p>}
            {stay.description && <p>{stay.description}</p>}
        </div>
    );
}

export default StayCard;