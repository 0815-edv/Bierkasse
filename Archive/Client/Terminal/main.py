import json
import mysql.connector
import RPi.GPIO as GPIO
import time
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

def getränkauswahl():
    lcd.clear()
    lcd.cursor_pos = (0, 0)
    lcd.write_string(vorname + " " + name)
    lcd.cursor_pos = (1, 0)
    lcd.write_string("  >1. Getränk Kaufen ")
    lcd.cursor_pos = (2, 0)
    lcd.write_string("  2. Exit ")

def getränkauswahlbeenden():
    lcd.clear
    lcd.cursor_pos = (0, 0)
    lcd.write_string(vorname + " " + name)
    lcd.cursor_pos = (1, 0)
    lcd.write_string("  1. Getränk Kaufen ")
    lcd.cursor_pos = (2, 0)
    lcd.write_string("  >2. Exit ")

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

def changeDisplay(x):
    if x == 1:
        firstDisplay()
    if x == 2:
        secondDisplay()
    if x == 3:
        thirdDisplay()

def selectOption(x):
    if x ==1 :
        getränkauswahl()


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

def getraenkbuchen():
    sql = "INSERT INTO kauefe (Datum, benutzer_idrfid, Ware_id) VALUES(%s, %s, %s)"
    val = ("now()", id(), 1)
    cursor.execute(sql, val)

    sql = "UPDATE benutzer SET guthaben = guthaben -1 Where idrfid like" + id()
    cursor.execute(sql)



initDisplay()
reader = SimpleMFRC522()
getUser()
firstDisplay()

i = 1
while (True):
    if GPIO.input(19) == 0:
        i = i+1
        if i>3:
            i=3
        changeDisplay(i)
        time.sleep(1)
    elif GPIO.input(26) ==0:

        i = i-1
        if i<1:
            i=1
        changeDisplay(i)
        time.sleep(1)

    if GPIO.input(13) == 0:
        selectOption(i)
        time.sleep(1)
        break

while (True):
    z = 1
    if i==1:
        if GPIO.input(19) == 0:
            z = z + 1
            if z > 2:
                z = 2
            getränkauswahlbeenden()
            time.sleep(1)
        elif GPIO.input(26) == 0:

            z = z - 1
            if z < 1:
                z = 1
            getränkauswahl()
            time.sleep(1)
        if GPIO.input(13) == 0 and z ==1:
            getraenkbuchen()
            z==1
            break

        elif GPIO.input(13) == 0 and z ==2:
            z == 1
            break







###hier gehts weiter###