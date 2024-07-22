import { Component } from "react";
import './StatesExample.css';

class StatesExample extends Component {

    constructor() {
        super();

        this.state = {
            message: 'Subscribe Our Channel To Get More Updates'
        }

    }


    render() {
        return <div className="sameline">
            <h3>{this.state.message}</h3>
            <button  onClick={() => this.changeStateValue()} type="button">Subscribe</button>
        </div>
    }


    changeStateValue() {
        this.setState({
            message: 'Thank you for subscribing our channel.'
        })
    }
}

export default StatesExample