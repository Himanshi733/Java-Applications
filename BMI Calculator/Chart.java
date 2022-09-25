/**********************************************
Workshop #6
Course:<subject type> - 4
Last Name:<Himanshi>
First Name:<->
ID:<155860208>
Section:<ZBB>
This assignment represents my own work in accordance with Seneca Academic Policy.
Himanshi
Date:<17-07-2022>
**********************************************/
public class Chart {

    private String BMI = null;
    private String WeightStatus = null;

    public Chart() {
    }

    public Chart(String BMI, String WeightStatus) {
        this.BMI = BMI;
        this.WeightStatus = WeightStatus;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getWeightStatus() {
        return WeightStatus;
    }

    public void setWeightStatus(String WeightStatus) {
        this.WeightStatus = WeightStatus;
    }
}
