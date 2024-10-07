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
public class kamarVIP extends Kamar {//Subclass dari class Kamar
    public kamarVIP(String nomorKamar){
        super(nomorKamar, "VIP", 1000000, true, "WiFi, TV, AC,Kolam renang pribadi");
    }
    
    @Override
    public double getHargaKamar() {
        return 250000;
    }

    @Override
    public String getFasilitas() {
        return "WiFi, TV, AC,Kolam renang pribadi";
    }
}
