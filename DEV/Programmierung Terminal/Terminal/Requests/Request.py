from http import HTTPStatus
import requests
from requests.exceptions import ConnectionError as NoConnection

url = "http://backend.werner-intern.cloud:8080/"

#HTTP-Request für das Erhatlen aller Waren
def wareget():
    try:
        r = requests.get(url +"ware/get")
        if r.status_code == 200:
            i = r.json()
            return i
        else:
            return checkHTTPStatus(r)
    except NoConnection:
        return requests.ConnectionError

#HTTP-Request für das durchführen von Käufe
def kaeufeADD(userid, wareid):
    conv_userid = str(userid)
    conv_wareid = str(wareid)
    try:
        r = requests.post(url +"kaeufe/add?userid=" + conv_userid + "&wareid=" + conv_wareid)
        status = checkHTTPStatus(r)
        return status
    except NoConnection:
        return requests.ConnectionError


#HTTP-Request für das Erhalten von Benutzerdaten anhand der CHIPID
def usergetbychipid(id):
    converted_id = str(id)
    try:
        r = requests.get(url +"benutzer/get/chipid?chipid=" + converted_id)
        print(r.status_code)
        if r.status_code == 200:
            i = r.json() #Konvertierung zu JSON Objekt
            return i
        else:
            return checkHTTPStatus(r)
    except NoConnection:
        return requests.ConnectionError





#HTTP-Request für das stellen von Guthaben Anträge
def guthabenAntragADD(userid, guthaben):
    converted_id = str(userid)
    converted_guthaben = str(guthaben)
    try:
        r = requests.post(
            url + "guthaben/antrag/add?user_id=" + converted_id + "&wert=" + converted_guthaben)
        if r.status_code == 200:
            return checkHTTPStatus(r)
    except NoConnection:
        return requests.ConnectionError

##Abfrage Status Code to Exception
def checkHTTPStatus(r):
    if r.status_code == 200:
        return True
    elif r.status_code == 400:
        return HTTPStatus.BAD_REQUEST
    elif r.status_code == 404:
        return HTTPStatus.NOT_FOUND
    elif r.status_code == 406:
        return HTTPStatus.NOT_ACCEPTABLE
    elif r.status_code == 409:
        return HTTPStatus.CONFLICT
    else:
        False