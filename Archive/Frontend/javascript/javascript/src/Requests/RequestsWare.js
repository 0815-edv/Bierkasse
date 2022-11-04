//URL Festlegung
const url = "http://backend.werner-intern.cloud:8080";

//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function WareGet() {
    try {
        //Aufruf des HTTP-Requestes anhand von Fetch
        const response = await fetch(url + "/ware/get", {
            method: 'GET',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (response.ok) {
            const ware = await response.json()
            return ware;
        }
    } catch (err) {
        return false;
    }
}
//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function WareAnzahl(id, anzahl, arithmetik) {
    const putdata = {
        id: id,
        anzahl: anzahl,
        arithmetik: arithmetik
    }
    let response = null;
    try {
        if (arithmetik == "add") {
            response = await fetch(url + "/ware/anzahl/add?id=" + putdata.id + "&anzahl=" + putdata.anzahl, {
                method: 'PATCH',
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },

            });
            console.log(response);
        } else if (arithmetik == "sub") {
            response = await fetch(url + "/ware/anzahl/sub?id=" + putdata.id + "&anzahl=" + putdata.anzahl, {
                method: 'PATCH',
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },

            });
        }

        if (!response.ok) {
            const message = "Error: " + response.status + response.statusText;
            return new Error(message);
        }
        if (response.ok) {
            return response.ok;
        }


    } catch (err) {
        return false;
    }
}

//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function WareCreate(artikelname, anzahl) {
    const putdata = {
        name: artikelname,
        anzahl: anzahl
    }
    let response = null;
    try {
        response = await fetch(url + "/ware/add?Artikelname=" + putdata.name + "&anzahl=" + putdata.anzahl, {
            method: 'POST',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },

        });

    } catch (err) {
        return false;
    }
}
//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function WareDelete(id) {
    const putdata = {
        id: id,
    }
    let response = null;
    try {
        response = await fetch(url + "/ware/del?id=" + putdata.id, {
            method: 'DELETE',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },

        });

    } catch (err) {
        return false;
    }
}