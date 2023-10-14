package tk3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class jenissampah {
    private String jenis;

    	public jenissampah(String name) {
    		this.jenis = name;
    	}

    	public String deteksijenis() {
    		return jenis;
    	}

    public abstract void diolah();
	}

class sampahorganik extends jenissampah {
    public sampahorganik(String namasampah) {
        super(namasampah);
    }
    public void diolah() {
        System.out.println(deteksijenis() + " akan dibusukkan untuk dijadikan pupuk organik.");
    }
}

class sampahanorganik extends jenissampah {
    public sampahanorganik(String namasampah) {
        super(namasampah);
    }

    public void diolah() {
        System.out.println(deteksijenis() + " akan didaur ulang.");
    }
}

class sampahKertas extends jenissampah {
    public sampahKertas(String namasampah) {
        super(namasampah);
    }

    public void diolah() {
        System.out.println(deteksijenis() + " akan didaur ulang menjadi kertas kembali.");
    }
}
public class tk3 {
	Scanner A = new Scanner(System.in);
	//agar tidak rusak apabila menginput huruf. Apabila inpu huruf, maka output digantikan menjadi -1
	public int numberinput() { 
		int a;
		try {
			a = A.nextInt();
		} catch (Exception e) {
			a = -1;
		}A.nextLine();
		return a;
	}
public tk3() {
        List<jenissampah> buang = new ArrayList<>();
        int option;
        System.out.println("Selamat datang di aplikasi pengelola sampah");
        System.out.println("Team Project Kelompok 3");
        System.out.println();
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Anggota:");
        System.out.println("Muhammad Ilham Kurniawan - 2602334524");
        System.out.println("Rinaldi Azhari - 2301967056");
        System.out.println("Raffaldo Timothy Soputan - 2602339140");
        System.out.println();
        System.out.println("Tekan Enter untuk melanjutkan.");
        A.nextLine();
        while (true) { //loop berjalan
        	System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Pilihan:");
            System.out.println("1. Masukkan sampah organik");
            System.out.println("2. Masukkan sampah anorganik");
            System.out.println("3. Masukkan sampah kertas");
            System.out.println("4. Olah sampah");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            option = numberinput();
            switch (option) {
                case 1:
                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    System.out.print("Apa nama sampah organik yang anda masukkan? ");
                    System.out.println();
                    String sOrganik = A.nextLine();
                    buang.add(new sampahorganik(sOrganik));
                    break;
                case 2:
                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    System.out.print("Apa nama sampah anorganik yang anda masukkan? ");
                    System.out.println();
                    String sAnorganik = A.nextLine();
                    buang.add(new sampahanorganik(sAnorganik));
                    break;
                case 3:
                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    System.out.print("Apa jenis kertas yang anda masukkan? ");
                    System.out.println();
                    String sKertas = A.nextLine();
                    buang.add(new sampahKertas(sKertas));
                    break;
                case 4:
                	if (!buang.isEmpty()) { 
	                	//if else untuk deteksi apakah terdapat sampah atau tidak
	                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
	                    System.out.println("Mengelola Sampah...");
	                    System.out.println();
	                    buang.forEach(jenissampah::diolah); //lambda
	                    buang.clear();
	                    System.out.println();
	                    System.out.println("Tekan Enter untuk kembali.");
	                    A.nextLine();
                	} else { 
                		//apabila array kosong maka akan muncul informasi sampah kosong
                		System.out.println("\n\n\n\n\n\n\n\n\n\n");
                		System.out.println("Sampah kosong");
                		System.out.println();
                		System.out.println("Tekan Enter untuk kembali");
                		A.nextLine();
                	}
                    break;
                case 5:
                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
                	System.out.println("Terimakasih sudah menggunakan aplikasi ini!");
                    A.close(); //loop berhenti
                    return;
                default: 
                	System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Masukkan angka 1 hingga 5 sesuai pilihan.");
                    //apabila input diluar dari case diatas
                    System.out.println();
                    System.out.println("Tekan Enter untuk kembali.");
                    A.nextLine();
                    break;
            }
        }
    }
public static void main(String[] args) {
	new tk3();
	}
}