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

//Class untuk mengelola pelanggan 
public class Pelanggan {
    private String namaPelanggan;//Variabel untuk menyimpan nama pelanggan 
    private Pesanan pesananPelanggan; // variabel untuk menyimpan objek pesanan pelanggan

    //Konsttruktor untuk inisialisasi object pelanggan 
    public Pelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }
    
    //Getter nama dan Pesanan yang dimiliki pelanggan
    public String getNamaPelanggan(){
        return namaPelanggan;
    }

    public Pesanan getPesanan() {
        return pesananPelanggan;
    }
    
    // Metode untuk mengecek apakah pelanggan punya pesanan 
    public boolean punyaPesanan() {
        return pesananPelanggan != null; // Mengembalikan true jika pesanan ada
    }

    //Metode untuk melakukan booking kamar oleh pelanggan 
    public void bookKamar(Hotel hotel, String nomorKamar, int durasiBooking) {
    Kamar room = hotel.getKamarByNomor(nomorKamar);//Pembuatan object kamat
    //dengan memanggil metode getByNomor dalam memvalidasi input kamar yang ingin dipesanan
    if (room != null && room.cekStatusKamar()) {//Pengecekan kamar tidak kosong dan status kamar juga tersedia
        room.bookingKamar();//Memanggil metode bookingKamar yang dimiliki oleh kelas Kamar
        
        double totalPesananPelanggan = durasiBooking * room.getHargaKamar();//Menghitung totalPesananPelanggan

        // Membuat objek pesana
        pesananPelanggan = new Pesanan(namaPelanggan, room, durasiBooking, totalPesananPelanggan);
        
        // Menambahkan pesanan ke hotel
        hotel.tambahPesanan(pesananPelanggan);
        
        System.out.println("Kamar berhasil dipesan.");
    } else {//Penanganan jika kamar tidak tersedia
        System.out.println("Kamar " + nomorKamar + " tidak tersedia atau tidak ditemukan.");
    }
    }

    //Metode untuk membayar pesanan
    public void payPesanan() {
        if (pesananPelanggan == null) {//Pengkondisian jika tidak ada pesanan yang dapat dibayar
            System.out.println("Tidak ada pesanan yang dapat dibayar.");
            return;
        }
        //Jika ada 
        Scanner inputBayar = new Scanner(System.in);//Membuat object Scanner untuk input pembayaran 
        
        System.out.print("Masukkan jumlah pembayaran: ");
        double jumlahBayar = inputBayar.nextDouble();//Input bayaran
        //Operasi untuk kembalian
        double kembalian = jumlahBayar - pesananPelanggan.getTotalPesanan();
        
        //Pengkondisian untuk mengecek uang yang dibayarkan 
        if (jumlahBayar >= pesananPelanggan.getTotalPesanan()) {
            System.out.println("Pembayaran berhasil. Terima kasih, " + namaPelanggan + "!");
            System.out.printf("Kembalian Anda: %.2f%n", kembalian);
        } else {//Jika uang yang diinput kurang dari yang seharusnay dibayarkan
            System.out.println("Jumlah pembayaran tidak mencukupi. Total yang harus dibayar: " + pesananPelanggan.getTotalPesanan());
        }
    }
    
    //Metode untuk menampilkan menu yang bisa dipilih oleh pelanggan, bersifat static 
     public static void menuPelanggan(){
        System.out.println("+=======================================+");
        System.out.println("+ \t\tMenu Pelanggan          +");
        System.out.println("+=======================================+");
        System.out.println("+ 1.Lihat Daftar Kamar                  +");
        System.out.println("+ 2.Pesan Kamar                         +");
        System.out.println("+ 3.Lihat Detail Pesanan dan Bayar      +");
        System.out.println("+ 4.Keluar                              +");
        System.out.println("+=======================================+");
        System.out.print("Masukkan Pilihan Anda: ");
    }
    
}
