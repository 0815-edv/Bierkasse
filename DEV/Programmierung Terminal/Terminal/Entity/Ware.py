#WarenEntität
class Ware:
    def __init__(self, id, name, anzahl):
        self.id = id
        self.name = name
        self.anzahl = anzahl

    def getid(self):
        return self.id

    def getname(self):
        return self.name

    def getanzahl(self):
        return self.anzahl