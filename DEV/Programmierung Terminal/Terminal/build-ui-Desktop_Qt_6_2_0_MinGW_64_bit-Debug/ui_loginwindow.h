/********************************************************************************
** Form generated from reading UI file 'loginwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.2.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LOGINWINDOW_H
#define UI_LOGINWINDOW_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTextBrowser>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_LoginWindow
{
public:
    QWidget *centralwidget;
    QLabel *label;
    QPushButton *btnLogin;
    QLabel *label_2;
    QTextBrowser *txfID;
    QMenuBar *menubar;
    QMenu *menuKassensystem;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *LoginWindow)
    {
        if (LoginWindow->objectName().isEmpty())
            LoginWindow->setObjectName(QString::fromUtf8("LoginWindow"));
        LoginWindow->resize(1024, 600);
        LoginWindow->setStyleSheet(QString::fromUtf8("background-color: rgb(195, 0, 0);"));
        centralwidget = new QWidget(LoginWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        label = new QLabel(centralwidget);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(200, 120, 571, 121));
        QFont font;
        font.setPointSize(18);
        label->setFont(font);
        btnLogin = new QPushButton(centralwidget);
        btnLogin->setObjectName(QString::fromUtf8("btnLogin"));
        btnLogin->setGeometry(QRect(410, 390, 171, 51));
        btnLogin->setStyleSheet(QString::fromUtf8("background-color: rgb(255, 255, 255);"));
        label_2 = new QLabel(centralwidget);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(320, 320, 91, 31));
        QFont font1;
        font1.setPointSize(10);
        label_2->setFont(font1);
        txfID = new QTextBrowser(centralwidget);
        txfID->setObjectName(QString::fromUtf8("txfID"));
        txfID->setGeometry(QRect(410, 320, 171, 41));
        txfID->setStyleSheet(QString::fromUtf8("background-color: rgb(255, 255, 255);"));
        LoginWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(LoginWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 1024, 21));
        menuKassensystem = new QMenu(menubar);
        menuKassensystem->setObjectName(QString::fromUtf8("menuKassensystem"));
        LoginWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(LoginWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        LoginWindow->setStatusBar(statusbar);

        menubar->addAction(menuKassensystem->menuAction());

        retranslateUi(LoginWindow);

        QMetaObject::connectSlotsByName(LoginWindow);
    } // setupUi

    void retranslateUi(QMainWindow *LoginWindow)
    {
        LoginWindow->setWindowTitle(QCoreApplication::translate("LoginWindow", "MainWindow", nullptr));
        label->setText(QCoreApplication::translate("LoginWindow", "Kassensystem - Zum Anmelden RFID-Chip vorhalten", nullptr));
        btnLogin->setText(QCoreApplication::translate("LoginWindow", "Login", nullptr));
        label_2->setText(QCoreApplication::translate("LoginWindow", "RFID-CHIP ID: ", nullptr));
        menuKassensystem->setTitle(QCoreApplication::translate("LoginWindow", "Kassensystem", nullptr));
    } // retranslateUi

};

namespace Ui {
    class LoginWindow: public Ui_LoginWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LOGINWINDOW_H
