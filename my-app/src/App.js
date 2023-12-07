import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Titlecomponent from './component/Titlecomponent';
import Navbar from './component/Navbar';
import Allproducts from './component/Allproducts'; // Ensure correct import path
import Home from './component/Home';
import Searchproduct from './component/Searchproduct';
import InsertItems from './component/InsertItems';
import Deleteproducts from './component/Deleteproducts';
import UpdateItem from './component/UpdateItem';




function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Titlecomponent/><br></br>
        <Navbar/><br></br><br></br>
        
        <Routes><Route path="/" element={<Home/>}/>
          <Route path="/allproducts" element={<Allproducts/>} />
          <Route path="/searchproducts" element={<Searchproduct/>}/>
          <Route path="/insertproducts" element={<InsertItems/>}/>
          <Route path="/deleteproducts" element={<Deleteproducts/>}/>
          <Route path="/updateproducts" element={<UpdateItem/>}/>
          {/* Add other routes here if needed */}
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
