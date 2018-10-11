// file: Die.java
// generated by: mashc
// from: Die.mash

public class Die {

protected static final int MAX_INT = java.lang.Integer.MAX_VALUE;

protected static final int MIN_INT = java.lang.Integer.MIN_VALUE;

protected static final long MAX_LONG = java.lang.Long.MAX_VALUE;

protected static final long MIN_LONG = java.lang.Long.MIN_VALUE;

protected static final double PI = java.lang.Math.PI;

private static java.util.Scanner mash_console_scanner 
               = new java.util.Scanner(System.in);

protected static final int TIMES = 100;

protected static final int MAX = 6;

protected static final int MIN = 1;

public static void main(java.lang.String[] mash_args_param) 
         throws java.lang.Exception {
            
{
for (int loop = 0; loop < Die.TIMES; loop = loop + 1)
{
java.lang.System.out.print(Die.dice() + (" "));
}
java.lang.System.out.println();
}

         }


protected static int dice()  {
double n = java.lang.Math.random() * Die.MAX + Die.MIN;
int m = (int) n;
return m;
}
}