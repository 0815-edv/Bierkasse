//URL Festlegung
const url = "http://backend.werner-intern.cloud:8080";

//Asynchrone Methode für die Durchführung der HTTP-Requests
export async function checkbackend(){
    try {
        const response = await fetch(url + "/benutzer/get", {
            method: 'GET',
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (response.ok) {
            return true

        }
        if (!response.ok) {
            return false

        }
    } catch (err) {
        return false
    }
}