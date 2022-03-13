package su.sniff.cepter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {
  Process a = null;
  
  public Context b;
  
  String c;
  
  String d;
  
  TextView e;
  
  ScrollView f;
  
  int g = 0;
  
  public void OnCLS(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    this.e.setText("");
  }
  
  public void OnDefend(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    String[] arrayOfString1 = new String[255];
    String[] arrayOfString2 = new String[255];
    BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
    int i = 0;
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        String str1 = str.substring(0, str.indexOf(" "));
        Matcher matcher = Pattern.compile(String.format("^%s\\s+0x1\\s+0x2\\s+([:0-9a-fA-F]+)\\s+\\*\\s+\\w+$", new Object[] { str1.replace(".", "\\.") })).matcher(str);
        if (matcher.matches()) {
          String str2 = matcher.group(1);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append(":");
          stringBuilder.append(str2);
          stringBuilder.append("\n");
          stringBuilder.toString();
          arrayOfString1[i] = str2;
          arrayOfString2[i] = str1;
          i++;
        } 
        continue;
      } 
      bufferedReader.close();
      int j = 0;
      boolean bool;
      for (bool = false; j < i; bool = bool1) {
        boolean bool1;
        int k = 0;
        while (true) {
          bool1 = bool;
          if (k < i) {
            if (arrayOfString1[k].equals(arrayOfString1[j]) && k != j && b.G.equals(arrayOfString2[j])) {
              TextView textView1 = this.e;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Warning! Gateway poisoned by ");
              stringBuilder1.append(arrayOfString2[k]);
              stringBuilder1.append(" - ");
              stringBuilder1.append(arrayOfString1[k]);
              stringBuilder1.append("\n");
              textView1.append(stringBuilder1.toString());
              Process process1 = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
              DataOutputStream dataOutputStream2 = new DataOutputStream(process1.getOutputStream());
              BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append("/data/data/su.sniff.cepter/files/cepter ");
              stringBuilder3.append(Integer.toString(b.a));
              stringBuilder3.append(" -r ");
              stringBuilder3.append(b.G);
              stringBuilder3.append("\n");
              dataOutputStream2.writeBytes(stringBuilder3.toString());
              dataOutputStream2.flush();
              dataOutputStream2.writeBytes("exit\n");
              dataOutputStream2.flush();
              dataOutputStream2.close();
              String str2 = bufferedReader1.readLine();
              str2 = str2.substring(str2.indexOf(':') + 1, str2.length());
              bufferedReader1.close();
              process1.waitFor();
              String str1 = str2.replaceAll("-", ":");
              TextView textView2 = this.e;
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Restoring original mac - ");
              stringBuilder2.append(str1);
              stringBuilder2.append("\n");
              textView2.append(stringBuilder2.toString());
              Process process2 = Runtime.getRuntime().exec("su", (String[])null, new File("/system/bin"));
              DataOutputStream dataOutputStream1 = new DataOutputStream(process2.getOutputStream());
              stringBuilder3 = new StringBuilder();
              stringBuilder3.append("LD_LIBRARY_PATH=/data/data/su.sniff.cepter/files /data/data/su.sniff.cepter/files/busybox arp -s ");
              stringBuilder3.append(b.G);
              stringBuilder3.append(" ");
              stringBuilder3.append(str1);
              stringBuilder3.append("\n");
              dataOutputStream1.writeBytes(stringBuilder3.toString());
              dataOutputStream1.flush();
              dataOutputStream1.writeBytes("exit\n");
              dataOutputStream1.flush();
              dataOutputStream1.close();
              process2.waitFor();
              bool1 = true;
              break;
            } 
            k++;
            continue;
          } 
          break;
        } 
        j++;
      } 
      if (!bool)
        this.e.append("ARP Cache is clean. No attacks detected.\n"); 
      return;
    } 
  }
  
  public void OnOpenCap(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    String str = b.J;
    f f = new f(this);
    (new d((Context)this, str, new String[] { ".pcap", ".cap" }, f)).show();
  }
  
  public void OnSave(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    e e = new e(this);
    (new e((Context)this, str, new String[] { ".txt" }, e)).show();
  }
  
  public boolean a(String paramString1, String paramString2) {
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    dataOutputStream.writeBytes(paramString1);
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    while (true) {
      paramString1 = bufferedReader.readLine();
      if (paramString1 != null) {
        if (paramString1.indexOf(paramString2) != -1) {
          bufferedReader.close();
          return true;
        } 
        continue;
      } 
      bufferedReader.close();
      return false;
    } 
  }
  
  public void clk_run(View paramView) {
    String str;
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    if (this.a != null) {
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      ((ImageView)findViewById(2130903079)).setImageResource(2130837533);
      openFileOutput("exits.id", 0).close();
      this.a = null;
      return;
    } 
    ((ImageView)findViewById(2130903079)).setImageResource(2130837534);
    if (b.c == 1) {
      str = " w ";
    } else {
      str = " ";
    } 
    this.e.setTextSize(2, b.q);
    TextView textView = (TextView)findViewById(2130903109);
    textView.setTextSize(2, b.q);
    textView.setText("");
    File file = new File("/data/data/su.sniff.cepter/files/exits.id");
    if (file.exists())
      file.delete(); 
    if (b.r == 1) {
      (new Thread(new c(this))).start();
    } else {
      try {
        Process process1 = Runtime.getRuntime().exec("su");
        DataOutputStream dataOutputStream1 = new DataOutputStream(process1.getOutputStream());
        dataOutputStream1.writeBytes("iptables -F;iptables -X;iptables -t nat -F;iptables -t nat -X;iptables -t mangle -F;iptables -t mangle -X;iptables -P INPUT ACCEPT;iptables -P FORWARD ACCEPT;iptables -P OUTPUT ACCEPT\n");
        dataOutputStream1.flush();
        dataOutputStream1.writeBytes("echo '1' > /proc/sys/net/ipv4/ip_forward\n");
        dataOutputStream1.flush();
        if (!a("ip route\n", "default") && b.z == 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("ip route save > ");
          stringBuilder1.append(getFilesDir().getAbsolutePath());
          stringBuilder1.append("/iproutebackup\n");
          dataOutputStream1.writeBytes(stringBuilder1.toString());
          dataOutputStream1.flush();
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("ip rule save > ");
          stringBuilder1.append(getFilesDir().getAbsolutePath());
          stringBuilder1.append("/iprulebackup\n");
          dataOutputStream1.writeBytes(stringBuilder1.toString());
          dataOutputStream1.flush();
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("ip route add default via ");
          stringBuilder1.append(b.G);
          stringBuilder1.append("\n");
          dataOutputStream1.writeBytes(stringBuilder1.toString());
          dataOutputStream1.flush();
          dataOutputStream1.writeBytes("ip rule add from all lookup main pref 1\n");
          dataOutputStream1.flush();
          b.z = 1;
        } 
        if (b.d == 1) {
          dataOutputStream1.writeBytes("iptables -t nat -A PREROUTING -p udp --destination-port 53 -j REDIRECT --to-port 8053\n");
          dataOutputStream1.flush();
        } 
        dataOutputStream1.writeBytes("exit\n");
        dataOutputStream1.flush();
        dataOutputStream1.close();
        process1.waitFor();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
    stringBuilder.append(Integer.toString(b.a));
    stringBuilder.append(" ");
    stringBuilder.append(Integer.toString(b.b));
    stringBuilder.append(str);
    stringBuilder.append(this.c);
    stringBuilder.append(b.I);
    stringBuilder.append("\n");
    dataOutputStream.writeBytes(stringBuilder.toString());
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    this.a = process;
    (new Thread(new d(this, process))).start();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130968576);
    getWindow().setFeatureDrawableResource(3, 2130837514);
    TextView textView = (TextView)findViewById(2130903070);
    this.e = textView;
    b.E = textView;
    this.b = (Context)this;
    this.f = (ScrollView)findViewById(2130903091);
    b.K = new a(this, (Context)this, 2130968595, 2130903081, b.e);
    b.L = new b(this, (Context)this, 2130968595, 2130903081, b.i);
    this.f.setOnTouchListener(new g(this));
    this.c = getIntent().getExtras().getString("Key_String");
    this.d = getIntent().getExtras().getString("Key_String_origin");
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("iptables-save > ");
      stringBuilder.append(getFilesDir().getAbsolutePath());
      stringBuilder.append("/iptablesbackup\n");
      a(stringBuilder.toString(), "");
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    this.e.setTypeface(Typeface.MONOSPACE);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    Intent intent;
    if (paramInt == 4) {
      if (this.a == null) {
        intent = new Intent(this.b, ScanActivity.class);
        intent.putExtra("Key_String", this.d);
        startActivity(intent);
        finish();
        return false;
      } 
      Toast.makeText(getBaseContext(), "Stop ARP Poison!", 1).show();
      return true;
    } 
    return super.onKeyDown(paramInt, (KeyEvent)intent);
  }
  
  class a extends ArrayAdapter<String> {
    a(MainActivity this$0, Context param1Context, int param1Int1, int param1Int2, List param1List) {
      super(param1Context, param1Int1, param1Int2, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = param1View;
      if (param1View == null)
        view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130968595, param1ViewGroup, false); 
      TextView textView = (TextView)view.findViewById(2130903081);
      textView.setText((CharSequence)Html.fromHtml((String)getItem(param1Int)));
      textView.setTextSize(2, b.q);
      textView.setTypeface(Typeface.MONOSPACE);
      return view;
    }
  }
  
  class b extends ArrayAdapter<String> {
    b(MainActivity this$0, Context param1Context, int param1Int1, int param1Int2, List param1List) {
      super(param1Context, param1Int1, param1Int2, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = param1View;
      if (param1View == null)
        view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130968595, param1ViewGroup, false); 
      TextView textView = (TextView)view.findViewById(2130903081);
      textView.setText((CharSequence)Html.fromHtml((String)getItem(param1Int)));
      textView.setTextSize(2, b.q);
      textView.setTypeface(Typeface.MONOSPACE);
      return view;
    }
  }
  
  class c implements Runnable {
    c(MainActivity this$0) {}
    
    public void run() {
      try {
        Process process = Runtime.getRuntime().exec("su");
        DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
        dataOutputStream.writeBytes("iptables -F;iptables -X;iptables -t nat -F;iptables -t nat -X;iptables -t mangle -F;iptables -t mangle -X;iptables -P INPUT ACCEPT;iptables -P FORWARD ACCEPT;iptables -P OUTPUT ACCEPT\n");
        dataOutputStream.flush();
        dataOutputStream.writeBytes("echo '1' > /proc/sys/net/ipv4/ip_forward\n");
        dataOutputStream.flush();
        if (!this.a.a("ip route\n", "default") && b.z == 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("ip route save > ");
          stringBuilder.append(this.a.getFilesDir().getAbsolutePath());
          stringBuilder.append("/iproutebackup\n");
          dataOutputStream.writeBytes(stringBuilder.toString());
          dataOutputStream.flush();
          stringBuilder = new StringBuilder();
          stringBuilder.append("ip rule save > ");
          stringBuilder.append(this.a.getFilesDir().getAbsolutePath());
          stringBuilder.append("/iprulebackup\n");
          dataOutputStream.writeBytes(stringBuilder.toString());
          dataOutputStream.flush();
          stringBuilder = new StringBuilder();
          stringBuilder.append("ip route add default via ");
          stringBuilder.append(b.G);
          stringBuilder.append("\n");
          dataOutputStream.writeBytes(stringBuilder.toString());
          dataOutputStream.flush();
          dataOutputStream.writeBytes("ip rule add from all lookup main pref 1\n");
          dataOutputStream.flush();
          b.z = 1;
        } 
        dataOutputStream.writeBytes("iptables -t nat -A PREROUTING -p tcp --destination-port 80 -j REDIRECT --to-port 8081\n");
        dataOutputStream.flush();
        if (b.d == 1) {
          dataOutputStream.writeBytes("iptables -t nat -A PREROUTING -p udp --destination-port 53 -j REDIRECT --to-port 8053\n");
          dataOutputStream.flush();
        } 
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        process.waitFor();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
        return;
      } 
    }
  }
  
  class d implements Runnable {
    d(MainActivity this$0, Process param1Process) {}
    
    public void run() {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
      while (true) {
        try {
          MainActivity mainActivity;
          b b;
          e e;
          String str = bufferedReader.readLine();
          if (str == null) {
            bufferedReader.close();
            this.a.waitFor();
            this.b.runOnUiThread(new a(this));
            return;
          } 
          if (str.indexOf("Forcing download") != -1) {
            if (b.v > 0)
              b.v--; 
            if (b.v == 0) {
              File file = new File("/data/data/su.sniff.cepter/files/force");
              if (file.exists())
                file.delete(); 
            } 
          } 
          if (str.indexOf("###STAT###") != -1) {
            mainActivity = this.b;
            b = new b(this, str);
          } else {
            c c;
            if (b.indexOf("REQ###") != -1) {
              if (b.x == 1 && (b.y == 0 || (b.y == 1 && b.indexOf(b.F) == -1))) {
                mainActivity = this.b;
                c = new c(this, (String)b);
              } else {
                continue;
              } 
            } else {
              boolean bool1;
              String str1;
              String str2;
              String str3;
              if (c.indexOf("Cookie###") != -1) {
                String str4 = bufferedReader.readLine();
                str1 = bufferedReader.readLine();
                str2 = bufferedReader.readLine();
                str3 = bufferedReader.readLine();
                if (str1.equals(b.F))
                  continue; 
              } else {
                mainActivity = this.b;
                e = new e(this, str1);
                mainActivity.runOnUiThread(e);
              } 
              boolean bool2 = false;
              int i = 0;
              while (true) {
                bool1 = bool2;
                if (i < b.m) {
                  if (((String)b.f.get(i)).equals(str3)) {
                    bool1 = true;
                    break;
                  } 
                  i++;
                  continue;
                } 
                break;
              } 
              if (bool1 == true)
                continue; 
              this.b.runOnUiThread(new d(this, (String)mainActivity, (String)e, str3, str2));
              continue;
            } 
          } 
          mainActivity.runOnUiThread(e);
        } catch (IOException iOException) {
        
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        } 
      } 
    }
    
    class a implements Runnable {
      a(MainActivity.d this$0) {}
      
      public void run() {
        this.a.b.e.append("process terminated\n");
      }
    }
    
    class b implements Runnable {
      b(MainActivity.d this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class c implements Runnable {
      c(MainActivity.d this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        String str = this.a.substring(6, i);
        this.b.b.e.append(str);
        this.b.b.e.append("\n");
      }
    }
    
    class d implements Runnable {
      d(MainActivity.d this$0, String param2String1, String param2String2, String param2String3, String param2String4) {}
      
      public void run() {
        // Byte code:
        //   0: getstatic su/sniff/cepter/b.o : I
        //   3: ifne -> 13
        //   6: iconst_1
        //   7: putstatic su/sniff/cepter/b.o : I
        //   10: goto -> 35
        //   13: getstatic su/sniff/cepter/b.o : I
        //   16: iconst_1
        //   17: if_icmpne -> 6
        //   20: lconst_1
        //   21: invokestatic sleep : (J)V
        //   24: goto -> 13
        //   27: astore_2
        //   28: aload_2
        //   29: invokevirtual printStackTrace : ()V
        //   32: goto -> 13
        //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
        //   38: astore_2
        //   39: getstatic su/sniff/cepter/b.m : I
        //   42: istore_1
        //   43: new java/lang/StringBuilder
        //   46: dup
        //   47: invokespecial <init> : ()V
        //   50: astore_3
        //   51: aload_3
        //   52: aload_0
        //   53: getfield a : Ljava/lang/String;
        //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: pop
        //   60: aload_3
        //   61: ldc ' : '
        //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: aload_3
        //   68: aload_0
        //   69: getfield b : Ljava/lang/String;
        //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: pop
        //   76: aload_2
        //   77: iload_1
        //   78: aload_3
        //   79: invokevirtual toString : ()Ljava/lang/String;
        //   82: invokevirtual add : (ILjava/lang/Object;)V
        //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
        //   88: astore_2
        //   89: getstatic su/sniff/cepter/b.m : I
        //   92: istore_1
        //   93: new java/lang/StringBuilder
        //   96: dup
        //   97: invokespecial <init> : ()V
        //   100: astore_3
        //   101: aload_3
        //   102: ldc '<font color="#00aa00"><b>'
        //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: pop
        //   108: aload_3
        //   109: aload_0
        //   110: getfield a : Ljava/lang/String;
        //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: pop
        //   117: aload_3
        //   118: ldc ' : '
        //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: pop
        //   124: aload_3
        //   125: aload_0
        //   126: getfield b : Ljava/lang/String;
        //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: pop
        //   133: aload_3
        //   134: ldc '</b></font><br><font color="#397E7E">'
        //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop
        //   140: aload_3
        //   141: aload_0
        //   142: getfield c : Ljava/lang/String;
        //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: pop
        //   149: aload_3
        //   150: ldc '</font>'
        //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: pop
        //   156: aload_2
        //   157: iload_1
        //   158: aload_3
        //   159: invokevirtual toString : ()Ljava/lang/String;
        //   162: invokevirtual add : (ILjava/lang/Object;)V
        //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
        //   168: invokevirtual notifyDataSetChanged : ()V
        //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
        //   174: invokevirtual notifyDataSetChanged : ()V
        //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
        //   180: getstatic su/sniff/cepter/b.m : I
        //   183: aload_0
        //   184: getfield d : Ljava/lang/String;
        //   187: invokevirtual add : (ILjava/lang/Object;)V
        //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
        //   193: getstatic su/sniff/cepter/b.m : I
        //   196: aload_0
        //   197: getfield c : Ljava/lang/String;
        //   200: invokevirtual add : (ILjava/lang/Object;)V
        //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
        //   206: getstatic su/sniff/cepter/b.m : I
        //   209: aload_0
        //   210: getfield b : Ljava/lang/String;
        //   213: invokevirtual add : (ILjava/lang/Object;)V
        //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
        //   219: getstatic su/sniff/cepter/b.m : I
        //   222: aload_0
        //   223: getfield d : Ljava/lang/String;
        //   226: invokevirtual add : (ILjava/lang/Object;)V
        //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
        //   232: getstatic su/sniff/cepter/b.m : I
        //   235: aload_0
        //   236: getfield c : Ljava/lang/String;
        //   239: invokevirtual add : (ILjava/lang/Object;)V
        //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
        //   245: getstatic su/sniff/cepter/b.m : I
        //   248: aload_0
        //   249: getfield b : Ljava/lang/String;
        //   252: invokevirtual add : (ILjava/lang/Object;)V
        //   255: getstatic su/sniff/cepter/b.m : I
        //   258: iconst_1
        //   259: iadd
        //   260: putstatic su/sniff/cepter/b.m : I
        //   263: iconst_0
        //   264: putstatic su/sniff/cepter/b.o : I
        //   267: return
        // Exception table:
        //   from	to	target	type
        //   20	24	27	java/lang/InterruptedException
      }
    }
    
    class e implements Runnable {
      e(MainActivity.d this$0, String param2String) {}
      
      public void run() {
        if (this.a.indexOf("intercepted") != -1) {
          SpannableString spannableString = new SpannableString(this.a);
          spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
          this.b.b.e.append((CharSequence)spannableString);
        } else {
          this.b.b.e.append(this.a);
        } 
        this.b.b.e.append("\n");
        ScrollView scrollView = (ScrollView)this.b.b.findViewById(2130903091);
        if (b.p == 1)
          scrollView.scrollTo(0, this.b.b.e.getHeight() + 50); 
      }
    }
  }
  
  class a implements Runnable {
    a(MainActivity this$0) {}
    
    public void run() {
      this.a.b.e.append("process terminated\n");
    }
  }
  
  class b implements Runnable {
    b(MainActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      int j = this.a.indexOf("###STAT###") + 11;
      ((TextView)this.b.b.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
    }
  }
  
  class c implements Runnable {
    c(MainActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      String str = this.a.substring(6, i);
      this.b.b.e.append(str);
      this.b.b.e.append("\n");
    }
  }
  
  class d implements Runnable {
    d(MainActivity this$0, String param1String1, String param1String2, String param1String3, String param1String4) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic su/sniff/cepter/b.o : I
      //   3: ifne -> 13
      //   6: iconst_1
      //   7: putstatic su/sniff/cepter/b.o : I
      //   10: goto -> 35
      //   13: getstatic su/sniff/cepter/b.o : I
      //   16: iconst_1
      //   17: if_icmpne -> 6
      //   20: lconst_1
      //   21: invokestatic sleep : (J)V
      //   24: goto -> 13
      //   27: astore_2
      //   28: aload_2
      //   29: invokevirtual printStackTrace : ()V
      //   32: goto -> 13
      //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
      //   38: astore_2
      //   39: getstatic su/sniff/cepter/b.m : I
      //   42: istore_1
      //   43: new java/lang/StringBuilder
      //   46: dup
      //   47: invokespecial <init> : ()V
      //   50: astore_3
      //   51: aload_3
      //   52: aload_0
      //   53: getfield a : Ljava/lang/String;
      //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: pop
      //   60: aload_3
      //   61: ldc ' : '
      //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: aload_3
      //   68: aload_0
      //   69: getfield b : Ljava/lang/String;
      //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: aload_2
      //   77: iload_1
      //   78: aload_3
      //   79: invokevirtual toString : ()Ljava/lang/String;
      //   82: invokevirtual add : (ILjava/lang/Object;)V
      //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
      //   88: astore_2
      //   89: getstatic su/sniff/cepter/b.m : I
      //   92: istore_1
      //   93: new java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial <init> : ()V
      //   100: astore_3
      //   101: aload_3
      //   102: ldc '<font color="#00aa00"><b>'
      //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: pop
      //   108: aload_3
      //   109: aload_0
      //   110: getfield a : Ljava/lang/String;
      //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: pop
      //   117: aload_3
      //   118: ldc ' : '
      //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: aload_3
      //   125: aload_0
      //   126: getfield b : Ljava/lang/String;
      //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   132: pop
      //   133: aload_3
      //   134: ldc '</b></font><br><font color="#397E7E">'
      //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: pop
      //   140: aload_3
      //   141: aload_0
      //   142: getfield c : Ljava/lang/String;
      //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: pop
      //   149: aload_3
      //   150: ldc '</font>'
      //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: pop
      //   156: aload_2
      //   157: iload_1
      //   158: aload_3
      //   159: invokevirtual toString : ()Ljava/lang/String;
      //   162: invokevirtual add : (ILjava/lang/Object;)V
      //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
      //   168: invokevirtual notifyDataSetChanged : ()V
      //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
      //   174: invokevirtual notifyDataSetChanged : ()V
      //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
      //   180: getstatic su/sniff/cepter/b.m : I
      //   183: aload_0
      //   184: getfield d : Ljava/lang/String;
      //   187: invokevirtual add : (ILjava/lang/Object;)V
      //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
      //   193: getstatic su/sniff/cepter/b.m : I
      //   196: aload_0
      //   197: getfield c : Ljava/lang/String;
      //   200: invokevirtual add : (ILjava/lang/Object;)V
      //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
      //   206: getstatic su/sniff/cepter/b.m : I
      //   209: aload_0
      //   210: getfield b : Ljava/lang/String;
      //   213: invokevirtual add : (ILjava/lang/Object;)V
      //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
      //   219: getstatic su/sniff/cepter/b.m : I
      //   222: aload_0
      //   223: getfield d : Ljava/lang/String;
      //   226: invokevirtual add : (ILjava/lang/Object;)V
      //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
      //   232: getstatic su/sniff/cepter/b.m : I
      //   235: aload_0
      //   236: getfield c : Ljava/lang/String;
      //   239: invokevirtual add : (ILjava/lang/Object;)V
      //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
      //   245: getstatic su/sniff/cepter/b.m : I
      //   248: aload_0
      //   249: getfield b : Ljava/lang/String;
      //   252: invokevirtual add : (ILjava/lang/Object;)V
      //   255: getstatic su/sniff/cepter/b.m : I
      //   258: iconst_1
      //   259: iadd
      //   260: putstatic su/sniff/cepter/b.m : I
      //   263: iconst_0
      //   264: putstatic su/sniff/cepter/b.o : I
      //   267: return
      // Exception table:
      //   from	to	target	type
      //   20	24	27	java/lang/InterruptedException
    }
  }
  
  class e implements Runnable {
    e(MainActivity this$0, String param1String) {}
    
    public void run() {
      if (this.a.indexOf("intercepted") != -1) {
        SpannableString spannableString = new SpannableString(this.a);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
        this.b.b.e.append((CharSequence)spannableString);
      } else {
        this.b.b.e.append(this.a);
      } 
      this.b.b.e.append("\n");
      ScrollView scrollView = (ScrollView)this.b.b.findViewById(2130903091);
      if (b.p == 1)
        scrollView.scrollTo(0, this.b.b.e.getHeight() + 50); 
    }
  }
  
  class e implements e.d {
    e(MainActivity this$0) {}
    
    public void a(File param1File) {
      String str = this.a.e.getText().toString();
      try {
        FileWriter fileWriter = new FileWriter(param1File);
        fileWriter.append(str);
        fileWriter.flush();
        fileWriter.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
  
  class f implements d.c {
    f(MainActivity this$0) {}
    
    public void a(File param1File) {
      int i = b.c;
      this.a.e.setTextSize(2, b.q);
      TextView textView = (TextView)this.a.findViewById(2130903109);
      textView.setTextSize(2, b.q);
      textView.setText("");
      File file = new File("/data/data/su.sniff.cepter/files/exits.id");
      if (file.exists())
        file.delete(); 
      try {
        Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
        DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
        stringBuilder.append(param1File.getAbsolutePath());
        stringBuilder.append(" ");
        stringBuilder.append(Integer.toString(b.b));
        stringBuilder.append(b.I);
        stringBuilder.append("\n");
        dataOutputStream.writeBytes(stringBuilder.toString());
        dataOutputStream.flush();
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        this.a.a = process;
        (new Thread(new a(this, process))).start();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      this.a.a = null;
    }
    
    class a implements Runnable {
      a(MainActivity.f this$0, Process param2Process) {}
      
      public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
        while (true) {
          try {
            MainActivity mainActivity;
            a a1;
            d d;
            String str = bufferedReader.readLine();
            if (str == null) {
              bufferedReader.close();
              this.a.waitFor();
              return;
            } 
            if (str.indexOf("###STAT###") != -1) {
              mainActivity = this.b.a;
              a1 = new a(this, str);
            } else {
              b b;
              if (a1.indexOf("REQ###") != -1) {
                if (b.x == 1) {
                  mainActivity = this.b.a;
                  b = new b(this, (String)a1);
                } else {
                  continue;
                } 
              } else {
                boolean bool1;
                String str1;
                String str2;
                String str3;
                if (b.indexOf("Cookie###") != -1) {
                  String str4 = bufferedReader.readLine();
                  str1 = bufferedReader.readLine();
                  str2 = bufferedReader.readLine();
                  str3 = bufferedReader.readLine();
                  if (str1.equals(b.F))
                    continue; 
                } else {
                  Log.w("TAG", str1);
                  mainActivity = this.b.a;
                  d = new d(this, str1);
                  mainActivity.runOnUiThread(d);
                } 
                boolean bool2 = false;
                int i = 0;
                while (true) {
                  bool1 = bool2;
                  if (i < b.m) {
                    if (((String)b.f.get(i)).equals(str3)) {
                      bool1 = true;
                      break;
                    } 
                    i++;
                    continue;
                  } 
                  break;
                } 
                if (bool1 == true)
                  continue; 
                this.b.a.runOnUiThread(new c(this, (String)mainActivity, (String)d, str3, str2));
                continue;
              } 
            } 
            mainActivity.runOnUiThread(d);
          } catch (IOException iOException) {
          
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
        } 
      }
      
      class a implements Runnable {
        a(MainActivity.f.a this$0, String param3String) {}
        
        public void run() {
          int i = this.a.length();
          int j = this.a.indexOf("###STAT###") + 11;
          ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
        }
      }
      
      class b implements Runnable {
        b(MainActivity.f.a this$0, String param3String) {}
        
        public void run() {
          int i = this.a.length();
          String str = this.a.substring(6, i);
          this.b.b.a.e.append(str);
          this.b.b.a.e.append("\n");
        }
      }
      
      class c implements Runnable {
        c(MainActivity.f.a this$0, String param3String1, String param3String2, String param3String3, String param3String4) {}
        
        public void run() {
          // Byte code:
          //   0: getstatic su/sniff/cepter/b.o : I
          //   3: ifne -> 13
          //   6: iconst_1
          //   7: putstatic su/sniff/cepter/b.o : I
          //   10: goto -> 35
          //   13: getstatic su/sniff/cepter/b.o : I
          //   16: iconst_1
          //   17: if_icmpne -> 6
          //   20: lconst_1
          //   21: invokestatic sleep : (J)V
          //   24: goto -> 13
          //   27: astore_2
          //   28: aload_2
          //   29: invokevirtual printStackTrace : ()V
          //   32: goto -> 13
          //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
          //   38: astore_2
          //   39: getstatic su/sniff/cepter/b.m : I
          //   42: istore_1
          //   43: new java/lang/StringBuilder
          //   46: dup
          //   47: invokespecial <init> : ()V
          //   50: astore_3
          //   51: aload_3
          //   52: aload_0
          //   53: getfield a : Ljava/lang/String;
          //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   59: pop
          //   60: aload_3
          //   61: ldc ' : '
          //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   66: pop
          //   67: aload_3
          //   68: aload_0
          //   69: getfield b : Ljava/lang/String;
          //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   75: pop
          //   76: aload_2
          //   77: iload_1
          //   78: aload_3
          //   79: invokevirtual toString : ()Ljava/lang/String;
          //   82: invokevirtual add : (ILjava/lang/Object;)V
          //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
          //   88: astore_2
          //   89: getstatic su/sniff/cepter/b.m : I
          //   92: istore_1
          //   93: new java/lang/StringBuilder
          //   96: dup
          //   97: invokespecial <init> : ()V
          //   100: astore_3
          //   101: aload_3
          //   102: ldc '<font color="#00aa00"><b>'
          //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   107: pop
          //   108: aload_3
          //   109: aload_0
          //   110: getfield a : Ljava/lang/String;
          //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   116: pop
          //   117: aload_3
          //   118: ldc ' : '
          //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   123: pop
          //   124: aload_3
          //   125: aload_0
          //   126: getfield b : Ljava/lang/String;
          //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   132: pop
          //   133: aload_3
          //   134: ldc '</b></font><br><font color="#397E7E">'
          //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   139: pop
          //   140: aload_3
          //   141: aload_0
          //   142: getfield c : Ljava/lang/String;
          //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   148: pop
          //   149: aload_3
          //   150: ldc '</font>'
          //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   155: pop
          //   156: aload_2
          //   157: iload_1
          //   158: aload_3
          //   159: invokevirtual toString : ()Ljava/lang/String;
          //   162: invokevirtual add : (ILjava/lang/Object;)V
          //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
          //   168: invokevirtual notifyDataSetChanged : ()V
          //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
          //   174: invokevirtual notifyDataSetChanged : ()V
          //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
          //   180: getstatic su/sniff/cepter/b.m : I
          //   183: aload_0
          //   184: getfield d : Ljava/lang/String;
          //   187: invokevirtual add : (ILjava/lang/Object;)V
          //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
          //   193: getstatic su/sniff/cepter/b.m : I
          //   196: aload_0
          //   197: getfield c : Ljava/lang/String;
          //   200: invokevirtual add : (ILjava/lang/Object;)V
          //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
          //   206: getstatic su/sniff/cepter/b.m : I
          //   209: aload_0
          //   210: getfield b : Ljava/lang/String;
          //   213: invokevirtual add : (ILjava/lang/Object;)V
          //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
          //   219: getstatic su/sniff/cepter/b.m : I
          //   222: aload_0
          //   223: getfield d : Ljava/lang/String;
          //   226: invokevirtual add : (ILjava/lang/Object;)V
          //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
          //   232: getstatic su/sniff/cepter/b.m : I
          //   235: aload_0
          //   236: getfield c : Ljava/lang/String;
          //   239: invokevirtual add : (ILjava/lang/Object;)V
          //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
          //   245: getstatic su/sniff/cepter/b.m : I
          //   248: aload_0
          //   249: getfield b : Ljava/lang/String;
          //   252: invokevirtual add : (ILjava/lang/Object;)V
          //   255: getstatic su/sniff/cepter/b.m : I
          //   258: iconst_1
          //   259: iadd
          //   260: putstatic su/sniff/cepter/b.m : I
          //   263: iconst_0
          //   264: putstatic su/sniff/cepter/b.o : I
          //   267: return
          // Exception table:
          //   from	to	target	type
          //   20	24	27	java/lang/InterruptedException
        }
      }
      
      class d implements Runnable {
        d(MainActivity.f.a this$0, String param3String) {}
        
        public void run() {
          if (this.a.indexOf("intercepted") != -1) {
            SpannableString spannableString = new SpannableString(this.a);
            spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
            this.b.b.a.e.append((CharSequence)spannableString);
          } else {
            this.b.b.a.e.append(this.a);
          } 
          this.b.b.a.e.append("\n");
          ScrollView scrollView = (ScrollView)this.b.b.a.findViewById(2130903091);
          if (b.p == 1)
            scrollView.scrollTo(0, this.b.b.a.e.getHeight()); 
        }
      }
    }
    
    class a implements Runnable {
      a(MainActivity.f this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class b implements Runnable {
      b(MainActivity.f this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        String str = this.a.substring(6, i);
        this.b.b.a.e.append(str);
        this.b.b.a.e.append("\n");
      }
    }
    
    class c implements Runnable {
      c(MainActivity.f this$0, String param2String1, String param2String2, String param2String3, String param2String4) {}
      
      public void run() {
        // Byte code:
        //   0: getstatic su/sniff/cepter/b.o : I
        //   3: ifne -> 13
        //   6: iconst_1
        //   7: putstatic su/sniff/cepter/b.o : I
        //   10: goto -> 35
        //   13: getstatic su/sniff/cepter/b.o : I
        //   16: iconst_1
        //   17: if_icmpne -> 6
        //   20: lconst_1
        //   21: invokestatic sleep : (J)V
        //   24: goto -> 13
        //   27: astore_2
        //   28: aload_2
        //   29: invokevirtual printStackTrace : ()V
        //   32: goto -> 13
        //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
        //   38: astore_2
        //   39: getstatic su/sniff/cepter/b.m : I
        //   42: istore_1
        //   43: new java/lang/StringBuilder
        //   46: dup
        //   47: invokespecial <init> : ()V
        //   50: astore_3
        //   51: aload_3
        //   52: aload_0
        //   53: getfield a : Ljava/lang/String;
        //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: pop
        //   60: aload_3
        //   61: ldc ' : '
        //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: aload_3
        //   68: aload_0
        //   69: getfield b : Ljava/lang/String;
        //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: pop
        //   76: aload_2
        //   77: iload_1
        //   78: aload_3
        //   79: invokevirtual toString : ()Ljava/lang/String;
        //   82: invokevirtual add : (ILjava/lang/Object;)V
        //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
        //   88: astore_2
        //   89: getstatic su/sniff/cepter/b.m : I
        //   92: istore_1
        //   93: new java/lang/StringBuilder
        //   96: dup
        //   97: invokespecial <init> : ()V
        //   100: astore_3
        //   101: aload_3
        //   102: ldc '<font color="#00aa00"><b>'
        //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: pop
        //   108: aload_3
        //   109: aload_0
        //   110: getfield a : Ljava/lang/String;
        //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: pop
        //   117: aload_3
        //   118: ldc ' : '
        //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: pop
        //   124: aload_3
        //   125: aload_0
        //   126: getfield b : Ljava/lang/String;
        //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: pop
        //   133: aload_3
        //   134: ldc '</b></font><br><font color="#397E7E">'
        //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop
        //   140: aload_3
        //   141: aload_0
        //   142: getfield c : Ljava/lang/String;
        //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: pop
        //   149: aload_3
        //   150: ldc '</font>'
        //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: pop
        //   156: aload_2
        //   157: iload_1
        //   158: aload_3
        //   159: invokevirtual toString : ()Ljava/lang/String;
        //   162: invokevirtual add : (ILjava/lang/Object;)V
        //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
        //   168: invokevirtual notifyDataSetChanged : ()V
        //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
        //   174: invokevirtual notifyDataSetChanged : ()V
        //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
        //   180: getstatic su/sniff/cepter/b.m : I
        //   183: aload_0
        //   184: getfield d : Ljava/lang/String;
        //   187: invokevirtual add : (ILjava/lang/Object;)V
        //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
        //   193: getstatic su/sniff/cepter/b.m : I
        //   196: aload_0
        //   197: getfield c : Ljava/lang/String;
        //   200: invokevirtual add : (ILjava/lang/Object;)V
        //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
        //   206: getstatic su/sniff/cepter/b.m : I
        //   209: aload_0
        //   210: getfield b : Ljava/lang/String;
        //   213: invokevirtual add : (ILjava/lang/Object;)V
        //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
        //   219: getstatic su/sniff/cepter/b.m : I
        //   222: aload_0
        //   223: getfield d : Ljava/lang/String;
        //   226: invokevirtual add : (ILjava/lang/Object;)V
        //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
        //   232: getstatic su/sniff/cepter/b.m : I
        //   235: aload_0
        //   236: getfield c : Ljava/lang/String;
        //   239: invokevirtual add : (ILjava/lang/Object;)V
        //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
        //   245: getstatic su/sniff/cepter/b.m : I
        //   248: aload_0
        //   249: getfield b : Ljava/lang/String;
        //   252: invokevirtual add : (ILjava/lang/Object;)V
        //   255: getstatic su/sniff/cepter/b.m : I
        //   258: iconst_1
        //   259: iadd
        //   260: putstatic su/sniff/cepter/b.m : I
        //   263: iconst_0
        //   264: putstatic su/sniff/cepter/b.o : I
        //   267: return
        // Exception table:
        //   from	to	target	type
        //   20	24	27	java/lang/InterruptedException
      }
    }
    
    class d implements Runnable {
      d(MainActivity.f this$0, String param2String) {}
      
      public void run() {
        if (this.a.indexOf("intercepted") != -1) {
          SpannableString spannableString = new SpannableString(this.a);
          spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
          this.b.b.a.e.append((CharSequence)spannableString);
        } else {
          this.b.b.a.e.append(this.a);
        } 
        this.b.b.a.e.append("\n");
        ScrollView scrollView = (ScrollView)this.b.b.a.findViewById(2130903091);
        if (b.p == 1)
          scrollView.scrollTo(0, this.b.b.a.e.getHeight()); 
      }
    }
  }
  
  class a implements Runnable {
    a(MainActivity this$0, Process param1Process) {}
    
    public void run() {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
      while (true) {
        try {
          MainActivity mainActivity;
          a a1;
          d d;
          String str = bufferedReader.readLine();
          if (str == null) {
            bufferedReader.close();
            this.a.waitFor();
            return;
          } 
          if (str.indexOf("###STAT###") != -1) {
            mainActivity = this.b.a;
            a1 = new a(this, str);
          } else {
            b b;
            if (a1.indexOf("REQ###") != -1) {
              if (b.x == 1) {
                mainActivity = this.b.a;
                b = new b(this, (String)a1);
              } else {
                continue;
              } 
            } else {
              boolean bool1;
              String str1;
              String str2;
              String str3;
              if (b.indexOf("Cookie###") != -1) {
                String str4 = bufferedReader.readLine();
                str1 = bufferedReader.readLine();
                str2 = bufferedReader.readLine();
                str3 = bufferedReader.readLine();
                if (str1.equals(b.F))
                  continue; 
              } else {
                Log.w("TAG", str1);
                mainActivity = this.b.a;
                d = new d(this, str1);
                mainActivity.runOnUiThread(d);
              } 
              boolean bool2 = false;
              int i = 0;
              while (true) {
                bool1 = bool2;
                if (i < b.m) {
                  if (((String)b.f.get(i)).equals(str3)) {
                    bool1 = true;
                    break;
                  } 
                  i++;
                  continue;
                } 
                break;
              } 
              if (bool1 == true)
                continue; 
              this.b.a.runOnUiThread(new c(this, (String)mainActivity, (String)d, str3, str2));
              continue;
            } 
          } 
          mainActivity.runOnUiThread(d);
        } catch (IOException iOException) {
        
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        } 
      } 
    }
    
    class a implements Runnable {
      a(MainActivity.f.a this$0, String param3String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class b implements Runnable {
      b(MainActivity.f.a this$0, String param3String) {}
      
      public void run() {
        int i = this.a.length();
        String str = this.a.substring(6, i);
        this.b.b.a.e.append(str);
        this.b.b.a.e.append("\n");
      }
    }
    
    class c implements Runnable {
      c(MainActivity.f.a this$0, String param3String1, String param3String2, String param3String3, String param3String4) {}
      
      public void run() {
        // Byte code:
        //   0: getstatic su/sniff/cepter/b.o : I
        //   3: ifne -> 13
        //   6: iconst_1
        //   7: putstatic su/sniff/cepter/b.o : I
        //   10: goto -> 35
        //   13: getstatic su/sniff/cepter/b.o : I
        //   16: iconst_1
        //   17: if_icmpne -> 6
        //   20: lconst_1
        //   21: invokestatic sleep : (J)V
        //   24: goto -> 13
        //   27: astore_2
        //   28: aload_2
        //   29: invokevirtual printStackTrace : ()V
        //   32: goto -> 13
        //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
        //   38: astore_2
        //   39: getstatic su/sniff/cepter/b.m : I
        //   42: istore_1
        //   43: new java/lang/StringBuilder
        //   46: dup
        //   47: invokespecial <init> : ()V
        //   50: astore_3
        //   51: aload_3
        //   52: aload_0
        //   53: getfield a : Ljava/lang/String;
        //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: pop
        //   60: aload_3
        //   61: ldc ' : '
        //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: pop
        //   67: aload_3
        //   68: aload_0
        //   69: getfield b : Ljava/lang/String;
        //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: pop
        //   76: aload_2
        //   77: iload_1
        //   78: aload_3
        //   79: invokevirtual toString : ()Ljava/lang/String;
        //   82: invokevirtual add : (ILjava/lang/Object;)V
        //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
        //   88: astore_2
        //   89: getstatic su/sniff/cepter/b.m : I
        //   92: istore_1
        //   93: new java/lang/StringBuilder
        //   96: dup
        //   97: invokespecial <init> : ()V
        //   100: astore_3
        //   101: aload_3
        //   102: ldc '<font color="#00aa00"><b>'
        //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: pop
        //   108: aload_3
        //   109: aload_0
        //   110: getfield a : Ljava/lang/String;
        //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: pop
        //   117: aload_3
        //   118: ldc ' : '
        //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: pop
        //   124: aload_3
        //   125: aload_0
        //   126: getfield b : Ljava/lang/String;
        //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: pop
        //   133: aload_3
        //   134: ldc '</b></font><br><font color="#397E7E">'
        //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop
        //   140: aload_3
        //   141: aload_0
        //   142: getfield c : Ljava/lang/String;
        //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: pop
        //   149: aload_3
        //   150: ldc '</font>'
        //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: pop
        //   156: aload_2
        //   157: iload_1
        //   158: aload_3
        //   159: invokevirtual toString : ()Ljava/lang/String;
        //   162: invokevirtual add : (ILjava/lang/Object;)V
        //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
        //   168: invokevirtual notifyDataSetChanged : ()V
        //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
        //   174: invokevirtual notifyDataSetChanged : ()V
        //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
        //   180: getstatic su/sniff/cepter/b.m : I
        //   183: aload_0
        //   184: getfield d : Ljava/lang/String;
        //   187: invokevirtual add : (ILjava/lang/Object;)V
        //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
        //   193: getstatic su/sniff/cepter/b.m : I
        //   196: aload_0
        //   197: getfield c : Ljava/lang/String;
        //   200: invokevirtual add : (ILjava/lang/Object;)V
        //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
        //   206: getstatic su/sniff/cepter/b.m : I
        //   209: aload_0
        //   210: getfield b : Ljava/lang/String;
        //   213: invokevirtual add : (ILjava/lang/Object;)V
        //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
        //   219: getstatic su/sniff/cepter/b.m : I
        //   222: aload_0
        //   223: getfield d : Ljava/lang/String;
        //   226: invokevirtual add : (ILjava/lang/Object;)V
        //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
        //   232: getstatic su/sniff/cepter/b.m : I
        //   235: aload_0
        //   236: getfield c : Ljava/lang/String;
        //   239: invokevirtual add : (ILjava/lang/Object;)V
        //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
        //   245: getstatic su/sniff/cepter/b.m : I
        //   248: aload_0
        //   249: getfield b : Ljava/lang/String;
        //   252: invokevirtual add : (ILjava/lang/Object;)V
        //   255: getstatic su/sniff/cepter/b.m : I
        //   258: iconst_1
        //   259: iadd
        //   260: putstatic su/sniff/cepter/b.m : I
        //   263: iconst_0
        //   264: putstatic su/sniff/cepter/b.o : I
        //   267: return
        // Exception table:
        //   from	to	target	type
        //   20	24	27	java/lang/InterruptedException
      }
    }
    
    class d implements Runnable {
      d(MainActivity.f.a this$0, String param3String) {}
      
      public void run() {
        if (this.a.indexOf("intercepted") != -1) {
          SpannableString spannableString = new SpannableString(this.a);
          spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
          this.b.b.a.e.append((CharSequence)spannableString);
        } else {
          this.b.b.a.e.append(this.a);
        } 
        this.b.b.a.e.append("\n");
        ScrollView scrollView = (ScrollView)this.b.b.a.findViewById(2130903091);
        if (b.p == 1)
          scrollView.scrollTo(0, this.b.b.a.e.getHeight()); 
      }
    }
  }
  
  class a implements Runnable {
    a(MainActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      int j = this.a.indexOf("###STAT###") + 11;
      ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
    }
  }
  
  class b implements Runnable {
    b(MainActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      String str = this.a.substring(6, i);
      this.b.b.a.e.append(str);
      this.b.b.a.e.append("\n");
    }
  }
  
  class c implements Runnable {
    c(MainActivity this$0, String param1String1, String param1String2, String param1String3, String param1String4) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic su/sniff/cepter/b.o : I
      //   3: ifne -> 13
      //   6: iconst_1
      //   7: putstatic su/sniff/cepter/b.o : I
      //   10: goto -> 35
      //   13: getstatic su/sniff/cepter/b.o : I
      //   16: iconst_1
      //   17: if_icmpne -> 6
      //   20: lconst_1
      //   21: invokestatic sleep : (J)V
      //   24: goto -> 13
      //   27: astore_2
      //   28: aload_2
      //   29: invokevirtual printStackTrace : ()V
      //   32: goto -> 13
      //   35: getstatic su/sniff/cepter/b.e : Ljava/util/ArrayList;
      //   38: astore_2
      //   39: getstatic su/sniff/cepter/b.m : I
      //   42: istore_1
      //   43: new java/lang/StringBuilder
      //   46: dup
      //   47: invokespecial <init> : ()V
      //   50: astore_3
      //   51: aload_3
      //   52: aload_0
      //   53: getfield a : Ljava/lang/String;
      //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: pop
      //   60: aload_3
      //   61: ldc ' : '
      //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: aload_3
      //   68: aload_0
      //   69: getfield b : Ljava/lang/String;
      //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: aload_2
      //   77: iload_1
      //   78: aload_3
      //   79: invokevirtual toString : ()Ljava/lang/String;
      //   82: invokevirtual add : (ILjava/lang/Object;)V
      //   85: getstatic su/sniff/cepter/b.i : Ljava/util/ArrayList;
      //   88: astore_2
      //   89: getstatic su/sniff/cepter/b.m : I
      //   92: istore_1
      //   93: new java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial <init> : ()V
      //   100: astore_3
      //   101: aload_3
      //   102: ldc '<font color="#00aa00"><b>'
      //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: pop
      //   108: aload_3
      //   109: aload_0
      //   110: getfield a : Ljava/lang/String;
      //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: pop
      //   117: aload_3
      //   118: ldc ' : '
      //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: aload_3
      //   125: aload_0
      //   126: getfield b : Ljava/lang/String;
      //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   132: pop
      //   133: aload_3
      //   134: ldc '</b></font><br><font color="#397E7E">'
      //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: pop
      //   140: aload_3
      //   141: aload_0
      //   142: getfield c : Ljava/lang/String;
      //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: pop
      //   149: aload_3
      //   150: ldc '</font>'
      //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: pop
      //   156: aload_2
      //   157: iload_1
      //   158: aload_3
      //   159: invokevirtual toString : ()Ljava/lang/String;
      //   162: invokevirtual add : (ILjava/lang/Object;)V
      //   165: getstatic su/sniff/cepter/b.K : Landroid/widget/ArrayAdapter;
      //   168: invokevirtual notifyDataSetChanged : ()V
      //   171: getstatic su/sniff/cepter/b.L : Landroid/widget/ArrayAdapter;
      //   174: invokevirtual notifyDataSetChanged : ()V
      //   177: getstatic su/sniff/cepter/b.g : Ljava/util/ArrayList;
      //   180: getstatic su/sniff/cepter/b.m : I
      //   183: aload_0
      //   184: getfield d : Ljava/lang/String;
      //   187: invokevirtual add : (ILjava/lang/Object;)V
      //   190: getstatic su/sniff/cepter/b.f : Ljava/util/ArrayList;
      //   193: getstatic su/sniff/cepter/b.m : I
      //   196: aload_0
      //   197: getfield c : Ljava/lang/String;
      //   200: invokevirtual add : (ILjava/lang/Object;)V
      //   203: getstatic su/sniff/cepter/b.h : Ljava/util/ArrayList;
      //   206: getstatic su/sniff/cepter/b.m : I
      //   209: aload_0
      //   210: getfield b : Ljava/lang/String;
      //   213: invokevirtual add : (ILjava/lang/Object;)V
      //   216: getstatic su/sniff/cepter/b.k : Ljava/util/ArrayList;
      //   219: getstatic su/sniff/cepter/b.m : I
      //   222: aload_0
      //   223: getfield d : Ljava/lang/String;
      //   226: invokevirtual add : (ILjava/lang/Object;)V
      //   229: getstatic su/sniff/cepter/b.j : Ljava/util/ArrayList;
      //   232: getstatic su/sniff/cepter/b.m : I
      //   235: aload_0
      //   236: getfield c : Ljava/lang/String;
      //   239: invokevirtual add : (ILjava/lang/Object;)V
      //   242: getstatic su/sniff/cepter/b.l : Ljava/util/ArrayList;
      //   245: getstatic su/sniff/cepter/b.m : I
      //   248: aload_0
      //   249: getfield b : Ljava/lang/String;
      //   252: invokevirtual add : (ILjava/lang/Object;)V
      //   255: getstatic su/sniff/cepter/b.m : I
      //   258: iconst_1
      //   259: iadd
      //   260: putstatic su/sniff/cepter/b.m : I
      //   263: iconst_0
      //   264: putstatic su/sniff/cepter/b.o : I
      //   267: return
      // Exception table:
      //   from	to	target	type
      //   20	24	27	java/lang/InterruptedException
    }
  }
  
  class d implements Runnable {
    d(MainActivity this$0, String param1String) {}
    
    public void run() {
      if (this.a.indexOf("intercepted") != -1) {
        SpannableString spannableString = new SpannableString(this.a);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, this.a.length(), 33);
        this.b.b.a.e.append((CharSequence)spannableString);
      } else {
        this.b.b.a.e.append(this.a);
      } 
      this.b.b.a.e.append("\n");
      ScrollView scrollView = (ScrollView)this.b.b.a.findViewById(2130903091);
      if (b.p == 1)
        scrollView.scrollTo(0, this.b.b.a.e.getHeight()); 
    }
  }
  
  public class g implements View.OnTouchListener {
    private final GestureDetector a = new GestureDetector((GestureDetector.OnGestureListener)new a(null));
    
    private final ScaleGestureDetector b = new ScaleGestureDetector(this.c.b, (ScaleGestureDetector.OnScaleGestureListener)new b(null));
    
    public g(MainActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.b.onTouchEvent(param1MotionEvent);
      this.a.onTouchEvent(param1MotionEvent);
      return false;
    }
    
    private final class a extends GestureDetector.SimpleOnGestureListener {
      private a(MainActivity.g this$0) {}
      
      public void a() {
        b.B.setCurrentTab(1);
      }
      
      public void b() {}
      
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
    
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
      private b(MainActivity.g this$0) {}
      
      public boolean onScale(ScaleGestureDetector param2ScaleGestureDetector) {
        float f = param2ScaleGestureDetector.getScaleFactor();
        if (f < 1.0F) {
          MainActivity mainActivity = this.a.c;
          int i = mainActivity.g + 1;
          mainActivity.g = i;
          if (i > 10) {
            i = b.q - 1;
            b.q = i;
            mainActivity.e.setTextSize(i);
            this.a.c.e.invalidate();
            this.a.c.g = 0;
          } 
        } 
        if (f > 1.0F) {
          MainActivity mainActivity = this.a.c;
          int i = mainActivity.g + 1;
          mainActivity.g = i;
          if (i > 10) {
            i = b.q + 1;
            b.q = i;
            mainActivity.e.setTextSize(i);
            this.a.c.e.invalidate();
            this.a.c.g = 0;
          } 
        } 
        return true;
      }
    }
  }
  
  private final class a extends GestureDetector.SimpleOnGestureListener {
    private a(MainActivity this$0) {}
    
    public void a() {
      b.B.setCurrentTab(1);
    }
    
    public void b() {}
    
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
  
  private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private b(MainActivity this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f = param1ScaleGestureDetector.getScaleFactor();
      if (f < 1.0F) {
        MainActivity mainActivity = this.a.c;
        int i = mainActivity.g + 1;
        mainActivity.g = i;
        if (i > 10) {
          i = b.q - 1;
          b.q = i;
          mainActivity.e.setTextSize(i);
          this.a.c.e.invalidate();
          this.a.c.g = 0;
        } 
      } 
      if (f > 1.0F) {
        MainActivity mainActivity = this.a.c;
        int i = mainActivity.g + 1;
        mainActivity.g = i;
        if (i > 10) {
          i = b.q + 1;
          b.q = i;
          mainActivity.e.setTextSize(i);
          this.a.c.e.invalidate();
          this.a.c.g = 0;
        } 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */