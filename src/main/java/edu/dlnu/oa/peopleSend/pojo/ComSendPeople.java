package edu.dlnu.oa.peopleSend.pojo;

public class ComSendPeople {
    private Integer spId;
    private String spName;
    private String spEdu;
    private String spWork;
    private String spAbility;
    private String spLoc;
    private Integer spSalay;
    private Integer spState;

    public ComSendPeople() {
    }

    public ComSendPeople(String spName, String spEdu, String spWork, String spAbility, String spLoc, Integer spSalay, Integer spState) {
        this.spName = spName;
        this.spEdu = spEdu;
        this.spWork = spWork;
        this.spAbility = spAbility;
        this.spLoc = spLoc;
        this.spSalay = spSalay;
        this.spState = spState;
    }

    public ComSendPeople(Integer spId, String spName, String spEdu, String spWork, String spAbility, String spLoc, Integer spSalay, Integer spState) {
        this.spId = spId;
        this.spName = spName;
        this.spEdu = spEdu;
        this.spWork = spWork;
        this.spAbility = spAbility;
        this.spLoc = spLoc;
        this.spSalay = spSalay;
        this.spState = spState;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpEdu() {
        return spEdu;
    }

    public void setSpEdu(String spEdu) {
        this.spEdu = spEdu;
    }

    public String getSpWork() {
        return spWork;
    }

    public void setSpWork(String spWork) {
        this.spWork = spWork;
    }

    public String getSpAbility() {
        return spAbility;
    }

    public void setSpAbility(String spAbility) {
        this.spAbility = spAbility;
    }

    public String getSpLoc() {
        return spLoc;
    }

    public void setSpLoc(String spLoc) {
        this.spLoc = spLoc;
    }

    public Integer getSpSalay() {
        return spSalay;
    }

    public void setSpSalay(Integer spSalay) {
        this.spSalay = spSalay;
    }

    public Integer getSpState() {
        return spState;
    }

    public void setSpState(Integer spState) {
        this.spState = spState;
    }

    @Override
    public String toString() {
        return "ComSendPeople{" +
                "spId=" + spId +
                ", spName='" + spName + '\'' +
                ", spEdu='" + spEdu + '\'' +
                ", spWork='" + spWork + '\'' +
                ", spAbility='" + spAbility + '\'' +
                ", spLoc='" + spLoc + '\'' +
                ", spSalay=" + spSalay +
                ", spState=" + spState +
                '}';
    }
}
