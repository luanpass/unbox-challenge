package br.com.unbox.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

import static br.com.unbox.utils.DocUtils.cleanString;
import static br.com.unbox.utils.DocUtils.verifyDocInvalid;

@Component
public class DocValidator {

    public static final Logger LOG = LoggerFactory.getLogger(DocValidator.class);

    private static final String CPF_FORMAT = "^\\d{3}\\d{3}\\d{3}\\d{2}$";

    public Boolean validateCPF(String docId) {

        String doc = cleanString(docId);

        if (!doc.matches(CPF_FORMAT) || !verifyDocInvalid(doc)) {
            LOG.info("Document [ " + doc + " ] is outside the standards");
            return Boolean.FALSE;
        }

        int sm, i, r, num, peso;
        char dig10, dig11;
        try {
            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {
                num = (int) (doc.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))

                dig10 = '0';
            else dig10 = (char) (r + 48);

            sm = 0;

            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (doc.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            if ((dig10 == doc.charAt(9)) && (dig11 == doc.charAt(10))) {
                return true;
            } else LOG.info("Document [ " + doc + " ] is outside the standards");
        } catch (InputMismatchException erro) {
            LOG.info("Document [ " + doc + " ] is outside the standards");
        }
        return Boolean.FALSE;
    }

}
