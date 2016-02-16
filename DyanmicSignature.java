package scripts.SPXAIOMiner;

import org.tribot.api.General;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sphiinx on 2/15/2016.
 */
public class DyanmicSignature {

    //<editor-fold defaultstate="collapsed" desc="SignatureData">
    public static boolean sendSignatureData(long runtimeInSeconds, int oresMined, int profit, int xpgained, int levelgained, int muletrades, int mastertrades) {
        // In order to provide some security, so that people will not tamper the data and post it themselves, we will be encrypting it here and decrypting it in php.
        // These keys should be the same as in PHP (db.php) (16bit long)
        String privateKey = "4030582721639900";
        String initVector = "4030582721639900";

        try {
            // data we will be encrypting. you can remove the var's if you want (username and runtime are required though)
            String data = initVector+","+ General.getTRiBotUsername()+","+runtimeInSeconds+","+oresMined+","+profit+","+xpgained+","+levelgained+","+muletrades+","+mastertrades; // comma delimited so we can split in php

            // set up iv and key for encrypting
            IvParameterSpec ivspec = new IvParameterSpec(initVector.getBytes());
            SecretKeySpec keyspec = new SecretKeySpec(privateKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // encrypt
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));

            // convert to hex
            String token = "";
            for (byte anEncrypted : encrypted) {
                if ((anEncrypted & 0xFF) < 16) {
                    token = token + "0" + Integer.toHexString(anEncrypted & 0xFF);
                } else {
                    token = token + Integer.toHexString(anEncrypted & 0xFF);
                }
            }

            // And post it :)
            URL url = new URL("http://www.spxscripts.com/spxaiominer/input.php?token="+token);
            URLConnection conn = url.openConnection();

            // fake request coming from browser (solves permission issue on shared webhosting)
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            in.readLine();
            in.close();
            return true;
        } catch (Exception e) {
            General.println(e.getMessage());
        }
        return false;
    }
    //</editor-fold>

}

