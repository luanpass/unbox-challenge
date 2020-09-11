package br.com.unbox.utils;

import org.apache.logging.log4j.util.Strings;

public class DocUtils {
    public static String cleanString(String str) {
        if(Strings.isNotBlank(str)){
            return str.trim().replaceAll("[^a-zA-Z0-9 ]", "");
        }return null;
    }

    public static Boolean verifyDocInvalid(String doc) {
        for (int i = 1; i <= doc.length() - 1; i++) {
            if (doc.charAt(0) != doc.charAt(i)) return true;
        }
        return false;
    }
}
