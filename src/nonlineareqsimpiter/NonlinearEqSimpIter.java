package nonlineareqsimpiter;

import static java.lang.Math.abs;


public class NonlinearEqSimpIter {
    static final String f = "x^3 + 3x + 1 = 0";
    static final double a = -1.5;
    static final int b = 0;
    static final double eps = 0.000001;

    public static void main(String[] args) {       
        System.out.println(f);
        System.out.println("[" + a + "]" + "[" + b + "]");
        System.out.println("e = " + eps);
        
        System.out.println("Метод простой итерации");
        simpIter();
        System.out.println("*****************************************");
        
        System.out.println(f);
        System.out.println("[" + a + "]" + "[" + b + "]");
        System.out.println("e = " + eps);
        
        System.out.println("Метод дихотомии");
        dihotomy();
        
        System.out.println("*****************************************");
        
        System.out.println(f);
        System.out.println("[" + a + "]" + "[" + b + "]");
        System.out.println("e = " + eps);
        
        System.out.println("Метод Ньютона");
        newton();
        
        System.out.println("*****************************************");
        
        System.out.println(f);
        System.out.println("[" + a + "]" + "[" + b + "]");
        System.out.println("e = " + eps);
        
        System.out.println("Метод хорд");
        hord();
           
    }
    
    public static void simpIter(){       
        int n = 1;
        
        double xPrev = a;
        double x = (-(Math.pow(xPrev, 3) - 1)) / 3.;
        
        do {
           xPrev = x;
           x = (-(Math.pow(xPrev, 3)) - 1) / 3.;
           n++;
        } while(abs(x - xPrev) >= eps);
        
        System.out.println("x = " + x);
        System.out.println("n = " + n);
        
        System.out.print(x + "^3 + 3*" + x + " + 1 = ");
        System.out.print(Math.pow(x, 3) + 3*x + 1);
    }
    
    public static void dihotomy(){
        int n = 1;
        
        double x = a;
        double h = (b - a) / 2;
        
        while(Math.abs(Math.pow(x, 3) + 3 * x + 1) > eps){
            x = x + Math.signum(Math.pow(a, 3) + 3 * a + 1) * Math.signum(Math.pow(x, 3) + 3 * x + 1) * h;
            h = h / 2;
            n++;
        }
        
        System.out.println("x = " + x);
        System.out.println("n = " + n);
        
        System.out.print(x + "^3 + 3*" + x + " + 1 = ");
        System.out.print(Math.pow(x, 3) + 3*x + 1);
    }
    
    public static void newton(){
        int n = 1;
        
        double x = b;
        
        while(Math.abs(Math.pow(x, 3) + 3 * x + 1) > eps){
            x = x - (Math.pow(x, 3) + 3 * x + 1) / (3 * Math.pow(x, 2) + 3);
            n++;
        }
        
        System.out.println("x = " + x);
        System.out.println("n = " + n);
        
        System.out.print(x + "^3 + 3*" + x + " + 1 = ");
        System.out.print(Math.pow(x, 3) + 3*x + 1);
    }
    
    public static void hord(){
        int n = 1;
        
        double x;
        double xPrev;
        double m1 = 3;
        
        if(Math.pow(a, 3) + 3 * a + 1 > 0){
            xPrev = b;
            x = xPrev - (Math.pow(xPrev, 3) + 3 * xPrev + 1) / (Math.pow(xPrev, 3) + 3 * xPrev + 1 - (Math.pow(a, 3) + 3 * a + 1)) * (xPrev - a);
            do{
                xPrev = x;
                x = xPrev - (Math.pow(xPrev, 3) + 3 * xPrev + 1) / (Math.pow(xPrev, 3) + 3 * xPrev + 1 - (Math.pow(a, 3) + 3 * a + 1)) * (xPrev - a);
                n++;
            } while(Math.abs(x - xPrev) > eps);
            
        }
        else{
            xPrev = a;
            x = xPrev - (Math.pow(xPrev, 3) + 3 * xPrev + 1) / (Math.pow(xPrev, 3) + 3 * xPrev + 1 - (Math.pow(b, 3) + 3 * b + 1)) * (xPrev - b);
            do{
                xPrev = x;
                x = xPrev - (Math.pow(xPrev, 3) + 3 * xPrev + 1) / (Math.pow(xPrev, 3) + 3 * xPrev + 1 - (Math.pow(b, 3) + 3 * b + 1)) * (xPrev - b);
                n++;
            } while(Math.abs(x - xPrev) > eps);
        }
        
        System.out.println("x = " + x);
        System.out.println("n = " + n);
        System.out.print(x + "^3 + 3*" + x + " + 1 = ");
        System.out.print(Math.pow(x, 3) + 3*x + 1);
    }
}
