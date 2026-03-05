import {useEffect, useState} from "react";
import StayCard from "./StayCard.jsx";


function Home(){

    const [stays, setStays] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)

    useEffect(() => {
        fetchStays();
    },[]);

    const fetchStays = async () => {
        try {
            const response = await fetch('http://localhost:8080/v1/stays', {
                headers: { 'Content-Type': 'application/json' }
            });

            if (!response.ok) throw new Error('Failed to fetch stays');

            const data = await response.json();
            setStays(data);
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <div>Loading stays...</div>;
    if (error) return <div>Error: {error}</div>;


    return (
        <div>
            <h1>Your Vacation Homes</h1>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '20px' }}>
                {stays.map(stay => (
                    <StayCard key={stay.id} stay={stay} />
                ))}
            </div>
            {stays.length === 0 && <p>No stays available</p>}
        </div>
    )
}

export default Home;