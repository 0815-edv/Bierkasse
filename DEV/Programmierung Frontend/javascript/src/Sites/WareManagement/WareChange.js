import React, {Component} from "react";
import {WareCreate, WareAnzahl, WareDelete} from "../../Requests/RequestsWare";
import {Button, Col, Form, Row} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

class WareChange extends Component{
    constructor(props) {
        super(props);
        this.state= {
            ware: [],
            id: "",
            name:"",
            anzahl: "",
            veraendernAnzahl:"",
            addWare:"",
            addAnzahl:""

        }
        this.handleChange = this.handleChange.bind(this);
        this.searchWareByID= this.searchWareByID.bind(this);
        this.addWare = this.addWare.bind(this);
        this.changeWare= this.changeWare.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        }
    //Behält den Fokus auf einer Site und aktualisiert diese nicht nach jedem Button Click.
    handleSubmit(event) {
        event.preventDefault();
    }
    //Globale SET-State anpassung

    handleChange(event){
        this.setState({
            [event.target.name]: event.target.value,

        })
    }
    //Methode Waren suchen anhand der OD
    searchWareByID(){
        if (this.state.id != null) {
            this.props.ware.map(ware => {
                if (ware.id == this.state.id) {
                    console.log(ware)
                    this.setState({
                            id: ware.id,
                            name: ware.name,
                            anzahl: ware.anzahl,
                        }
                    )
                }

            });
        }
    }
    //Methode für die Änderung von Waren
    async changeWare(arithmetik){
        if(this.state.id !== "" && this.state.anzahl >0) {
            const result = await WareAnzahl(this.state.id, this.state.veraendernAnzahl, arithmetik)
        }
    }
    //Methode für das Löschen von Waren
    async deleteWare(){
        if(this.state.id !== "" && this.state.anzahl >0) {
            const result = await WareDelete(this.state.id)
        }
    }
    //Methode für die Erstellung einer Ware
    async addWare(){
        if(this.state.addWare !== "" && this.state.addAnzahl >0) {
            const result = await WareCreate(this.state.addWare, this.state.addAnzahl);
        }
    }

    render() {
        return(
            <div>
                <Form>
                    <Row>
                        <Form.Group as={Col} controlId="formGridID">
                            <Form.Label> Ware anhand der ID auswählen </Form.Label>
                            <Form.Control type="id" placeholder="ID" name="id" onChange={this.handleChange} value={this.state.id}/>

                        </Form.Group>
                        <Button size="lg" onClick={this.searchWareByID} onSubmit ={this.handleSubmit}> Auswählen</Button>
                        </Row>
                    <Row>
                        <Form.Group as={Col} controlId="formGridName">
                            <Form.Label> Name  </Form.Label>
                            <Form.Control type="name" name="name" onChange={this.handleChange} value={this.state.name}/>
                        </Form.Group>
                    </Row>
                    <Row>
                        <Form.Group as={Col} controlId="formGridAnzahl">
                            <Form.Label> Anzahl  </Form.Label>
                            <Form.Control type="anzahl" name="veraendernAnzahl" onChange={this.handleChange} value={this.state.veraendernAnzahl}/>
                            <Button onClick={() =>this.changeWare("add")} type="submit"> Anzahl Erhöhen</Button>
                            <Button onClick={() =>this.changeWare("sub")} type="submit"> Anzahl Verringern</Button>
                        </Form.Group>
                    </Row>
                    <Row>
                        <Form.Group as={Col} controlId="fromGridDelete">
                            <br/>
                            <Button onClick={() => { if (window.confirm('Sind sie sich sicher das Objekt zu löschen?'))this.deleteWare() } } type="submit">Löschen</Button>
                        </Form.Group>
                    </Row>
                <br/>
                </Form>
            </div>
        )
    }

}
export default WareChange