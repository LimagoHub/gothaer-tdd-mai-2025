package de.gothaer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Multi multi = new MultiImpl();
        multi = new MultiOptimizer(multi);
        System.out.println( multi.multipliziere(3, 4) );
    }
}
