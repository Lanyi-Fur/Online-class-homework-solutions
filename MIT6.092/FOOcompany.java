public class FOOcompany{
    public static void paycalculator(double basepay,double hour){
            if(basepay< 8.0){
                System.out.println("ERROR: Employee is being payed below base pay($8.00/hr) or the base pay you typed is negative.");
            }
            else if(hour >60){
                System.out.printf("ERROR: Employee worked over 60 hours or the hours you typed are negative.");
            }
            else {
                double overhours = hour - 40;
                double Salary = 0;
                if(hour <=40){
                    Salary = hour * basepay;
                }
            
            else {
                Salary = 40 * basepay + overhours * basepay*1.5;
            }
            System.out.println("Employee has worked " + hour + " hours and earned $" +Salary + ".");
        }
    }
    public static void main(String[] agrs){
            paycalculator(7.5, 35);
            paycalculator(8.2, 47);
            paycalculator(10, 73);
    }

}
