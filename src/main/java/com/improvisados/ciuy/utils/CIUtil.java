package com.improvisados.ciuy.utils;

import com.improvisados.ciuy.exceptions.CIException;

/**
 *
 * @author Joaquin Martinez
 */
public class CIUtil
{

    //magic Number to calculate the Verificatio digit
    public static int DEFAULT_MAGIC_NUMBER = 2987634;

    /**
     * Return the verificatio digit por a CI
     *
     * @param ci - The CI number <b>without</b> the verification digit
     * @throws CIException - If ci is not a 7 digit number
     * @returns The verification digit for a CI
     */
    public static int getVerificationDigit(int ci) throws CIException
    {
        return getVerificationDigit(ci, DEFAULT_MAGIC_NUMBER);
    }

     /**
     * Return the verificatio digit por a CI
     *
     * @param ci - The CI number <b>without</b> the verification digit.
     * @param magicNumber - The magic number to make the calculation.
     * @throws CIException - If ci is not a 7 digit number
     * @returns The verification digit for a CI
     */
    public static int getVerificationDigit(int ci, int magicNumber) throws CIException
    {
        if ((ci + "").matches("^\\d{7}$"))
        {
            int ret = -1;
            int citemp = ci;
            int magicNumberTemp = magicNumber;
            int sum = 0;

            int ciMultiplicer;
            int magicNumberMultiplicer;
            while (citemp > 0 && magicNumberTemp > 0)
            {
                ciMultiplicer = citemp % 10;
                magicNumberMultiplicer = magicNumberTemp % 10;

                sum += (ciMultiplicer * magicNumberMultiplicer);
                citemp = citemp / 10;
                magicNumberTemp = magicNumberTemp / 10;

            }
            return 10 - (sum % 10);

        }
        else
        {
            throw new CIException();
        }
    }

    
            
    /**
     * Return the verificatio digit por a CI
     *
     * @param ci - The CI number <b>with</b> the verification digit
     * @throws CIException - If ci is not a 8 digit number
     * @returns true iff the calcuated verification code is equals que verification code pass in the ci
     */
     public static boolean checkCI(int ci) throws CIException
    {
        if ((ci + "").matches("^\\d{8}$"))
        {
            int veification = ci % 10;
            int calcVerification = getVerificationDigit(ci / 10);

            return veification == calcVerification;
        }
        else
        {
            throw new CIException();
        }

    }
}
