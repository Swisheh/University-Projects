// file: BMI.java
// generated by: mashc
// from: BMI.mash

public class BMI {

protected static final int MAX_INT = java.lang.Integer.MAX_VALUE;

protected static final int MIN_INT = java.lang.Integer.MIN_VALUE;

protected static final long MAX_LONG = java.lang.Long.MAX_VALUE;

protected static final long MIN_LONG = java.lang.Long.MIN_VALUE;

protected static final double PI = java.lang.Math.PI;

private static java.util.Scanner mash_console_scanner 
               = new java.util.Scanner(System.in);

public static void main(java.lang.String[] mash_args_param) 
         throws java.lang.Exception {
            
java.lang.System.out.print("What's your height? ");
double h = mash_console_scanner.nextDouble();
java.lang.System.out.print("What's your weight? ");
double w = mash_console_scanner.nextDouble();
double bmi = (w / (h * h)) * 10000;
java.lang.System.out.println("Your BMI result is: " + bmi);

         }

}
