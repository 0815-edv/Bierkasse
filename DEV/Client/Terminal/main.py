import json
import mysql.connector
import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
from mfrc522 import SimpleMFRC522

GPIO.setwarnings(False)
##GPIO-Taster Hoch = 26##
##GPIO-Taster unten = 19##
##GPIO-Taster Bestätigen = 13##


GPIO.setmode(GPIO.BCM)
GPIO.setup(13, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(19, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(26, GPIO.IN, pull_up_down=GPIO.PUD_UP)

##GlobaleVariablenfürBenutzer##

##LOAD DATABASE##
with open("dbconf.json") as jsonFile:
    jsonObject = json.load(jsonFile)
jsonFile.close()
Servername = jsonObject['url']
Benutzer = jsonObject['user']
Passwort = jsonObject['password']
Datenbank = jsonObject['database']

con = mysql.connector.connect(host=Servername, user=Benutzer, password=Passwort, database=Datenbank)
cursor = con.cursor()
####################################################################################################
##################LOAD DISPLAY######################################################################
lcd = CharLCD('PCF8574', 0x27)


####################################################################################################
##################LOAD DISPLAYMethoden######################################################################
def initDisplay():
    lcd.clear()
    lcd.write_string('Bierkasse DLRG')
    lcd.cursor_pos = (2, 0)
    lcd.write_string('RFID-Chip vorlegen: ')


def firstDisplay():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string(vorname + " " + name)
    lcd.cursor_pos = (1, 0)
    lcd.write_string(" >1. Getränke ")
    lcd.cursor_pos = (2, 0)
    lcd.write_string("  2. Guthaben")
    lcd.cursor_pos = (3, 0)
    lcd.write_string("  3. Exit")


def secondDisplay():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string(vorname + " " + name)
    lcd.cursor_pos = (1, 0)
    lcd.write_string("  1. Getränke ")
    lcd.cursor_pos = (2, 0)
    lcd.write_string(" >2. Guthaben")
    lcd.cursor_pos = (3, 0)
    lcd.write_string("  3. Exit")


def thirdDisplay():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string(vorname + " " + name)
    lcd.cursor_pos = (1, 0)
    lcd.write_string("  1. Getränke ")
    lcd.cursor_pos = (2, 0)
    lcd.write_string("  2. Guthaben")
    lcd.cursor_pos = (3, 0)
    lcd.write_string(" >3. Exit")


def firstguthabenDisplay():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string("Guthaben = " + guthaben)
    lcd.cursor_pos = (2, 0)
    lcd.write_string = ("> Guthaben aufladen")
    lcd.cursor_pos = (3, 0)
    lcd.write_string = ("Exit")


def secondguthabenDisplay():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string("Guthaben = " + guthaben)
    lcd.cursor_pos = (2, 0)
    lcd.write_string = ("Guthaben aufladen")
    lcd.cursor_pos = (3, 0)
    lcd.write_string = ("> Exit")


###################READ CHIP########################################################################
def getUser():
    while (True):
        try:
            cpid, text = reader.read()
            query = "Select * FROM benutzer where chipid = " + str(cpid)
            cursor.execute(query)
            row = cursor.fetchone()
            global id
            global name
            global vorname
            global chipid
            global guthaben
            while (row != None):
                id = row[0]
                name = row[1]
                vorname = row[2]
                guthaben = row[3]
                chipid = row[5]

                row = cursor.fetchone()
            break

        except KeyboardInterrupt:
            cursor.close()
            con.close()
            break


initDisplay()
reader = SimpleMFRC522()
getUser()
firstDisplay()
###hier gehts weiter###