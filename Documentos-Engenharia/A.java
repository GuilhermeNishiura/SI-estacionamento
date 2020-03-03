package mili;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner potato = new Scanner(System.in);

		char[][] mapa = new char[8][8];
		char[] brancas = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' };
		char[] pretas = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '@' };
		int[][] jogP = new int[24][2];
		int j = 1, a = 0, b = 1, c = 0, dirB, dirP;
		char moveP, moveB;

		while (a < 7) {

			mapa[0][a] = brancas[c];
			jogP[a][0] = 0;
			jogP[a][1] = a;

			mapa[7][a] = pretas[c];
			jogP[(12 + c)][0] = 7;
			jogP[(12 + c)][1] = a;

			a = a + 2;
			c++;
		}

		while (b < 8) {

			mapa[1][b] = brancas[c];
			jogP[c][0] = 1;
			jogP[c][1] = a;

			mapa[6][b] = pretas[c];
			jogP[(12 + c)][0] = 6;
			jogP[(12 + c)][1] = a;

			b = b + 2;
			c++;
		}

		a = 0;

		while (a < 7) {

			mapa[2][a] = brancas[c];
			jogP[c][0] = 2;
			jogP[c][1] = a;

			mapa[5][a] = pretas[c];
			jogP[(12 + c)][0] = 5;
			jogP[(12 + c)][1] = a;

			a = a + 2;
			c++;
		}
		
		for(int i=0; i<24; i++) {
			System.out.print(jogP[i][0] + "\t");
			System.out.println(jogP[i][1]);
		}

		while (0 < j) {

			for (int i = 0; i < 8; i++) {
				for (int l = 0; l < 8; l++) {
					System.out.print(mapa[i][l] + " | ");
				}
				System.out.println();
			}

			System.out.println("Rodada das brancas");
			System.out.println("Selecione uma peça:");
			moveB = potato.next().charAt(0);

			for (int i = 0; i < 12; i++) {
				if (moveB == brancas[i]) {
					mapa[jogP[i][0]][jogP[i][1]] = ' ';
					if (jogP[i][0] == 0) {
						jogP[i][0]++;
						jogP[i][1]++;
						mapa[jogP[i][0]][jogP[i][1]] = brancas[i];
					} else if (jogP[i][0] == 7) {
						jogP[i][0]--;
						jogP[i][1]++;
						mapa[jogP[i][0]][jogP[i][1]] = brancas[i];
					} else {
						System.out.println("Qual direção?");
						System.out.println("0   1");
						System.out.println("| 1 |");
						dirB = potato.nextInt();
						if (dirB == 0) {
							jogP[i][0]--;
						} else {
							jogP[i][0]++;
						}
						jogP[i][1]++;
						mapa[jogP[i][0]][jogP[i][1]] = brancas[i];
					}
				}
			}
		}

		potato.close();
	}

}
