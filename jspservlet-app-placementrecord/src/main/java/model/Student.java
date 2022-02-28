package model;

public class Student {
    //StudentId
    private int studentId;
    public int getStudentId() {
      return studentId;
    }
    public void setStudentId(int sid) {
      this.studentId = sid;
    }
    //StudentName
    private String studentName;
    public String getstudentName() {
      return studentName;
    }
    public void setstudentName(String stName) {
      this.studentName = stName;
    }
    //CompanyName
    private String companyName;
    public String getcompanyName() {
      return companyName;
    }
    public void setcompanyName(String cName) {
      this.companyName = cName;
    }
    //SalaryOffered
    private double salaryOffered;
    public double getsalaryOffered() {
      return salaryOffered;
    }
    public void setsalaryOffered(double salOffered) {
      this.salaryOffered = salOffered;
    }
    //Batch
    private String batch;
    public String getbatch() {
      return batch;
    }
    public void setbatch(String bh) {
      this.batch = bh;
    }
  }
