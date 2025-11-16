import java.util.*;
import java.util.function.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
interface Shape{
    void execute();
}
interface Print{
    void display(String s);
}
@FunctionalInterface
interface Addition{
    int addition(int a,int b);
}
@FunctionalInterface
interface LowerCase{
    String lowerCase(String s);
}
interface StringReversal{
    String reverse(String s);
}
interface Display{
    String print(String s);
}
public class MethodReference
{
    public static void displayed(String s){
        System.out.println(s+" displayed is called");
    }
    public static int additional(int a,int b){
        return a+b;
    }
	public static void main(String[] args) {
// 		print(()-> System.out.println("rectangle method: draw() method"));
// // 		rectangle.execute();
// 		print(()-> System.out.println("Circle method: draw() method"));
// // 		circle.execute();
// 		print(()-> System.out.println("Square method: draw() method"));
// // 		square.execute();
//         // print(rectangle);
//         // print(square);
//         // print(circle);
// 	}
// 	public static void print(Shape shape){
// 	    shape.execute();
        // Addition addition=(a,b)->(a+b);
        // System.out.println(addition.addition(6,5));
        
        // LowerCase lowercase=(s)-> s.toLowerCase();
        // System.out.println(lowercase.lowerCase("SHYAMSUNDER"));
        // StringReversal rev=( s)->{
        //     String reversal="";
        //     for(char i:s.toCharArray()){
        //         reversal=i+reversal;
        //     }
        //     return reversal;
        // };
        // System.out.println(rev.reverse("Shyamusunder"));
        // Thread thread=new Thread(()->System.out.println("Run method is called using Lambda expression"));
        // thread.start();
        // Function<String,Integer> function= (s)->s.length();
        // System.out.println(function.apply("shyamsunder"));
        // Supplier<LocalDate> supplier=()-> LocalDate.now();
        // System.out.println(supplier.get());
        // LocalDateTime localdate=LocalDateTime.now();
        // DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM");
        // String time=localdate.format(formatter);
        // System.out.println(time);
        // LocalDateTime SixMonthsBefore=localdate.plusMinutes(330);
        // DateTimeFormatter formatt=DateTimeFormatter.ofPattern("yyyy/dd/MMM HH:mm:ss");
        // System.out.println(SixMonthsBefore.format(formatt));
        Function<Integer,Double> functionLambda=(a)->Math.sqrt(a);
        System.out.println(functionLambda.apply(4));
        Function<Integer,Double> functionMf=Math::sqrt;
        System.out.println(functionMf.apply(18));
        BiFunction<Integer,Integer,Integer> bifunction=(a,b)->Main.additional(a,b);
        System.out.println(bifunction.apply(10,20));
        BiFunction<Integer,Integer,Integer> answer=Main::additional;
        System.out.println(answer.apply(20,30));
        Print print=Main::displayed;
        print.display("Shyamsunder");
        Display dis=String::toUpperCase;
        System.out.println(dis.print("shyamsnder"));
	}
}
