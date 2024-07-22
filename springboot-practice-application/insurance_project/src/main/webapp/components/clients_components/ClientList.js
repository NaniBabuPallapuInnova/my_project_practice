import React, { Component } from "react";
import ClientService from "../../services/ClientService";

class ClientList extends Component {
    constructor() {
        super();
        this.state = {
            message: 'this is default message',
        };
    }

    // Use async/await correctly to handle the promise
    gettingMessage = async () => {
        try {
            const msg = await ClientService.getFirstMessage(); // Wait for the promise to resolve
            this.setState({ message: msg }); // Update state with the resolved value
        } catch (error) {
            console.error("Failed to fetch message:", error);
            this.setState({ message: "Failed to fetch message" }); // Set an error message if needed
        }
    };
    
    render() {
        return (
            <div>
                <button type="button" onClick={this.gettingMessage} className="btn btn-primary">
                    Show Message
                </button>
                <h3>{this.state.message}</h3>
            </div>
        );
    }
}

export default ClientList;
