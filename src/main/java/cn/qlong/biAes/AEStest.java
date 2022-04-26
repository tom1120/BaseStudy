package cn.qlong.biAes;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

import java.security.Key;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

public class AEStest
{
    private static final int FRAGMENT_LENGTH = 245;
    private static final int FRAGMENT_LENGTH_DECRYPT = 256;
    private static final int AES_KEY_LENGTH = 16;


    public static String byte2Base64(byte[] paramArrayOfByte)
    {
        BASE64Encoder localBASE64Encoder = new BASE64Encoder();
        return localBASE64Encoder.encode(paramArrayOfByte);
    }

    public static byte[] base642Byte(String paramString)
            throws IOException
    {
        BASE64Decoder localBASE64Decoder = new BASE64Decoder();
        return localBASE64Decoder.decodeBuffer(paramString);
    }

    public static String aesEncrypt(String paramString1, String paramString2)
    {
        Key localKey = getEasKey(paramString2);
        try
        {
            Cipher localCipher = Cipher.getInstance("AES");
            localCipher.init(1, localKey);
            byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
            byte[] arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
            return byte2Base64(arrayOfByte2);
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }

    public static String aesDecrypt(String paramString1, String paramString2)
    {
        try
        {
            Key localKey = getEasKey(paramString2);
            Cipher localCipher = Cipher.getInstance("AES");
            localCipher.init(2, localKey);
            byte[] arrayOfByte = localCipher.doFinal(base642Byte(paramString1));
            return new String(arrayOfByte, "UTF-8");
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }

    private static Key getEasKey(String paramString)
    {
        try
        {
            byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
            byte[] arrayOfByte2 = new byte[16];
            for (int i = 0; (i < arrayOfByte1.length) && (i < arrayOfByte2.length); i++)
                arrayOfByte2[i] = arrayOfByte1[i];
            return new SecretKeySpec(arrayOfByte2, "AES");
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String key="fynwdKGFBfmHdfWj";
        String s=aesEncrypt("123456",key);
        System.out.println("加密s = " + s);
        String ss=aesDecrypt(s,key);
        System.out.println("解密ss = " + ss);
    }

}
