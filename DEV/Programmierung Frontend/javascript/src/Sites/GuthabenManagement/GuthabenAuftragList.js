import React, {Component} from "react";
import {GuthabenAntragAccept, GuthabenAntragDeny, GuthabenGet} from "../../Requests/RequestsGuthaben";
import "../../Extensions/Styles/GuthabenAuftrag.css"
import SiteHead from "../../Extensions/Component/SiteHead";
import GuthabenAuftragRequest from "./GuthabenAuftragRequest";

class GuthabenAuftrag extends Component{
    constructor(props) {
        super(props);

        this.state = ({
            guthaben: [],
        })
    }
    //Methodenaufruf beim öffnen vom Component
    async componentDidMount(){
        const result = await GuthabenGet();
        if (result != null) {
            this.setState({
                guthaben: result,
            })
        }
        else {
            this.setState({
                guthaben: 0,
            })
        }
    }
    //Methode für die Zeilenwerte
    renderTableRows() {
        return this.state.guthaben.map(guthaben => {
            return (
                <tr key={guthaben.id}>
                    <td className="Guthaben-TD">{guthaben.id}</td>
                    <td className="Guthaben-TD">{guthaben.benutzer.name}</td>
                    <td className="Guthaben-TD">{guthaben.benutzer.vorname}</td>
                    <td className="Guthaben-TD">{guthaben.wert + "€"}</td>
                    <td className="Guthaben-TD">{guthaben.addDatum}</td>
                </tr>

        )
        })
    }
render() {
    return this.state.guthaben.length > 0 ?(
        <div>
            <SiteHead></SiteHead>
        <h1>Guthaben Aufträge Verwalten -- Gehnemigen//Annehmen</h1>
        <table className="Guthaben-Tabelle">
            <thead>
                <tr className="Guthaben-TH">
                    <th>
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
                        Antragsdatum
                    </th>
                </tr>
            </thead>
            <tbody>
                {this.renderTableRows()}
            </tbody>
        </table>
        <br/>
            <GuthabenAuftragRequest></GuthabenAuftragRequest>
        </div>
    ) :(
        <div>
            <SiteHead></SiteHead>
            <h1>Keine Anträge vorhanden</h1>
            </div>
    )
}


}
export default GuthabenAuftrag