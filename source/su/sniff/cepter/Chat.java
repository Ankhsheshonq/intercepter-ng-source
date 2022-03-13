package su.sniff.cepter;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;

public class Chat extends Activity {
  TextView a;
  
  b.a.k.b b;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968579);
    TextView textView = (TextView)findViewById(2130903109);
    this.a = textView;
    textView.setTextSize(2, (b.q + 3));
    this.a.setTypeface(Typeface.MONOSPACE);
    if (b.s == 0) {
      (new Thread(new a(this))).start();
      b.s = 1;
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      finish();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSend(View paramView) {
    EditText editText = (EditText)findViewById(2130903070);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("<b><font color=green> [you] ");
    stringBuilder1.append(editText.getEditableText());
    stringBuilder1.append("</font></b>");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[anonymous] ");
    stringBuilder2.append(editText.getEditableText().toString());
    null = stringBuilder2.toString();
    runOnUiThread(new b(this, str));
    synchronized (this.b.a()) {
      Iterator<b.a.b> iterator = null.iterator();
      while (iterator.hasNext())
        ((b.a.b)iterator.next()).a(null.toString()); 
      return;
    } 
  }
  
  class a implements Runnable {
    a(Chat this$0) {}
    
    public void run() {
      String str = b.F;
      this.a.b = new Chat.c(this.a, new InetSocketAddress(str, 11220));
      this.a.b.run();
    }
  }
  
  class b implements Runnable {
    b(Chat this$0, String param1String) {}
    
    public void run() {
      this.b.a.append((CharSequence)Html.fromHtml(this.a));
      this.b.a.append("\n");
    }
  }
  
  public class c extends b.a.k.b {
    public c(Chat this$0, InetSocketAddress param1InetSocketAddress) {
      super(param1InetSocketAddress);
    }
    
    public void a(b.a.b param1b, b.a.j.a param1a) {
      this.o.runOnUiThread(new a(this, param1b));
      param1b.a("Привет!");
    }
    
    public void b(b.a.b param1b, Exception param1Exception) {
      this.o.runOnUiThread(new d(this, param1b, param1Exception));
    }
    
    public void b(b.a.b param1b, String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<b><font color=red>[");
      stringBuilder.append(param1b.b().getHostName());
      stringBuilder.append("] ");
      stringBuilder.append(param1String);
      stringBuilder.append("</font></b>");
      String str = stringBuilder.toString();
      this.o.runOnUiThread(new c(this, str));
    }
    
    public void c(b.a.b param1b, int param1Int, String param1String, boolean param1Boolean) {
      this.o.runOnUiThread(new b(this));
    }
    
    class a implements Runnable {
      a(Chat.c this$0, b.a.b param2b) {}
      
      public void run() {
        TextView textView = this.b.o.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incoming connection from ");
        stringBuilder.append(this.a.b());
        textView.append(stringBuilder.toString());
        this.b.o.a.append("\n");
      }
    }
    
    class b implements Runnable {
      b(Chat.c this$0) {}
      
      public void run() {
        this.a.o.a.append("User closed connection ");
        this.a.o.a.append("\n");
      }
    }
    
    class c implements Runnable {
      c(Chat.c this$0, String param2String) {}
      
      public void run() {
        this.b.o.a.append((CharSequence)Html.fromHtml(this.a));
        this.b.o.a.append("\n");
      }
    }
    
    class d implements Runnable {
      d(Chat.c this$0, b.a.b param2b, Exception param2Exception) {}
      
      public void run() {
        TextView textView = this.c.o.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error ");
        stringBuilder.append(this.a.b());
        stringBuilder.append(":");
        stringBuilder.append(this.b);
        textView.append(stringBuilder.toString());
        this.c.o.a.append("\n");
      }
    }
  }
  
  class a implements Runnable {
    a(Chat this$0, b.a.b param1b) {}
    
    public void run() {
      TextView textView = this.b.o.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Incoming connection from ");
      stringBuilder.append(this.a.b());
      textView.append(stringBuilder.toString());
      this.b.o.a.append("\n");
    }
  }
  
  class b implements Runnable {
    b(Chat this$0) {}
    
    public void run() {
      this.a.o.a.append("User closed connection ");
      this.a.o.a.append("\n");
    }
  }
  
  class c implements Runnable {
    c(Chat this$0, String param1String) {}
    
    public void run() {
      this.b.o.a.append((CharSequence)Html.fromHtml(this.a));
      this.b.o.a.append("\n");
    }
  }
  
  class d implements Runnable {
    d(Chat this$0, b.a.b param1b, Exception param1Exception) {}
    
    public void run() {
      TextView textView = this.c.o.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error ");
      stringBuilder.append(this.a.b());
      stringBuilder.append(":");
      stringBuilder.append(this.b);
      textView.append(stringBuilder.toString());
      this.c.o.a.append("\n");
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\Chat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */