package b.a.l;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class a {
  private static final byte[] a = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] b = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] c = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  private static final byte[] d = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] e = new byte[] { 
      45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
      57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
      74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
      84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
      99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
      109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
      119, 120, 121, 122 };
  
  private static final byte[] f = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
      3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
      -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
      16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
      26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
      36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
      41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
      51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
      61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9 };
  
  public static String a(byte[] paramArrayOfbyte) {
    try {
      return a(paramArrayOfbyte, 0, paramArrayOfbyte.length, 0);
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    paramArrayOfbyte = b(paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
    try {
      return new String(paramArrayOfbyte, "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return new String(paramArrayOfbyte);
    } 
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
    byte b;
    byte[] arrayOfByte = b(paramInt4);
    int i = 0;
    if (paramInt2 > 0) {
      paramInt4 = paramArrayOfbyte1[paramInt1] << 24 >>> 8;
    } else {
      paramInt4 = 0;
    } 
    if (paramInt2 > 1) {
      b = paramArrayOfbyte1[paramInt1 + 1] << 24 >>> 16;
    } else {
      b = 0;
    } 
    if (paramInt2 > 2)
      i = paramArrayOfbyte1[paramInt1 + 2] << 24 >>> 24; 
    paramInt1 = paramInt4 | b | i;
    if (paramInt2 != 1) {
      if (paramInt2 != 2) {
        if (paramInt2 != 3)
          return paramArrayOfbyte2; 
        paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
        paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[paramInt1 >>> 6 & 0x3F];
        paramArrayOfbyte2[paramInt3 + 3] = arrayOfByte[paramInt1 & 0x3F];
        return paramArrayOfbyte2;
      } 
      paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
      paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
      paramArrayOfbyte2[paramInt3 + 2] = arrayOfByte[paramInt1 >>> 6 & 0x3F];
      paramArrayOfbyte2[paramInt3 + 3] = 61;
      return paramArrayOfbyte2;
    } 
    paramArrayOfbyte2[paramInt3] = arrayOfByte[paramInt1 >>> 18];
    paramArrayOfbyte2[paramInt3 + 1] = arrayOfByte[paramInt1 >>> 12 & 0x3F];
    paramArrayOfbyte2[paramInt3 + 2] = 61;
    paramArrayOfbyte2[paramInt3 + 3] = 61;
    return paramArrayOfbyte2;
  }
  
  private static int b(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
    if (paramArrayOfbyte1 != null) {
      if (paramArrayOfbyte2 != null) {
        if (paramInt1 >= 0) {
          int i = paramInt1 + 3;
          if (i < paramArrayOfbyte1.length) {
            if (paramInt2 >= 0) {
              int j = paramInt2 + 2;
              if (j < paramArrayOfbyte2.length) {
                byte[] arrayOfByte = c(paramInt3);
                paramInt3 = paramInt1 + 2;
                if (paramArrayOfbyte1[paramInt3] == 61) {
                  paramInt3 = arrayOfByte[paramArrayOfbyte1[paramInt1]];
                  paramArrayOfbyte2[paramInt2] = (byte)(((arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]] & 0xFF) << 12 | (paramInt3 & 0xFF) << 18) >>> 16);
                  return 1;
                } 
                if (paramArrayOfbyte1[i] == 61) {
                  j = arrayOfByte[paramArrayOfbyte1[paramInt1]];
                  paramInt1 = arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]];
                  paramInt1 = (arrayOfByte[paramArrayOfbyte1[paramInt3]] & 0xFF) << 6 | (paramInt1 & 0xFF) << 12 | (j & 0xFF) << 18;
                  paramArrayOfbyte2[paramInt2] = (byte)(paramInt1 >>> 16);
                  paramArrayOfbyte2[paramInt2 + 1] = (byte)(paramInt1 >>> 8);
                  return 2;
                } 
                byte b = arrayOfByte[paramArrayOfbyte1[paramInt1]];
                paramInt1 = arrayOfByte[paramArrayOfbyte1[paramInt1 + 1]];
                paramInt3 = arrayOfByte[paramArrayOfbyte1[paramInt3]];
                paramInt1 = arrayOfByte[paramArrayOfbyte1[i]] & 0xFF | (paramInt1 & 0xFF) << 12 | (b & 0xFF) << 18 | (paramInt3 & 0xFF) << 6;
                paramArrayOfbyte2[paramInt2] = (byte)(paramInt1 >> 16);
                paramArrayOfbyte2[paramInt2 + 1] = (byte)(paramInt1 >> 8);
                paramArrayOfbyte2[j] = (byte)paramInt1;
                return 3;
              } 
            } 
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte2.length), Integer.valueOf(paramInt2) }));
          } 
        } 
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte1.length), Integer.valueOf(paramInt1) }));
      } 
      throw new NullPointerException("Destination array was null.");
    } 
    throw new NullPointerException("Source array was null.");
  }
  
  private static final byte[] b(int paramInt) {
    return ((paramInt & 0x10) == 16) ? c : (((paramInt & 0x20) == 32) ? e : a);
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    if (paramArrayOfbyte != null) {
      if (paramInt1 >= 0) {
        if (paramInt2 >= 0) {
          byte[] arrayOfByte;
          if (paramInt1 + paramInt2 <= paramArrayOfbyte.length) {
            Exception exception;
            boolean bool;
            if ((paramInt3 & 0x2) != 0) {
              byte[] arrayOfByte2;
              a a2;
              byte[] arrayOfByte3;
              byte[] arrayOfByte4;
              Exception exception1 = null;
              a a1 = null;
              try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                  a a3;
                } catch (IOException iOException) {
                
                } finally {
                  Exception exception2;
                  paramArrayOfbyte = null;
                  a1 = null;
                } 
              } catch (IOException iOException) {
              
              } finally {
                Exception exception2;
                paramArrayOfbyte = null;
                a2 = null;
                a1 = a2;
              } 
              try {
                throw a2;
              } finally {
                exception1 = null;
                a2 = a1;
                arrayOfByte4 = paramArrayOfbyte;
                arrayOfByte2 = arrayOfByte3;
              } 
              try {
                arrayOfByte4.close();
              } catch (Exception exception2) {}
              try {
                arrayOfByte2.close();
              } catch (Exception exception2) {}
              try {
                a2.close();
              } catch (Exception exception2) {}
            } 
            if ((paramInt3 & 0x8) != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            int j = paramInt2 / 3;
            if (paramInt2 % 3 > 0) {
              i = 4;
            } else {
              i = 0;
            } 
            int i = j * 4 + i;
            int k = i;
            if (bool)
              k = i + i / 76; 
            byte[] arrayOfByte1 = new byte[k];
            int m = 0;
            i = 0;
            j = 0;
            while (m < paramInt2 - 2) {
              a((byte[])exception, m + paramInt1, 3, arrayOfByte1, i, paramInt3);
              j += 4;
              if (bool && j >= 76) {
                arrayOfByte1[i + 4] = 10;
                i++;
                j = 0;
              } 
              m += 3;
              i += 4;
            } 
            j = i;
            if (m < paramInt2) {
              a((byte[])exception, m + paramInt1, paramInt2 - m, arrayOfByte1, i, paramInt3);
              j = i + 4;
            } 
            if (j <= k - 1) {
              arrayOfByte = new byte[j];
              System.arraycopy(arrayOfByte1, 0, arrayOfByte, 0, j);
              return arrayOfByte;
            } 
            return arrayOfByte1;
          } 
          throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(arrayOfByte.length) }));
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Cannot have length offset: ");
        stringBuilder1.append(paramInt2);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot have negative offset: ");
      stringBuilder.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    NullPointerException nullPointerException = new NullPointerException("Cannot serialize a null array.");
    throw nullPointerException;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
    a(paramArrayOfbyte2, 0, paramInt1, paramArrayOfbyte1, 0, paramInt2);
    return paramArrayOfbyte1;
  }
  
  private static final byte[] c(int paramInt) {
    return ((paramInt & 0x10) == 16) ? d : (((paramInt & 0x20) == 32) ? f : b);
  }
  
  public static class a extends FilterOutputStream {
    private boolean a;
    
    private int b;
    
    private byte[] c;
    
    private int d;
    
    private int e;
    
    private boolean f;
    
    private byte[] g;
    
    private boolean h;
    
    private int i;
    
    private byte[] j;
    
    public a(OutputStream param1OutputStream, int param1Int) {
      super(param1OutputStream);
      byte b;
      boolean bool1;
      boolean bool2 = true;
      if ((param1Int & 0x8) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.f = bool1;
      if ((param1Int & 0x1) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.a = bool1;
      if (bool1) {
        b = 3;
      } else {
        b = 4;
      } 
      this.d = b;
      this.c = new byte[b];
      this.b = 0;
      this.e = 0;
      this.h = false;
      this.g = new byte[4];
      this.i = param1Int;
      this.j = a.a(param1Int);
    }
    
    public void close() {
      d();
      super.close();
      this.c = null;
      this.out = null;
    }
    
    public void d() {
      int i = this.b;
      if (i > 0) {
        if (this.a) {
          OutputStream outputStream = this.out;
          byte[] arrayOfByte = this.g;
          a.a(arrayOfByte, this.c, i, this.i);
          outputStream.write(arrayOfByte);
          this.b = 0;
          return;
        } 
        throw new IOException("Base64 input not properly padded.");
      } 
    }
    
    public void write(int param1Int) {
      if (this.h) {
        this.out.write(param1Int);
        return;
      } 
      if (this.a) {
        byte[] arrayOfByte = this.c;
        int j = this.b;
        int i = j + 1;
        this.b = i;
        arrayOfByte[j] = (byte)param1Int;
        param1Int = this.d;
        if (i >= param1Int) {
          OutputStream outputStream = this.out;
          byte[] arrayOfByte1 = this.g;
          a.a(arrayOfByte1, arrayOfByte, param1Int, this.i);
          outputStream.write(arrayOfByte1);
          param1Int = this.e + 4;
          this.e = param1Int;
          if (this.f && param1Int >= 76) {
            this.out.write(10);
            this.e = 0;
          } 
        } else {
          return;
        } 
      } else {
        byte[] arrayOfByte = this.j;
        int i = param1Int & 0x7F;
        if (arrayOfByte[i] > -5) {
          arrayOfByte = this.c;
          i = this.b;
          int j = i + 1;
          this.b = j;
          arrayOfByte[i] = (byte)param1Int;
          if (j >= this.d) {
            param1Int = a.a(arrayOfByte, 0, this.g, 0, this.i);
            this.out.write(this.g, 0, param1Int);
          } else {
            return;
          } 
        } else {
          if (arrayOfByte[i] != -5)
            throw new IOException("Invalid character in Base64 data."); 
          return;
        } 
      } 
      this.b = 0;
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (this.h) {
        this.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } 
      int i;
      for (i = 0; i < param1Int2; i++)
        write(param1ArrayOfbyte[param1Int1 + i]); 
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */