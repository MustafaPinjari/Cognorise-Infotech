import java.util.Scanner;

public class Calculator

{
    public static  void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int a,b,c,r;

        System.out.println("Welcome to the Calculator Simulator \n Please Select an operator (Type a number)");
        System.out.println("1.+\n2.-\n3.*\n4./ ");
        System.out.println("->");
        c=sc.nextInt();

        System.out.println("Enter the value for 'A' :");
        a=sc.nextInt();

        System.out.println("Enter the value for 'B' :" );
        b=sc.nextInt();

        switch (c)
        {
            case 1:
                System.out.println("You Select Addition!");
                r=a+b;
                System.out.println("Addition of "+a+" and " +b+ " is "+r);
                break;
            case 2:
                System.out.println("You Select Subtraction!");
                r=a-b;
                System.out.println("Subtraction of "+a+" and " +b+" is "+r);
                break;
            case 3:
                System.out.println("You Select Multiplication!");
                r=a*b;
                System.out.println("Subtraction of "+a+" and " +b+" is "+r);
                break;
            case 4:

                System.out.println("You Select Division!");
                if (a <= 0 || b<=0)
                {
                    System.out.println("A number less then 0 is not Divisible");
                }
                else
                {

                r=a/b;
                System.out.println("Division of \"+a+\" and \" +b+\" is \"+r");
                }
            default:
                System.out.println("Invalid Choice X");
                break;
        }

    }
}
