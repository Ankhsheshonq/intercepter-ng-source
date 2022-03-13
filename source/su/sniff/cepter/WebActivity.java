package su.sniff.cepter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class WebActivity extends Activity {
  public ListView a;
  
  Context b;
  
  public void OnClearCookie(View paramView) {
    b.e.clear();
    b.f.clear();
    b.K.notifyDataSetChanged();
    b.g.clear();
    b.h.clear();
    b.m = 0;
    b.i.clear();
    b.j.clear();
    b.L.notifyDataSetChanged();
    b.k.clear();
    b.l.clear();
  }
  
  public void OnShowMore(View paramView) {
    if (b.n == 0) {
      ((Button)findViewById(2130903050)).setText("Show Less");
      b.n = 1;
      runOnUiThread(new d(this));
      return;
    } 
    ((Button)findViewById(2130903050)).setText("Show More");
    b.n = 0;
    this.a.setAdapter((ListAdapter)b.K);
    b.K.notifyDataSetInvalidated();
  }
  
  public void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: iconst_3
    //   7: invokevirtual requestWindowFeature : (I)Z
    //   10: pop
    //   11: aload_0
    //   12: ldc 2130968602
    //   14: invokevirtual setContentView : (I)V
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   22: aload_0
    //   23: aload_0
    //   24: putfield b : Landroid/content/Context;
    //   27: new android/webkit/WebView
    //   30: dup
    //   31: aload_0
    //   32: invokespecial <init> : (Landroid/content/Context;)V
    //   35: pop
    //   36: getstatic su/sniff/cepter/b.o : I
    //   39: ifne -> 49
    //   42: iconst_1
    //   43: putstatic su/sniff/cepter/b.o : I
    //   46: goto -> 71
    //   49: getstatic su/sniff/cepter/b.o : I
    //   52: iconst_1
    //   53: if_icmpne -> 42
    //   56: lconst_1
    //   57: invokestatic sleep : (J)V
    //   60: goto -> 49
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual printStackTrace : ()V
    //   68: goto -> 49
    //   71: iconst_0
    //   72: putstatic su/sniff/cepter/b.o : I
    //   75: aload_0
    //   76: ldc 2130903082
    //   78: invokevirtual findViewById : (I)Landroid/view/View;
    //   81: checkcast android/widget/ListView
    //   84: astore_1
    //   85: aload_0
    //   86: aload_1
    //   87: putfield a : Landroid/widget/ListView;
    //   90: aload_1
    //   91: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
    //   94: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   97: aload_0
    //   98: getfield a : Landroid/widget/ListView;
    //   101: new su/sniff/cepter/WebActivity$e
    //   104: dup
    //   105: aload_0
    //   106: invokespecial <init> : (Lsu/sniff/cepter/WebActivity;)V
    //   109: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   112: new java/lang/Thread
    //   115: dup
    //   116: new su/sniff/cepter/WebActivity$a
    //   119: dup
    //   120: aload_0
    //   121: invokespecial <init> : (Lsu/sniff/cepter/WebActivity;)V
    //   124: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   127: invokevirtual start : ()V
    //   130: aload_0
    //   131: getfield a : Landroid/widget/ListView;
    //   134: new su/sniff/cepter/WebActivity$b
    //   137: dup
    //   138: aload_0
    //   139: invokespecial <init> : (Lsu/sniff/cepter/WebActivity;)V
    //   142: invokevirtual setOnItemLongClickListener : (Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   145: aload_0
    //   146: getfield a : Landroid/widget/ListView;
    //   149: new su/sniff/cepter/WebActivity$c
    //   152: dup
    //   153: aload_0
    //   154: invokespecial <init> : (Lsu/sniff/cepter/WebActivity;)V
    //   157: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
    //   160: return
    // Exception table:
    //   from	to	target	type
    //   56	60	63	java/lang/InterruptedException
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      b.C--;
      b.B.setCurrentTab(b.C);
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume() {
    super.onResume();
    b.C = 3;
  }
  
  class a implements Runnable {
    a(WebActivity this$0) {}
    
    public void run() {
      while (true) {
        try {
          Thread.sleep(2000L);
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        } 
        this.a.runOnUiThread(new a(this));
      } 
    }
    
    class a implements Runnable {
      a(WebActivity.a this$0) {}
      
      public void run() {
        b.K.notifyDataSetChanged();
      }
    }
  }
  
  class a implements Runnable {
    a(WebActivity this$0) {}
    
    public void run() {
      b.K.notifyDataSetChanged();
    }
  }
  
  class b implements AdapterView.OnItemLongClickListener {
    b(WebActivity this$0) {}
    
    public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      b.e.remove(param1Int);
      b.g.remove(param1Int);
      b.h.remove(param1Int);
      b.f.remove(param1Int);
      b.m--;
      b.i.remove(param1Int);
      b.k.remove(param1Int);
      b.l.remove(param1Int);
      b.j.remove(param1Int);
      b.K.notifyDataSetChanged();
      b.L.notifyDataSetChanged();
      return true;
    }
  }
  
  class c implements AdapterView.OnItemClickListener {
    c(WebActivity this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (Build.VERSION.SDK_INT < 11) {
        ((ClipboardManager)this.a.getSystemService("clipboard")).setText(b.j.get(param1Int));
      } else {
        ((ClipboardManager)this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(b.i.get(param1Int), b.j.get(param1Int)));
      } 
      Intent intent = new Intent(this.a.b, BrowserActivity.class);
      intent.putExtra("Key_Int", param1Int);
      this.a.startActivityForResult(intent, 1);
      b.o = 0;
    }
  }
  
  class d implements Runnable {
    d(WebActivity this$0) {}
    
    public void run() {
      this.a.a.setAdapter((ListAdapter)b.L);
      b.L.notifyDataSetInvalidated();
    }
  }
  
  public class e implements View.OnTouchListener {
    private final GestureDetector a = new GestureDetector((GestureDetector.OnGestureListener)new a(null));
    
    public e(WebActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.onTouchEvent(param1MotionEvent);
      return false;
    }
    
    private final class a extends GestureDetector.SimpleOnGestureListener {
      private a(WebActivity.e this$0) {}
      
      public void a() {
        b.B.setCurrentTab(3);
      }
      
      public void b() {
        b.B.setCurrentTab(1);
      }
      
      public boolean onDown(MotionEvent param2MotionEvent) {
        return true;
      }
      
      public boolean onFling(MotionEvent param2MotionEvent1, MotionEvent param2MotionEvent2, float param2Float1, float param2Float2) {
        try {
          param2Float2 = param2MotionEvent2.getY();
          float f1 = param2MotionEvent1.getY();
          float f2 = param2MotionEvent2.getX() - param2MotionEvent1.getX();
          if (Math.abs(f2) > Math.abs(param2Float2 - f1) && Math.abs(f2) > 300.0F && Math.abs(param2Float1) > 300.0F)
            if (f2 > 0.0F) {
              b();
            } else {
              a();
            }  
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return false;
      }
    }
  }
  
  private final class a extends GestureDetector.SimpleOnGestureListener {
    private a(WebActivity this$0) {}
    
    public void a() {
      b.B.setCurrentTab(3);
    }
    
    public void b() {
      b.B.setCurrentTab(1);
    }
    
    public boolean onDown(MotionEvent param1MotionEvent) {
      return true;
    }
    
    public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      try {
        param1Float2 = param1MotionEvent2.getY();
        float f1 = param1MotionEvent1.getY();
        float f2 = param1MotionEvent2.getX() - param1MotionEvent1.getX();
        if (Math.abs(f2) > Math.abs(param1Float2 - f1) && Math.abs(f2) > 300.0F && Math.abs(param1Float1) > 300.0F)
          if (f2 > 0.0F) {
            b();
          } else {
            a();
          }  
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return false;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\WebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */