
interface PaymentStr{
    public void processPaymentII();
}
class DebitCard implements PaymentStr{
    public void processPaymentII(){
        System.out.println("The payment is done using Debitcard");
    }
}
class CreditCard implements PaymentStr{
    public void processPaymentII(){
        System.out.println("The payment is done using Creditcard");
    }
}
class UPI implements PaymentStr{
    public void processPaymentII(){
        System.out.println("The payment is done using UPI");
    }
}
class PaymentServiceII{
    private PaymentStr strategy;
    public void setStrategy(PaymentStr strategy){
        this.strategy=strategy;
    }
    public void pay(){
        strategy.processPaymentII();
    }
}
public class StrategyPat{
    public static void main(String[] args){
        PaymentServiceII pss=new PaymentServiceII();
        pss.setStrategy(new UPI());
        pss.pay();
    }
} 