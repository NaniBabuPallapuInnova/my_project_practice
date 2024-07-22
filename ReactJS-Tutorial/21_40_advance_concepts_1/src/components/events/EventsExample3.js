import React, { Component } from "react";

class EventsExample3 extends Component{

    exampleMethod(){
        console.log(this)
    }


    render() {
        return (
            <div>
                <h3>Welcome to my world</h3>
                <button type="button" onClick={this.exampleMethod.bind(this)}>Click Me</button>
            </div>
        )
    }
}

export default EventsExample3 