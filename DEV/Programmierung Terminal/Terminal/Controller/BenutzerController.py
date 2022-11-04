import Entity.Benutzer as benutzer
import Requests.Request as requests

#Controller für das Erhalten der benutzerinformationen anhand der CHIPID
def getBenutzer(id):
    if id !=0 or id != '':
        user1 = requests.usergetbychipid(id)
        actuelluser = benutzer.Benutzer(user1["id"], user1["name"], user1["vorname"], user1["guthaben"], user1["chipid"])
        return actuelluser
    else:
        return False
