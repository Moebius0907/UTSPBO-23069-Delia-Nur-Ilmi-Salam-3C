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
public class kamarStandar extends Kamar{//Subclass dari kelas Kamar
    
    public kamarStandar(String nomorKamar) {
         super(nomorKamar, "Standar", 500000, true, "WiFi, TV, Shower");
    }

    @Override
    public double getHargaKamar() {
        return 150000;
    }

    @Override
    public String getFasilitas() {
        return "Wifi, TV dan Shower";
    }
}
