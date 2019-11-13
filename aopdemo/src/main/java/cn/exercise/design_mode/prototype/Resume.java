package cn.exercise.design_mode.prototype;

public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private WorkExperience work;

    public Resume() {
        work = new WorkExperience();
    }

    public Resume(WorkExperience work) {
        this.work = work.clone();
    }

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    public void setPersonalInfo(String sex, String  age){
        this.sex = sex;
        this.age = age;
    }
    public void setWorkExperience(String workDate,String company){
        work.setCompany(company);
        work.setWorkdDate(workDate);
    }

    public void display(){
        System.out.printf("%s %s %s",name,sex,age);
        System.out.println();
        System.out.printf("工作经历：%s %s",work.getWorkdDate(), work.getCompany());
        System.out.println();
    }

    @Override
    protected Resume clone()  {
//        Object obj = null;
//        try {
//            obj = super.clone();
//            return (Resume)obj;
//        } catch (CloneNotSupportedException e) {
//            System.out.println("不支持复制");
//            return null;
//        }
        Resume obj = new Resume(this.work);
        obj.name = name;
        obj.sex = sex;
        obj.age = age;
        return  obj;

    }
}
