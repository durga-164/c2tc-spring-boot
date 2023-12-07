import React, { Component } from "react";

class DeleteProduct extends Component {
  constructor(props) {
    super(props);
    this.state = {
      itemId: "",
      error: null,
      deletionMessage: "",
    };
  }

  handleItemIdChange = (event) => {
    this.setState({ itemId: event.target.value });
  };
  handleItemDelete = (event) => {
    event.preventDefault();
  
    fetch(`http://localhost:8080/item/delete/${this.state.itemId}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        // Add any necessary headers (e.g., authorization token) here
      },
    })
      
    .then((data) => {
      // Handle successful JSON response here if needed
      console.log("Item deleted successfully", data);
      this.setState({ itemId: "", error: null, deletionMessage: "Item deleted successfully" });
    })
      .catch((error) => {
        // Handle errors here
        console.error("Error deleting item:", error);
        this.setState({ error: "Failed to delete item. Please try again." });
      });
  };
  

  render() {
    return (
      <div className="deletediv">
        <center>
          <h1 style={{ color: "white", fontFamily: "monospace", fontSize: "40px" }}>DELETE ITEMS FROM MAX MART</h1>
        </center>
        <form>
          <div className="deleteform">
            <label htmlFor="del">Enter ID of the item to be deleted</label>
            <input type="text" id="del" onChange={this.handleItemIdChange} value={this.state.itemId} placeholder="enter item id"></input>
            <br></br>
            <button type="submit" id="deletebutton" onClick={this.handleItemDelete}>
              DELETE ITEM
            </button><div><center>
            {this.state.deletionMessage && <p id="errorp">{this.state.deletionMessage}</p>}</center></div>
          </div>
        </form>
      </div>
    );
  }
}

export default DeleteProduct;
