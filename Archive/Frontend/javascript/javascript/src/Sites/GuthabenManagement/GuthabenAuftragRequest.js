import {Component} from "react";
import {GuthabenAntragAccept, GuthabenAntragDeny} from "../../Requests/RequestsGuthaben";
import {Button, Col, Form, Row} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css'

class GuthabenAuftragRequest extends Component{
    constructor(props) {
        super(props);
        this.state = {
          id: ""
        }
        //Methodenaufruf definieren
        this.acceptRequest = this.acceptRequest.bind(this);
        this.denyRequest = this.denyRequest.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }
    //Globale SET-State anpassung
    handleChange(event){
        this.setState({
                [event.target.name]: event.target.value
            }
        )
    }
    //Methodenaufruf um den Antrag zu akzeptieren
    async acceptRequest() {
        const id = this.state.id
        let result = null
        if (id !== "") {
            result = await GuthabenAntragAccept(id)
            if (result === false) {
                alert("Antrag konnte nicht bearbeitet werden")
            }
        }
            else {
                alert("ID auswählen")
            }
        }
        //Methodenaufruf um den Antrag abzulehnen
        async denyRequest(){
            const id = this.state.id
            let result = null
            if (id !== "") {
                result = await GuthabenAntragDeny(id)
                if (result === false){
                    alert("Antrag konnte nicht bearbeitet werden")
                }
            }
            else {
                alert("ID auswählen")
            }

        }

    //RenderMethode für die Darstellung
    render() {
        return(
            <div>
                <Form>
                    <Row>
                        <Form.Group as={Col} controlId="formGridAddVorname">
                            <Form.Label>ID</Form.Label>
                            <Form.Control type="id" name="id" onChange={this.handleChange} value={this.state.id}/>
                        </Form.Group>
                    </Row>

                <Button type="submit" onClick={this.acceptRequest}>Akzeptieren</Button>
                <Button type="submit" onClick={this.denyRequest}>Ablehnen</Button>
                </Form>
            </div>

        )
    }
}
export default GuthabenAuftragRequest