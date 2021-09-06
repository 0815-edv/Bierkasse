import json

import mysql.connector


class DBconnector:

    with open("dbconf.json") as jsonFile:
        jsonObject = json.load(jsonFile)
    jsonFile.close()

    Servername = jsonObject['url']
    Benutzer = jsonObject['user']
    Passwort = jsonObject['password']
    Datenbank = jsonObject['database']

    con = mysql.connector.connect(host=Servername, user=Benutzer, password=Passwort, database=Datenbank)

def GetConnection():
    return DBconnector.con