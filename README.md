# CIUy-Utils
CiUy-Utils is a Utility class that allow the user to validate a CI

## Use

### Getting Verification code out of a CI Number

```java

    try
    {
        int ci=1234567  
        int verificationDigit = CIUtil.getVerificationDigit(ci); // 2
    }
    catch (CIException ex)
    {
        Logger.getLogger(CI.class.getName()).log(Level.SEVERE, null, ex);
    }
```

### Validate the CI
```java
    try
    {
        int ci=12345678
        boolean isValidCI = CIUtil.validateCI(ci); // false
        ci=12345672
        boolean isValidCI = CIUtil.validateCI(ci); // true
    }
    catch (CIException ex)
    {
        Logger.getLogger(CI.class.getName()).log(Level.SEVERE, null, ex);
    }
```