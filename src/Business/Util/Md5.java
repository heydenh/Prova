package Business.Util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static String getMd5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            //ritorna la stringa codificata in md5 in byte
            byte[] messageDigest = md.digest(text.getBytes());

            //converte da byte a intero
            BigInteger no = new BigInteger(1, messageDigest);

            //converte da intero a stringa(esadecimale)
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        //messaggio di errore
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}