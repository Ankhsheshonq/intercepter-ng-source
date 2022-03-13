package b.a;

import b.a.g.a;
import b.a.i.d;
import b.a.i.e;
import b.a.j.a;
import b.a.j.e;
import b.a.j.h;
import b.a.j.i;

public abstract class c implements e {
  public i a(b paramb, a parama, a parama1) {
    return (i)new e();
  }
  
  public String a(b paramb) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    stringBuilder.append(paramb.a().getPort());
    stringBuilder.append("\" /></cross-domain-policy>\000");
    return stringBuilder.toString();
  }
  
  public void a(b paramb, d paramd) {
    e e1 = new e(paramd);
    e1.a(d.a.e);
    paramb.a((d)e1);
  }
  
  public void a(b paramb, a parama, h paramh) {}
  
  public void b(b paramb, d paramd) {}
  
  public void c(b paramb, d paramd) {}
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */