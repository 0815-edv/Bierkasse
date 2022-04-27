import React, {Component} from "react";
import {BenutzerChange, BenutzerGuthaben, BenutzerLoeschen} from "../../Requests/RequestsBenutzer";
import "../../Extensions/Styles/Benutzer.css"
import {Button, Col, Form, Row} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

class BenutzerItemChange extends Component{
    actuellBenutzer= {
        id:0,
        name:null,
        vorname:null,
        guthaben:null,
        chipid:null
    };
    //State definieren
    constructor(props) {
        super(props);
        this.state= {
            userSet: false,
            benutzer: null,
            id: null,
            name: null,
            vorname: null,
            guthaben: null,
            chipid: null,
            guthabenerhoehen:"",
            guthabenverringern:"",


        }
        //Methodenaufrufe definieren
        this.handleChange = this.handleChange.bind(this);
        this.searchUserByID = this.searchUserByID.bind(this);
        this.saveChanges = this.saveChanges.bind(this);
        this.handleSubmit= this.handleSubmit.bind(this);
        this.delUserbyID = this.delUserbyID.bind(this);


}
    //Globale SET-State anpassung
    handleChange(event){
        this.setState({
            [event.target.name]: event.target.value
            }
        )
    }
    //Behält den Fokus auf einer Site und aktualisiert diese nicht nach jedem Button Click.
    handleSubmit(event) {
        event.preventDefault();
    }
    //Methodenaufruf beim öffnen vom Component
    componentDidMount() {
        this.setState({
            benutzer: this.props.benutzer
        })
    }
    //Methode zur Suche von Benutzern
    searchUserByID(){
    if (this.state.id != null) {
        this.state.benutzer.map(user => {
            if (user.id == this.state.id) {
                this.setState({
                        name: user.name,
                        vorname: user.vorname,
                        chipid: user.chipid,
                        guthaben: user.guthaben,
                        userSet: true
                    }
                )
                //Der Zweite Benutzer dient zur Überprüfung ob sich daten am stammuser geändert haben.
                this.actuellBenutzer = {
                    id: user.id,
                    name: user.name,
                    vorname: user.vorname,
                    guthaben: user.guthaben,
                    chipid: user.chipid
                }
            }


        });
    }
    else {
        alert("BenutzerID bitte eingeben");
    }

}
    //Methode für das Löschen von Benutzern
    delUserbyID(){
        let id = this.state.id;
        const result = BenutzerLoeschen(id)

    }
    //Methode für die Änderung von Benutzerwerten mit überprüfungsvariablen
    async saveChanges(){
        let id = this.state.id;
        if (this.actuellBenutzer.name !== this.state.name || this.actuellBenutzer.vorname !== this.state.vorname || this.actuellBenutzer.chipid !== this.state.chipid){
            const result = await BenutzerChange(id, this.state.name, this.state.vorname, this.state.chipid);
        }
        else{

        }
        if (this.state.guthabenerhoehen > 0 && this.state.guthabenverringern === ""){
            await BenutzerGuthaben(this.state.id, this.state.guthabenerhoehen, "add");


        }
        else if(this.state.guthabenverringern >0 && this.state.guthabenerhoehen ===""){
            await BenutzerGuthaben(this.state.id, this.state.guthabenverringern, "sub");

        }
        else if(this.state.guthabenverringern === "" && this.state.guthabenerhoehen === ""){
            this.setState({
                guthabenverringern: "",
                guthabenerhoehen: ""
            })
        }
        else{
            alert("Guthabenänderungen nur auf einer Maske ausführen")
        }

    }

    //RenderMethode für die Darstellung
    render(){
       return (
            <div>
                <Form onSubmit ={this.handleSubmit}>
                    <Row>
                  <Form.Group as={Col} controlId="formGridID">
                      <Form.Label> Benutzer anhand der ID auswählen </Form.Label>
                      <Form.Control type="id" placeholder="ID" name="id" onChange={this.handleChange} value={this.state.id}/>

                  </Form.Group>
                        <Button size="lg" onClick={this.searchUserByID}> Auswählen</Button>
                    </Row>
                    <Row>
                        <Form.Group as={Col} controlId="formGridName">
                            <Form.Label>Vorname: </Form.Label>
                            <Form.Control name="vorname" onChange={this.handleChange} value={this.state.vorname} />
                        </Form.Group>
                    <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label>Name: </Form.Label>
                            <Form.Control name="name" onChange={this.handleChange} value={this.state.name} />
                    </Form.Group>
                        <Form.Group as={Col} controlId="formGridCHIPID">
                            <Form.Label>CHIPID: </Form.Label>
                            <Form.Control name="chipid" onChange={this.handleChange} value={this.state.chipid} />
                            <Form.Label/>
                        </Form.Group>
                    </Row>
                    <h1>Guthaben Vewalten + Aktuelles Guthaben: {this.state.guthaben} €</h1>
                    <Row>
                        <Form.Group as={Col} controlId="formGridGuthabenErhoehen">
                            <Form.Label>Guthaben erhöhen</Form.Label>
                            <Form.Control name="guthabenerhoehen" value={this.state.guthabenerhoehen} onChange={this.handleChange} />
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridGuthabenVerringern">
                            <Form.Label>Guthaben verringern</Form.Label>
                            <Form.Control name="guthabenverringern" value={this.state.guthabenverringern} onChange={this.handleChange} />
                            <Form.Label/>
                        </Form.Group>
                    </Row>
                </Form>
                <form>
                    <Row>
                        <Form.Group as={Col} controlId="formGridBtnSave">
                            <Button type="submit" onClick={this.saveChanges}> Änderungen Speichern</Button>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridBtnDelete">
                            <Button type="submit" value="Benutzer Löschen" onClick={() => { if (window.confirm('Sind sie sich sicher das Objekt zu löschen?'))this.delUserbyID() } }> Benutzer Löschen</Button>
                        </Form.Group>
                    </Row>
                </form>


            </div>
        )

    }
}
export default BenutzerItemChange