import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    // variables to hold numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;
    // default constructor creates a rational number 0/1
    public Rational(){
        this(BigInteger.ZERO, BigInteger.ONE);
    }
// constructor, creates Rational number with specified numerator/denominator
public Rational(BigInteger numerator, BigInteger denominator) {
    // checks if demnominator is 0
    if (denominator.equals(BigInteger.ZERO)) {
        throw new ArithmeticException("The denominator cannot be 0. ");
    }
    // find the GCD to simplify the fraction
    BigInteger gcd = numerator.gcd(denominator);
    // simplify the numerator and denominator
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
}

// returns numerator
public BigInteger getNumerator() {
    return numerator;
}

// returns denominator
public BigInteger getDenominator() {
    return denominator; 
}

// add rational numbers
public Rational add(Rational secondRational) {
    BigInteger newNumerator = numerator.multiply(secondRational.getDenominator())
            .add(denominator.multiply(secondRational.getNumerator()));
    BigInteger newDenominator = denominator.multiply(secondRational.getDenominator());
    return new Rational(newNumerator, newDenominator);
}

// subtract rational number from this rational
public Rational subtract(Rational secondRational) {
    BigInteger newNumerator = numerator.multiply(secondRational.getDenominator())
            .subtract(denominator.multiply(secondRational.getNumerator()));
    BigInteger newDenominator = denominator.multiply(secondRational.getDenominator());
    return new Rational(newNumerator, newDenominator);
}

// multiply rational numbers
public Rational multiply(Rational secondRational) {
    BigInteger newNumerator = numerator.multiply(secondRational.getNumerator());
    BigInteger newDenominator = denominator.multiply(secondRational.getDenominator());
    return new Rational(newNumerator, newDenominator);
}

// divide rational number by this rational
public Rational divide(Rational secondRational) {
    BigInteger newNumerator = numerator.multiply(secondRational.getDenominator());
    BigInteger newDenominator = denominator.multiply(secondRational.getNumerator());
    return new Rational(newNumerator, newDenominator);
}
// convert the Rational object to string
@Override
public String toString() {
    // if denominator is 1, return numerator only
    if (denominator.equals(BigInteger.ONE)) {
        return numerator.toString();
    } else {
        return numerator + "/" + denominator;
    }
}

// convert to double, preventing non-teranating decimal error
@Override
public double doubleValue() {
    return new java.math.BigDecimal(numerator)
            .divide(new java.math.BigDecimal(denominator), 10, java.math.RoundingMode.HALF_UP)
            .doubleValue();
}

// convert to int
@Override
public int intValue() {
    return (int) doubleValue();
}

// convert to float
@Override
public float floatValue() {
    return (float) doubleValue();
    
}

@Override
public long longValue() {
    return (long) doubleValue(); // Convert the Rational to a double, then to a long
}

// comapare 2 rational numbers
@Override
public int compareTo(Rational o) {
    BigInteger diff = numerator.multiply(o.getDenominator())
            .subtract(denominator.multiply(o.getNumerator()));
    return diff.compareTo(BigInteger.ZERO);
    }

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // prompt user for the first rational number
    System.out.print("Enter the first rational number (numerator and denominator): ");
    BigInteger num1 = input.nextBigInteger();
    BigInteger den1 = input.nextBigInteger();
    Rational r1 = new Rational(num1, den1);

    // prompt user for the second rational number
    System.out.print("Enter the second rational number (numerator and denominator): ");
    BigInteger num2 = input.nextBigInteger();
    BigInteger den2 = input.nextBigInteger();
    Rational r2 = new Rational(num2, den2);

    // display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " as a decimal = " + r2.doubleValue());
    }
}
    
