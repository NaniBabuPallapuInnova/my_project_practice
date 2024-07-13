import { Component } from "react";

class Counter extends Component {

    constructor() {

        super();
        this.state = {
            count: 0
        }
    }

    incrementCountValue() {
        // this.setState({
            
        //     count:  this.state.count + 1
        // },
        //     () => { console.log('CallBack Value After Increment :' + this.state.count) }
        // )

        // otherway
        this.setState( prevState => ({
            count : prevState.count  + 1
        }))
        console.log('CallBack Value After Increment :' + this.state.count)
    }

    decrementCountValue() {
        // this.setState({
        //     count: this.state.count - 1
        // },
        //     () => { console.log('CallBack Value After Decrement : ' + this.state.count) }
        // )

        //otherway
        this.setState(prevState => ({
            count : prevState.count - 1
        }))

        console.log('CallBack Value After Decrement : ' + this.state.count)
    }
    render() {
        return (
            <div className="settingLine">
                <button onClick={() => this.decrementCountValue()} type="button">-</button>
                <h3>Count : {this.state.count}</h3>
                <button onClick={() => this.incrementCountValue()} type="button">+</button>
            </div>
        )
    }


}

export default Counter