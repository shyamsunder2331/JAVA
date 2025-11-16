import java.util.*;
import java.util.function.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
interface Shape{
    void execute();
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
public class LambdaTime
{
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
        Addition addition=(a,b)->(a+b);
        System.out.println(addition.addition(6,5));
        
        LowerCase lowercase=(s)-> s.toLowerCase();
        System.out.println(lowercase.lowerCase("SHYAMSUNDER"));
        StringReversal rev=( s)->{
            String reversal="";
            for(char i:s.toCharArray()){
                reversal=i+reversal;
            }
            return reversal;
        };
        System.out.println(rev.reverse("Shyamusunder"));
        Thread thread=new Thread(()->System.out.println("Run method is called using Lambda expression"));
        thread.start();
        Function<String,Integer> function= (s)->s.length();
        System.out.println(function.apply("shyamsunder"));
        Supplier<LocalDate> supplier=()-> LocalDate.now();
        System.out.println(supplier.get());
        LocalDateTime localdate=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMM dd/yyyy");
        String time=localdate.format(formatter);
        System.out.println(time);
	}
}
