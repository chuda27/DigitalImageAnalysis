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
public class RGBtoHSV {
    public static void main(String[] args) {
        System.out.println("===== Hasil Konversi RGB to HSV======");
        String dataWarnaRGB = "65, 27, 234";
        System.out.println(Konversi(dataWarnaRGB));
    }
    
    public static String Konversi(String warnaRGB){
        
        String[] strRGB;
        String hasil = "";
        double H = 0;
        double S = 0;
        double V = 0;
        
        strRGB = warnaRGB.split(",");
        
        if (strRGB.length > 2) {
            double R;
            double G;
            double B;
            double min;
            double max;
            
            R = Double.parseDouble(strRGB[0])/255;
            G = Double.parseDouble(strRGB[1])/255;
            B = Double.parseDouble(strRGB[2])/255;
            
            max = R;
            if (max < G) max = G;
            if (max < B) max = B;
            
            min = R;
            if (min > G) min = G;
            if (min > B) min = B;
            
            if (max == min) 
                H = 0;
            else if (max == R) 
                H = 60 * ((G - B) / (max - min) % 6);
            else if (max == G)
                H = 60 * ((B - R) / (max - min) + 2);
            else if (max == B)
                H = 60 * ((R - G) / (max - min) + 4);
            
            
            if(max == min)
                S = 0;
            else
                S = (max - min) / max;
            
            V = max;
            
            DecimalFormat df = new DecimalFormat("0.0000");
            hasil ="H : "+df.format(H)+" degree, S : "+df.format(S)+"%, V : "+df.format(V)+"%";
            
        } else
            System.out.println("Cek kembali input");
        return hasil;
    }
}
