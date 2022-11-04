import React, {Component} from "react";
import {checkbackend} from "../../Requests/ReactCheckConnection";
import {Form} from "react-bootstrap";

class CheckBackendConnection extends Component {
    constructor(props) {
        super(props);

        this.state = {
            isLoaded: null
        }
        this.connectionhandler = this.connectionhandler.bind(this);
    }



     componentDidMount() {
        this.connectionhandler()
        this.timerID = setInterval(
            () => this.connectionhandler(),
            5000

        )
    }

     async connectionhandler() {
         let result = await checkbackend()
         this.setState({
                 isLoaded: result
             }
         )
     }
    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    render() {

        let output = null
        if (this.state.isLoaded === true){
            output = <label>Connection: Successful</label>

        }
        else if (this.state.isLoaded ===null){
            output = <label>Connection: Waiting</label>
        }
        else{
            output = <label>Connection: Failed</label>
        }
        return (
            <div>
                {output}
        </div>
        )

    }
}
export default CheckBackendConnection
