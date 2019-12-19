package edu.dlnu.oa.dept.pojo;

/**
 * @author wuhan
 * @date 2019/12/19 10:06
 */

public class Dept {
    private Integer deptId;
    private String deptName;
    private String deptAddress;
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public Dept(String deptName, String deptAddress) {
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    public Dept(Integer deptId, String deptName, String deptAddress) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    public Dept() {
    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptAddress + '\'' +
                '}';
    }
}
