package edu.dlnu.oa.emp.pojo;


import java.sql.Date;

public class Emp  {

    private Integer empId;

    private String empName;

    private String empLoginName;

    private String empPwd;

    private String empEmail;

    private String empPhone;

    private Date empHiredate;

    private Integer empSalary;

    private Integer deptId;

    private Integer empJobId;

    private String empPic;

    private String empInfo;

    private Integer empRoleId;

    private String empGender;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLoginName() {
        return empLoginName;
    }

    public void setEmpLoginName(String empLoginName) {
        this.empLoginName = empLoginName;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public Date getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(Date empHiredate) {
        this.empHiredate = empHiredate;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpJobId() {
        return empJobId;
    }

    public void setEmpJobId(Integer empJobId) {
        this.empJobId = empJobId;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getEmpInfo() {
        return empInfo;
    }

    public void setEmpInfo(String empInfo) {
        this.empInfo = empInfo;
    }

    public Integer getEmpRoleId() {
        return empRoleId;
    }

    public void setEmpRoleId(Integer empRoleId) {
        this.empRoleId = empRoleId;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Emp() {
    }

    public Emp(String empName, String empLoginName, String empPwd, String empEmail, String empPhone, Date empHiredate, Integer empSalary, Integer deptId, Integer empJobId, String empPic, String empInfo, Integer empRoleId, String empGender) {
        this.empName = empName;
        this.empLoginName = empLoginName;
        this.empPwd = empPwd;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empHiredate = empHiredate;
        this.empSalary = empSalary;
        this.deptId = deptId;
        this.empJobId = empJobId;
        this.empPic = empPic;
        this.empInfo = empInfo;
        this.empRoleId = empRoleId;
        this.empGender = empGender;
    }

    public Emp(Integer empId, String empName, String empLoginName, String empPwd, String empEmail, String empPhone, Date empHiredate, Integer empSalary, Integer deptId, Integer empJobId, String empPic, String empInfo, Integer empRoleId, String empGender) {
        this.empId = empId;
        this.empName = empName;
        this.empLoginName = empLoginName;
        this.empPwd = empPwd;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empHiredate = empHiredate;
        this.empSalary = empSalary;
        this.deptId = deptId;
        this.empJobId = empJobId;
        this.empPic = empPic;
        this.empInfo = empInfo;
        this.empRoleId = empRoleId;
        this.empGender = empGender;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empLoginName='" + empLoginName + '\'' +
                ", empPwd='" + empPwd + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empHiredate=" + empHiredate +
                ", empSalary=" + empSalary +
                ", deptId=" + deptId +
                ", empJobId=" + empJobId +
                ", empPic='" + empPic + '\'' +
                ", empInfo='" + empInfo + '\'' +
                ", empRoleId=" + empRoleId +
                ", empGender='" + empGender + '\'' +
                '}';
    }
}