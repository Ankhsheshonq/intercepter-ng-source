package b.a.l;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class b {
  public static CodingErrorAction a = CodingErrorAction.REPORT;
  
  public static String a(ByteBuffer paramByteBuffer) {
    CharsetDecoder charsetDecoder = Charset.forName("UTF8").newDecoder();
    charsetDecoder.onMalformedInput(a);
    charsetDecoder.onUnmappableCharacter(a);
    try {
      paramByteBuffer.mark();
      String str = charsetDecoder.decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      return str;
    } catch (CharacterCodingException characterCodingException) {
      throw new b.a.h.b(1007, characterCodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return new String(paramArrayOfbyte, paramInt1, paramInt2, "ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static byte[] a(String paramString) {
    try {
      return paramString.getBytes("ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static byte[] b(String paramString) {
    try {
      return paramString.getBytes("UTF8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */