package b.a.g;

import b.a.b;
import b.a.h.a;
import b.a.h.c;
import b.a.h.d;
import b.a.i.b;
import b.a.i.d;
import b.a.j.a;
import b.a.j.c;
import b.a.j.f;
import b.a.j.h;
import b.a.j.i;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class e extends d {
  private static final byte[] i = new byte[] { -1, 0 };
  
  private boolean h = false;
  
  public e() {
    new Random();
  }
  
  private static byte[] a(String paramString) {
    try {
      long l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      long l2 = ((paramString.split(" ")).length - 1);
      if (l2 != 0L) {
        l1 = (new Long(l1 / l2)).longValue();
        return new byte[] { (byte)(int)(l1 >> 24L), (byte)(int)(l1 << 8L >> 24L), (byte)(int)(l1 << 16L >> 24L), (byte)(int)(l1 << 24L >> 24L) };
      } 
      throw new d("invalid Sec-WebSocket-Key (/key2/)");
    } catch (NumberFormatException numberFormatException) {
      throw new d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    } 
  }
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = a(paramString1);
    byte[] arrayOfByte2 = a(paramString2);
    byte b1 = arrayOfByte1[0];
    byte b2 = arrayOfByte1[1];
    byte b3 = arrayOfByte1[2];
    byte b4 = arrayOfByte1[3];
    byte b5 = arrayOfByte2[0];
    byte b6 = arrayOfByte2[1];
    byte b7 = arrayOfByte2[2];
    byte b8 = arrayOfByte2[3];
    byte b9 = paramArrayOfbyte[0];
    byte b10 = paramArrayOfbyte[1];
    byte b11 = paramArrayOfbyte[2];
    byte b12 = paramArrayOfbyte[3];
    byte b13 = paramArrayOfbyte[4];
    byte b14 = paramArrayOfbyte[5];
    byte b15 = paramArrayOfbyte[6];
    byte b16 = paramArrayOfbyte[7];
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      return messageDigest.digest(new byte[] { 
            b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, 
            b11, b12, b13, b14, b15, b16 });
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException);
    } 
  }
  
  public a.b a(a parama) {
    return (parama.c("Upgrade").equals("WebSocket") && parama.c("Connection").contains("Upgrade") && parama.c("Sec-WebSocket-Key1").length() > 0 && !parama.c("Sec-WebSocket-Key2").isEmpty() && parama.a("Origin")) ? a.b.a : a.b.b;
  }
  
  public a.b a(a parama, h paramh) {
    if (this.h)
      return a.b.b; 
    try {
      if (!paramh.c("Sec-WebSocket-Origin").equals(parama.c("Origin")) || !a((f)paramh))
        return a.b.b; 
      byte[] arrayOfByte = paramh.d();
      if (arrayOfByte != null && arrayOfByte.length != 0)
        return Arrays.equals(arrayOfByte, a(parama.c("Sec-WebSocket-Key1"), parama.c("Sec-WebSocket-Key2"), parama.d())) ? a.b.a : a.b.b; 
      throw new a();
    } catch (d d1) {
      throw new RuntimeException("bad handshakerequest", d1);
    } 
  }
  
  public a a() {
    return new e();
  }
  
  public c a(a parama, i parami) {
    parami.d("WebSocket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.c("Connection"));
    parami.a("Sec-WebSocket-Origin", parama.c("Origin"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ws://");
    stringBuilder.append(parama.c("Host"));
    stringBuilder.append(parama.a());
    parami.a("Sec-WebSocket-Location", stringBuilder.toString());
    String str1 = parama.c("Sec-WebSocket-Key1");
    String str2 = parama.c("Sec-WebSocket-Key2");
    byte[] arrayOfByte = parama.d();
    if (str1 != null && str2 != null && arrayOfByte != null && arrayOfByte.length == 8) {
      parami.a(a(str1, str2, arrayOfByte));
      return (c)parami;
    } 
    throw new d("Bad keys");
  }
  
  public ByteBuffer a(d paramd) {
    return (paramd.a() == d.a.f) ? ByteBuffer.wrap(i) : super.a(paramd);
  }
  
  public List<d> a(ByteBuffer paramByteBuffer) {
    paramByteBuffer.mark();
    List<d> list = f(paramByteBuffer);
    if (list == null) {
      paramByteBuffer.reset();
      list = this.f;
      this.d = true;
      if (this.g == null) {
        this.g = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() <= this.g.remaining()) {
          this.g.put(paramByteBuffer);
          if (!this.g.hasRemaining()) {
            if (Arrays.equals(this.g.array(), i)) {
              list.add(new b(1000));
              return list;
            } 
            throw new c();
          } 
          this.f = new LinkedList<d>();
          return list;
        } 
        throw new c();
      } 
      throw new c();
    } 
    return list;
  }
  
  public a.a b() {
    return a.a.b;
  }
  
  public f b(ByteBuffer paramByteBuffer) {
    c c = a.a(paramByteBuffer, this.a);
    if ((c.a("Sec-WebSocket-Key1") || this.a == b.b.a) && !c.a("Sec-WebSocket-Version")) {
      byte b;
      if (this.a == b.b.b) {
        b = 8;
      } else {
        b = 16;
      } 
      byte[] arrayOfByte = new byte[b];
      try {
        paramByteBuffer.get(arrayOfByte);
        c.a(arrayOfByte);
        return (f)c;
      } catch (BufferUnderflowException bufferUnderflowException) {
        throw new a(paramByteBuffer.capacity() + 16);
      } 
    } 
    return (f)bufferUnderflowException;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */