package java_filekezeles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filekezeles {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// h1();
		// h2("cica.txt");
		// h3("cica.txt","cicamasolat.txt");
		// h4();
		// System.out.println(visszaolvas(1));
		dragabbak(1000);
	}

	public static String h1() throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = null;
		String sor;
		String filenev = "";
		int sorid = 0;
		System.out.println("Name of the File: ");
		while (sorid >= 0) {
			sor = scanner.nextLine();
			if (sorid == 0) {
				filenev = sor;
				bw = new BufferedWriter(new FileWriter(sor));
				System.out.println("Type /end/ to close...");
			} else {
				bw.write(sor);
				bw.newLine();
			}
			sorid++;
			String[] szavak;
			szavak = sor.split(" ");
			for (String szo : szavak) {
				System.out.println(szo + ": ");
				if (szo.equalsIgnoreCase("end")) {
					sorid = -1;
				}
			}
		}
		bw.close();
		System.out.println("Done...");
		return filenev;
	}

	public static void h2(String filenev) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filenev));
			String sor;
			while ((sor = br.readLine()) != null) {
				System.out.println(sor.toUpperCase());
			}
			br.close();
			System.out.println("Done...");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filenev);
		}
	}

	public static void h3(String filebe, String fileki) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileki));
		BufferedReader br = new BufferedReader(new FileReader(filebe));
		String[] szamok = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		String[] betuvel = { "egy", "ketto", "harom", "negy", "ot", "hat", "het", "nyolc", "kilenc", "nulla" };
		String sor;
		while ((sor = br.readLine()) != null) {
			for (int i = 0; i < 10; i++) {
				sor = sor.replace(szamok[i], betuvel[i]);
			}
			bw.write(sor);
			bw.newLine();

		}
		br.close();
		bw.close();

	}

	public static void h4() throws FileNotFoundException, IOException {
		auto[] autok = { new auto("AAA111", "Opel", 500), new auto("BBB222", "Kia", 1300),
				new auto("CCC333", "Fiat", 350), new auto("DDD444", "Skoda", 1500) };
		ObjectOutputStream kiiro = new ObjectOutputStream(new FileOutputStream("Autok.dat"));

		for (auto auto : autok) {
			kiiro.writeObject(auto);
		}
		kiiro.close();
		System.out.println("Done...");
	}

	public static auto visszaolvas(int i) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("Autok.dat");
		List<auto> autok = new ArrayList();
		if (file.exists()) {
			ObjectInputStream olvaso = new ObjectInputStream(new FileInputStream(file));
			auto beolvasott;
			try {
				while (true) {
					beolvasott = (auto) olvaso.readObject();

					autok.add(beolvasott);

				}
			} catch (EOFException e) {

			}
			try {
				auto eredmeny = autok.get(i);
				return eredmeny;
			} catch (Exception e) {
				return null;
			}

		}
		return null;
	}

	public static void dragabbak(int min) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("Autok.dat");
		List<auto> autok = new ArrayList();
		if (file.exists()) {
			ObjectInputStream olvaso = new ObjectInputStream(new FileInputStream(file));
			auto beolvasott;
			try {
				while (true) {
					beolvasott = (auto) olvaso.readObject();
					if (beolvasott.ar >= min) {
						autok.add(beolvasott);
					}
				}
			} catch (EOFException e) {
				for (auto auto : autok) {
					System.out.println(auto);
				}
			}
		}
	}

}
