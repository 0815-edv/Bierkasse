import React, {Component} from "react";
import BenutzerListe from "./Sites/BenutzerManagement/BenutzerList";


class App extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <BenutzerListe></BenutzerListe>
            </div>
        );
    }
}
export default App;
