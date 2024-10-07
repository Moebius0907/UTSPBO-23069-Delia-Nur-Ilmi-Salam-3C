/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RancanganSistem;

import java.util.Scanner;

/**
 *
 * @author delia
 */

//Class admin yang berguna dalam pengelolaan hotel oleh admin
public class Admin {
     //Attribute yang dimiliki oleh class admin accesnya private
    private String usernameAdmin;
    private String Password;
    
    //Konstruktor untuk menginisialisasi class Admin
    public Admin(String usernameAdmin, String password){
        this.usernameAdmin = usernameAdmin;
        this.Password = Password;
    }
    
    //Metode untuk menambahkan kamar oleh admin
    public void tambahKamar(Hotel hotelDelia){//Menerima parameter berupa object dari kelas Hotel 
        Scanner inputKamar = new Scanner(System.in);//Membuat object Scanner untuk inputKamar
        
        //Input nomor dan tipe kamar
        System.out.print("Masukkan nomor kamar: ");
        String nomorKamar = inputKamar.nextLine();
        System.out.print("Masukkan tipe kamar (Standar/VIP): ");
        String tipeKamar = inputKamar.nextLine();
        
        Kamar kamar;//deklarasi variabel kamar yang akan digunakan untuk membuat object kamar berdasarkan input tipe kamar
        
        //Pengkondisian pembuatan objek kamar berdasarkan tipe
        if (tipeKamar.equals("Standar")) {//menggunakan method equals ddalam membandingkan string 
            kamar = new kamarStandar(nomorKamar);//dibuat objek kamarStandar 
        } else if (tipeKamar.equals("VIP")) {
            kamar = new kamarVIP(nomorKamar);//dibuat objek kamarVIP
        } else {//Penanganan jika input selain di atas
            System.out.println("Tipe kamar tidak valid! Kamar baru gagal ditambahkan.");
            return;//mengakhiri eksekusi 
        }

        hotelDelia.tambahKamar(kamar);//Menambahkan kamar yang sudah dibuat ke objek hotel 
        System.out.println(usernameAdmin + " berhasil menambahkan kamar " + kamar.getNomorKamar());//Pesan berhasil input kamar
    }
    
    //Metode untuk melihat pesanan
    public void lihatPesanan(Hotel hotelDelia) {
        hotelDelia.lihatSemuaPesanan();//Memanggil method lihatSemuaPesanan yang dimiliki oleh kelas Hotel 
    }
    
    //Metode untuk melihat daftar pelanggan
     public void lihatDaftarPelanggan(Hotel hotelDelia) {
        hotelDelia.lihatDaftarPelanggan();//Memanggil method lihatDaftarPelanggan yang dimiliki oleh kelas hotel
    }
    
    public static void menuAdmin(){//Metode static yang bisa dipanggil tanpa membuat objek, hanya menampilkan menu-menu yang bisa diakses admin
        System.out.println("+=======================================+");
        System.out.println("+ \t\tMenu Admin              +");
        System.out.println("+=======================================+");
        System.out.println("+ 1.Lihat Daftar Kamar                  +");
        System.out.println("+ 2.Tambah Kamar                        +");
        System.out.println("+ 3.Lihat Daftar Pelanggan              +");
        System.out.println("+ 4.Lihat Daftar Pesanan                +");
        System.out.println("+ 5.Keluar                              +");
        System.out.println("+=======================================+");
        System.out.print("Masukkan Pilihan Anda: ");
    }
}