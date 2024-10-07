/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RunningSistem;
import RancanganSistem.*;//Mengimpor semua kelas dari package rancanganSistem 
import java.util.Scanner;

/**
 *
 * @author delia
 */
//Main class tempat mengimplementasikan semua kelas dan metode yang sudah dibuat dibedakan package agar tidak bingung yang mana yang di run 
public class GoHotel {

    //Metode untuk mencetak garis, bersifat static (opsional agar tampilan rapih)
    public static void line(){
        for(int i = 0; i <= 50; i++){
            System.out.print("=");
        }
        System.out.println();
    }
    
    public static void menuUtama(){//menu utama
        line();
        System.out.println("|\tSistem Reservasi GoHotel\t\t  |");
        line();
        System.out.println("1. Masuk sebagai Admin");
        System.out.println("2. Masuk sebagai Pelanggan");
        System.out.println("3. Keluar");
        line();
    }
    
    public static void main(String[] args) {
        // Membuat objek hotel
        Hotel hotelDelia = new Hotel();
        //Membuat objek scanner 
        Scanner inputMenu = new Scanner(System.in);
        int pilihan;//Deklarasi variabel yang akan digunakan sebagai ekspresi switch 
        
        do {//Program dieksekusi satu kali dulu 
            menuUtama();//Menampilkan menu utama 
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = inputMenu.nextInt(); //Input pilihan menu utama 
            inputMenu.nextLine();//Membersihkan sisa buffer 
            switch (pilihan) {
                case 1://Masuk sebagai admin 
                    Admin admin = new Admin("admin1", "admin123");//buat objek admin
                    System.out.print("Masukkan nama admin: ");
                    String inputNama = inputMenu.nextLine(); 
                    System.out.print("Masukkan password: ");
                    String inputPassword = inputMenu.nextLine(); 
                    // Periksa apakah nama dan password yang dimasukkan sesuai
                    if (inputNama.equals("Admin1") && inputPassword.equals("admin123")) {
                        System.out.println("Login berhasil. Selamat datang, " + inputNama + "!");
                        while (true) {
                        admin.menuAdmin();
                        // Memilih menu admin
                        int pilihanAdmin = inputMenu.nextInt();
                        inputMenu.nextLine();
                        
                        switch (pilihanAdmin) {
                            case 1:
                                hotelDelia.lihatSemuaKamar();//Memanggil method lihatSemuaKamar
                                break;
                            case 2:
                                admin.tambahKamar(hotelDelia);//Memanggil method tambahKamar
                                break;
                            case 3:
                                admin.lihatDaftarPelanggan(hotelDelia);//Memanggil method lihatDaftarPelanggan
                                break;
                            case 4:
                                admin.lihatPesanan(hotelDelia);//Memanggil methid lihatPesanan
                                break;
                            case 5:
                                System.out.println("Keluar dari menu admin.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                        if (pilihanAdmin == 5) 
                            break; // keluar dari loop admin
                    }
                    }
                        else{
                                 System.out.println("Login gagal. Nama atau password tidak sesuai.");
                                }
                        break;
             
                case 2:
                    // Cek apakah kapasitas pelanggan sudah penuh
                    if (hotelDelia.getJumlahPelanggan() < 5) {
                        System.out.print("Masukkan nama pelanggan: ");
                        String namaPelanggan = inputMenu.nextLine();
                        Pelanggan pelanggan = new Pelanggan(namaPelanggan);


                    // Menambahkan pelanggan ke daftar
                    if (hotelDelia.tambahPelanggan(pelanggan)) {
                        System.out.println("Pelanggan berhasil ditambahkan.");

                    // Menu untuk pelanggan
                    while (true){
                        Pelanggan.menuPelanggan();//Memanggil menu pelanggan
                        int pilihanPelanggan = inputMenu.nextInt();
                        inputMenu.nextLine();
                        
                        switch (pilihanPelanggan) {//Switch case berdasarkan pilihanPelanggan
                            case 1:
                                hotelDelia.lihatSemuaKamar();
                                break;
                                
                            case 2:
                                System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                                String nomorKamar = inputMenu.nextLine();
                                System.out.print("Masukkan durasi booking (hari): ");
                                int durasi = inputMenu.nextInt();
                                pelanggan.bookKamar(hotelDelia, nomorKamar, durasi);
                                break;
                            
                            case 3:
                                if (pelanggan.punyaPesanan()) {
                                    pelanggan.getPesanan().displayDetailPesanan();
                                    pelanggan.payPesanan();
                                } else {
                                    System.out.println("Tidak ada pesanan yang dapat ditampilkan.");
                                }
                                break;
                            case 4:
                                System.out.println("Keluar dari menu pelanggan.");
                                break;
                            
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }if (pilihanPelanggan == 4)
                        break; // keluar dari loop pelanggan
                    }
                    } else {
                        System.out.println("Gagal menambahkan pelanggan.");
                    }
                    } else {
                        System.out.println("Maaf, kapasitas pelanggan sudah penuh.");
                    }
                    break;

                case 3:
                    line();
                    System.out.println("Terima kasih telah menggunakan Aplikasi GoHotel!");
                    break; // keluar dari program
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 3);//Looping selama tidak memilih menu utama 3
        
        inputMenu.close(); // Menutup scanner
    }
   
}
