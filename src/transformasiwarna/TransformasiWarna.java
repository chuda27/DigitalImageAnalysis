/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformasiwarna;

/**
 *
 * @author mgmdeveloper
 */
public class TransformasiWarna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("===== Hasil Konversi RGB to HSV======");
        String dataWarnaRGB = "65, 27, 234";
        System.out.println(KonversiKeBiner(dataWarnaRGB));
    }
    
    public static String KonversiKeBiner(String dataWarna) {
        String[] RGB = dataWarna.split(",");
        if (RGB.length > 2) {
            double R;
            double G;
            double B;
            double rata2;
            
            R = Double.parseDouble(RGB[0]);
            G = Double.parseDouble(RGB[1]);
            B = Double.parseDouble(RGB[2]);
            
            rata2 = (R + G + B)/3;
            
            if (R > rata2) {
                R = 1;
            } else R = 0;
            
           if (G > rata2) {
                G = 1;
            } else G = 0;
           
           if (B > rata2) {
                B = 1;
            } else B = 0;
           
           return "Nilai R : "+R+"\nNilai G : "+G+"\nNilai B : "+B+"\nNilai Rata2 = "+rata2;
        } else
            return "Data Kosong";
    }
    
}
