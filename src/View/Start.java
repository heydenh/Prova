package View;

import static Business.Util.Md5.getMd5;

public class Start {
    public static void main(String[] args){
        String testo="Prova";
        System.out.println(getMd5(testo));
    }
}
