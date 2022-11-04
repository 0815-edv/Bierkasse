#BenutzerEntität
class Benutzer:

    def __init__(self, id, name, vorname, guthaben, chipid):
        self.id = id
        self.name = name
        self.vorname = vorname
        self.guthaben = guthaben
        self.chipid = chipid

    def getid(self):
        return self.id

    def getname(self):
        return self.name

    def getvorname(self):
        return self.vorname

    def getguthaben(self):
        return self.guthaben

    def getchipid(self):
        return self.chipid

    def setGuthaben(self, guthaben):
        self.guthaben = guthaben
