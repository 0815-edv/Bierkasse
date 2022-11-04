import sys
import time

from qtpy import QtWidgets


from ui.kassenwindow import Ui_MainWindow
from Entity import Ware
from Controller.WareController import allWaren
from Controller.BenutzerController import getBenutzer
from Controller.GuthabenController import createRequest
from Enum.guthaben import guthaben
from Controller.KaufeController import KaufeWaren


class KassenWindows(QtWidgets.QMainWindow):

    def __init__(self, chipid, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Digitales Kassensystem - Kasse")
        self.ui_kasse = Ui_MainWindow()
        self.ui_kasse.setupUi(self)
        self.chipid = chipid
        self.localuser = getBenutzer(self.chipid)
        self.ui_kasse.lblguthaben.setText(str(self.localuser.getguthaben()) + " €")
        self.ui_kasse.lbl_benutzer.setText("Benutzer: " + self.localuser.getvorname() + " " + self.localuser.getname())
        self.warenliste()
        self.ui_kasse.btnguthabenaufladen.clicked.connect(self.guthabenAntragstellen)
        self.ui_kasse.btnkaufen.clicked.connect(self.kaufeArtikel)
        self.ui_kasse.tableWaren.clicked.connect(self.setLabelWare);

    def setUserid(self, id):
        self.chipid = id

    def warenliste(self):
        warenlist = allWaren()
        length = len(warenlist)
        row = 0
        self.ui_kasse.tableWaren.setRowCount(length)
        for x in warenlist:
            test = x
            self.ui_kasse.tableWaren.setItem(row, 0, QtWidgets.QTableWidgetItem((str(test.getid()))))
            self.ui_kasse.tableWaren.setItem(row, 1, QtWidgets.QTableWidgetItem((test.getname())))
            self.ui_kasse.tableWaren.setItem(row, 2, QtWidgets.QTableWidgetItem((str(test.getanzahl()))))
            row = row + 1

    def guthabenAntragstellen(self):
        i = 1
        if self.ui_kasse.rbtn10.isChecked():
            i = createRequest(guthaben.zehn, self.localuser.getid())
            self.ui_kasse.btnguthabenaufladen.setDisabled(True)
            self.ui_kasse.lblguthaben.setText("Antrag von 10 € Erfolgreich gestellt")
        elif self.ui_kasse.rbtn20.isChecked():
            i = createRequest(guthaben.zwanzig, self.localuser.getid())
            self.ui_kasse.btnguthabenaufladen.setDisabled(True)
            self.ui_kasse.lblguthaben.setText("Antrag von 20 € Erfolgreich gestellt")
        elif self.ui_kasse.rbtn50.isChecked():
            i = createRequest(guthaben.fuenfzig, self.localuser.getid())
            i = createRequest(guthaben.zwanzig, self.localuser.getid())
            self.ui_kasse.btnguthabenaufladen.setDisabled(True)
            self.ui_kasse.lblguthaben.setText("Antrag von 50 € Erfolgreich gestellt")
        else:
            self.ui_kasse.lblguthaben.setText("Fehler beim aufladen")
        if i == "0":
            self.ui_kasse.lblguthaben.setText("Fehler beim aufladen")

    def kaufeArtikel(self):
        row = self.ui_kasse.tableWaren.currentRow()
        ware_id = self.ui_kasse.tableWaren.item(row, 0).text()
        print(ware_id)
        KaufeWaren(str(self.localuser.getid()), str(ware_id))

        self.ui_kasse.lblkaufbetaetigt.setText("Kauf Erfolgreich ")
        self.ui_kasse.btnkaufen.setDisabled(True)
        time.sleep(2)
        self.ui_kasse.btnkaufen.setDisabled(False)

    def setLabelWare(self):
        row = self.ui_kasse.tableWaren.currentRow();
        name = self.ui_kasse.tableWaren.item(row, 1).text();
        anzahl = self.ui_kasse.tableWaren.item(row, 2).text();
        self.ui_kasse.lblartikel.setText(str(name));
        self.ui_kasse.lblanzahl.setText(str(anzahl));

