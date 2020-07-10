package com.improvisados.ciuy.exceptions;

/**
 *
 * @author joaquin
 */
public class CIException  extends Exception
{

    public CIException()
    {
        super("Your Ci must have 7 digits");
    }
}
