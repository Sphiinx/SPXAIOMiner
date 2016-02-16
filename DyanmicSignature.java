package scripts.SPXAIOMiner;

import org.tribot.api.General;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class DyanmicSignature {

    //<editor-fold defaultstate="collapsed" desc="SignatureData">
    public static boolean sendSignatureData(long runtimeInSeconds, int oresMined, int profit, int xpgained, int levelgained, int muletrades, int mastertrades) {
        // In order to provide some security, so that people will not tamper the data and post it themselves, we will be encrypting it here and decrypting it in php.
        // These keys should be the same as in PHP (db.php) (16bit long)
        String privateKey = "C5A1B33F62AC2D81";
        String initVector = "E6135CCC2FE8BE8C";

        try {
            // data we will be encrypting. you can remove the var's if you want (username and runtime are required though)
            String data = initVector+","+ General.getTRiBotUsername()+","+runtimeInSeconds+","+oresMined+","+profit+","+xpgained+","+levelgained+","+muletrades+","+mastertrades; // comma delimited so we can split in php

            String token = Base64.getEncoder().encodeToString(data.getBytes());

            // And post it :)
            URL url = new URL("http://www.spxscripts.com/spxaiominer/input.php?token="+token);
            URLConnection conn = url.openConnection();

            // fake request coming from browser (solves permission issue on shared webhosting)
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output = in.readLine();

            General.println(output);
            in.close();
            return true;
        } catch (Exception e) {
            General.println(e.getMessage());
        }
        return false;
    }
    //</editor-fold>

}

