package com.example.sam;

import java.util.*;
import java.lang.*;

public class Traducteur {
    static ArrayList<String> alphabetMorse = new ArrayList<String>(Arrays.asList(
            // ***** 0 -> 9 *****
            "-----", "·----", "··---", "···--", "····-", "·····", "-····", "--···", "---··", "----·",
            // ***** A -> Z *****
            "·−", "-···", "-·-·", "-··", "·", "··-·", "--·", "····", "··", "·---", "-·-", "·-··", "--", "-·", "---", "·--·", "--·-", "·-·", "···", "-", "··-", "···-", "·--", "-··-", "-·--", "--··"
    ));

    static int indAlphabetMorse(String chaine) {
        for(int i = 0; i < Traducteur.alphabetMorse.size(); i++)
            if(Traducteur.alphabetMorse.get(i).equals(chaine))
                return i;

        return -1; // Pas trouvé
    }

    static ArrayList<String> alphabetBraille = new ArrayList<String>(Arrays.asList(
            // ***** 0 -> 9 ***** (2 car -> '⠠' + ?)
            "⠠⠼", "⠠⠡", "⠠⠣", "⠠⠩", "⠠⠹", "⠠⠱", "⠠⠫", "⠠⠻", "⠠⠳", "⠠⠪",
            // ***** A -> Z ***** (2 car -> '⠨' + ?)
            "⠨⠁", "⠨⠃", "⠨⠉", "⠨⠙", "⠨⠑", "⠨⠋", "⠨⠛", "⠨⠓", "⠨⠊", "⠨⠚", "⠨⠅", "⠨⠇", "⠨⠍", "⠨⠝", "⠨⠕", "⠨⠏", "⠨⠟", "⠨⠗", "⠨⠎", "⠨⠞", "⠨⠥", "⠨⠧", "⠨⠺", "⠨⠭", "⠨⠽", "⠨⠵",
            // ***** a -> z ***** (1 car + '\0')
            "⠁\0", "⠃\0", "⠉\0", "⠙\0", "⠑\0", "⠋\0", "⠛\0", "⠓\0", "⠊\0", "⠚\0", "⠅\0", "⠇\0", "⠍\0", "⠝\0", "⠕\0", "⠏\0", "⠟\0", "⠗\0", "⠎\0", "⠞\0", "⠥\0", "⠧\0", "⠺\0", "⠭\0", "⠽\0", "⠵\0"
    ));

    static int indAlphabetBraille(String chaine) {
        for(int i = 0; i < Traducteur.alphabetBraille.size(); i++)
            if(Traducteur.alphabetBraille.get(i).equals(chaine))
                return i;

        return -1; // Pas trouvé
    }

    public static String latinToBraille(String chaine) {
        String res = new String();
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            // ***** 0(48) - 9(57) *****
            if(((int)c >= '0') && ((int)c <= '9'))
                res += alphabetBraille.get((int)c - '0');

                // ***** A(65) - Z(90) *****
            else if(((int)c >= 'A') && ((int)c <= 'Z'))
                res += alphabetBraille.get(10 + ((int)c - 'A'));

                // ***** a(97) - z(122) *****
            else if(((int)c >= 'a') && ((int)c <= 'z'))
                res += alphabetBraille.get(36 + ((int)c - 'a'));

            else
                res += ' ';
        }

        return res;
    }

    public static String latinToMorse(String chaine) {
        String res = new String();
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            // ***** 0(48) - 9(57) *****
            if(((int)c >= '0') && ((int)c <= '9'))
                res += (alphabetMorse.get((int)c - '0') + ' ');

                // ***** A(65) - Z(90) *****
            else if(((int)c >= 'A') && ((int)c <= 'Z'))
                res += (alphabetMorse.get(10 + ((int)c - 'A')) + ' ');

                // ***** a(97) - z(122) *****
            else if(((int)c >= 'a') && ((int)c <= 'z'))
                res += (alphabetMorse.get(10 + ((int)c - 'a')) + ' ');

            else
                res += ' ';
        }

        return res;
    }

    public static String brailleToLatin(String chaine) {
        String res = new String();

        int ind;
        int taille = chaine.length();

        boolean estChiffre, estMaj, estMin;

        // Caractères courants
        char cc1;
        char cc2;

        String str;

        for(int i = 0; i < taille; i++) {
            // ********** Initialisation **********
            estChiffre = false;
            estMaj = false;
            estMin = false;

            // ********** Obtention de l'indice **********
            cc1 = chaine.charAt(i);

            // ***** 0 -> 9 ***** (2 car -> '⠠' + ?)
            if(cc1 == '⠠') {
                i++;
                cc2 = chaine.charAt(i);
                estChiffre = true;
            }

            // ***** A -> Z ***** (2 car -> '⠨' + ?)
            else if(cc1 == '⠨') {
                i++;
                cc2 = chaine.charAt(i);
                estMaj = true;
            }

            // ***** a -> z ***** (1 car + '\0')
            else {
                cc2 = '\0';
                estMin = true;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(cc1);
            sb.append(cc2);
            str = sb.toString();

            ind = indAlphabetBraille(str);

            // ********** Traduction **********
            if(ind == -1)
                res += ' ';
            else {
                // ***** 0 -> 9 ***** (2 car -> '⠠' + ?)
                if(estChiffre)
                    res += (char)('0' + (ind - indAlphabetBraille("⠠⠼")));

                    // ***** A -> Z ***** (2 car -> '⠨' + ?)
                else if(estMaj)
                    res += (char)('A' + (ind - indAlphabetBraille("⠨⠁")));

                    // ***** a -> z ***** (1 car + '\0')
                else if(estMin)
                    res += (char)('a' + (ind - indAlphabetBraille("⠁\0")));
            }
        }

        return res;
    }

    public static String brailleToMorse(String chaine) {
        return latinToMorse(brailleToLatin(chaine));
    }

    public static String morseToLatin(String chaine) {
        String res = new String();
        int ind;

        String[] chaineSplit = chaine.split(" ");

        for(int i = 0; i < chaineSplit.length; i++) {
            ind = indAlphabetMorse(chaineSplit[i]);

            // ***** 0 - 9 *****
            if((ind >= indAlphabetMorse("-----")) && (ind <= indAlphabetMorse("----·")))
                res += (char)('0' + (ind - indAlphabetMorse("-----")));

                // ***** A - Z *****
            else if((ind >= indAlphabetMorse("·−")) && (ind <= indAlphabetMorse("--··")))
                res += (char)('A' + (ind - indAlphabetMorse("·−")));

            else
                res += ' ';
        }

        return res;
    }

    public static String morseToBraille(String chaine) {
        return latinToBraille(morseToLatin(chaine));
    }
}