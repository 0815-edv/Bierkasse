import React, {Component} from "react";
import "../Styles/SiteHead.css";
import {Link} from "react-router-dom";
import Clock from "./Clock";

class SiteHead extends Component {
    render() {
        return (
            <div>
                <Link className="Button-zurueck" to="/">zurück</Link>
                <Clock></Clock>
                <br/>
            </div>
        );
    }

}
export default SiteHead;