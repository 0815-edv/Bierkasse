import React, {Component} from "react";
import {GuthabenRevisionGet} from "../../Requests/RequestsGuthaben";
import "../../Extensions/Styles/GuthabenRevision.css";
import SiteHead from "../../Extensions/Component/SiteHead";

class GuthabenRevision extends Component{
    constructor(props) {
        super(props);
        this.state = ({
            guthaben: [],
            isLoading: false,
            isError: false
        })
        this.checkStatus = this.checkStatus.bind(this);

    }
    //Methodenaufruf beim öffnen vom Component
    async componentDidMount(){
        const guthabenrevision = await GuthabenRevisionGet();
        this.setState({
            guthaben: guthabenrevision
        })


    }
    //Ausgabe des Status Types
    checkStatus(dear){
        if (dear == "true"){
            return "Gehnemigt"
        }
        if (dear == "false"){
            return "Abgelehnt"
        }
        if (dear == ""){
            return "Fehler"
        }
    }
    //Methode für die Zeilenwerte
    renderTableRows(){
        return this.state.guthaben.map(guthaben => {
            return(
                <tr key={guthaben.id}>
                    <td className="Guthaben-TD">{guthaben.id}</td>
                    <td className="Guthaben-TD">{guthaben.benutzer.name}</td>
                    <td className="Guthaben-TD">{guthaben.benutzer.vorname}</td>
                    <td className="Guthaben-TD">{guthaben.wert + "€"}</td>
                    <td className="Guthaben-TD">{guthaben.acceptDate}</td>
                    <td className="Guthaben-TD">{this.checkStatus(guthaben.status.toString())}</td>
                </tr>
            )
        })
    }

    render() {
        return(
        <div>
            <SiteHead></SiteHead>
            <h1>Historie der Guthabenanträge</h1>
            <table className="Guthaben-Tabelle">
                <thead>
                    <tr className="Guthaben-TH">
                        <th >
                            ID
                        </th>
                        <th>
                            Name
                        </th>
                        <th>
                            Vorname
                        </th>
                        <th>
                            Wert
                        </th>
                        <th>
                            Datum
                        </th>
                        <th>
                            Status
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {this.renderTableRows()}
                </tbody>
            </table>
        </div>
        )
    }



}
export default GuthabenRevision