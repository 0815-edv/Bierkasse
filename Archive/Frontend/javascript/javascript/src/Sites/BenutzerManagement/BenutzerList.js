import React, {Component} from "react";
import '../../Extensions/Styles/Benutzer.css'
import BenutzerItemChange from "./BenutzerItemChange";
import { BenutzerGet } from "../../Requests/RequestsBenutzer";
import SiteHead from "../../Extensions/Component/SiteHead";
import BenutzerADD from "./BenutzerADD";


class BenutzerListe extends Component{

    constructor(props) {
        super(props);

        this.state= {
            benutzer: [],
            isLoading: false,
            isError: false,


        }

    }
    //Methodenaufruf beim öffnen vom Component
    async componentDidMount() {
        const benutzer = await BenutzerGet();
        this.setState({benutzer, isLoading: false})
    }
    //Methode für den Table Kopf
    renderTableHeader(){
        return Object.keys(this.state.benutzer[0]).map(attr => <th key={attr} className='Benutzer-TH'> {attr.toUpperCase()}</th>
        )
    }
    //Methode für die Zeilenwerte
    renderTableRows(){
        return this.state.benutzer.map(benutzer => {
            return(
            <tr key={benutzer.id} className="Benutzer-TD">
                <td className="Benutzer-TD">{benutzer.id}</td>
                <td className="Benutzer-TD">{benutzer.name}</td>
                <td className="Benutzer-TD">{benutzer.vorname}</td>
                <td className="Benutzer-TD">{benutzer.guthaben}</td>
                <td className="Benutzer-TD">{benutzer.chipid}</td>
            </tr>
            )
        })
    }

//RenderMethode für die Darstellung
    render() {
        return this.state.benutzer.length > 0
            ? (
                <div>
                    <SiteHead/>
                    <table className="Benutzer-Tabelle">
                        <thead>
                        <tr>
                            {this.renderTableHeader()}
                        </tr>
                        </thead>
                        <tbody>
                        {this.renderTableRows()}
                        </tbody>
                    </table>
                    <BenutzerItemChange benutzer={this.state.benutzer}/>
                    <BenutzerADD/>
                </div>
            ) : (
                <div>
                    <SiteHead/>
                    No Users
                </div>
            )
    }

}
export default BenutzerListe;