import benutzer
import DBConnector


class LoadBenutzer:
    user = benutzer
    con = DBConnector.GetConnection()
    cursor = con.cursor()

    query = "Select * FROM benutzer"
    cursor.execute(query)
    row = cursor.fetchone()
    while (row != None):
        user.append(benutzer(row[0], row[1], row[2], row[3], row[4], row[5]))
        row = cursor.fetchone()
    cursor.close()
    con.disconnect()


def getUserbyID(chipid):
    i = 0
    while i < len(LoadBenutzer.user):
        if chipid == LoadBenutzer.user[i].get_ChipId:
            return LoadBenutzer.user[i]
        i += 1
    return ""
