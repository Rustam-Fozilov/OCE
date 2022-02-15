package com.company;

public class AdminInformation {
    private String ismi;
    private String familiyasi;
    private String login;
    private String parol;

    public AdminInformation(String ismi, String familiyasi, String login, String parol) {
        this.ismi = ismi;
        this.familiyasi = familiyasi;
        this.login = login;
        this.parol = parol;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public String getFamiliyasi() {
        return familiyasi;
    }

    public void setFamiliyasi(String familiyasi) {
        this.familiyasi = familiyasi;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }
}
