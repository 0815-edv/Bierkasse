import React, {Component} from "react";
import {WareCreate} from "../../Requests/RequestsWare";
import {Button, Col, Form, Row} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'



class WareADD extends Component{

    constructor(props) {
        super(props);
        this.state={
            addWare:"",
            addAnzahl:""
        }
        //Methodenaufrufe definieren
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.addWare = this.addWare.bind(this);

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
    //Aufruf HTTP-Request
    async addWare(){
        if(this.state.addWare !== "" && this.state.addAnzahl >0) {
            const result = await WareCreate(this.state.addWare, this.state.addAnzahl);
        }
    }
//Ausgabe der Buttons und Textfelder mit dem Bootstrap CSS Style
    render() {
        return (
            <div>
                <Form>
                    <h1>Neue Ware anlegen: </h1>
                    <Row>
                        <Form.Group as={Col} controlId="formGridaddWare">
                            <Form.Label>Name: </Form.Label>
                            <Form.Control type="ware" name="addWare" onChange={this.handleChange} value={this.state.addWare}/>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAddName">
                            <Form.Label>Anzahl: </Form.Label>
                            <Form.Control type="anzahl" name="addAnzahl" onChange={this.handleChange} value={this.state.addAnzahl}/>
                        </Form.Group>
                        <Form.Group>
                            <Button type="submit" onClick={this.addWare}> Erstellen</Button>
                        </Form.Group>
                    </Row>
                </Form>
            </div>
        )

    }


}
export default WareADD