from http import HTTPStatus
import requests
from Requests.Request import kaeufeADD

#Controller für das Erstellen Käufen mit der abfrage des HTTP Status
def KaufeWaren(iduser, idware):
    result = kaeufeADD(iduser, idware)
    if result == True:
        return "Kauf Erfolgreich"
    elif result == HTTPStatus.BAD_REQUEST:
        return "Creation incorrect"
    elif result == HTTPStatus.NOT_ACCEPTABLE:
        return "Credit not sufficient"
    elif result == requests.ConnectionError:
        return "Connection Error"
    else:
        return "No buy possible"
