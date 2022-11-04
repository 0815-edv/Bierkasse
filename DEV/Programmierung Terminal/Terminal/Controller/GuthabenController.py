from Requests import Request

#Controller für das Erstellen von GuthabenRequests
def createRequest(guthaben, id):
    if guthaben is guthaben.fünf:
        state = Request.guthabenAntragADD(id, 5)
        return state
    elif guthaben is guthaben.zehn:
        state = Request.guthabenAntragADD(id, 10)
        return state
    elif guthaben is guthaben.zwanzig:
        state = Request.guthabenAntragADD(id, 20)
        return state
    elif guthaben is guthaben.fuenfzig:
        state = Request.guthabenAntragADD(id, 50)
        return state
    else:
        return False

