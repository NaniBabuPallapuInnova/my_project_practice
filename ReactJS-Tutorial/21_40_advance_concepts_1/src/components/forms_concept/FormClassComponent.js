import { Component } from "react";
class FormClassComponent extends Component {

    state = {
        fullName: '',
        message: ''
    };

    // for single state or single property(only for fullName)
    /*
    handleChanges = (event) => {
        this.setState(
            { fullName: event.target.value },
        )
    };
    */

    handleChanges = (event) => {
        const {name, value} = event.target;
        this.setState(
            {
                [name]: value,
            }
        )
    };

    render() {
        return (
            <div>
                <h4>Controlled Class Component</h4>
                <form>
                    <input type="text" name="fullName" value={this.state.fullName} placeholder="enter full name" onChange={this.handleChanges} />
                    <input type="text" name="message" value={this.state.message} placeholder="enter you message" onChange={this.handleChanges} />

                    <pre>Entered FullName : {this.state.fullName}</pre>
                    <pre>Entered Message : {this.state.message}</pre>

                </form>
            </div>
        )
    }
}

export default FormClassComponent