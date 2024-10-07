/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RancanganSistem;

/**
 *
 * @author delia
 */

//Class untuk mengelola pesanan
public class Pesanan {
       //Atribut-atribut yang dimiliki oleh kelas Pesanan
    private String namaPelanggan;
    private Kamar room;
    private int durasiBooking;
    private double totalPesanan;
    
    
    //Konstruktur untuk inisialisasi object Pesanan
    public Pesanan(String namaPelanggan, Kamar room, int durasiBooking, double totalPesanan) {
        this.namaPelanggan= namaPelanggan;
        this.room = room;
        this.durasiBooking = durasiBooking;
        this.totalPesanan = totalPesanan;
    }
    
    //Getter untuk mengakses totalPesanan
    public double getTotalPesanan() {
        return totalPesanan; 
    }
    
    //Getter untuk mengakses namaPelanggan
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    
    //getter untuk mengakses kamar yang dipesanan
    public Kamar getKamar() {
        return room;
    }

    //Getter untuk mengakses durasiBooking dari pesanan yang dibuat
    public int getDurasiBooking() {
        return durasiBooking;
    }
    
    //Metode untuk menampilkan detail pesanan 
    public void displayDetailPesanan() {
        line();
        System.out.println("\t\t Detail Pesanan\t");
        line();
        System.out.println("Nama Customer            : " + namaPelanggan);
        System.out.println("Nomor Kamar yang dipesan : " + room.getNomorKamar());
        System.out.println("Tipe Kamar yang dipesan  : " + room.getTipeKamar());
        System.out.println("Durasi check-in (Hari)   : " + durasiBooking);
        System.out.println("Total Pembayaran         : Rp." + totalPesanan );
    }
    
    // Metode untuk mencetak garis yang bersifat static dan bisa dipanggil tanpa harus membuat method
    public static void line() {
        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
