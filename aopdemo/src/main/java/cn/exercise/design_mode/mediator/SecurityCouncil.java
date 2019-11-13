package cn.exercise.design_mode.mediator;

/**
 * 安理会
 */
public class SecurityCouncil extends UnitedNations{
    private USA colleage1;
    private Iraq colleage2;


    @Override
    public void declare(String message, Country colleague) {
        if(colleague == colleage1){
            colleage2.getMessage(message);
        }else {
            colleage1.getMessage(message);
        }
    }

    public USA getColleage1() {
        return colleage1;
    }

    public void setColleage1(USA colleage1) {
        this.colleage1 = colleage1;
    }

    public Iraq getColleage2() {
        return colleage2;
    }

    public void setColleage2(Iraq colleage2) {
        this.colleage2 = colleage2;
    }
}
