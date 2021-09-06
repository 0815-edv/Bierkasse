class Benutzer(object):
    def __init__(self, idrfid, name, vorname, guthaben, isAdmin, chipid):
        self.Idrfid = idrfid
        self.Name = name
        self.Vorname = vorname
        self.Guthaben = guthaben
        self.IsAdmin = isAdmin
        self.CHIPID = chipid


def get_idrfid(self):
    return self.Idrfid


def get_name(self):
    return self.Name


def get_vorname(self):
    return self.Vorname


def get_Guthaben(self):
    return self.Guthaben


def get_ChipId(self):
    return self.CHIPID
