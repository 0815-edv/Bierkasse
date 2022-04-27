//URL Festlegung
const url = "http://backend.werner-intern.cloud:8080";

//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function BenutzerGet() {
    try{
        const response = await fetch(url + "/benutzer/get", {
            method: 'GET',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        //console.log(response.json())
        if (response.ok) {
            const benutzer = await response.json();
            return benutzer;
        }
    }
    catch (err){
        return false
    }
}

export async function BenutzerAdd(name, vorname, chipid) {
    try {
        const response = await fetch(url + "/benutzer/add?vorname=" + vorname + "&name=" + name + "&chipid=" + chipid, {
            method: 'POST',
            mode: "cors",
        });
        if (response.ok) {
            return true
        } else {
            return false
        }
    }
    catch(err){
        return false
    }
}

export async function BenutzerChange(id, name, vorname, chipid){
    const putdata = {
        id: id,
        name: name,
        vorname: vorname,
        chipid: chipid
    }
    try {
        const response = await fetch(url +"/benutzer/change?id="+putdata.id+"&name=" + putdata.name + "&vorname="+putdata.vorname+"&chipid="+putdata.chipid, {
            method: 'PUT',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },

        });
        console.log(response);

        if (!response.ok){
            const message ="Error: " + response.status + response.statusText;
            return new Error(message);
        }
        if (response.ok){
            return response.ok;
        }


    }
    catch(err){
        return false;
    }
}

export async function BenutzerGuthaben(id, guthaben, arithmetik){
    const putdata = {
        id: id,
        guthaben: guthaben,
        arithmetik: arithmetik
    }
    let response = null;
    try {
        if (arithmetik == "add") {
            response = await fetch(url + "/benutzer/guthaben/add?id=" + putdata.id + "&guthaben=" + putdata.guthaben, {
                method: 'PATCH',
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },

            });
            console.log(response);
        }
        else if (arithmetik =="sub") {
             response = await fetch(url + "/benutzer/guthaben/sub?id=" + putdata.id + "&guthaben=" + putdata.guthaben, {
                method: 'PATCH',
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },

            });
        }
        if (!response.ok){
            const message ="Error: " + response.status + response.statusText;
            return message;
        }
        if (response.ok){
            return response.ok;
        }

    }
    catch(err){
        return false;
    }
}

export async function BenutzerLoeschen(id){
    const putdata = {
        id: id,
       }
    try {
        const response = await fetch(url + "/benutzer/del/id?id=" + putdata.id, {
            method: 'DELETE',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },

        });
        console.log(response);

        if (!response.ok) {
            const message = "Error: " + response.status + response.statusText;
            return new Error(message);
        }
        if (response.ok) {
            return response.ok;
        }
    }
    catch(err){
        return false;
    }
}


