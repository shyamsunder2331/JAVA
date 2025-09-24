class PaymentService{
    public void processPayment(String payMethod){
        if(payMethod.equalsIgnoreCase("Credit card")){
            System.out.println("Payment is done using Credit Card");
        }else if(payMethod.equalsIgnoreCase("Debit card")){
            System.out.println("Payment is done using Debit Card");
        }else{
            System.out.println("Payment Method is unsupported!..");
        }
    }
}
public class WithoutStrategy{
    public static void main(String[] args){
        PaymentService ps=new PaymentService();
        ps.processPayment("Debit Card");
    }
}