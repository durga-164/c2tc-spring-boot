import React, { Component } from "react";

class UpdateItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      itemId: "",
      updatedPrice: "",
      updateMessage: "",
      error: null,
    };
  }

  handleItemIdChange = (event) => {
    this.setState({ itemId: event.target.value });
  };

  handlePriceChange = (event) => {
    this.setState({ updatedPrice: event.target.value });
  };

  handleItemUpdate = async (event) => {
    event.preventDefault();

    const { itemId, updatedPrice } = this.state;

    try {
      const response = await fetch(`http://localhost:8080/item/update/${itemId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ price: parseFloat(updatedPrice) }),
      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }

      const data = await response.json();

      if (data) {
        this.setState({
          updateMessage: "Item updated successfully",
          error: null,
        });
      } else {
        this.setState({
          updateMessage: "Item not found",
          error: null,
        });
      }
    } catch (error) {
      console.error("Error:", error.message);
      this.setState({
        error: "Failed to update item. Please try again.",
        updateMessage: "",
      });
    }
  };

  render() {
    return (
      <div className="a">
        <h1 style={{color: "white", fontFamily: "monospace", fontSize: "40px", textAlign:'center'}}  >Update Item price of products</h1>
        <form>
          <div className="update-div">
            <label>Enter Item ID:</label>
            <input type="text" onChange={this.handleItemIdChange} value={this.state.itemId} id="text1" /><br></br>
        
          
            <label>Enter Updated Price:</label>
            <input type="text" onChange={this.handlePriceChange} value={this.state.updatedPrice} id="text2"/>
          
          <button onClick={this.handleItemUpdate} id="updatebutton">Update Item</button>
          {this.state.updateMessage && <p style={{textAlign:'center'}}>{this.state.updateMessage}</p>}
          {this.state.error && <p>{this.state.error}</p>}
          </div>
        </form>
      </div>
    );
  }
}

export default UpdateItem;
