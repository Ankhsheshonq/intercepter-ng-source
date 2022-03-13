package su.sniff.cepter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RawActivity extends Activity {
  public ListView a;
  
  private Context b;
  
  public Process c = null;
  
  int d = 0;
  
  public void OnOpenCap(View paramView) {
    try {
      EditText editText = (EditText)findViewById(2130903070);
      FileOutputStream fileOutputStream = openFileOutput("pf", 0);
      fileOutputStream.write(editText.getEditableText().toString().getBytes());
      fileOutputStream.close();
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    ((TextView)findViewById(2130903109)).setText("");
    String str = b.J;
    b b = new b(this);
    (new d((Context)this, str, new String[] { ".pcap", ".cap" }, b)).show();
  }
  
  public void OnRaw(View paramView) {
    String str;
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    if (this.c != null) {
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      ((ImageView)findViewById(2130903076)).setImageResource(2130837533);
      openFileOutput("exitr.id", 0).close();
      this.c = null;
      return;
    } 
    ((ImageView)findViewById(2130903076)).setImageResource(2130837534);
    File file = new File("/data/data/su.sniff.cepter/files/exitr.id");
    if (file.exists())
      file.delete(); 
    if (b.c == 1) {
      str = " w ";
    } else {
      str = " ";
    } 
    EditText editText = (EditText)findViewById(2130903070);
    FileOutputStream fileOutputStream = openFileOutput("pf", 0);
    fileOutputStream.write(editText.getEditableText().toString().getBytes());
    fileOutputStream.close();
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
    stringBuilder.append(Integer.toString(b.a));
    stringBuilder.append(" 3 raw");
    stringBuilder.append(str);
    stringBuilder.append("\n");
    dataOutputStream.writeBytes(stringBuilder.toString());
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    ((TextView)findViewById(2130903109)).setText("");
    this.c = process;
    (new Thread(new a(this, process))).start();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130968593);
    ScrollView scrollView = (ScrollView)findViewById(2130903091);
    this.a = (ListView)findViewById(2130903082);
    new ArrayList();
    this.b = (Context)this;
    getIntent().getExtras().getString("Key_String");
    getIntent().getExtras().getString("Key_String_origin");
    this.a.setOnTouchListener(new c(this));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      b.C--;
      b.B.setCurrentTab(b.C);
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements Runnable {
    a(RawActivity this$0, Process param1Process) {}
    
    public void run() {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
      ArrayList<String> arrayList = new ArrayList();
      a a1 = new a((Context)this.b, 2130968594, arrayList);
      this.b.runOnUiThread(new a(this, a1));
      this.b.a.setOnItemClickListener(new b(this));
      int i = 0;
      while (true) {
        int j;
        String str1;
        String str2;
        String str3;
        try {
          String str = bufferedReader.readLine();
          if (str == null) {
            bufferedReader.close();
            this.a.waitFor();
            this.b.runOnUiThread(new c(this, arrayList, i, a1));
            return;
          } 
          if (str.indexOf("###STAT###") != -1) {
            this.b.runOnUiThread(new d(this, str));
            continue;
          } 
          if (str.indexOf("REQ###") != -1)
            continue; 
          if (str.indexOf("Cookie###") != -1) {
            str = bufferedReader.readLine();
            str1 = bufferedReader.readLine();
            str2 = bufferedReader.readLine();
            str3 = bufferedReader.readLine();
            bufferedReader.readLine();
            j = 0;
            while (true) {
              if (j < b.m) {
                if (((String)b.f.get(j)).equals(str3)) {
                  j = 1;
                  break;
                } 
                j++;
                continue;
              } 
              j = 0;
              break;
            } 
          } else {
            if (b.A == 0) {
              this.b.runOnUiThread(new f(this, arrayList, i, str, a1));
              i++;
            } 
            continue;
          } 
        } catch (IOException iOException) {
          continue;
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
          continue;
        } 
        if (j == 1)
          continue; 
        this.b.runOnUiThread(new e(this, (String)interruptedException, str1, str3, str2));
      } 
    }
    
    class a implements Runnable {
      a(RawActivity.a this$0, a param2a) {}
      
      public void run() {
        this.b.b.a.setAdapter((ListAdapter)this.a);
        this.a.notifyDataSetChanged();
      }
    }
    
    class b implements AdapterView.OnItemClickListener {
      b(RawActivity.a this$0) {}
      
      public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
        String str = param2AdapterView.getItemAtPosition(param2Int).toString();
        param2Int = str.indexOf(" ");
        if (param2Int > 0) {
          str = str.substring(0, param2Int);
          try {
            Integer.valueOf(str).intValue();
            Intent intent = new Intent(RawActivity.a(this.a.b), RawDetails.class);
            intent.putExtra("Key_Int", Integer.valueOf(str));
            this.a.b.startActivityForResult(intent, 1);
            b.o = 0;
            return;
          } catch (NumberFormatException numberFormatException) {
            return;
          } 
        } 
      }
    }
    
    class c implements Runnable {
      c(RawActivity.a this$0, ArrayList param2ArrayList, int param2Int, a param2a) {}
      
      public void run() {
        this.a.add(this.b, "process terminated");
        this.c.notifyDataSetChanged();
        if (b.p == 1)
          this.d.b.a.setSelection(this.b); 
      }
    }
    
    class d implements Runnable {
      d(RawActivity.a this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class e implements Runnable {
      e(RawActivity.a this$0, String param2String1, String param2String2, String param2String3, String param2String4) {}
      
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
    
    class f implements Runnable {
      f(RawActivity.a this$0, ArrayList param2ArrayList, int param2Int, String param2String, a param2a) {}
      
      public void run() {
        this.a.add(this.b, this.c);
        this.d.notifyDataSetChanged();
        if (b.p == 1)
          this.e.b.a.setSelection(this.b); 
      }
    }
  }
  
  class a implements Runnable {
    a(RawActivity this$0, a param1a) {}
    
    public void run() {
      this.b.b.a.setAdapter((ListAdapter)this.a);
      this.a.notifyDataSetChanged();
    }
  }
  
  class b implements AdapterView.OnItemClickListener {
    b(RawActivity this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      String str = param1AdapterView.getItemAtPosition(param1Int).toString();
      param1Int = str.indexOf(" ");
      if (param1Int > 0) {
        str = str.substring(0, param1Int);
        try {
          Integer.valueOf(str).intValue();
          Intent intent = new Intent(RawActivity.a(this.a.b), RawDetails.class);
          intent.putExtra("Key_Int", Integer.valueOf(str));
          this.a.b.startActivityForResult(intent, 1);
          b.o = 0;
          return;
        } catch (NumberFormatException numberFormatException) {
          return;
        } 
      } 
    }
  }
  
  class c implements Runnable {
    c(RawActivity this$0, ArrayList param1ArrayList, int param1Int, a param1a) {}
    
    public void run() {
      this.a.add(this.b, "process terminated");
      this.c.notifyDataSetChanged();
      if (b.p == 1)
        this.d.b.a.setSelection(this.b); 
    }
  }
  
  class d implements Runnable {
    d(RawActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      int j = this.a.indexOf("###STAT###") + 11;
      ((TextView)this.b.b.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
    }
  }
  
  class e implements Runnable {
    e(RawActivity this$0, String param1String1, String param1String2, String param1String3, String param1String4) {}
    
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
  
  class f implements Runnable {
    f(RawActivity this$0, ArrayList param1ArrayList, int param1Int, String param1String, a param1a) {}
    
    public void run() {
      this.a.add(this.b, this.c);
      this.d.notifyDataSetChanged();
      if (b.p == 1)
        this.e.b.a.setSelection(this.b); 
    }
  }
  
  class b implements d.c {
    b(RawActivity this$0) {}
    
    public void a(File param1File) {
      int i = b.c;
      ((ImageView)this.a.findViewById(2130903076)).setImageResource(2130837534);
      File file = new File("/data/data/su.sniff.cepter/files/exitr.id");
      if (file.exists())
        file.delete(); 
      try {
        Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
        DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
        stringBuilder.append(param1File.getAbsolutePath());
        stringBuilder.append(" 3 raw\n");
        dataOutputStream.writeBytes(stringBuilder.toString());
        dataOutputStream.flush();
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        this.a.c = process;
        (new Thread(new a(this, process))).start();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
    
    class a implements Runnable {
      a(RawActivity.b this$0, Process param2Process) {}
      
      public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
        ArrayList<String> arrayList = new ArrayList();
        a a1 = new a((Context)this.b.a, 2130968594, arrayList);
        this.b.a.runOnUiThread(new a(this, a1));
        this.b.a.a.setOnItemClickListener(new b(this));
        int i = 0;
        while (true) {
          int j;
          String str1;
          String str2;
          String str3;
          try {
            String str = bufferedReader.readLine();
            if (str == null) {
              bufferedReader.close();
              this.a.waitFor();
              this.b.a.runOnUiThread(new f(this));
              this.b.a.c = null;
              return;
            } 
            if (str.contains("###STAT###")) {
              this.b.a.runOnUiThread(new c(this, str));
              continue;
            } 
            if (str.indexOf("REQ###") != -1)
              continue; 
            if (str.indexOf("Cookie###") != -1) {
              str = bufferedReader.readLine();
              str1 = bufferedReader.readLine();
              str2 = bufferedReader.readLine();
              str3 = bufferedReader.readLine();
              bufferedReader.readLine();
              j = 0;
              while (true) {
                if (j < b.m) {
                  if (((String)b.f.get(j)).equals(str3)) {
                    j = 1;
                    break;
                  } 
                  j++;
                  continue;
                } 
                j = 0;
                break;
              } 
            } else {
              this.b.a.runOnUiThread(new e(this, arrayList, i, str, a1));
              i++;
              continue;
            } 
          } catch (IOException iOException) {
            continue;
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            continue;
          } 
          if (j == 1)
            continue; 
          this.b.a.runOnUiThread(new d(this, (String)interruptedException, str1, str3, str2));
        } 
      }
      
      class a implements Runnable {
        a(RawActivity.b.a this$0, a param3a) {}
        
        public void run() {
          this.b.b.a.a.setAdapter((ListAdapter)this.a);
          this.a.notifyDataSetChanged();
        }
      }
      
      class b implements AdapterView.OnItemClickListener {
        b(RawActivity.b.a this$0) {}
        
        public void onItemClick(AdapterView<?> param3AdapterView, View param3View, int param3Int, long param3Long) {
          String str = param3AdapterView.getItemAtPosition(param3Int).toString();
          param3Int = str.indexOf(" ");
          if (param3Int > 0) {
            str = str.substring(0, param3Int);
            try {
              Integer.valueOf(str).intValue();
              Intent intent = new Intent(RawActivity.a(this.a.b.a), RawDetails.class);
              intent.putExtra("Key_Int", Integer.valueOf(str));
              this.a.b.a.startActivityForResult(intent, 1);
              b.o = 0;
              return;
            } catch (NumberFormatException numberFormatException) {
              return;
            } 
          } 
        }
      }
      
      class c implements Runnable {
        c(RawActivity.b.a this$0, String param3String) {}
        
        public void run() {
          int i = this.a.length();
          int j = this.a.indexOf("###STAT###") + 11;
          ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
        }
      }
      
      class d implements Runnable {
        d(RawActivity.b.a this$0, String param3String1, String param3String2, String param3String3, String param3String4) {}
        
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
        e(RawActivity.b.a this$0, ArrayList param3ArrayList, int param3Int, String param3String, a param3a) {}
        
        public void run() {
          this.a.add(this.b, this.c);
          this.d.notifyDataSetChanged();
        }
      }
      
      class f implements Runnable {
        f(RawActivity.b.a this$0) {}
        
        public void run() {
          ((ImageView)this.a.b.a.findViewById(2130903076)).setImageResource(2130837533);
        }
      }
    }
    
    class a implements Runnable {
      a(RawActivity.b this$0, a param2a) {}
      
      public void run() {
        this.b.b.a.a.setAdapter((ListAdapter)this.a);
        this.a.notifyDataSetChanged();
      }
    }
    
    class b implements AdapterView.OnItemClickListener {
      b(RawActivity.b this$0) {}
      
      public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
        String str = param2AdapterView.getItemAtPosition(param2Int).toString();
        param2Int = str.indexOf(" ");
        if (param2Int > 0) {
          str = str.substring(0, param2Int);
          try {
            Integer.valueOf(str).intValue();
            Intent intent = new Intent(RawActivity.a(this.a.b.a), RawDetails.class);
            intent.putExtra("Key_Int", Integer.valueOf(str));
            this.a.b.a.startActivityForResult(intent, 1);
            b.o = 0;
            return;
          } catch (NumberFormatException numberFormatException) {
            return;
          } 
        } 
      }
    }
    
    class c implements Runnable {
      c(RawActivity.b this$0, String param2String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class d implements Runnable {
      d(RawActivity.b this$0, String param2String1, String param2String2, String param2String3, String param2String4) {}
      
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
      e(RawActivity.b this$0, ArrayList param2ArrayList, int param2Int, String param2String, a param2a) {}
      
      public void run() {
        this.a.add(this.b, this.c);
        this.d.notifyDataSetChanged();
      }
    }
    
    class f implements Runnable {
      f(RawActivity.b this$0) {}
      
      public void run() {
        ((ImageView)this.a.b.a.findViewById(2130903076)).setImageResource(2130837533);
      }
    }
  }
  
  class a implements Runnable {
    a(RawActivity this$0, Process param1Process) {}
    
    public void run() {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
      ArrayList<String> arrayList = new ArrayList();
      a a1 = new a((Context)this.b.a, 2130968594, arrayList);
      this.b.a.runOnUiThread(new a(this, a1));
      this.b.a.a.setOnItemClickListener(new b(this));
      int i = 0;
      while (true) {
        int j;
        String str1;
        String str2;
        String str3;
        try {
          String str = bufferedReader.readLine();
          if (str == null) {
            bufferedReader.close();
            this.a.waitFor();
            this.b.a.runOnUiThread(new f(this));
            this.b.a.c = null;
            return;
          } 
          if (str.contains("###STAT###")) {
            this.b.a.runOnUiThread(new c(this, str));
            continue;
          } 
          if (str.indexOf("REQ###") != -1)
            continue; 
          if (str.indexOf("Cookie###") != -1) {
            str = bufferedReader.readLine();
            str1 = bufferedReader.readLine();
            str2 = bufferedReader.readLine();
            str3 = bufferedReader.readLine();
            bufferedReader.readLine();
            j = 0;
            while (true) {
              if (j < b.m) {
                if (((String)b.f.get(j)).equals(str3)) {
                  j = 1;
                  break;
                } 
                j++;
                continue;
              } 
              j = 0;
              break;
            } 
          } else {
            this.b.a.runOnUiThread(new e(this, arrayList, i, str, a1));
            i++;
            continue;
          } 
        } catch (IOException iOException) {
          continue;
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
          continue;
        } 
        if (j == 1)
          continue; 
        this.b.a.runOnUiThread(new d(this, (String)interruptedException, str1, str3, str2));
      } 
    }
    
    class a implements Runnable {
      a(RawActivity.b.a this$0, a param3a) {}
      
      public void run() {
        this.b.b.a.a.setAdapter((ListAdapter)this.a);
        this.a.notifyDataSetChanged();
      }
    }
    
    class b implements AdapterView.OnItemClickListener {
      b(RawActivity.b.a this$0) {}
      
      public void onItemClick(AdapterView<?> param3AdapterView, View param3View, int param3Int, long param3Long) {
        String str = param3AdapterView.getItemAtPosition(param3Int).toString();
        param3Int = str.indexOf(" ");
        if (param3Int > 0) {
          str = str.substring(0, param3Int);
          try {
            Integer.valueOf(str).intValue();
            Intent intent = new Intent(RawActivity.a(this.a.b.a), RawDetails.class);
            intent.putExtra("Key_Int", Integer.valueOf(str));
            this.a.b.a.startActivityForResult(intent, 1);
            b.o = 0;
            return;
          } catch (NumberFormatException numberFormatException) {
            return;
          } 
        } 
      }
    }
    
    class c implements Runnable {
      c(RawActivity.b.a this$0, String param3String) {}
      
      public void run() {
        int i = this.a.length();
        int j = this.a.indexOf("###STAT###") + 11;
        ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
      }
    }
    
    class d implements Runnable {
      d(RawActivity.b.a this$0, String param3String1, String param3String2, String param3String3, String param3String4) {}
      
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
      e(RawActivity.b.a this$0, ArrayList param3ArrayList, int param3Int, String param3String, a param3a) {}
      
      public void run() {
        this.a.add(this.b, this.c);
        this.d.notifyDataSetChanged();
      }
    }
    
    class f implements Runnable {
      f(RawActivity.b.a this$0) {}
      
      public void run() {
        ((ImageView)this.a.b.a.findViewById(2130903076)).setImageResource(2130837533);
      }
    }
  }
  
  class a implements Runnable {
    a(RawActivity this$0, a param1a) {}
    
    public void run() {
      this.b.b.a.a.setAdapter((ListAdapter)this.a);
      this.a.notifyDataSetChanged();
    }
  }
  
  class b implements AdapterView.OnItemClickListener {
    b(RawActivity this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      String str = param1AdapterView.getItemAtPosition(param1Int).toString();
      param1Int = str.indexOf(" ");
      if (param1Int > 0) {
        str = str.substring(0, param1Int);
        try {
          Integer.valueOf(str).intValue();
          Intent intent = new Intent(RawActivity.a(this.a.b.a), RawDetails.class);
          intent.putExtra("Key_Int", Integer.valueOf(str));
          this.a.b.a.startActivityForResult(intent, 1);
          b.o = 0;
          return;
        } catch (NumberFormatException numberFormatException) {
          return;
        } 
      } 
    }
  }
  
  class c implements Runnable {
    c(RawActivity this$0, String param1String) {}
    
    public void run() {
      int i = this.a.length();
      int j = this.a.indexOf("###STAT###") + 11;
      ((TextView)this.b.b.a.findViewById(2130903109)).setText(this.a.substring(j, i - j + 11));
    }
  }
  
  class d implements Runnable {
    d(RawActivity this$0, String param1String1, String param1String2, String param1String3, String param1String4) {}
    
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
    e(RawActivity this$0, ArrayList param1ArrayList, int param1Int, String param1String, a param1a) {}
    
    public void run() {
      this.a.add(this.b, this.c);
      this.d.notifyDataSetChanged();
    }
  }
  
  class f implements Runnable {
    f(RawActivity this$0) {}
    
    public void run() {
      ((ImageView)this.a.b.a.findViewById(2130903076)).setImageResource(2130837533);
    }
  }
  
  public class c implements View.OnTouchListener {
    private final GestureDetector a = new GestureDetector((GestureDetector.OnGestureListener)new a(null));
    
    private final ScaleGestureDetector b = new ScaleGestureDetector(RawActivity.a(this.c), (ScaleGestureDetector.OnScaleGestureListener)new b(null));
    
    public c(RawActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.b.onTouchEvent(param1MotionEvent);
      this.a.onTouchEvent(param1MotionEvent);
      return false;
    }
    
    private final class a extends GestureDetector.SimpleOnGestureListener {
      private a(RawActivity.c this$0) {}
      
      public void a() {
        b.B.setCurrentTab(2);
      }
      
      public void b() {
        b.B.setCurrentTab(0);
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
    
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
      private b(RawActivity.c this$0) {}
      
      public boolean onScale(ScaleGestureDetector param2ScaleGestureDetector) {
        float f = param2ScaleGestureDetector.getScaleFactor();
        if (f < 1.0F) {
          RawActivity rawActivity = this.a.c;
          int i = rawActivity.d + 1;
          rawActivity.d = i;
          if (i > 10) {
            b.q--;
            rawActivity.a.invalidateViews();
            b.E.invalidate();
            this.a.c.d = 0;
          } 
        } 
        if (f > 1.0F) {
          RawActivity rawActivity = this.a.c;
          int i = rawActivity.d + 1;
          rawActivity.d = i;
          if (i > 10) {
            b.q++;
            rawActivity.a.invalidateViews();
            b.E.invalidate();
            this.a.c.d = 0;
          } 
        } 
        return false;
      }
    }
  }
  
  private final class a extends GestureDetector.SimpleOnGestureListener {
    private a(RawActivity this$0) {}
    
    public void a() {
      b.B.setCurrentTab(2);
    }
    
    public void b() {
      b.B.setCurrentTab(0);
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
  
  private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private b(RawActivity this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f = param1ScaleGestureDetector.getScaleFactor();
      if (f < 1.0F) {
        RawActivity rawActivity = this.a.c;
        int i = rawActivity.d + 1;
        rawActivity.d = i;
        if (i > 10) {
          b.q--;
          rawActivity.a.invalidateViews();
          b.E.invalidate();
          this.a.c.d = 0;
        } 
      } 
      if (f > 1.0F) {
        RawActivity rawActivity = this.a.c;
        int i = rawActivity.d + 1;
        rawActivity.d = i;
        if (i > 10) {
          b.q++;
          rawActivity.a.invalidateViews();
          b.E.invalidate();
          this.a.c.d = 0;
        } 
      } 
      return false;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\RawActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */