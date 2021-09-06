package de.dlrg.Restservice;

//import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

    @Entity
    @Table(name = "Benutzer")
    public class Benutzer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idrfid;
        private String name;
        private String vorname;
        private double guthaben;
        private int isAdmin;    // 0-> ist kein Admin --  1-> ist Admin
        private Long chipid;

        public Benutzer(Long idrfid, String name, String vorname, double guthaben, int isAdmin, Long chipid) {
            this.idrfid = idrfid;
            this.name = name;
            this.vorname = vorname;
            this.guthaben = guthaben;
            this.isAdmin = isAdmin;
            this.chipid = chipid;
        }



        public Long getIdrfid() {
            return idrfid;
        }

        public void setIdrfid(Long idrfid) {
            this.idrfid = idrfid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVorname() {
            return vorname;
        }

        public void setVorname(String vorname) {
            this.vorname = vorname;
        }

        public double getGuthaben() {
            return guthaben;
        }

        public void setGuthaben(double guthaben) {
            this.guthaben = guthaben;
        }

        public int getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(int isAdmin) {
            this.isAdmin = isAdmin;
        }

        public Long getChipid() {
            return chipid;
        }

        public void setChipid(Long chipid) {
            this.chipid = chipid;
        }


    }


