import { Component } from "react"

class User extends Component {

    constructor(props){
        super();
        this.state = {
            loggedIn : true,
        }
    }
    render() {

        
        

        //approach - 1
        if(this.state.loggedIn){
            return <div><b>User LoggedIn</b></div>
        } else{
            return <div><b>User Logged Out</b></div>
        }

        

        /*
        //approach - 2
        let message
        if(this.state.loggedIn){
            message =  <div><b>User LoggedIn</b></div>
        } else{
            message =  <div><b>User Logged Out</b></div>
        }
        return <div>{message}</div>

        */

        //approach - 3
        // return this.state.loggedIn ? <div><b>User LoggedIn</b></div> : <div><b>User Logged Out</b></div>

        //approach - 4
        // return this.state.loggedIn && <div><b>User LoggedIn</b></div> 

    }
}

export default User