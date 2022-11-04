//URL Festlegung
const url = "http://backend.werner-intern.cloud:8080";

//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function GuthabenGet() {
    try {
        const response = await fetch(url + "/guthaben/get", {
            method: 'GET',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        if (response.ok) {
            const guthaben = await response.json();
            return guthaben;
        }
        if (!response.ok) {
            return false;
        }
    } catch (err) {
        return false
    }
}

export async function GuthabenRevisionGet() {
    try {
        const response = await fetch(url + "/guthaben/revision/get", {
            method: 'GET',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        //console.log(response.json())
        if (response.ok) {
            const guthaben = await response.json();
            return guthaben;
        }
        if (!response.ok) {
            return false;
        }
    } catch (err) {
        return false
    }
}

export async function GuthabenAntragAccept(id) {
    try {
        const response = await fetch(url + "/guthaben/antrag/accept?AuftragsID=" + id, {
            method: 'POST',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        //console.log(response.json())
        if (response.ok) {
            return true;
        }
        if (!response.ok) {
            return false
        }
    } catch (err) {
        return false
    }
}

export async function GuthabenAntragDeny(id) {
    try {
        const response = await fetch(url + "/guthaben/antrag/deny?AuftragsID=" + id, {
            method: 'POST',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });
        //console.log(response.json())
        if (response.ok) {
            return true;
        }
        if (!response.ok) {
            return false
        }
    } catch (err) {
        return false
    }
}


