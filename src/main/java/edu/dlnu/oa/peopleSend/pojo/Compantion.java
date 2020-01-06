package edu.dlnu.oa.peopleSend.pojo;

/**
 * 外派企业
 */
public class Compantion {

    private Integer comId;
    private String comName;
    private String comLinkmanName;
    private String comLinkmanPhone;
    private String comLinkmanQq;
    private String comInfo;

    public Compantion() {
    }

    public Compantion(String comName, String comLinkmanName, String comLinkmanPhone, String comLinkmanQq, String comInfo) {
        this.comName = comName;
        this.comLinkmanName = comLinkmanName;
        this.comLinkmanPhone = comLinkmanPhone;
        this.comLinkmanQq = comLinkmanQq;
        this.comInfo = comInfo;
    }

    public Compantion(Integer comId, String comName, String comLinkmanName, String comLinkmanPhone, String comLinkmanQq, String comInfo) {
        this.comId = comId;
        this.comName = comName;
        this.comLinkmanName = comLinkmanName;
        this.comLinkmanPhone = comLinkmanPhone;
        this.comLinkmanQq = comLinkmanQq;
        this.comInfo = comInfo;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComLinkmanName() {
        return comLinkmanName;
    }

    public void setComLinkmanName(String comLinkmanName) {
        this.comLinkmanName = comLinkmanName;
    }

    public String getComLinkmanPhone() {
        return comLinkmanPhone;
    }

    public void setComLinkmanPhone(String comLinkmanPhone) {
        this.comLinkmanPhone = comLinkmanPhone;
    }

    public String getComLinkmanQq() {
        return comLinkmanQq;
    }

    public void setComLinkmanQq(String comLinkmanQq) {
        this.comLinkmanQq = comLinkmanQq;
    }

    public String getComInfo() {
        return comInfo;
    }

    public void setComInfo(String comInfo) {
        this.comInfo = comInfo;
    }

    @Override
    public String toString() {
        return "Compantion{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", comLinkmanName='" + comLinkmanName + '\'' +
                ", comLinkmanPhone='" + comLinkmanPhone + '\'' +
                ", comLinkmanQq='" + comLinkmanQq + '\'' +
                ", comInfo='" + comInfo + '\'' +
                '}';
    }
}
