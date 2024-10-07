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
public interface LayananHotel {//Interface yang akan diimplementasikan oleh Class Hotel
    
    //Berupa metode-metode yang dimiliki oleh class Hotel 
    public void tambahKamar(Kamar room); 
    public void lihatSemuaKamar();
    public void tambahPesanan(Pesanan pesanan); 
    public void lihatSemuaPesanan(); 
    public boolean tambahPelanggan(Pelanggan pelanggan);
    public void lihatDaftarPelanggan(); 
}
