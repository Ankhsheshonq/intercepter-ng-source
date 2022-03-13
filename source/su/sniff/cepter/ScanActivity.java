package su.sniff.cepter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanActivity extends Activity {
  public ListView a;
  
  public String b;
  
  public String c;
  
  private String d = "";
  
  String e = "";
  
  private Context f;
  
  int g;
  
  ScaleGestureDetector h;
  
  ArrayAdapter<String> i;
  
  private boolean[] j;
  
  int k = 0;
  
  ArrayList<String> l;
  
  int m = 0;
  
  public static Integer a(String paramString) {
    if (paramString == null)
      return null; 
    int j = 0;
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, ".");
    for (int i = 3; i >= 0; i--)
      j |= Integer.parseInt(stringTokenizer.nextToken()) << i * 8; 
    return new Integer(j);
  }
  
  public void OnCage(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    if (this.a.getCount() > 0) {
      int k = this.a.getCount();
      FileOutputStream fileOutputStream = openFileOutput("cage", 0);
      String str = "";
      int i = 0;
      for (int j = 1; i < k; j = m) {
        String str1 = str;
        int m = j;
        if (this.j[i] == true) {
          m = this.a.getAdapter().getItem(i).toString().indexOf('[');
          int n = this.a.getAdapter().getItem(i).toString().indexOf(' ');
          int i1 = this.a.getAdapter().getItem(i).toString().indexOf("]");
          String str2 = this.a.getAdapter().getItem(i).toString().substring(m + 1, i1);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str);
          stringBuilder2.append(" -t");
          stringBuilder2.append(Integer.toString(j));
          stringBuilder2.append(" ");
          stringBuilder2.append(this.a.getAdapter().getItem(i).toString().substring(0, n));
          str1 = stringBuilder2.toString();
          m = j + 1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.a.getAdapter().getItem(i).toString().substring(0, n));
          stringBuilder1.append(":");
          stringBuilder1.append(str2);
          stringBuilder1.append("\n");
          fileOutputStream.write(stringBuilder1.toString().getBytes());
        } 
        i++;
        str = str1;
      } 
      fileOutputStream.close();
      if (str.equals("")) {
        Toast.makeText(getApplicationContext(), "Choose a target!", 0).show();
        return;
      } 
      a(1);
      startActivityForResult(new Intent(this.f, CageActivity.class), 1);
      return;
    } 
    Toast.makeText(getApplicationContext(), "Scan the network!", 0).show();
  }
  
  public void OnScanNext(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    if (this.a.getCount() > 0) {
      int k = this.a.getCount();
      FileOutputStream fileOutputStream = openFileOutput("targets", 0);
      String str2 = "";
      int i = 0;
      for (int j = 1; i < k; j = m) {
        String str = str2;
        int m = j;
        if (this.j[i] == true) {
          m = this.a.getAdapter().getItem(i).toString().indexOf('[');
          int n = this.a.getAdapter().getItem(i).toString().indexOf(' ');
          int i1 = this.a.getAdapter().getItem(i).toString().indexOf("]");
          String str3 = this.a.getAdapter().getItem(i).toString().substring(m + 1, i1);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(str2);
          stringBuilder2.append(" -t");
          stringBuilder2.append(Integer.toString(j));
          stringBuilder2.append(" ");
          stringBuilder2.append(this.a.getAdapter().getItem(i).toString().substring(0, n));
          str = stringBuilder2.toString();
          m = j + 1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.a.getAdapter().getItem(i).toString().substring(0, n));
          stringBuilder1.append(":");
          stringBuilder1.append(str3);
          stringBuilder1.append("\n");
          fileOutputStream.write(stringBuilder1.toString().getBytes());
        } 
        i++;
        str2 = str;
      } 
      fileOutputStream.close();
      if (str2.equals("")) {
        Toast.makeText(getApplicationContext(), "Choose a target!", 0).show();
        return;
      } 
      a(1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-gw ");
      stringBuilder.append(b.G);
      String str1 = stringBuilder.toString();
      Intent intent = new Intent(this.f, TabAct.class);
      intent.putExtra("Key_String", str1);
      intent.putExtra("Key_String_origin", this.c);
      startActivity(intent);
      finish();
      return;
    } 
    Toast.makeText(getApplicationContext(), "Scan the network!", 0).show();
  }
  
  public void OnSelectAll(View paramView) {
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    int j = this.a.getCount();
    int i = 0;
    if (j > 0) {
      int k = this.a.getCount();
      while (i < k) {
        boolean[] arrayOfBoolean = this.j;
        arrayOfBoolean[i] = arrayOfBoolean[i] ^ true;
        if (this.a.getChildAt(i) != null) {
          ImageView imageView = (ImageView)this.a.getChildAt(i).findViewById(2130903073);
          if (this.j[i]) {
            j = 2130837528;
          } else {
            j = 2130837535;
          } 
          imageView.setImageResource(j);
        } 
        i++;
      } 
    } else {
      Toast.makeText(getApplicationContext(), "Scan the network!", 0).show();
    } 
  }
  
  public void OnSkip(View paramView) {
    a(1);
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    Intent intent = new Intent(this.f, TabAct.class);
    intent.putExtra("Key_String", "");
    intent.putExtra("Key_String_origin", this.c);
    startActivity(intent);
    finish();
  }
  
  public void a() {
    this.l = new ArrayList<String>();
    this.a.setChoiceMode(2);
    k<String> k = new k<String>(this, (Context)this, 2130968587, 2130903081, this.l);
    this.a.setAdapter((ListAdapter)k);
    this.i = k;
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/su.sniff.cepter/files/cepter scan ");
    stringBuilder.append(b.a);
    stringBuilder.append(" ");
    stringBuilder.append(this.e);
    stringBuilder.append(" ");
    stringBuilder.append(b.G);
    stringBuilder.append(b.I);
    stringBuilder.append("\n");
    dataOutputStream.writeBytes(stringBuilder.toString());
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    (new Thread(new a(this, process, bufferedReader, k))).start();
  }
  
  public void a(int paramInt) {
    int i = this.a.getCount();
    boolean bool = false;
    if (i > 0 && paramInt == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("lasthosts.");
      stringBuilder.append(this.e);
      FileOutputStream fileOutputStream = openFileOutput(stringBuilder.toString(), 0);
      int j = this.a.getCount();
      for (i = 0; i < j; i++) {
        fileOutputStream.write(this.a.getAdapter().getItem(i).toString().getBytes());
        fileOutputStream.write("\n".getBytes());
      } 
      fileOutputStream.close();
    } 
    if (paramInt == 0) {
      this.l = new ArrayList<String>();
      this.a.setChoiceMode(2);
      k<String> k = new k<String>(this, (Context)this, 2130968587, 2130903081, this.l);
      this.a.setAdapter((ListAdapter)k);
      this.i = k;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("lasthosts.");
      stringBuilder.append(this.e);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(stringBuilder.toString())));
      paramInt = bool;
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          String str1 = bufferedReader.readLine();
          if (str != null && str1 != null) {
            ArrayList<String> arrayList = this.l;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str.toString());
            stringBuilder1.append("\n");
            stringBuilder1.append(str1.toString());
            arrayList.add(paramInt, stringBuilder1.toString());
            k.notifyDataSetChanged();
            paramInt++;
          } 
          continue;
        } 
        bufferedReader.close();
        break;
      } 
    } 
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
  
  public String b(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    paramInt >>>= 8;
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    paramInt >>>= 8;
    stringBuilder.append(paramInt & 0xFF);
    stringBuilder.append(".");
    stringBuilder.append(paramInt >>> 8 & 0xFF);
    return stringBuilder.toString();
  }
  
  public void b() {
    if (b.z == 1) {
      b.z = 0;
      Process process = Runtime.getRuntime().exec("su");
      DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
      dataOutputStream.writeBytes("ip route flush all\n");
      dataOutputStream.flush();
      dataOutputStream.writeBytes("ip rule flush\n");
      dataOutputStream.flush();
      dataOutputStream.writeBytes("ip rule del 0\n");
      dataOutputStream.flush();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ip rule restore < ");
      stringBuilder.append(getFilesDir().getAbsolutePath());
      stringBuilder.append("/iprulebackup\n");
      dataOutputStream.writeBytes(stringBuilder.toString());
      dataOutputStream.flush();
      stringBuilder = new StringBuilder();
      stringBuilder.append("ip route restore < ");
      stringBuilder.append(getFilesDir().getAbsolutePath());
      stringBuilder.append("/iproutebackup\n");
      dataOutputStream.writeBytes(stringBuilder.toString());
      dataOutputStream.flush();
      dataOutputStream.writeBytes("exit\n");
      dataOutputStream.flush();
      dataOutputStream.close();
      try {
        process.waitFor();
        return;
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130968596);
    getWindow().setFeatureDrawableResource(3, 2130837514);
    this.f = (Context)this;
    boolean[] arrayOfBoolean = new boolean[2048];
    this.j = arrayOfBoolean;
    Arrays.fill(arrayOfBoolean, false);
    a.a.a.a.a.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
    this.h = new ScaleGestureDetector((Context)this, (ScaleGestureDetector.OnScaleGestureListener)new l(this));
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("settings"));
      String str = (new BufferedReader(inputStreamReader)).readLine();
      inputStreamReader.close();
      b.q = Integer.parseInt(str);
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    String str2 = getIntent().getExtras().getString("Key_String");
    this.b = str2;
    this.c = str2;
    TextView textView = (TextView)findViewById(2130903043);
    textView.setTextSize(12.0F);
    WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService("wifi");
    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
    DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
    b.G = b(dhcpInfo.gateway);
    String str3 = "";
    String str1 = str3;
    try {
      BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/proc/net/arp"));
      while (true) {
        str1 = str3;
        String str = bufferedReader1.readLine();
        if (str != null) {
          str1 = str3;
          String str4 = str.substring(0, str.indexOf(" "));
          str1 = str3;
          Matcher matcher = Pattern.compile(String.format("^%s\\s+0x1\\s+0x2\\s+([:0-9a-fA-F]+)\\s+\\*\\s+\\w+$", new Object[] { str4.replace(".", "\\.") })).matcher(str);
          str1 = str3;
          if (matcher.matches()) {
            str1 = str3;
            String str5 = matcher.group(1);
            str1 = str3;
            if (str4.equals(b(dhcpInfo.gateway))) {
              str1 = str3;
              this.e = str5;
              break;
            } 
          } 
          continue;
        } 
        break;
      } 
      str1 = str3;
      bufferedReader1.close();
      str1 = str3;
      Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
      str1 = str3;
      DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
      str1 = str3;
      BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
      str1 = str3;
      StringBuilder stringBuilder = new StringBuilder();
      str1 = str3;
      stringBuilder.append("/data/data/su.sniff.cepter/files/cepter getv ");
      str1 = str3;
      stringBuilder.append(this.e);
      str1 = str3;
      stringBuilder.append("\n");
      str1 = str3;
      dataOutputStream.writeBytes(stringBuilder.toString());
      str1 = str3;
      dataOutputStream.writeBytes("exit\n");
      str1 = str3;
      dataOutputStream.flush();
      str1 = str3;
      dataOutputStream.close();
      str1 = str3;
      str3 = bufferedReader2.readLine();
      str1 = str3;
      bufferedReader2.close();
      str1 = str3;
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    if (this.b.indexOf("WiFi") == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append("\nWiFi: ");
      stringBuilder.append(wifiInfo.getSSID());
      stringBuilder.append(", GW: ");
      stringBuilder.append(b(dhcpInfo.gateway));
      stringBuilder.append("/");
      stringBuilder.append(b.H);
      stringBuilder.append("\nVendor: ");
      stringBuilder.append(str1);
      this.b = stringBuilder.toString();
    } 
    textView.setText(this.b);
    try {
      int i = Integer.bitCount(a(b.H).intValue());
      this.g = i;
      if (i < 24)
        runOnUiThread(new b(this)); 
      if (this.g < 14)
        this.g = 14; 
      if (this.g == 24) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.F);
        stringBuilder.append("/");
        stringBuilder.append(this.g);
        c c = new c(stringBuilder.toString());
        List<String> list = c.a(c.a());
        ExecutorService executorService = Executors.newCachedThreadPool();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
          executorService.submit(new c(this, iterator.next()));
          SystemClock.sleep(1L);
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    ListView listView = (ListView)findViewById(2130903082);
    this.a = listView;
    listView.setOnTouchListener(new d(this));
    this.a.setOnItemClickListener(new e(this));
    this.a.setOnItemLongClickListener(new f(this));
    try {
      a(0);
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    // Byte code:
    //   0: iload_1
    //   1: iconst_4
    //   2: if_icmpne -> 268
    //   5: aload_0
    //   6: ldc_w 'exits.id'
    //   9: iconst_0
    //   10: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   13: invokevirtual close : ()V
    //   16: aload_0
    //   17: ldc_w 'exitr.id'
    //   20: iconst_0
    //   21: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: invokevirtual close : ()V
    //   27: aload_0
    //   28: invokevirtual b : ()V
    //   31: aload_0
    //   32: ldc_w 'iptables -F;iptables -X;iptables -t nat -F;iptables -t nat -X;iptables -t mangle -F;iptables -t mangle -X;iptables -P INPUT ACCEPT;iptables -P FORWARD ACCEPT;iptables -P OUTPUT ACCEPT\\n'
    //   35: ldc ''
    //   37: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   40: pop
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc_w 'iptables-restore < '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_0
    //   59: invokevirtual getFilesDir : ()Ljava/io/File;
    //   62: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: ldc_w '/iptablesbackup\\n'
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: ldc ''
    //   84: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   87: pop
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore_3
    //   96: aload_3
    //   97: ldc_w 'rm  '
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: aload_0
    //   106: invokevirtual getFilesDir : ()Ljava/io/File;
    //   109: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w '/*backup\\n'
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: aload_3
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: ldc ''
    //   131: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   134: pop
    //   135: getstatic su/sniff/cepter/b.D : Lb/a/k/b;
    //   138: ifnull -> 171
    //   141: getstatic su/sniff/cepter/b.D : Lb/a/k/b;
    //   144: invokevirtual c : ()V
    //   147: goto -> 171
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual printStackTrace : ()V
    //   155: goto -> 171
    //   158: astore_3
    //   159: aload_3
    //   160: invokevirtual printStackTrace : ()V
    //   163: goto -> 171
    //   166: astore_3
    //   167: aload_3
    //   168: invokevirtual printStackTrace : ()V
    //   171: new java/io/DataOutputStream
    //   174: dup
    //   175: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   178: ldc_w 'su'
    //   181: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   184: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   187: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   190: astore_3
    //   191: aload_3
    //   192: ldc_w 'killall cepter\\n'
    //   195: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   198: aload_3
    //   199: invokevirtual flush : ()V
    //   202: aload_3
    //   203: ldc_w 'killall cepter\\n'
    //   206: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   209: aload_3
    //   210: invokevirtual flush : ()V
    //   213: aload_3
    //   214: ldc_w 'killall cepter\\n'
    //   217: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   220: aload_3
    //   221: invokevirtual flush : ()V
    //   224: aload_3
    //   225: invokevirtual close : ()V
    //   228: new java/io/File
    //   231: dup
    //   232: ldc_w '/data/data/su.sniff.cepter/files/inj'
    //   235: invokespecial <init> : (Ljava/lang/String;)V
    //   238: astore_3
    //   239: aload_3
    //   240: invokevirtual exists : ()Z
    //   243: ifeq -> 251
    //   246: aload_3
    //   247: invokevirtual delete : ()Z
    //   250: pop
    //   251: aload_0
    //   252: iconst_1
    //   253: invokevirtual a : (I)V
    //   256: iconst_0
    //   257: invokestatic exit : (I)V
    //   260: goto -> 268
    //   263: astore_3
    //   264: aload_3
    //   265: invokevirtual printStackTrace : ()V
    //   268: aload_0
    //   269: iload_1
    //   270: aload_2
    //   271: invokespecial onKeyDown : (ILandroid/view/KeyEvent;)Z
    //   274: ireturn
    // Exception table:
    //   from	to	target	type
    //   5	147	166	java/io/FileNotFoundException
    //   5	147	158	java/io/IOException
    //   5	147	150	java/lang/InterruptedException
    //   151	155	263	java/io/IOException
    //   159	163	263	java/io/IOException
    //   167	171	263	java/io/IOException
    //   171	251	263	java/io/IOException
    //   251	260	263	java/io/IOException
  }
  
  public void onScanNet(View paramView) {
    this.l = new ArrayList<String>();
    this.a.setChoiceMode(2);
    k<String> k = new k<String>(this, (Context)this, 2130968587, 2130903081, this.l);
    this.a.setAdapter((ListAdapter)k);
    this.i = k;
    ((ImageView)findViewById(2130903075)).setImageResource(2130837527);
    ExecutorService executorService = Executors.newCachedThreadPool();
    ((Vibrator)getSystemService("vibrator")).vibrate(50L);
    int i = 0;
    this.k = 0;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(b.F);
    stringBuilder2.append("/");
    stringBuilder2.append(this.g);
    c c = new c(stringBuilder2.toString());
    Integer integer = c.a();
    List<String> list = c.a(integer);
    int j = list.size();
    Context context2 = getApplicationContext();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Scanning subnet (");
    stringBuilder3.append(j);
    stringBuilder3.append("  hosts), please wait...");
    Toast.makeText(context2, stringBuilder3.toString(), 1).show();
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      executorService.submit(new g(this, iterator.next()));
      SystemClock.sleep(1L);
    } 
    if (integer.intValue() < 300) {
      Iterator<String> iterator1 = list.iterator();
      while (iterator1.hasNext())
        executorService.submit(new h(this, iterator1.next())); 
    } 
    ProgressBar progressBar = (ProgressBar)findViewById(2130903090);
    progressBar.setProgress(0);
    progressBar.setMax(5000);
    ImageView imageView = (ImageView)findViewById(2130903075);
    imageView.setEnabled(false);
    (new Thread(new i(this, progressBar, imageView))).start();
    FileOutputStream fileOutputStream = openFileOutput("hostlist", 0);
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
      i = 0;
      while (true) {
        j = i;
        try {
          String str = bufferedReader.readLine();
          if (str != null) {
            j = i;
            String str1 = str.substring(0, str.indexOf(" "));
            j = i;
            Matcher matcher = Pattern.compile(String.format("^%s\\s+0x1\\s+0x2\\s+([:0-9a-fA-F]+)\\s+\\*\\s+\\w+$", new Object[] { str1.replace(".", "\\.") })).matcher(str);
            j = i;
            if (matcher.matches()) {
              j = i;
              String str2 = matcher.group(1);
              j = i;
              stringBuilder3 = new StringBuilder();
              j = i;
              stringBuilder3.append(str1);
              j = i;
              stringBuilder3.append(":");
              j = i;
              stringBuilder3.append(str2);
              j = i;
              stringBuilder3.append("\n");
              j = i;
              fileOutputStream.write(stringBuilder3.toString().getBytes());
              j = ++i;
              runOnUiThread(new j(this));
            } 
            continue;
          } 
          j = i;
          bufferedReader.close();
          j = i;
          fileOutputStream.close();
        } catch (IOException iOException) {
          i = j;
          // Byte code: goto -> 619
        } 
        break;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    a();
    Context context1 = getApplicationContext();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Found ");
    stringBuilder1.append(i);
    stringBuilder1.append(" hosts. Performing smart scanning...");
    Toast.makeText(context1, stringBuilder1.toString(), 1).show();
  }
  
  class a implements Runnable {
    a(ScanActivity this$0, Process param1Process, BufferedReader param1BufferedReader, ArrayAdapter param1ArrayAdapter) {}
    
    public void run() {
      try {
        new InputStreamReader(this.a.getInputStream());
        int i = 0;
        while (true) {
          String str = this.b.readLine();
          if (str != null) {
            str.indexOf(';');
            int j = str.indexOf(' ');
            str.length();
            if (j <= 0)
              continue; 
            str = str.replace(": ", "\n").replace(";", ":");
            this.d.runOnUiThread(new a(this, i, str));
            i++;
            continue;
          } 
          this.b.close();
          this.a.waitFor();
          this.d.k = 1;
          return;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
        return;
      } 
    }
    
    class a implements Runnable {
      a(ScanActivity.a this$0, int param2Int, String param2String) {}
      
      public void run() {
        this.c.d.l.add(this.a, this.b);
        this.c.c.sort(new a(this));
        this.c.c.notifyDataSetChanged();
      }
      
      class a implements Comparator {
        a(ScanActivity.a.a this$0) {}
        
        public int compare(Object param3Object1, Object param3Object2) {
          param3Object1 = param3Object1;
          param3Object2 = param3Object2;
          int i = param3Object1.indexOf(' ');
          int j = param3Object2.indexOf(' ');
          param3Object1 = param3Object1.substring(0, i);
          param3Object2 = param3Object2.substring(0, j);
          param3Object1 = param3Object1.substring(param3Object1.lastIndexOf(".") + 1, param3Object1.length());
          param3Object2 = param3Object2.substring(param3Object2.lastIndexOf(".") + 1, param3Object2.length());
          if (param3Object1.length() != 0) {
            if (param3Object2.length() == 0)
              return 0; 
            try {
              if (Integer.parseInt((String)param3Object1) == Integer.parseInt((String)param3Object2))
                return 0; 
              i = Integer.parseInt((String)param3Object1);
              j = Integer.parseInt((String)param3Object2);
              return (i > j) ? 1 : -1;
            } catch (NumberFormatException numberFormatException) {
              return -1;
            } 
          } 
          return 0;
        }
      }
    }
    
    class a implements Comparator {
      a(ScanActivity.a this$0) {}
      
      public int compare(Object param2Object1, Object param2Object2) {
        param2Object1 = param2Object1;
        param2Object2 = param2Object2;
        int i = param2Object1.indexOf(' ');
        int j = param2Object2.indexOf(' ');
        param2Object1 = param2Object1.substring(0, i);
        param2Object2 = param2Object2.substring(0, j);
        param2Object1 = param2Object1.substring(param2Object1.lastIndexOf(".") + 1, param2Object1.length());
        param2Object2 = param2Object2.substring(param2Object2.lastIndexOf(".") + 1, param2Object2.length());
        if (param2Object1.length() != 0) {
          if (param2Object2.length() == 0)
            return 0; 
          try {
            if (Integer.parseInt((String)param2Object1) == Integer.parseInt((String)param2Object2))
              return 0; 
            i = Integer.parseInt((String)param2Object1);
            j = Integer.parseInt((String)param2Object2);
            return (i > j) ? 1 : -1;
          } catch (NumberFormatException numberFormatException) {
            return -1;
          } 
        } 
        return 0;
      }
    }
  }
  
  class a implements Runnable {
    a(ScanActivity this$0, int param1Int, String param1String) {}
    
    public void run() {
      this.c.d.l.add(this.a, this.b);
      this.c.c.sort(new a(this));
      this.c.c.notifyDataSetChanged();
    }
    
    class a implements Comparator {
      a(ScanActivity.a.a this$0) {}
      
      public int compare(Object param3Object1, Object param3Object2) {
        param3Object1 = param3Object1;
        param3Object2 = param3Object2;
        int i = param3Object1.indexOf(' ');
        int j = param3Object2.indexOf(' ');
        param3Object1 = param3Object1.substring(0, i);
        param3Object2 = param3Object2.substring(0, j);
        param3Object1 = param3Object1.substring(param3Object1.lastIndexOf(".") + 1, param3Object1.length());
        param3Object2 = param3Object2.substring(param3Object2.lastIndexOf(".") + 1, param3Object2.length());
        if (param3Object1.length() != 0) {
          if (param3Object2.length() == 0)
            return 0; 
          try {
            if (Integer.parseInt((String)param3Object1) == Integer.parseInt((String)param3Object2))
              return 0; 
            i = Integer.parseInt((String)param3Object1);
            j = Integer.parseInt((String)param3Object2);
            return (i > j) ? 1 : -1;
          } catch (NumberFormatException numberFormatException) {
            return -1;
          } 
        } 
        return 0;
      }
    }
  }
  
  class a implements Comparator {
    a(ScanActivity this$0) {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      param1Object2 = param1Object2;
      int i = param1Object1.indexOf(' ');
      int j = param1Object2.indexOf(' ');
      param1Object1 = param1Object1.substring(0, i);
      param1Object2 = param1Object2.substring(0, j);
      param1Object1 = param1Object1.substring(param1Object1.lastIndexOf(".") + 1, param1Object1.length());
      param1Object2 = param1Object2.substring(param1Object2.lastIndexOf(".") + 1, param1Object2.length());
      if (param1Object1.length() != 0) {
        if (param1Object2.length() == 0)
          return 0; 
        try {
          if (Integer.parseInt((String)param1Object1) == Integer.parseInt((String)param1Object2))
            return 0; 
          i = Integer.parseInt((String)param1Object1);
          j = Integer.parseInt((String)param1Object2);
          return (i > j) ? 1 : -1;
        } catch (NumberFormatException numberFormatException) {
          return -1;
        } 
      } 
      return 0;
    }
  }
  
  class b implements Runnable {
    b(ScanActivity this$0) {}
    
    public void run() {
      Toast.makeText(this.a.getApplicationContext(), "Due to netmask the scanning might take a while, be patient", 1).show();
    }
  }
  
  class c implements Runnable {
    c(ScanActivity this$0, String param1String) {}
    
    public void run() {
      try {
        InetAddress.getByName(this.a).isReachable(1);
        return;
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
  
  class d implements View.OnTouchListener {
    d(ScanActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.h.onTouchEvent(param1MotionEvent);
      return false;
    }
  }
  
  class e implements AdapterView.OnItemClickListener {
    e(ScanActivity this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      ScanActivity.a(this.a)[param1Int] = ScanActivity.a(this.a)[param1Int] ^ true;
      ImageView imageView = (ImageView)param1View.findViewById(2130903073);
      int i = 2130837528;
      imageView.setImageResource(2130837528);
      if (ScanActivity.a(this.a)[param1Int]) {
        param1Int = i;
      } else {
        param1Int = 2130837535;
      } 
      imageView.setImageResource(param1Int);
    }
  }
  
  class f implements AdapterView.OnItemLongClickListener {
    f(ScanActivity this$0) {}
    
    public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      // Byte code:
      //   0: new android/app/AlertDialog$Builder
      //   3: dup
      //   4: aload_0
      //   5: getfield a : Lsu/sniff/cepter/ScanActivity;
      //   8: invokestatic b : (Lsu/sniff/cepter/ScanActivity;)Landroid/content/Context;
      //   11: invokespecial <init> : (Landroid/content/Context;)V
      //   14: astore #8
      //   16: aload_1
      //   17: iload_3
      //   18: invokevirtual getItemAtPosition : (I)Ljava/lang/Object;
      //   21: invokevirtual toString : ()Ljava/lang/String;
      //   24: astore #9
      //   26: aload #8
      //   28: ldc 'Select Action'
      //   30: invokevirtual setTitle : (Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;
      //   33: pop
      //   34: aload #8
      //   36: ldc 'X-Scan'
      //   38: new su/sniff/cepter/ScanActivity$f$a
      //   41: dup
      //   42: aload_0
      //   43: aload #9
      //   45: invokespecial <init> : (Lsu/sniff/cepter/ScanActivity$f;Ljava/lang/String;)V
      //   48: invokevirtual setPositiveButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
      //   51: pop
      //   52: aload #9
      //   54: aload #9
      //   56: bipush #91
      //   58: invokevirtual indexOf : (I)I
      //   61: iconst_1
      //   62: iadd
      //   63: aload #9
      //   65: ldc ']'
      //   67: invokevirtual indexOf : (Ljava/lang/String;)I
      //   70: invokevirtual substring : (II)Ljava/lang/String;
      //   73: astore #10
      //   75: ldc ''
      //   77: astore_1
      //   78: aload_1
      //   79: astore #6
      //   81: aload_1
      //   82: astore #7
      //   84: new java/io/BufferedReader
      //   87: dup
      //   88: new java/io/InputStreamReader
      //   91: dup
      //   92: aload_0
      //   93: getfield a : Lsu/sniff/cepter/ScanActivity;
      //   96: ldc 'aliases'
      //   98: invokevirtual openFileInput : (Ljava/lang/String;)Ljava/io/FileInputStream;
      //   101: invokespecial <init> : (Ljava/io/InputStream;)V
      //   104: invokespecial <init> : (Ljava/io/Reader;)V
      //   107: astore #11
      //   109: aload_1
      //   110: astore #6
      //   112: aload_1
      //   113: astore #7
      //   115: aload #11
      //   117: invokevirtual readLine : ()Ljava/lang/String;
      //   120: astore #12
      //   122: aload #12
      //   124: ifnull -> 168
      //   127: aload_1
      //   128: astore #6
      //   130: aload_1
      //   131: astore #7
      //   133: aload #12
      //   135: aload #10
      //   137: invokevirtual indexOf : (Ljava/lang/String;)I
      //   140: iconst_m1
      //   141: if_icmpeq -> 109
      //   144: aload_1
      //   145: astore #6
      //   147: aload_1
      //   148: astore #7
      //   150: aload #12
      //   152: aload #12
      //   154: ldc ':'
      //   156: invokevirtual indexOf : (Ljava/lang/String;)I
      //   159: iconst_1
      //   160: iadd
      //   161: invokevirtual substring : (I)Ljava/lang/String;
      //   164: astore_1
      //   165: goto -> 109
      //   168: aload_1
      //   169: astore #6
      //   171: aload_1
      //   172: astore #7
      //   174: aload #11
      //   176: invokevirtual close : ()V
      //   179: goto -> 201
      //   182: astore_1
      //   183: aload_1
      //   184: invokevirtual printStackTrace : ()V
      //   187: aload #6
      //   189: astore_1
      //   190: goto -> 201
      //   193: astore_1
      //   194: aload_1
      //   195: invokevirtual printStackTrace : ()V
      //   198: aload #7
      //   200: astore_1
      //   201: aload_1
      //   202: invokevirtual length : ()I
      //   205: ifle -> 229
      //   208: aload #8
      //   210: ldc 'Remove Alias'
      //   212: new su/sniff/cepter/ScanActivity$f$b
      //   215: dup
      //   216: aload_0
      //   217: aload #10
      //   219: invokespecial <init> : (Lsu/sniff/cepter/ScanActivity$f;Ljava/lang/String;)V
      //   222: invokevirtual setNeutralButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
      //   225: pop
      //   226: goto -> 248
      //   229: aload #8
      //   231: ldc 'Set Alias'
      //   233: new su/sniff/cepter/ScanActivity$f$c
      //   236: dup
      //   237: aload_0
      //   238: aload_2
      //   239: aload #9
      //   241: invokespecial <init> : (Lsu/sniff/cepter/ScanActivity$f;Landroid/view/View;Ljava/lang/String;)V
      //   244: invokevirtual setNeutralButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
      //   247: pop
      //   248: aload #8
      //   250: ldc 'Cancel'
      //   252: new su/sniff/cepter/ScanActivity$f$d
      //   255: dup
      //   256: aload_0
      //   257: invokespecial <init> : (Lsu/sniff/cepter/ScanActivity$f;)V
      //   260: invokevirtual setNegativeButton : (Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
      //   263: pop
      //   264: aload #8
      //   266: invokevirtual create : ()Landroid/app/AlertDialog;
      //   269: invokevirtual show : ()V
      //   272: iconst_1
      //   273: ireturn
      // Exception table:
      //   from	to	target	type
      //   84	109	193	java/io/FileNotFoundException
      //   84	109	182	java/io/IOException
      //   115	122	193	java/io/FileNotFoundException
      //   115	122	182	java/io/IOException
      //   133	144	193	java/io/FileNotFoundException
      //   133	144	182	java/io/IOException
      //   150	165	193	java/io/FileNotFoundException
      //   150	165	182	java/io/IOException
      //   174	179	193	java/io/FileNotFoundException
      //   174	179	182	java/io/IOException
    }
    
    class a implements DialogInterface.OnClickListener {
      a(ScanActivity.f this$0, String param2String) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        param2Int = this.a.indexOf('[');
        int i = this.a.indexOf("]");
        String str = this.a.substring(param2Int + 1, i);
        param2Int = this.a.indexOf(" ");
        if (param2Int > 0) {
          String str1 = this.a.substring(0, param2Int);
          try {
            Intent intent = new Intent(ScanActivity.b(this.b.a), PortScan.class);
            intent.putExtra("Key_Int", str1);
            intent.putExtra("Key_String", str);
            this.b.a.startActivityForResult(intent, 1);
            b.o = 0;
          } catch (NumberFormatException numberFormatException) {}
        } 
        param2DialogInterface.dismiss();
      }
    }
    
    class b implements DialogInterface.OnClickListener {
      b(ScanActivity.f this$0, String param2String) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        try {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.a.openFileInput("aliases")));
          FileOutputStream fileOutputStream = this.b.a.openFileOutput("aliases2", 0);
          String str = this.a;
          while (true) {
            String str1 = bufferedReader.readLine();
            if (str1 != null) {
              if (str1.trim().indexOf(str) != -1)
                continue; 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str1);
              stringBuilder.append("\n");
              fileOutputStream.write(stringBuilder.toString().getBytes());
              continue;
            } 
            fileOutputStream.close();
            bufferedReader.close();
            FileInputStream fileInputStream = this.b.a.openFileInput("aliases2");
            fileOutputStream = this.b.a.openFileOutput("aliases", 0);
            byte[] arrayOfByte = new byte[1024];
            while (true) {
              param2Int = fileInputStream.read(arrayOfByte);
              if (param2Int > 0) {
                fileOutputStream.write(arrayOfByte, 0, param2Int);
                continue;
              } 
              fileInputStream.close();
              fileOutputStream.close();
              (new File(this.b.a.getFilesDir(), "aliases2")).delete();
              this.b.a.i.notifyDataSetChanged();
              param2DialogInterface.dismiss();
              return;
            } 
            break;
          } 
        } catch (FileNotFoundException fileNotFoundException) {
          fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
        param2DialogInterface.dismiss();
      }
    }
    
    class c implements DialogInterface.OnClickListener {
      c(ScanActivity.f this$0, View param2View, String param2String) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.b(this.c.a));
        builder.setTitle("Set Alias");
        EditText editText = new EditText(ScanActivity.b(this.c.a));
        editText.setInputType(1);
        builder.setView((View)editText);
        builder.setPositiveButton("Set", new a(this, editText));
        builder.setNegativeButton("Cancel", new b(this));
        builder.show();
        param2DialogInterface.dismiss();
      }
      
      class a implements DialogInterface.OnClickListener {
        a(ScanActivity.f.c this$0, EditText param3EditText) {}
        
        public void onClick(DialogInterface param3DialogInterface, int param3Int) {
          ScanActivity.a(this.b.c.a, this.a.getText().toString());
          TextView textView = (TextView)this.b.a.findViewById(2130903081);
          String str2 = this.b.b;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("(");
          stringBuilder2.append(ScanActivity.c(this.b.c.a));
          stringBuilder2.append(")");
          textView.setText(str2.replaceAll("\\((.*?)\\)", stringBuilder2.toString()));
          this.b.c.a.i.notifyDataSetChanged();
          param3Int = this.b.b.indexOf('[');
          int i = this.b.b.indexOf("]");
          String str1 = this.b.b.substring(param3Int + 1, i);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str1);
          stringBuilder1.append(":");
          stringBuilder1.append(ScanActivity.c(this.b.c.a));
          stringBuilder1.append("\n");
          str1 = stringBuilder1.toString();
          try {
            FileOutputStream fileOutputStream = this.b.c.a.openFileOutput("aliases", 32768);
            fileOutputStream.write(str1.getBytes());
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
      }
      
      class b implements DialogInterface.OnClickListener {
        b(ScanActivity.f.c this$0) {}
        
        public void onClick(DialogInterface param3DialogInterface, int param3Int) {
          param3DialogInterface.cancel();
        }
      }
    }
    
    class a implements DialogInterface.OnClickListener {
      a(ScanActivity.f this$0, EditText param2EditText) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        ScanActivity.a(this.b.c.a, this.a.getText().toString());
        TextView textView = (TextView)this.b.a.findViewById(2130903081);
        String str2 = this.b.b;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("(");
        stringBuilder2.append(ScanActivity.c(this.b.c.a));
        stringBuilder2.append(")");
        textView.setText(str2.replaceAll("\\((.*?)\\)", stringBuilder2.toString()));
        this.b.c.a.i.notifyDataSetChanged();
        param2Int = this.b.b.indexOf('[');
        int i = this.b.b.indexOf("]");
        String str1 = this.b.b.substring(param2Int + 1, i);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(":");
        stringBuilder1.append(ScanActivity.c(this.b.c.a));
        stringBuilder1.append("\n");
        str1 = stringBuilder1.toString();
        try {
          FileOutputStream fileOutputStream = this.b.c.a.openFileOutput("aliases", 32768);
          fileOutputStream.write(str1.getBytes());
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
    }
    
    class b implements DialogInterface.OnClickListener {
      b(ScanActivity.f this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        param2DialogInterface.cancel();
      }
    }
    
    class d implements DialogInterface.OnClickListener {
      d(ScanActivity.f this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        param2DialogInterface.dismiss();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(ScanActivity this$0, String param1String) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1Int = this.a.indexOf('[');
      int i = this.a.indexOf("]");
      String str = this.a.substring(param1Int + 1, i);
      param1Int = this.a.indexOf(" ");
      if (param1Int > 0) {
        String str1 = this.a.substring(0, param1Int);
        try {
          Intent intent = new Intent(ScanActivity.b(this.b.a), PortScan.class);
          intent.putExtra("Key_Int", str1);
          intent.putExtra("Key_String", str);
          this.b.a.startActivityForResult(intent, 1);
          b.o = 0;
        } catch (NumberFormatException numberFormatException) {}
      } 
      param1DialogInterface.dismiss();
    }
  }
  
  class b implements DialogInterface.OnClickListener {
    b(ScanActivity this$0, String param1String) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.a.openFileInput("aliases")));
        FileOutputStream fileOutputStream = this.b.a.openFileOutput("aliases2", 0);
        String str = this.a;
        while (true) {
          String str1 = bufferedReader.readLine();
          if (str1 != null) {
            if (str1.trim().indexOf(str) != -1)
              continue; 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append("\n");
            fileOutputStream.write(stringBuilder.toString().getBytes());
            continue;
          } 
          fileOutputStream.close();
          bufferedReader.close();
          FileInputStream fileInputStream = this.b.a.openFileInput("aliases2");
          fileOutputStream = this.b.a.openFileOutput("aliases", 0);
          byte[] arrayOfByte = new byte[1024];
          while (true) {
            param1Int = fileInputStream.read(arrayOfByte);
            if (param1Int > 0) {
              fileOutputStream.write(arrayOfByte, 0, param1Int);
              continue;
            } 
            fileInputStream.close();
            fileOutputStream.close();
            (new File(this.b.a.getFilesDir(), "aliases2")).delete();
            this.b.a.i.notifyDataSetChanged();
            param1DialogInterface.dismiss();
            return;
          } 
          break;
        } 
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      param1DialogInterface.dismiss();
    }
  }
  
  class c implements DialogInterface.OnClickListener {
    c(ScanActivity this$0, View param1View, String param1String) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.b(this.c.a));
      builder.setTitle("Set Alias");
      EditText editText = new EditText(ScanActivity.b(this.c.a));
      editText.setInputType(1);
      builder.setView((View)editText);
      builder.setPositiveButton("Set", new a(this, editText));
      builder.setNegativeButton("Cancel", new b(this));
      builder.show();
      param1DialogInterface.dismiss();
    }
    
    class a implements DialogInterface.OnClickListener {
      a(ScanActivity.f.c this$0, EditText param3EditText) {}
      
      public void onClick(DialogInterface param3DialogInterface, int param3Int) {
        ScanActivity.a(this.b.c.a, this.a.getText().toString());
        TextView textView = (TextView)this.b.a.findViewById(2130903081);
        String str2 = this.b.b;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("(");
        stringBuilder2.append(ScanActivity.c(this.b.c.a));
        stringBuilder2.append(")");
        textView.setText(str2.replaceAll("\\((.*?)\\)", stringBuilder2.toString()));
        this.b.c.a.i.notifyDataSetChanged();
        param3Int = this.b.b.indexOf('[');
        int i = this.b.b.indexOf("]");
        String str1 = this.b.b.substring(param3Int + 1, i);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(":");
        stringBuilder1.append(ScanActivity.c(this.b.c.a));
        stringBuilder1.append("\n");
        str1 = stringBuilder1.toString();
        try {
          FileOutputStream fileOutputStream = this.b.c.a.openFileOutput("aliases", 32768);
          fileOutputStream.write(str1.getBytes());
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
    }
    
    class b implements DialogInterface.OnClickListener {
      b(ScanActivity.f.c this$0) {}
      
      public void onClick(DialogInterface param3DialogInterface, int param3Int) {
        param3DialogInterface.cancel();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(ScanActivity this$0, EditText param1EditText) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      ScanActivity.a(this.b.c.a, this.a.getText().toString());
      TextView textView = (TextView)this.b.a.findViewById(2130903081);
      String str2 = this.b.b;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("(");
      stringBuilder2.append(ScanActivity.c(this.b.c.a));
      stringBuilder2.append(")");
      textView.setText(str2.replaceAll("\\((.*?)\\)", stringBuilder2.toString()));
      this.b.c.a.i.notifyDataSetChanged();
      param1Int = this.b.b.indexOf('[');
      int i = this.b.b.indexOf("]");
      String str1 = this.b.b.substring(param1Int + 1, i);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(":");
      stringBuilder1.append(ScanActivity.c(this.b.c.a));
      stringBuilder1.append("\n");
      str1 = stringBuilder1.toString();
      try {
        FileOutputStream fileOutputStream = this.b.c.a.openFileOutput("aliases", 32768);
        fileOutputStream.write(str1.getBytes());
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
  }
  
  class b implements DialogInterface.OnClickListener {
    b(ScanActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.cancel();
    }
  }
  
  class d implements DialogInterface.OnClickListener {
    d(ScanActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      param1DialogInterface.dismiss();
    }
  }
  
  class g implements Runnable {
    g(ScanActivity this$0, String param1String) {}
    
    public void run() {
      try {
        InetAddress.getByName(this.a).isReachable(1);
        return;
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
  
  class h implements Runnable {
    h(ScanActivity this$0, String param1String) {}
    
    public void run() {
      try {
        InetAddress.getByName(this.a).isReachable(1);
        return;
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
  
  class i implements Runnable {
    i(ScanActivity this$0, ProgressBar param1ProgressBar, ImageView param1ImageView) {}
    
    public void run() {
      int j = 0;
      while (true) {
        ScanActivity scanActivity = this.c;
        if (scanActivity.k == 0) {
          int k = j;
          if (j >= 5000)
            k = 0; 
          try {
            Thread.sleep(10L);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          j = k + 10;
          this.c.runOnUiThread(new a(this, j));
          continue;
        } 
        interruptedException.runOnUiThread(new b(this));
        return;
      } 
    }
    
    class a implements Runnable {
      a(ScanActivity.i this$0, int param2Int) {}
      
      public void run() {
        this.b.a.setProgress(this.a);
      }
    }
    
    class b implements Runnable {
      b(ScanActivity.i this$0) {}
      
      public void run() {
        this.a.a.setProgress(5000);
        this.a.b.setEnabled(true);
        ((ImageView)this.a.c.findViewById(2130903075)).setImageResource(2130837526);
      }
    }
  }
  
  class a implements Runnable {
    a(ScanActivity this$0, int param1Int) {}
    
    public void run() {
      this.b.a.setProgress(this.a);
    }
  }
  
  class b implements Runnable {
    b(ScanActivity this$0) {}
    
    public void run() {
      this.a.a.setProgress(5000);
      this.a.b.setEnabled(true);
      ((ImageView)this.a.c.findViewById(2130903075)).setImageResource(2130837526);
    }
  }
  
  class j implements Runnable {
    j(ScanActivity this$0) {}
    
    public void run() {}
  }
  
  private class k<T> extends ArrayAdapter<T> {
    public k(ScanActivity this$0, Context param1Context, int param1Int1, int param1Int2, List<T> param1List) {
      super(param1Context, param1Int1, param1Int2, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ForegroundColorSpan foregroundColorSpan;
      View view = super.getView(param1Int, param1View, param1ViewGroup);
      ImageView imageView1 = (ImageView)view.findViewById(2130903073);
      if (ScanActivity.a(this.a)[param1Int]) {
        param1Int = 2130837528;
      } else {
        param1Int = 2130837535;
      } 
      imageView1.setImageResource(param1Int);
      ImageView imageView2 = (ImageView)view.findViewById(2130903072);
      imageView2.setImageResource(2130837518);
      TextView textView = (TextView)view.findViewById(2130903081);
      textView.setTextSize(2, b.q);
      String str1 = textView.getText().toString();
      str1.indexOf('\n');
      param1Int = str1.indexOf("}") + 1;
      String str5 = str1.substring(0, param1Int);
      String str6 = str1.substring(param1Int, str1.length());
      int i = str6.indexOf('[');
      param1Int = str6.indexOf("]");
      i++;
      str1 = "99999999999999";
      String str4 = str1;
      if (i < param1Int)
        try {
          str4 = str6.substring(i, param1Int);
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
          str4 = str1;
        }  
      try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.openFileInput("aliases")));
        String str = "";
        while (true) {
          str1 = str;
          try {
            String str7 = bufferedReader.readLine();
            if (str7 != null) {
              str = str1;
              if (str7.indexOf(str4) != -1)
                str = str7.substring(str7.indexOf(":") + 1); 
              continue;
            } 
            bufferedReader.close();
            break;
          } catch (FileNotFoundException fileNotFoundException) {
            // Byte code: goto -> 282
          } catch (IOException iOException) {
            // Byte code: goto -> 271
          } 
        } 
      } catch (FileNotFoundException fileNotFoundException) {
        str1 = "";
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        str1 = "";
        iOException.printStackTrace();
      } 
      Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(str5);
      if (matcher.find()) {
        String str = matcher.group(1);
        str5.substring(0, str5.indexOf(" "));
        try {
          FileOutputStream fileOutputStream;
          param1Int = str.length();
          if (param1Int > 1) {
            String str7 = str1;
            String str8 = str1;
            try {
              StringBuilder stringBuilder1 = new StringBuilder();
              str7 = str1;
              str8 = str1;
              stringBuilder1.append(str4);
              str7 = str1;
              str8 = str1;
              stringBuilder1.append(":");
              str7 = str1;
              str8 = str1;
              stringBuilder1.append(str);
              str7 = str1;
              str8 = str1;
              stringBuilder1.append("\n");
              str7 = str1;
              str8 = str1;
              str = stringBuilder1.toString();
              str7 = str1;
              str8 = str1;
              fileOutputStream = this.a.openFileOutput("autoaliases", 32768);
              str7 = str1;
              str8 = str1;
              fileOutputStream.write(str.getBytes());
              str7 = str1;
              str8 = str1;
              fileOutputStream.close();
              str = str1;
            } catch (FileNotFoundException fileNotFoundException) {
              str1 = str8;
              fileNotFoundException.printStackTrace();
              String str9 = str1;
            } catch (IOException iOException) {
              str1 = str7;
            } 
          } else {
            String str7 = str1;
            String str8 = str1;
            str = str1;
            if (str1.length() == 0) {
              str7 = str1;
              str8 = str1;
              BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.openFileInput("autoaliases")));
              while (true) {
                str7 = str1;
                str8 = str1;
                String str10 = bufferedReader.readLine();
                if (str10 != null) {
                  str7 = str1;
                  str8 = str1;
                  if (str10.indexOf((String)fileOutputStream) != -1) {
                    str7 = str1;
                    str8 = str1;
                    str1 = str10.substring(str10.indexOf(":") + 1);
                  } 
                  continue;
                } 
                str7 = str1;
                str8 = str1;
                bufferedReader.close();
                String str9 = str1;
                break;
              } 
            } 
          } 
        } catch (FileNotFoundException fileNotFoundException) {
          fileNotFoundException.printStackTrace();
          String str7 = str1;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          str = str1;
        } 
        if (str.length() > 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("(");
          stringBuilder1.append(str);
          stringBuilder1.append(")");
          String str7 = str5.replaceAll("\\((.*?)\\)", stringBuilder1.toString());
        } else {
          str1 = str5.replaceAll("\\(-\\)", "");
        } 
      } else {
        str1 = str5;
      } 
      String str2 = str6.replaceAll(":", "\n");
      String str3 = str1.replaceAll("\\}", " ");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append(str2);
      SpannableString spannableString = new SpannableString(stringBuilder.toString());
      spannableString.setSpan(new StyleSpan(1), 0, str3.length(), 33);
      spannableString.setSpan(new AbsoluteSizeSpan(b.q + 3, true), 0, str3.length(), 33);
      stringBuilder = new StringBuilder();
      stringBuilder.append(b.G);
      stringBuilder.append(" ");
      if (str3.contains(stringBuilder.toString())) {
        foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00aa00"));
        param1Int = str3.length();
      } else {
        foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#5AB6B6"));
        param1Int = str3.length();
      } 
      spannableString.setSpan(foregroundColorSpan, 0, param1Int, 33);
      textView.setText((CharSequence)spannableString);
      if (str3.indexOf("Windows") != -1)
        imageView2.setImageResource(2130837536); 
      if (str3.indexOf("Unix") != -1 || str3.indexOf("Linux") != -1 || str3.indexOf("BSD") != -1)
        imageView2.setImageResource(2130837516); 
      if (str2.indexOf("Apple") != -1)
        imageView2.setImageResource(2130837505); 
      if (str3.indexOf("Android") != -1)
        imageView2.setImageResource(2130837504); 
      return view;
    }
  }
  
  public class l extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public l(ScanActivity this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f = param1ScaleGestureDetector.getScaleFactor();
      if (f < 1.0F) {
        ScanActivity scanActivity = this.a;
        int i = scanActivity.m + 1;
        scanActivity.m = i;
        if (i > 10) {
          b.q--;
          scanActivity.a.invalidateViews();
          this.a.m = 0;
        } 
      } 
      if (f > 1.0F) {
        ScanActivity scanActivity = this.a;
        int i = scanActivity.m + 1;
        scanActivity.m = i;
        if (i > 10) {
          b.q++;
          scanActivity.a.invalidateViews();
          this.a.m = 0;
        } 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\ScanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */