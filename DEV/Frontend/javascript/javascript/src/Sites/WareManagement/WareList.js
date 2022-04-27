import React, {Component} from "react";
import WareADD from ".//WareADD";
import "../../Extensions/Styles/Ware.css"
import {WareGet} from "../../Requests/RequestsWare";
import WareChange from "./WareChange";
import SiteHead from "../../Extensions/Component/SiteHead";
import Table from "react-bootstrap/Table";

class Warenliste extends Component{
    constructor(props) {
        super(props);
        this.state= {
            ware: [],
            isLoading: false,
            isError: false,
            id: 0,
            name: 0,
            anzahl:0
        }
        this.onClickHandler = this.onClickHandler.bind(this);
    }
    //Methodenaufruf beim öffnen vom Component
    async componentDidMount() {
        const ware = await WareGet();
        this.setState({ware, isLoading:false})

    }
    //Methode für die Darstellung des Kopfes der Tabelle
    renderTableHeader(){
        return Object.keys(this.state.ware[0]).map(attr => <th key={attr} className="Ware-TH"> {attr.toUpperCase()}</th>
        )
    }
    //Suche der Ware anhand der ID
    onClickHandler(id){
        console.log(id)
        this.state.ware.map(ware => {
            if (ware.id == id) {
                this.setState({
                        id: ware.id,
                        name: ware.name,
                        anzahl: ware.anzahl
                    }
                )
                alert(ware.name);
            }
        });
    }
    //Methode für die Zeilenwerte
    renderTableRows(){
        return this.state.ware.map(ware => {
            return(
                <tr key={ware.id} className="Ware-TD">
                    <td className="Ware-TD">{ware.id}</td>
                    <td className="Ware-TD">{ware.name}</td>
                    <td className="Ware-TD">{ware.anzahl}</td>
                </tr>

                            )
        })
    }
    render() {
        return this.state.ware.length > 0
            ? (
                <div>
                    <SiteHead/>
                    <table className="Ware-Tabelle">
                        <thead>
                        <tr>
                            {this.renderTableHeader()}
                        </tr>
                        </thead>
                        <tbody>
                        {this.renderTableRows()}
                        </tbody>
                    </table>
                    <WareChange ware={this.state.ware}/>
                    <WareADD/>
                </div>
                ) : (

                <div> Keine Ware vorhanden</div>
            )
    }
}

export default Warenliste;
