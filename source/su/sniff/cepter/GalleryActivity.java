package su.sniff.cepter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;

public class GalleryActivity extends Activity {
  private Context a;
  
  TextView b;
  
  boolean c = false;
  
  public void OnChat(View paramView) {
    ((EditText)findViewById(2130903070)).setVisibility(0);
    ((Button)findViewById(2130903055)).setVisibility(0);
    if (!this.c) {
      InputStream inputStream = getResources().openRawResource(2131165189);
      try {
        FileOutputStream fileOutputStream = openFileOutput("chat.html", 0);
        byte[] arrayOfByte = new byte[64];
        while (inputStream.read(arrayOfByte) > -1)
          fileOutputStream.write(arrayOfByte); 
        fileOutputStream.flush();
        fileOutputStream.close();
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/data/data/su.sniff.cepter/files/chat.html")));
        String str = "";
        while (true) {
          String str1 = bufferedReader.readLine();
          if (str1 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str1);
            stringBuilder.append("\r\n");
            str = stringBuilder.toString();
            continue;
          } 
          bufferedReader.close();
          str = str.replaceAll("255.255.255.255", b.F);
          FileWriter fileWriter = new FileWriter("/data/data/su.sniff.cepter/files/chat.html");
          fileWriter.write(str);
          fileWriter.close();
          (new Thread(new d(this))).start();
          this.c = true;
          break;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        (new Thread(new d(this))).start();
        this.c = true;
        break;
      } 
    } 
    if (b.s == 0) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
      builder.setTitle("Set Welcome Message");
      EditText editText = new EditText(this.a);
      editText.setInputType(1);
      builder.setView((View)editText);
      builder.setPositiveButton("Set", new e(this, editText));
      builder.setNegativeButton("Cancel", new f(this));
      builder.show();
      b.s = 1;
      b.r = 1;
      ((CheckBox)findViewById(2130903059)).setChecked(true);
      try {
        openFileOutput("ic", 0).close();
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      try {
        FileOutputStream fileOutputStream = openFileOutput("force", 0);
        fileOutputStream.write("/data/data/su.sniff.cepter/files/chat.html".getBytes());
        fileOutputStream.close();
        return;
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    } 
    b.s = 0;
    File file = new File("/data/data/su.sniff.cepter/files/ic");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/force");
    if (file.exists())
      file.delete(); 
  }
  
  public void OnCookieKiller(View paramView) {
    if (b.u == 0) {
      b.u = 1;
      b.r = 1;
      ((CheckBox)findViewById(2130903059)).setChecked(true);
      try {
        openFileOutput("ck", 0).close();
        return;
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    } 
    b.u = 0;
    File file = new File("/data/data/su.sniff.cepter/files/ck");
    if (file.exists())
      file.delete(); 
  }
  
  public void OnDNS(View paramView) {
    startActivityForResult(new Intent(this.a, DNSSpoofing.class), 1);
  }
  
  public void OnExpert(View paramView) {
    ((CheckBox)findViewById(2130903060)).setVisibility(0);
    ((CheckBox)findViewById(2130903059)).setVisibility(0);
    ((CheckBox)findViewById(2130903061)).setVisibility(0);
    ((CheckBox)findViewById(2130903064)).setVisibility(0);
    ((Button)findViewById(2130903046)).setVisibility(0);
    ((Button)findViewById(2130903053)).setVisibility(0);
    ((Button)findViewById(2130903048)).setVisibility(0);
    ((ScrollView)findViewById(2130903092)).setVisibility(0);
    ((CheckBox)findViewById(2130903063)).setVisibility(4);
  }
  
  public void OnForce(View paramView) {
    CheckBox checkBox = (CheckBox)findViewById(2130903061);
    if (checkBox.isChecked() == true) {
      checkBox.setChecked(false);
      String str = b.J;
      c c = new c(this);
      (new d((Context)this, str, new String[] { "" }, c)).show();
      return;
    } 
    File file = new File("/data/data/su.sniff.cepter/files/force");
    if (file.exists())
      file.delete(); 
  }
  
  public void OnHSTS(View paramView) {
    startActivityForResult(new Intent(this.a, HSTSpoofing.class), 1);
  }
  
  public void OnInject(View paramView) {
    startActivityForResult(new Intent(this.a, InjectActivity.class), 1);
    b.r = 1;
    ((CheckBox)findViewById(2130903059)).setChecked(true);
  }
  
  public void OnSend(View paramView) {
    EditText editText = (EditText)findViewById(2130903070);
    if (editText.getEditableText().length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<b><font color=green> [you] ");
      stringBuilder.append(editText.getEditableText());
      stringBuilder.append("</font></b>");
      String str2 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("[anonymous] ");
      stringBuilder.append(editText.getEditableText().toString());
      String str1 = stringBuilder.toString();
      editText.getText().clear();
      editText.clearFocus();
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      runOnUiThread(new b(this, str2));
      synchronized (b.D.a()) {
        Iterator<b.a.b> iterator = null.iterator();
        while (iterator.hasNext())
          ((b.a.b)iterator.next()).a(str1.toString()); 
        return;
      } 
    } 
  }
  
  public void OnStrip(View paramView) {
    boolean bool;
    if (b.r == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    b.r = bool;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968583);
    this.a = (Context)this;
    CheckBox checkBox = (CheckBox)findViewById(2130903059);
    if (b.r == 1)
      checkBox.setChecked(true); 
    checkBox.setVisibility(4);
    ((CheckBox)findViewById(2130903060)).setVisibility(4);
    ((CheckBox)findViewById(2130903061)).setVisibility(4);
    ((CheckBox)findViewById(2130903064)).setVisibility(4);
    ((Button)findViewById(2130903046)).setVisibility(4);
    ((EditText)findViewById(2130903070)).setVisibility(4);
    ((Button)findViewById(2130903053)).setVisibility(4);
    ((Button)findViewById(2130903055)).setVisibility(4);
    ((Button)findViewById(2130903048)).setVisibility(4);
    TextView textView = (TextView)findViewById(2130903110);
    this.b = textView;
    textView.setTextSize(2, (b.q + 3));
    this.b.setTypeface(Typeface.MONOSPACE);
    this.b.setOnLongClickListener(new a(this));
    ((ScrollView)findViewById(2130903092)).setOnTouchListener(new g(this));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      b.C--;
      b.B.setCurrentTab(b.C);
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart() {
    super.onStart();
    CheckBox checkBox = (CheckBox)findViewById(2130903059);
    if (b.r == 1)
      checkBox.setChecked(true); 
  }
  
  class a implements View.OnLongClickListener {
    a(GalleryActivity this$0) {}
    
    public boolean onLongClick(View param1View) {
      AlertDialog.Builder builder = new AlertDialog.Builder(GalleryActivity.a(this.a));
      builder.setTitle("Confirm");
      builder.setMessage("Do you want to clear Chat view?");
      builder.setPositiveButton("YES", new a(this));
      builder.setNegativeButton("NO", new b(this));
      builder.create().show();
      return false;
    }
    
    class a implements DialogInterface.OnClickListener {
      a(GalleryActivity.a this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        this.a.a.b.setText("");
        param2DialogInterface.dismiss();
      }
    }
    
    class b implements DialogInterface.OnClickListener {
      b(GalleryActivity.a this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        param2DialogInterface.dismiss();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(GalleryActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.a.b.setText("");
      param1DialogInterface.dismiss();
    }
  }
  
  class b implements DialogInterface.OnClickListener {
    b(GalleryActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.dismiss();
    }
  }
  
  class b implements Runnable {
    b(GalleryActivity this$0, String param1String) {}
    
    public void run() {
      this.b.b.append((CharSequence)Html.fromHtml(this.a));
      this.b.b.append("\n");
    }
  }
  
  class c implements d.c {
    c(GalleryActivity this$0) {}
    
    public void a(File param1File) {
      Toast.makeText(this.a.getBaseContext(), param1File.getAbsolutePath(), 0).show();
      ((CheckBox)this.a.findViewById(2130903061)).setChecked(true);
      b.r = 1;
      ((CheckBox)this.a.findViewById(2130903059)).setChecked(true);
      try {
        FileOutputStream fileOutputStream = this.a.openFileOutput("force", 0);
        fileOutputStream.write(param1File.getAbsolutePath().getBytes());
        fileOutputStream.close();
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      AlertDialog.Builder builder = new AlertDialog.Builder(GalleryActivity.a(this.a));
      builder.setTitle("Do you want to limit injections?");
      EditText editText = new EditText(GalleryActivity.a(this.a));
      editText.setInputType(2);
      builder.setView((View)editText);
      builder.setPositiveButton("Limit", new a(this, editText));
      builder.setNegativeButton("Unlimited", new b(this));
      builder.show();
    }
    
    class a implements DialogInterface.OnClickListener {
      a(GalleryActivity.c this$0, EditText param2EditText) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        String str = this.a.getText().toString();
        if (str.length() > 0) {
          param2Int = Integer.parseInt(str);
        } else {
          param2Int = -1;
        } 
        b.v = param2Int;
      }
    }
    
    class b implements DialogInterface.OnClickListener {
      b(GalleryActivity.c this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        b.v = -1;
        param2DialogInterface.cancel();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(GalleryActivity this$0, EditText param1EditText) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      String str = this.a.getText().toString();
      if (str.length() > 0) {
        param1Int = Integer.parseInt(str);
      } else {
        param1Int = -1;
      } 
      b.v = param1Int;
    }
  }
  
  class b implements DialogInterface.OnClickListener {
    b(GalleryActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      b.v = -1;
      param1DialogInterface.cancel();
    }
  }
  
  class d implements Runnable {
    d(GalleryActivity this$0) {}
    
    public void run() {
      String str = b.F;
      GalleryActivity.h h = new GalleryActivity.h(this.a, new InetSocketAddress(str, 11220));
      b.D = h;
      h.run();
    }
  }
  
  class e implements DialogInterface.OnClickListener {
    e(GalleryActivity this$0, EditText param1EditText) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      b.t = this.a.getText().toString();
    }
  }
  
  class f implements DialogInterface.OnClickListener {
    f(GalleryActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.cancel();
    }
  }
  
  public class g implements View.OnTouchListener {
    private final GestureDetector a = new GestureDetector((GestureDetector.OnGestureListener)new a(null));
    
    public g(GalleryActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.onTouchEvent(param1MotionEvent);
      return false;
    }
    
    private final class a extends GestureDetector.SimpleOnGestureListener {
      private a(GalleryActivity.g this$0) {}
      
      public void a() {
        b.B.setCurrentTab(4);
      }
      
      public void b() {
        b.B.setCurrentTab(2);
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
    private a(GalleryActivity this$0) {}
    
    public void a() {
      b.B.setCurrentTab(4);
    }
    
    public void b() {
      b.B.setCurrentTab(2);
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
  
  public class h extends b.a.k.b {
    public h(GalleryActivity this$0, InetSocketAddress param1InetSocketAddress) {
      super(param1InetSocketAddress);
    }
    
    public void a(b.a.b param1b, b.a.j.a param1a) {
      this.o.runOnUiThread(new a(this, param1b));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[anonymous] ");
      stringBuilder.append(b.t);
      param1b.a(stringBuilder.toString());
    }
    
    public void b(b.a.b param1b, Exception param1Exception) {}
    
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
      a(GalleryActivity.h this$0, b.a.b param2b) {}
      
      public void run() {
        TextView textView = this.b.o.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incoming connection from ");
        stringBuilder.append(this.a.b().toString().substring(1, this.a.b().toString().indexOf(":")));
        textView.append(stringBuilder.toString());
        this.b.o.b.append("\n");
        textView = b.E;
        stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.a.b().toString().substring(1, this.a.b().toString().indexOf(":")));
        stringBuilder.append("] joined the Chat\n");
        textView.append(stringBuilder.toString());
      }
    }
    
    class b implements Runnable {
      b(GalleryActivity.h this$0) {}
      
      public void run() {
        this.a.o.b.append("User closed connection ");
        this.a.o.b.append("\n");
      }
    }
    
    class c implements Runnable {
      c(GalleryActivity.h this$0, String param2String) {}
      
      public void run() {
        this.b.o.b.append((CharSequence)Html.fromHtml(this.a));
        this.b.o.b.append("\n");
      }
    }
  }
  
  class a implements Runnable {
    a(GalleryActivity this$0, b.a.b param1b) {}
    
    public void run() {
      TextView textView = this.b.o.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Incoming connection from ");
      stringBuilder.append(this.a.b().toString().substring(1, this.a.b().toString().indexOf(":")));
      textView.append(stringBuilder.toString());
      this.b.o.b.append("\n");
      textView = b.E;
      stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(this.a.b().toString().substring(1, this.a.b().toString().indexOf(":")));
      stringBuilder.append("] joined the Chat\n");
      textView.append(stringBuilder.toString());
    }
  }
  
  class b implements Runnable {
    b(GalleryActivity this$0) {}
    
    public void run() {
      this.a.o.b.append("User closed connection ");
      this.a.o.b.append("\n");
    }
  }
  
  class c implements Runnable {
    c(GalleryActivity this$0, String param1String) {}
    
    public void run() {
      this.b.o.b.append((CharSequence)Html.fromHtml(this.a));
      this.b.o.b.append("\n");
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\GalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */