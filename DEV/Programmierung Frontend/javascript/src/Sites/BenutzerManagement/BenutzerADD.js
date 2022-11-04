import React, {Component} from "react";
import {BenutzerAdd} from "../../Requests/RequestsBenutzer";
import {Button, Col, Form, Row} from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

class BenutzerADD extends Component{
    constructor(props) {
        super(props);

        this.state = ({
            name: "",
            vorname: "",
            chipid: null,
            isError: null
        })
        this.addUser = this.addUser.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }
    //Methode für die Benutzererstellung
    async addUser(){
        const user = ({
            name: this.state.name,
            vorname: this.state.vorname,
            chipid: this.state.chipid
        })
        if (user.name !== "" && user.vorname !== "" && user.chipid != null) {
            const result = await BenutzerAdd(user.name, user.vorname, user.chipid)
            if (result === true){
                this.setState({
                isError: false
                    }
                )
            }
            else {
                this.setState({
                        isError: true
                    }
                )
            }
        }
    }
    //Globale SET-State anpassung
    handleChange(event){
        this.setState({
                [event.target.name]: event.target.value
            }
        )
    }
    //RenderMethode für die Darstellung
    render() {
        return (
            <div>
                <h1> Neuen Benutzer Erstellen</h1>
                <Form>
                    <Row>
                        <Form.Group as={Col} controlId="formGridAddVorname">
                            <Form.Label>Vorname: </Form.Label>
                            <Form.Control type="id" placeholder="Vorname" name="vorname" onChange={this.handleChange} value={this.state.vorname}/>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAddName">
                            <Form.Label>Vorname: </Form.Label>
                            <Form.Control type="name" placeholder="Name" name="name" onChange={this.handleChange} value={this.state.name}/>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAddchipid">
                            <Form.Label>Vorname: </Form.Label>
                            <Form.Control type="chipid" placeholder="chipid" name="chipid" onChange={this.handleChange} value={this.state.chipid}/>
                        </Form.Group>
                        <Form.Group>
                            <Button onClick={this.addUser} type="submit"> Erstellen</Button>
                        </Form.Group>
                    </Row>
                </Form>
            </div>
        )


    }

}
export default BenutzerADD




