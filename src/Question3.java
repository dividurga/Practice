package homework9;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		complexNumber complex1 = new complexNumber();
		complex1.setRealPart(3);
		complex1.setImagPart(4);

		complexNumber complex2 = new complexNumber();
		complex2.setRealPart(7.4);
		complex2.setImagPart(14.89);

		// Testing all class methods
		System.out.println("Complex Number 1: "+ complex1);
		System.out.println("Checking for Equality: "+complex1.equals(complex2));
		System.out.println("Addition: "+complex1.add(complex2));
		System.out.println("Subtraction: "+complex1.subtract(complex2));
		System.out.println("Multiplication: "+complex1.multiply(complex2));
		System.out.println("Division: "+complex1.divide(complex2));
		System.out.println("Absolute value of "+ complex1+" is " +complex1.abs());
		System.out.println("Complex conjugate of "+complex1+"is "+complex1.complexConjugate());

	}

	public static class complexNumber {
		private double realPart;
		private double imagPart;

		public double getRealPart() {
			return realPart;
		}

		public void setRealPart(double realPart) {
			this.realPart = realPart;
		}

		public double getImagPart() {
			return imagPart;
		}

		public void setImagPart(double imagPart) {
			this.imagPart = imagPart;
		}

		public complexNumber add(complexNumber that) {
			/**
			 * Adds passed argument to complex number
			 */
			double real = this.realPart + that.realPart;
			double imag = this.imagPart + that.imagPart;
			complexNumber complex = new complexNumber();
			complex.realPart = real;
			complex.imagPart = imag;
			return complex;

		}

		public complexNumber subtract(complexNumber that) {
			/**
			 * Subtracts passed argument from the complex number
			 */
			double real = this.realPart - that.realPart;
			double imag = this.imagPart - that.imagPart;
			complexNumber complex = new complexNumber();
			complex.realPart = real;
			complex.imagPart = imag;
			return complex;

		}

		public complexNumber multiply(complexNumber that) {
			/**
			 * Multiplies complex number with the argument passed. (a+ib)(c+id)= ac-bd
			 * +i(ad+bc)
			 */
			double real = (this.realPart * that.realPart) - (this.imagPart * that.imagPart);
			double imag = this.realPart * that.imagPart + this.imagPart * that.realPart;
			complexNumber complex = new complexNumber();
			complex.realPart = real;
			complex.imagPart = imag;
			return complex;

		}

		public complexNumber divide(complexNumber that) {
			/**
			 * Divides complex number by the argument passed. Returns original complex
			 * number if passed argument is 0 + 0i
			 */

			if (that.abs() == 0) {
				System.out.println("Cannot divide by 0");
				return this;

			} else {
				complexNumber complex = new complexNumber();
				complex = this.multiply(that.complexConjugate());
				// dividing by the absolute value of the 2nd complex number
				complex.realPart /= that.abs();
				complex.imagPart /= complex.imagPart / that.abs();
				return complex;
			}

		}

		public double abs() {
			/**
			 * Finds out the absolute value of the complex number
			 */
			return Math.sqrt(Math.pow(this.imagPart, 2) + Math.pow(this.realPart, 2));
		}

		public complexNumber complexConjugate() {
			/**
			 * finds the complex conjugate of the complex number
			 */
			complexNumber complex = new complexNumber();
			complex.realPart = this.realPart;
			complex.imagPart = -1 * this.getImagPart();
			return complex;
		}

		@Override
		public String toString() {
			if (this.imagPart < 0)
				return this.realPart + " " + this.imagPart + " i";
			else
				return this.realPart + " + " + this.imagPart + " i";

		}

		public boolean equals(complexNumber that) {
			return (this.realPart == that.realPart && this.imagPart == that.imagPart);
		}

	}

}
