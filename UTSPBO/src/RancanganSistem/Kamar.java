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

//Class kamar yang menyediakan informasi terkait kamar dan pengelolaan kamar, superclass dari KamarStandar dan kamarVIP
public class Kamar {
       //Atribut-atribut yang dimiliki class Kamar
    private String nomorKamar;
    private String tipeKamar;
    private double hargaKamar;
    private boolean kamarTersedia;
    private String fasilitas; 
    
    //Konstruktor untuk inisialisasi object kamar
    public Kamar(String nomorKamar, String tipeKamar, double hargaKamar, boolean kamarTersedia, String fasilitas) {
        this.nomorKamar= nomorKamar;
        this.tipeKamar = tipeKamar;
        this.hargaKamar = hargaKamar;
        this.kamarTersedia = true;  
        this.fasilitas = fasilitas; 
    }
    
    //Getter untuk akses atribut kamar 
    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }
    
    public double getHargaKamar() {
        return hargaKamar; 
    }

    public String getFasilitas() {
        return fasilitas;
    }
    
    //Metode untuk mengecek status kamar 
    public boolean cekStatusKamar() {
        return kamarTersedia;
    }
    
    //Metode untuk memesan kamar yang akan dipakai pelanggan 
    public void bookingKamar() {
        if (kamarTersedia) {
            kamarTersedia = false;//mengubah status kamar jadi false jika berhasil dipesan 
            System.out.println("Kamar nomor " + nomorKamar + " berhasil dipesan.");
        } else {
            System.out.println("Kamar nomor " + nomorKamar + " sudah tidak tersedia.");
        }
    } 
}