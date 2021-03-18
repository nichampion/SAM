package com.example.sam;
/* ---------------
    Checkbox
    ---
    b1  b2
    b3  b4
    b5  b6
    --------------- */

public class BrailleGetter {
    public static String get(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6) {
        int nb = ((b1 == true ? 1 : 0) * 2 + (b2 == true ? 1 : 0) * 4 + (b3 == true ? 1 : 0) * 8 + (b4 == true ? 1 : 0) * 16 + (b5 == true ? 1 : 0) * 32 + (b6 == true ? 1 : 0) * 64);

        switch (nb) {
            // ***** Pre-caractere Chiffre : "⠠" *****
            case 64:
                return "⠠";

            // ***** Pre-caractere Majuscule : "⠨" *****
            case 68:
                return "⠨";

            // ***** Lettre *****
            // a - m
            case 2:
                return "⠁";
            case 10:
                return "⠃";
            case 6:
                return "⠉";
            case 22:
                return "⠙";
            case 18:
                return "⠑";
            case 14:
                return "⠋";
            case 30:
                return "⠛";
            case 26:
                return "⠓";
            case 12:
                return "⠊";
            case 28:
                return "⠚";
            case 34:
                return "⠅";
            case 42:
                return "⠇";
            case 38:
                return "⠍";
            // n - z 
            case 54:
                return "⠝";
            case 50:
                return "⠕";
            case 46:
                return "⠏";
            case 62:
                return "⠟";
            case 58:
                return "⠗";
            case 44:
                return "⠎";
            case 60:
                return "⠞";
            case 98:
                return "⠥";
            case 106:
                return "⠧";
            case 92:
                return "⠺";
            case 102:
                return "⠭";
            case 118:
                return "⠽";
            case 114:
                return "⠵";

            // ***** Chiffre *****
            case 66:
                return "⠡";
            case 74:
                return "⠣";
            case 70:
                return "⠩";
            case 86:
                return "⠹";
            case 82:
                return "⠱";
            case 78:
                return "⠫";
            case 94:
                return "⠻";
            case 90:
                return "⠳";
            case 76:
                return "⠪";
            case 116:
                return "⠼";

            // ***** Autres *****
            default:
                return null;
        }
    }
}