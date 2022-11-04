import sys
import time
from http import HTTPStatus

import requests
from PyQt5.QtCore import QTimer
from RPi import GPIO
from mfrc522 import SimpleMFRC522
from qtpy import QtWidgets
from Controller.WareController import allWaren
from Controller.BenutzerController import getBenutzer
from Controller.GuthabenController import createRequest
from Enum.guthaben import guthaben
from Controller.KaufeController import KaufeWaren
from ui.kassenwindow import Ui_MainWindow
from ui.loginwindow import Ui_LoginWindow

GPIO.setwarnings(False)

##Klasse LoginFenster
class LoginWindow(QtWidgets.QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Digitales Kassensystem - LOGIN")
        self.ui_login = Ui_LoginWindow()
        self.ui_login.setupUi(self)
        self.showMaximized()
        self.readerid = 0
        self.timer = QTimer()
        self.timer.timeout.connect(self.readID)
        self.timer.start(1000)
        self.ui_login.btnLogin.clicked.connect(self.buildKasse)

    #Methode für das Einlesen der ID anhand der CHIPS
    def readID(self):
        reader = SimpleMFRC522()
        id = 0
        while id == 0:
            idoutput, text = reader.read()
            id = idoutput
            self.readerid = idoutput
            self.ui_login.txfID.setText(str(self.readerid))
        self.timer.stop()


    def getID(self):
        return self.ui_login.txfID.toPlainText()

    def returnUI(self):
        return self.ui_login

    #Initialisieren des Kassenfenster
    def buildKasse(self):
        if self.readerid != 0:
            userconnection = getBenutzer(str(self.readerid))
            print(userconnection)
            if userconnection == HTTPStatus.NOT_FOUND:
                self.ui_login.txfID.setText("Benutzer not Found")
            elif userconnection == requests.ConnectionError:
                self.ui_login.txfID.setText("No Connection")
            else:
                kasse = KassenWindow(chipid=str(self.readerid))
                widget.addWidget(kasse)
                widget.setCurrentIndex(widget.currentIndex() + 1) #Indexänderung des aktuellen widget(Fenster)


#Klasse Kassenfenster
class KassenWindow(QtWidgets.QMainWindow):
    def __init__(self, chipid, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Digitales Kassensystem - Kasse")
        self.ui_kasse = Ui_MainWindow()
        self.ui_kasse.setupUi(self)
        self.showMaximized()
        self.chipid = chipid
        self.localuser = getBenutzer(self.chipid)
        self.ui_kasse.lblguthaben.setText(str(self.localuser.getguthaben()) + " €")
        self.ui_kasse.lbl_benutzer.setText("Benutzer: " + self.localuser.getvorname() + " " + self.localuser.getname())
        self.warenliste()
        self.ui_kasse.btnguthabenaufladen.clicked.connect(self.guthabenAntragstellen)
        self.ui_kasse.btnkaufen.clicked.connect(self.kaufeArtikel)
        self.ui_kasse.tableWaren.clicked.connect(self.setLabelWare)
        self.ui_kasse.btnlogout.clicked.connect(self.logout)

    def setUserid(self, id):
        self.chipid = id

    #Erstellen der ListBox mit den Waren des Backend
    def warenliste(self):
        self.ui_kasse.lblartikel.setText("")
        self.ui_kasse.lblanzahl.setText("")
        warenlist = allWaren()
        if warenlist == HTTPStatus.NOT_FOUND:
            self.ui_kasse.lblstatus.setText("Status: Waren not Found")
        elif warenlist == requests.ConnectionError:
            self.ui_kasse.lblstatus.setText("Status: No Connection")
        else:
            self.ui_kasse.lblstatus.setText("Status: Erfolgreich")
            length = len(warenlist)
            row = 0
            self.ui_kasse.tableWaren.setRowCount(length)
            for x in warenlist:
                test = x
                self.ui_kasse.tableWaren.setItem(row, 0, QtWidgets.QTableWidgetItem((str(test.getid()))))
                self.ui_kasse.tableWaren.setItem(row, 1, QtWidgets.QTableWidgetItem((test.getname())))
                self.ui_kasse.tableWaren.setItem(row, 2, QtWidgets.QTableWidgetItem((str(test.getanzahl()))))
                row = row + 1

    #Methode für das stellen des Guthaben Antrages
    def guthabenAntragstellen(self):
        i = 1
        if self.ui_kasse.rbtn10.isChecked():
            i = createRequest(guthaben.zehn, self.localuser.getid())
            if i == HTTPStatus.NOT_FOUND:
                self.ui_kasse.lblguthaben.setText("User not found")
            elif i == HTTPStatus.CONFLICT:
                self.ui_kasse.lblguthaben.setText("Error during Transfer")
            else:
                self.ui_kasse.btnguthabenaufladen.setDisabled(True)
                self.ui_kasse.lblguthaben.setText("Antrag von 10 € Erfolgreich gestellt")
        elif self.ui_kasse.rbtn20.isChecked():
            i = createRequest(guthaben.zwanzig, self.localuser.getid())
            if i == HTTPStatus.NOT_FOUND:
                self.ui_kasse.lblguthaben.setText("User not found")
            elif i == HTTPStatus.CONFLICT:
                self.ui_kasse.lblguthaben.setText("Error during Transfer")
            else:
                self.ui_kasse.btnguthabenaufladen.setDisabled(True)
                self.ui_kasse.lblguthaben.setText("Antrag von 20 € Erfolgreich gestellt")
        elif self.ui_kasse.rbtn50.isChecked():
            i = createRequest(guthaben.fuenfzig, self.localuser.getid())
            if i == HTTPStatus.NOT_FOUND:
                self.ui_kasse.lblguthaben.setText("User not found")
            elif i == HTTPStatus.CONFLICT:
                self.ui_kasse.lblguthaben.setText("Error during Transfer")
            else:
                self.ui_kasse.btnguthabenaufladen.setDisabled(True)
                self.ui_kasse.lblguthaben.setText("Antrag von 50 € Erfolgreich gestellt")
        else:
            self.ui_kasse.lblguthaben.setText("Fehler beim aufladen")

    #Methode für das kaufen der Artikel
    def kaufeArtikel(self):
        row = self.ui_kasse.tableWaren.currentRow()
        ware_id = self.ui_kasse.tableWaren.item(row, 0).text()
        result = KaufeWaren(str(self.localuser.getid()), str(ware_id))
        self.ui_kasse.lblkaufbetaetigt.setText(str(result))
        self.ui_kasse.btnkaufen.setDisabled(True)
        self.warenliste()
        time.sleep(2)
        self.ui_kasse.btnkaufen.setDisabled(False)

    #Methode für das Definieren des aktuell ausgewählten Artikels anhand der ListBox
    def setLabelWare(self):
        row = self.ui_kasse.tableWaren.currentRow()
        name = self.ui_kasse.tableWaren.item(row, 1).text()
        anzahl = self.ui_kasse.tableWaren.item(row, 2).text()
        self.ui_kasse.lblartikel.setText(str(name))
        self.ui_kasse.lblanzahl.setText(str(anzahl))

    #Logout / Applikation beenden
    def logout(self):
        GPIO.cleanup()
        sys.exit(0)


app = QtWidgets.QApplication(sys.argv) #Objektinitialisierung wird für die Nutzung von QT genutzt
loginwindows = LoginWindow() #Objektinitialisierung des Login Window
widget = QtWidgets.QStackedWidget() #Objektinitialisierung des Widget
widget.addWidget(loginwindows) #Darstellen des LoginWindows
widget.showMaximized() #Im FullScreen
widget.show() #Zeigen des fenster
sys.exit(app.exec_())