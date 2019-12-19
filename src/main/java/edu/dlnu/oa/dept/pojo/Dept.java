package edu.dlnu.oa.dept.pojo;

/**
 * @author wuhan
 * @date 2019/12/19 10:06
 */
public class Dept {
    private Integer deptId;
    private String deptName;



    private String deptLoc;

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

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }

    public Dept(String deptName, String deptLoc) {
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public Dept(Integer deptId, String deptName, String deptLoc) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public Dept() {
    }
    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptLoc + '\'' +
                '}';
    }
}
