/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformasiwarna;

import java.text.DecimalFormat;

/**
 *
 * @author mgmdeveloper
 */
public class HSVtoRGB {
    
    public static void main(String[] args) {
        System.out.println("===== Hasil Konversi HSV to RGB======");
        String dataAwal = "65, 27, 234";
        String dataWarnaRGB = "251.0145, 0.8846, 0.9176";
        System.out.println(dataAwal);
        System.out.println(konversiHSVtoRGB(dataWarnaRGB));
    }
    
    public static String konversiHSVtoRGB(String warnaHSV){
        String[] strHSV;
        String hasil = "";
        
        strHSV = warnaHSV.split(",");
        double H = 0;
        double S = 0;
        double V = 0;
        double C;
        double H1;
        double X;
        double m;
        double R1 = 0;
        double G1 = 0;
        double B1 = 0;
        double R = 0;
        double G = 0;
        double B = 0;
        
        
        if (strHSV.length > 2) {
            H = Double.parseDouble(strHSV[0]);
            S = Double.parseDouble(strHSV[1]);
            V = Double.parseDouble(strHSV[2]);
            
            C = V * S;
            H1 = H / 60;
            X = C * (1 - Math.abs((H1 % 2) - 1));
            
            if (H >= 0 && H < 60) {
                R1 = C; G1 = X; B1 = 0;
            } else if (H >= 60 && H < 120) {
                R1 = X; G1 = C; B1 = 0;
            } else if (H >= 120 && H < 180) {
                R1 = 0; G1 = C; B1 = X;
            } else if (H >= 180 && H < 240) {
                R1 = 0; G1 = X; B1 = C;
            } else if (H >= 240 && H < 300) {
                R1 = X; G1 = 0; B1 = C;
            } else if (H >= 300 && H < 360) {
                R1 = C; G1 = 0; B1 = X; 
            }
            
            m = V - C;
            
            R = (R1 + m) * 255; 
            G = (G1 + m) * 255; 
            B = (B1 + m) * 255;
            DecimalFormat df = new DecimalFormat("0.0000");
            hasil ="R : "+df.format(R)+", G : "+df.format(G)+", B : "+df.format(B);
            
        } else
            System.out.println("Cek input warna HSV");
        return hasil;
    }
}
