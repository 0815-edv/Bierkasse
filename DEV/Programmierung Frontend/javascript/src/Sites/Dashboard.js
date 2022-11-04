import React, {Component} from "react";
import {Link} from "react-router-dom";
import CheckBackendConnection from "../Extensions/Component/CheckBackendConnection"
//JavaScript Klasse für das Dashboard
class Dashboard extends Component{
    constructor(props) {
        super(props);

    }
//RenderMethode für die Darstellung
// Implementierung des Component CheckBackendConnection
    render() {
        return(
            <div>
                <h1>Dashboard</h1>
                <nav>
                    <Link to="/app">Benutzerverwaltung</Link>
                    <br/>
                    <Link to="/ware">Warenverwaltung</Link>
                    <br/>
                    <Link to="/guthabenauftraege">Auftrag Guthaben</Link>
                    <br/>
                    <Link to="/guthabenrevision">Revision Guthaben</Link>
                    <br/>
                    <Link to="/kaeufe">Kauf Historie</Link>
                </nav>
                <br/>
                <CheckBackendConnection></CheckBackendConnection>
            </div>
        )
    }


}
export default Dashboard