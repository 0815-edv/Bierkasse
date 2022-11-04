import React, {Component} from "react";
import { KaeufeGET } from "../../Requests/RequestKaeufe";
import SiteHead from "../../Extensions/Component/SiteHead";
import "../../Extensions/Styles/KaeufeList.css"


class KaeufeList extends Component{
    constructor(props) {
        super(props);

        this.state={
            kaeufe: [],
            isLoading: false
        }
    }
    //Methodenaufruf beim öffnen vom Component
    async componentDidMount(){
        const result = await KaeufeGET();
        this.setState({
            kaeufe: result
        })
    }
    //Methode für die Zeilenwerte
    renderTableRows(){
        return this.state.kaeufe.map(kaeufe => {
            return(
                <tr key={kaeufe.id}>
                    <td className="Kaeufe-TD">{kaeufe.id}</td>
                    <td className="Kaeufe-TD">{kaeufe.datum}</td>
                    <td className="Kaeufe-TD">{kaeufe.user.name}</td>
                    <td className="Kaeufe-TD">{kaeufe.user.vorname}</td>
                    <td className="Kaeufe-TD">{kaeufe.ware.name}</td>
                </tr>
            )
        })
    }
    render() {
        return(
            <div>
                <SiteHead></SiteHead>
                <h1>Übersicht aller Käufe</h1>
                    <table className="Kaeufe-Tabelle">
                        <thead className="Kaeufe-TH">
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    Datum
                                </th>
                                <th>
                                    Name
                                </th>
                                <th>
                                    Vorname
                                </th>
                                <th>
                                    Getränk
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
export default KaeufeList;