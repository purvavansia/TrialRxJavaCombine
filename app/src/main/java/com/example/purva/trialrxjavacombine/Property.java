package com.example.purva.trialrxjavacombine;

import java.util.List;

/**
 * Created by purva on 4/28/18.
 */

public class Property {


    private List<PropertyBean> Property;

    public List<PropertyBean> getProperty() {
        return Property;
    }

    public void setProperty(List<PropertyBean> Property) {
        this.Property = Property;
    }

    public static class PropertyBean {
        /**
         * id : 1
         * propertyaddress : fla1234
         * propertycity : Noida
         * propertystate : UP
         * propertycountry : India
         * propertystatus : tenants
         * propertypurchaseprice : 12000
         * propertymortageinfo : no
         */

        private String id;
        private String propertyaddress;
        private String propertycity;
        private String propertystate;
        private String propertycountry;
        private String propertystatus;
        private String propertypurchaseprice;
        private String propertymortageinfo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPropertyaddress() {
            return propertyaddress;
        }

        public void setPropertyaddress(String propertyaddress) {
            this.propertyaddress = propertyaddress;
        }

        public String getPropertycity() {
            return propertycity;
        }

        public void setPropertycity(String propertycity) {
            this.propertycity = propertycity;
        }

        public String getPropertystate() {
            return propertystate;
        }

        public void setPropertystate(String propertystate) {
            this.propertystate = propertystate;
        }

        public String getPropertycountry() {
            return propertycountry;
        }

        public void setPropertycountry(String propertycountry) {
            this.propertycountry = propertycountry;
        }

        public String getPropertystatus() {
            return propertystatus;
        }

        public void setPropertystatus(String propertystatus) {
            this.propertystatus = propertystatus;
        }

        public String getPropertypurchaseprice() {
            return propertypurchaseprice;
        }

        public void setPropertypurchaseprice(String propertypurchaseprice) {
            this.propertypurchaseprice = propertypurchaseprice;
        }

        public String getPropertymortageinfo() {
            return propertymortageinfo;
        }

        public void setPropertymortageinfo(String propertymortageinfo) {
            this.propertymortageinfo = propertymortageinfo;
        }
    }
}
