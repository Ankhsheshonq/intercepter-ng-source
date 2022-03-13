package b.a.i;

import b.a.l.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
  protected static byte[] e = new byte[0];
  
  protected boolean a;
  
  protected d.a b;
  
  private ByteBuffer c;
  
  protected boolean d;
  
  public e() {}
  
  public e(d.a parama) {
    this.b = parama;
    this.c = ByteBuffer.wrap(e);
  }
  
  public e(d paramd) {
    this.a = paramd.e();
    this.b = paramd.a();
    this.c = paramd.d();
    this.d = paramd.f();
  }
  
  public d.a a() {
    return this.b;
  }
  
  public void a(d.a parama) {
    this.b = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer) {
    this.c = paramByteBuffer;
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void b(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public ByteBuffer d() {
    return this.c;
  }
  
  public boolean e() {
    return this.a;
  }
  
  public boolean f() {
    return this.d;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Framedata{ optcode:");
    stringBuilder.append(a());
    stringBuilder.append(", fin:");
    stringBuilder.append(e());
    stringBuilder.append(", payloadlength:");
    stringBuilder.append(this.c.limit());
    stringBuilder.append(", payload:");
    stringBuilder.append(Arrays.toString(b.b(new String(this.c.array()))));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */