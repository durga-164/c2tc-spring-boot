import React, { Component } from "react";

class InsertItems extends Component {
  constructor(props) {
    super(props);
    this.state = {
      insertionMessage: "",
      error: null,
    };
  }

  handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const itemData = {
      category: formData.get("category"),
      expiry: formData.get("expiry"),
      manufacturing: formData.get("manufacturing"),
      name: formData.get("name"),
      price: parseFloat(formData.get("price")),
    };

    try {
      const response = await fetch("http://localhost:8080/item/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(itemData),
      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }

      this.setState({
        insertionMessage: "Item inserted successfully",
        error: null,
      });
    } catch (error) {
      console.error("Error:", error.message);
      this.setState({
        error: "Failed to insert item. Please try again.",
        insertionMessage: "",
      });
    }
  };

  render() {
    return (
      <div className="parentdiv">
        <h1 style={{ color: "white", fontFamily: "monospace", fontSize: "40px" }}>
          <center>Insert items to MAX MART shopping list</center>
        </h1>

        <div className="modifydiv">
          <form onSubmit={this.handleSubmit}>
            <div className="form-group">
              <label htmlFor="name">Enter item name:</label>
              <input type="text" id="name" name="name" placeholder="cinnamon" required />
            </div>

            <div className="form-group">
              <label htmlFor="price">Enter item price:</label>
              <input type="text" id="price" name="price" placeholder="300" required />
            </div>

            <div className="form-group">
              <label htmlFor="category">Enter item category:</label>
              <input type="text" id="category" name="category" placeholder="grocery" required />
            </div>

            <div className="form-group">
              <label htmlFor="manufacturing">Enter item manufacturing date:</label>
              <input type="text" id="manufacturing" name="manufacturing" placeholder="YYYY-MM-DD" required />
            </div>

            <div className="form-group">
              <label htmlFor="expiry">Enter item expiry date:</label>
              <input type="text" id="expiry" name="expiry" placeholder="YYYY-MM-DD" required />
            </div>

            <button type="submit" id="insert">
              INSERT ITEM
            </button>

            {this.state.insertionMessage && (
              <p style={{ color: "black", backgroundColor:'white', textAlign:'center' }}>{this.state.insertionMessage}</p>
            )}
            {this.state.error && <p style={{ color: "red" }}>{this.state.error}</p>}
          </form>
        </div>
      </div>
    );
  }
}

export default InsertItems;
