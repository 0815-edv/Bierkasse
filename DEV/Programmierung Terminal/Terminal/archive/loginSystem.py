from qtpy import QtWidgets

import kassenSystem
from ui.loginwindow import Ui_LoginWindow


class LoginWindow(QtWidgets.QMainWindow):

    def __init__(self, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Digitales Kassensystem - LOGIN")
        self.ui_login = Ui_LoginWindow()
        self.ui_login.setupUi(self)
        self.ui_login.btnLogin.clicked.connect(buildKasse)

    def getID(self):
        return self.ui_login.txfID.toPlainText()

    def returnUI(self):
        return self.ui_login


def buildKasse():
    chipid = 123456789
    kasse = kassenSystem.KassenWindows(chipid=chipid)
    #kasse.setUserid(123456789)
    kasse.show()




