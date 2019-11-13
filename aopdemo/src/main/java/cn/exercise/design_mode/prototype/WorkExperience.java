package cn.exercise.mode.prototype;

public class WorkExperience implements Cloneable{
    private String workdDate;
    private String company;

    public String getWorkdDate() {
        return workdDate;
    }

    public void setWorkdDate(String workdDate) {
        this.workdDate = workdDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected WorkExperience clone()  {
        Object obj = null;
        try {
            obj = super.clone();
            return (WorkExperience)obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }

    }
}
