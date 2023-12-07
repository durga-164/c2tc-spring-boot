import React, { Component } from "react";

class Searchproduct extends Component {
  constructor(props) {
    super(props);
    this.state = {
      itemId: "",
      category: "",
      itemDetails: [],
      error: null
    };
  }

  handleItemIdChange = (event) => {
    this.setState({ itemId: event.target.value });
  };

  handleCategoryChange = (event) => {
    this.setState({ category: event.target.value });
  };

  handleSearch = (event) => {
    event.preventDefault();
    const { itemId, category } = this.state;

    // Choose the endpoint based on the input provided
    const apiUrl = itemId ? `http://localhost:8080/item/${itemId}` : `http://localhost:8080/items/${category}`;

    fetch(apiUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        if (Array.isArray(data)) {
          this.setState({ itemDetails: data, error: null });
        } else {
          this.setState({ itemDetails: [data], error: null });
        }
      })
      .catch((error) => {
        console.error("There was a problem with the fetch operation:", error);
        this.setState({ itemDetails: [], error: "Items not found" });
      });
  };

  render() {
    return (
      <div><h1 style={{ color: 'white', fontFamily: 'monospace', fontSize: '40px', textAlign:'center'}}>SEARCH ITEMS IN MAX MART</h1>
      <div className="searchdiv">
        <br />
        
        <div className="searchform">
          <form>
            <div className="labeldiv">
              <label id="searchlabel">Enter item id:</label>
              <input
                type="text"
                id="idtext"
                placeholder="Enter item id"
                value={this.state.itemId}
                onChange={this.handleItemIdChange}
              />
            </div>
            <p id="orp">(OR)</p>
            <div className="label2">
              <label id="searchlabel">Enter item category:</label>
              <input
                type="text"
                id="idtext"
                placeholder="eg - grocery"
                value={this.state.category}
                onChange={this.handleCategoryChange}
              />
            </div>
            <br /><br />
            <button type="submit" id="searchbutton" onClick={this.handleSearch}>
              Search
            </button>
          </form>
        </div>
        {/* Display item details */}
        {this.state.error && <p id="errorp">{this.state.error}</p>}
        {this.state.itemDetails && this.state.itemDetails.length > 0 && (
          <div className="searchdisplay">
            {/* Render item details here */}
            <ul className="flex-grid">
              {this.state.itemDetails.map((item) => (
                <li key={item.id} className="item-details">
                  <div>
                    <p>Item Name: {item.name}</p>
                    <p>Category: {item.category}</p>
                    <p>Manufacturing: {item.manufacturing}</p>
                    <p>Expiry: {item.expiry}</p>
                    <p>Price: {item.price}</p>
                    {/* Add more details to display */}
                  </div>
                </li>
              ))}
            </ul>
          </div>
        )}
      </div>
      </div>
    );
  }
}

export default Searchproduct;
