package inflearn.section9._09_feature_envy;

public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    //before
//    public double calculateBill() {
    // bill class 가 기능욕심을 내고있다.
    // electricityUsage,gasUsage 를 참조해서 여기서 계산하고있다.
    // 굳이 여기서 계산할게아니라 electricityUsage,gasUsage 에서 계산해도 괜찮을텐데
    // 굳이 여기서 계산하고있다.
    // 만약에 gasBill 계산이 없엇다면
    // 이함수자체를 electricityUsage 옮겨줘도 괜찮앗을것같다.
//        var electicityBill = electricityUsage.getAmount() * electricityUsage.getPricePerUnit();
//        var gasBill = gasUsage.getAmount() * gasUsage.getPricePerUnit();
//        return electicityBill + gasBill;
//    }


    public double calculateBill() {
        return electricityUsage.getElecticityBill() + gasUsage.getgasBill();
    }

}
