package Tran;

import java.util.Scanner;

/**
 * Solution for Towers of Hanoi. <br>
 * Uses recursion in order to calculate the minimum number of moves needed from
 * a set number of discs.
 * 
 * @author Net_Nerd
 */
public class Main {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		String Src = "Src", Aux = "Aux", Dst = "Dst";
		System.out.print("Please enter the number of discs: ");
		int Discs = Integer.parseInt(myInput.nextLine());
		Solve(Discs, Src, Aux, Dst);
	}

	/**
	 * Use recursion to swap between the top disc and n number of discs from the
	 * source using the auxillary; moving the bottom disc to the destination.
	 * Rinse and repeat until the top disc arrives at the destination.
	 * 
	 * @param Discs Number of discs.
	 * @param Src Source peg.
	 * @param Aux Auxillary peg.
	 * @param Dst Destination peg.
	 */
	public static void Solve(int Discs, String Src, String Aux, String Dst) {
		// Recursion base case.
		if (Discs == 0)
			return;
		else {
			Solve(Discs - 1, Src, Dst, Aux);
			System.out.println("Move from " + Src + " to " + Dst);
			Solve(Discs - 1, Aux, Src, Dst);
		}
	}

}
