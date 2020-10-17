package main.resources;

public class Factorial {
    public  static Integer calculateFactorial(Integer n){
        if (n == 0){return 1;}
        else if (n == 1){return 1;}
        else{
            return (n*(calculateFactorial(n-1)));
        }
    }

    public static Integer calculateCombination(Integer n, Integer r) throws Exception{
        if (n >= r) {

            Integer numerator = calculateFactorial(n);
            Integer denominator =  (calculateFactorial(r) * calculateFactorial(n - r));

            return (numerator / denominator);
        }
        else {throw new Exception("n is less than r !!! ") ;}
    }
}
