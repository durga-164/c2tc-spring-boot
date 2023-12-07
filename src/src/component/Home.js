import React from 'react';
import backgroundImage from './background.webp'; // Import the image

function Home() {
  const backgroundStyle = {
    backgroundImage: `url(${backgroundImage})`,
    backgroundSize: 'cover',
    filter:'blur',
    padding:'118px',
    backgroundRepeat: 'no-repeat',
    /* Add more CSS properties here to adjust the background */
  };

  return (
    <div className="homediv" style={backgroundStyle}>
      <h1><marquee id="mark1">WELCOME TO MAX MART!!!</marquee></h1>
      <br />
      <p className='parah2'>
        
          Discover a world of convenience and quality at Max Mart, nestled within the heart of the bustling shopping mall.<br />
          We are your one-stop shop for all your daily needs, offering a vast array of products ranging from groceries to cosmetics and everything in between.<br />
          At Max Mart, we understand the importance of simplicity in your busy life.<br />
          That's why we've curated a diverse selection of items, ensuring that your shopping experience is effortless and enjoyable.<br />
          From fresh produce to pantry essentials, from skincare to household items, we have it all under one roof.
          
        
      </p>
    </div>
  );
}

export default Home;
