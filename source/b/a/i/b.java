package b.a.i;

import b.a.h.c;
import java.nio.ByteBuffer;

public class b extends e implements a {
  static final ByteBuffer h = ByteBuffer.allocate(0);
  
  private int f;
  
  private String g;
  
  public b() {
    super(d.a.f);
    b(true);
  }
  
  public b(int paramInt) {
    super(d.a.f);
    b(true);
    a(paramInt, "");
  }
  
  public b(int paramInt, String paramString) {
    super(d.a.f);
    b(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString) {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null)
      str1 = ""; 
    if (paramInt == 1015) {
      paramInt = 1005;
      str1 = str2;
    } 
    if (paramInt == 1005) {
      if (str1.length() <= 0)
        return; 
      throw new b.a.h.b(1002, "A close frame must have a closecode if it has a reason");
    } 
    byte[] arrayOfByte = b.a.l.b.b(str1);
    ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
    byteBuffer1.putInt(paramInt);
    byteBuffer1.position(2);
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(arrayOfByte.length + 2);
    byteBuffer2.put(byteBuffer1);
    byteBuffer2.put(arrayOfByte);
    byteBuffer2.rewind();
    a(byteBuffer2);
  }
  
  private void g() {
    StringBuilder stringBuilder;
    this.f = 1005;
    ByteBuffer byteBuffer = super.d();
    byteBuffer.mark();
    if (byteBuffer.remaining() >= 2) {
      ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
      byteBuffer1.position(2);
      byteBuffer1.putShort(byteBuffer.getShort());
      byteBuffer1.position(0);
      int i = byteBuffer1.getInt();
      this.f = i;
      if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("closecode must not be sent over the wire: ");
        stringBuilder.append(this.f);
        throw new c(stringBuilder.toString());
      } 
    } 
    stringBuilder.reset();
  }
  
  private void h() {
    Exception exception;
    if (this.f == 1005) {
      this.g = b.a.l.b.a(super.d());
      return;
    } 
    ByteBuffer byteBuffer = super.d();
    int i = byteBuffer.position();
    try {
      byteBuffer.position(byteBuffer.position() + 2);
      this.g = b.a.l.b.a(byteBuffer);
      byteBuffer.position(i);
      return;
    } catch (IllegalArgumentException null) {
      throw new c(exception);
    } finally {}
    byteBuffer.position(i);
    throw exception;
  }
  
  public void a(ByteBuffer paramByteBuffer) {
    super.a(paramByteBuffer);
    g();
    h();
  }
  
  public String b() {
    return this.g;
  }
  
  public int c() {
    return this.f;
  }
  
  public ByteBuffer d() {
    return (this.f == 1005) ? h : super.d();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("code: ");
    stringBuilder.append(this.f);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */