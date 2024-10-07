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

//Kelas Hotel bertanggung jawab untuk mengelola data terkait kamar, pelanggan, dan pesanan dalam hotel
public class Hotel implements LayananHotel{
     //Deklarasi attribute kelas Hotel 
    private Kamar daftarKamar[] = new Kamar[5];//Array untuk menyimpan kamar sebanyak 5 
    private Pesanan daftarPesanan [] = new Pesanan[5];//Array untuk menyimpan Pesanam
    private Pelanggan daftarPelanggan [] = new Pelanggan[5];//Array untuk menyimpan pelanggan
    private int jumlahPesanan = 0; // Menyimpan jumlah pesanan yang telah ditambahkan
    private int jumlahPelanggan = 0; // Menyimpan jumlah pelanggan yang telah ditambahkan
    boolean adaKamar = false;
    
    //Metode untuk memeriksa kamar berdasarkan nomor 
    public Kamar getKamarByNomor(String nomorKamar) {
    for (Kamar kamar : daftarKamar) {
        if (kamar != null && kamar.getNomorKamar().equals(nomorKamar)) {
            return kamar; 
        }
    }
    return null; 
    }
    
    public int getJumlahPelanggan() {
        return jumlahPelanggan;
    }
    
    //metode untuk menambahKamaar ke dalam array daftarKamar
    @Override
    public void tambahKamar(Kamar kamar){
      for (int i = 0; i < daftarKamar.length; i++) {
            if (daftarKamar[i] == null) {  // Jika masih ada slot di array 
                daftarKamar[i] = kamar;    // Tambahkan kamar ke slot tersebut
                break;
            }else{
                System.out.println("Maaf,Kamar sudah full.");
            }
        }
        
    }
   
    //metode untuk melihat semua kamar yang tersimpan di Hotel beserta detailnya
    @Override
    public void lihatSemuaKamar() {
    boolean adaKamar = false; 
    System.out.println("-------------------------------------------------------------------------------- -----------");
    System.out.printf("%-10s %-10s %-15s %-15s %-30s%n", "Kamar", "Tipe", "Harga", "Status", "Fasilitas");
    System.out.println("--------------------------------------------------------------------------------------------");

    //Looping untuk menampilkan 
    for (Kamar room : daftarKamar) {
        if (room != null) { 
            adaKamar = true; 

            String status = room.cekStatusKamar() ? "Tersedia" : "Sudah Dipesan"; // Memanggil metode cekStatusKamar
            System.out.printf("%-10s %-10s %-15.2f %-15s %-20s%n", 
                    room.getNomorKamar(),   
                    room.getTipeKamar(),   
                    room.getHargaKamar(),   
                    status, // Gunakan status yang sudah didefinisikan
                    room.getFasilitas());
        }
    }
    if (!adaKamar) {
        System.out.println("Daftar kamar masih kosong.");
    }
}
    
    //Metode untuk menambah pesanan 
    @Override
    public void tambahPesanan(Pesanan pesanan) {
        if (jumlahPesanan < daftarPesanan.length) { 
            daftarPesanan[jumlahPesanan] = pesanan; 
            jumlahPesanan++;
            System.out.println("Pesanan berhasil ditambahkan.");
        } else {
            System.out.println("Maaf, kapasitas pesanan sudah penuh.");
        }
    }
    
   
    //Metode untuk menampilkan semua pesanan 
    @Override
    public void lihatSemuaPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("Tidak ada pesanan yang terdaftar.");
            return;
        }
        System.out.println("\t\tDaftar Pesanan");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-10s%n", "Nama Customer", "Nomor Kamar", "Durasi", "Total");
        System.out.println("------------------------------------------------------");
        
        for (int i = 0; i < jumlahPesanan; i++) {
            Pesanan pesanan = daftarPesanan[i];
            System.out.printf("%-20s %-15s %-10d %-10.2f%n",
                    pesanan.getNamaPelanggan(), 
                    pesanan.getKamar().getNomorKamar(),
                    pesanan.getDurasiBooking(),
                    pesanan.getTotalPesanan());
        }
        System.out.println("------------------------------------------------------");
    }
    
    
    //Metode untuk menambahkan pelanggan ke array daftarPelanggan
    @Override
    public boolean tambahPelanggan(Pelanggan pelanggan) {
        if (jumlahPelanggan < daftarPelanggan.length) { // Cek apakah masih ada slot kosong
            daftarPelanggan[jumlahPelanggan] = pelanggan; // Tambahkan pelanggan ke array
            jumlahPelanggan++; // Increment jumlah pelanggan
            return true;
        } else {
            return false;
        }
    }
   
    //Metode untuk melihat daftar pelanggan 
    @Override
    public void lihatDaftarPelanggan() {
    if (jumlahPelanggan == 0) {
        System.out.println("Tidak ada pelanggan yang terdaftar.");
        return;
    }
    System.out.println("\t\tDaftar Pelanggan");
    System.out.println("------------------------------------------------------");
    System.out.printf("%-20s %-15s%n", "Nama Pelanggan", "Nomor Kamar");
    System.out.println("------------------------------------------------------");
    
    for (int i = 0; i < jumlahPelanggan; i++) {
        Pelanggan pelanggan = daftarPelanggan[i];
        String nomorKamar = pelanggan.punyaPesanan() ? 
                pelanggan.getPesanan().getKamar().getNomorKamar() : "Tidak ada pesanan"; // Menampilkan nomor kamar atau status
        System.out.printf("%-20s %-15s%n", pelanggan.getNamaPelanggan(), nomorKamar);
    }
    System.out.println("------------------------------------------------------");
}
    
}