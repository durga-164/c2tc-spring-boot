import React, { Component } from "react";
import { Link } from "react-router-dom";

class Navbar extends Component {
    render() {
        return (<div className="navcontainer">
            <div className="navdiv"><Link to="/"><button id="b1">HOME PAGE</button></Link>
                <Link to="/allproducts">
                    <button id="b1">ALL PRODUCTS</button>
                </Link>
                <br /><br />
                <Link to="/searchproducts">
                <button id="b1">SEARCH PRODUCTS</button></Link>
                <br /><br />
                <Link to="/insertproducts">
                <button id="b1">INSERT PRODUCTS</button></Link><br></br>
                <Link to="/deleteproducts">
                    <button id="b1">DELETE PRODUCTS</button>
                </Link>
                <Link to="/updateproducts">
                    <button id="b1">UPDATE PRODUCT PRICE</button>
                </Link>
                
            </div>
            </div>
        );
    }
}

export default Navbar;
