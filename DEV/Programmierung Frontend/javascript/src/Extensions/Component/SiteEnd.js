import React, {Component} from "react";
import CheckBackendConnection from "./CheckBackendConnection";

class SiteEnd extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div>
                <CheckBackendConnection></CheckBackendConnection>
            </div>
        )
    }

}

export default SiteEnd