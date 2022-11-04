from http import HTTPStatus
import requests
import Entity.Ware as ware
import Requests.Request as warerequest

#Controller für das Erhalten aller vorhandenen Waren
def allWaren():
    objects = warerequest.wareget()
    if objects == HTTPStatus.NOT_FOUND:
        return HTTPStatus.NOT_FOUND
    elif objects == requests.ConnectionError:
        return requests.ConnectionError
    else:
        WarenList = []
        for element in objects:
            WarenList.append(ware.Ware(element["id"], element["name"], element["anzahl"]))
        return WarenList


