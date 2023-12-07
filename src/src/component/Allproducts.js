import React, { useState, useEffect } from "react";
import axios from 'axios';

function AllProducts() {
    const [items, setItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/items')
            .then(res => {
                console.log("Fetched data:", res.data); // Check fetched data in console
                setItems(res.data); // Assuming API response contains an array of items
            })
            .catch(err => {
                console.error('Error fetching data:', err);
            });
    }, []);

    return (
        <div>
            <h1 className="allproducth1" style={{ color: "white", fontFamily: "monospace", fontSize: "40px" }}>All Items in MAX MART</h1>
            <ul className="allul">
                {items.map(item => (
                    <li key={item.id}>
                        <p>ID: {item.id}</p>
                        <p>Name: {item.name}</p>
                        <p>Manufacturing Date: {item.manufacturing}</p>
                        <p>Expiry Date: {item.expiry}</p>
                        <p>Price: {item.price}</p>
                        <p>Category: {item.category}</p>
                        {/* Add additional fields as needed */}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default AllProducts;
