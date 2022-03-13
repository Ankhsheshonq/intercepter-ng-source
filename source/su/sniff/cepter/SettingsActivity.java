package su.sniff.cepter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SettingsActivity extends Activity {
  FileOutputStream a;
  
  private Context b;
  
  int c = 0;
  
  public void OnClearPcap(View paramView) {
    Process process = Runtime.getRuntime().exec("su");
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    dataOutputStream.writeBytes("LD_LIBRARY_PATH=/data/data/su.sniff.cepter/files /data/data/su.sniff.cepter/files/busybox rm /data/data/su.sniff.cepter/files/*.pcap\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    process.waitFor();
    Context context = getBaseContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Captures cleared from ");
    stringBuilder.append(getFilesDir().getAbsolutePath());
    Toast.makeText(context, stringBuilder.toString(), 0).show();
  }
  
  public void OnDiag(View paramView) {
    startActivityForResult(new Intent(this.b, DiagnosticsActivity.class), 1);
  }
  
  public void OnGenFP(View paramView) {
    Process process = Runtime.getRuntime().exec("su", (String[])null, new File("/data/data/su.sniff.cepter/files"));
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/su.sniff.cepter/files/cepter ");
    stringBuilder.append(b.a);
    stringBuilder.append(" getfp ");
    stringBuilder.append(b.F);
    stringBuilder.append(" ");
    stringBuilder.append(b.G);
    stringBuilder.append("\n");
    dataOutputStream.writeBytes(stringBuilder.toString());
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    bufferedReader.readLine();
    String str = bufferedReader.readLine();
    if (str != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("=Android ");
      stringBuilder.append(Build.VERSION.RELEASE);
      stringBuilder.append(" ; ");
      stringBuilder.append(Build.MANUFACTURER);
      stringBuilder.append(" ");
      stringBuilder.append(Build.MODEL);
      str = stringBuilder.toString();
      ((TextView)findViewById(2130903113)).setText(str);
      ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Fingerprint", str));
      Toast.makeText(getBaseContext(), "Copied to clipboard", 1).show();
    } 
    bufferedReader.close();
  }
  
  public void OnJust(View paramView) {
    boolean bool;
    if (b.A == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    b.A = bool;
  }
  
  public void OnLock(View paramView) {
    String str;
    Context context;
    if (b.w == 0) {
      b.w = 1;
      b.M.getWindow().addFlags(128);
      context = getBaseContext();
      str = "Screen Locked";
    } else {
      b.w = 0;
      b.M.getWindow().clearFlags(128);
      context = getBaseContext();
      str = "Screen Unlocked";
    } 
    Toast.makeText(context, str, 0).show();
  }
  
  public void OnLogo(View paramView) {
    Context context = getBaseContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("API ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(":");
    stringBuilder.append(Build.CPU_ABI);
    stringBuilder.append("\n");
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(" ");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append("\nhttp://sniff.su");
    Toast.makeText(context, stringBuilder.toString(), 0).show();
    int i = this.c + 1;
    this.c = i;
    if (i == 5) {
      b.I = " -deb";
      Toast.makeText(getBaseContext(), "Debug mode ON", 0).show();
    } 
    if (this.c == 10) {
      b.I = "";
      Toast.makeText(getBaseContext(), "Debug mode OFF", 0).show();
      this.c = 0;
    } 
  }
  
  public void OnRawScroll(View paramView) {
    boolean bool;
    if (b.p == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    b.p = bool;
  }
  
  public void OnReset(View paramView) {
    File file = new File("/data/data/su.sniff.cepter/files/aliases");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/autoaliases");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/hostlist");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/settings");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/targets");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/pf");
    if (file.exists())
      file.delete(); 
    file = new File("/data/data/su.sniff.cepter/files/exits.id");
    if (file.exists())
      file.delete(); 
    Process process = Runtime.getRuntime().exec("su");
    DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
    dataOutputStream.writeBytes("LD_LIBRARY_PATH=/data/data/su.sniff.cepter/files /data/data/su.sniff.cepter/files/busybox rm /data/data/su.sniff.cepter/files/last*\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    process.waitFor();
    process = Runtime.getRuntime().exec("su");
    dataOutputStream = new DataOutputStream(process.getOutputStream());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ip route add default via ");
    stringBuilder.append(b.G);
    stringBuilder.append("\n");
    dataOutputStream.writeBytes(stringBuilder.toString());
    dataOutputStream.flush();
    dataOutputStream.writeBytes("ip rule del 0\n");
    dataOutputStream.flush();
    dataOutputStream.writeBytes("ip rule del 1\n");
    dataOutputStream.flush();
    dataOutputStream.writeBytes("ip rule add from all lookup local pref 0\n");
    dataOutputStream.flush();
    dataOutputStream.writeBytes("ip rule add from all lookup main pref 1\n");
    dataOutputStream.flush();
    dataOutputStream.writeBytes("exit\n");
    dataOutputStream.flush();
    dataOutputStream.close();
    process.waitFor();
    Toast.makeText(getBaseContext(), "Temporary files removed and Network settings restored", 0).show();
  }
  
  public void OnSave(View paramView) {
    CheckBox checkBox = (CheckBox)findViewById(2130903065);
    if (b.c == 0) {
      b.c = 1;
      checkBox.setVisibility(0);
      return;
    } 
    b.c = 0;
    checkBox.setVisibility(4);
  }
  
  public void OnShowHTTP(View paramView) {
    if (b.x == 0) {
      b.x = 1;
      AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
      builder.setTitle("Confirm");
      builder.setMessage("Do you want to ignore your own requests?");
      builder.setPositiveButton("YES", new c(this));
      builder.setNegativeButton("NO", new d(this));
      builder.create().show();
      return;
    } 
    b.x = 0;
  }
  
  public void a() {
    try {
      FileOutputStream fileOutputStream = openFileOutput("settings", 0);
      fileOutputStream.write(Integer.toString(b.q).getBytes());
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
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130968597);
    getIntent().getExtras().getString("Key_String");
    getIntent().getExtras().getString("Key_String_origin");
    TextView textView = (TextView)findViewById(2130903109);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Home dir: ");
    stringBuilder.append(getFilesDir().toString());
    textView.setText(stringBuilder.toString());
    this.b = (Context)this;
    CheckBox checkBox = (CheckBox)findViewById(2130903059);
    if (b.c == 1)
      checkBox.setChecked(true); 
    checkBox = (CheckBox)findViewById(2130903060);
    if (b.p == 1)
      checkBox.setChecked(true); 
    checkBox = (CheckBox)findViewById(2130903061);
    if (b.w == 1)
      checkBox.setChecked(true); 
    checkBox = (CheckBox)findViewById(2130903065);
    if (b.A == 1) {
      checkBox.setChecked(true);
      checkBox.setVisibility(0);
    } else {
      checkBox.setVisibility(4);
    } 
    ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context)this, 17367048, (Object[])new String[] { 
          "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
          "11", "12", "13", "14", "15" });
    arrayAdapter2.setDropDownViewResource(17367049);
    Spinner spinner1 = (Spinner)findViewById(2130903106);
    spinner1.setAdapter((SpinnerAdapter)arrayAdapter2);
    try {
      InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("settings"));
      String str = (new BufferedReader(inputStreamReader)).readLine();
      inputStreamReader.close();
      int i = Integer.parseInt(str);
      b.q = i;
      spinner1.setSelection(i - 1);
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    spinner1.setOnItemSelectedListener(new a(this, spinner1));
    spinner1.setSelection(b.q - 1);
    ArrayAdapter arrayAdapter1 = new ArrayAdapter((Context)this, 17367048, (Object[])new String[] { "sdcard1", "sdcard2", "int memory", "custom" });
    arrayAdapter1.setDropDownViewResource(17367049);
    Spinner spinner2 = (Spinner)findViewById(2130903105);
    spinner2.setAdapter((SpinnerAdapter)arrayAdapter1);
    ((ScrollView)findViewById(2130903092)).setOnTouchListener(new e(this));
    spinner2.setOnItemSelectedListener(new b(this, spinner2));
    if ("mounted".equals(Environment.getExternalStorageState())) {
      spinner2.setSelection(0);
      return;
    } 
    spinner2.setSelection(2);
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
  }
  
  class a implements AdapterView.OnItemSelectedListener {
    a(SettingsActivity this$0, Spinner param1Spinner) {}
    
    public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      b.q = Integer.parseInt(this.a.getSelectedItem().toString());
      this.b.a();
    }
    
    public void onNothingSelected(AdapterView<?> param1AdapterView) {}
  }
  
  class b implements AdapterView.OnItemSelectedListener {
    b(SettingsActivity this$0, Spinner param1Spinner) {}
    
    public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      String str = this.a.getSelectedItem().toString();
      try {
        FileOutputStream fileOutputStream;
        this.b.a = this.b.openFileOutput("savepath", 0);
        param1Int = str.indexOf("sdcard1");
        if (param1Int != -1) {
          str = Environment.getExternalStorageDirectory().getAbsolutePath();
          this.b.a.write(str.getBytes());
          Context context = this.b.getBaseContext();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Save pcap to ");
          stringBuilder.append(str);
          Toast.makeText(context, stringBuilder.toString(), 0).show();
          b.J = Environment.getExternalStorageDirectory().getAbsolutePath();
          fileOutputStream = this.b.a;
        } else {
          AlertDialog.Builder builder;
          if (fileOutputStream.indexOf("custom") != -1) {
            builder = new AlertDialog.Builder(SettingsActivity.a(this.b));
            builder.setTitle("Set custom path for pcaps");
            EditText editText = new EditText(SettingsActivity.a(this.b));
            editText.setInputType(1);
            builder.setView((View)editText);
            builder.setPositiveButton("Set", new a(this, editText));
            builder.setNegativeButton("Cancel", new b(this));
            builder.show();
            return;
          } 
          if (builder.indexOf("sdcard2") != -1) {
            String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
            str1 = str1.substring(0, str1.length() - 1);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str1);
            stringBuilder1.append("1");
            str1 = stringBuilder1.toString();
            this.b.a.write(str1.getBytes());
            Context context = this.b.getBaseContext();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Save pcap to ");
            stringBuilder2.append(str1);
            Toast.makeText(context, stringBuilder2.toString(), 0).show();
            b.J = str1;
            FileOutputStream fileOutputStream1 = this.b.a;
          } else {
            Context context = this.b.getBaseContext();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Save pcap to internal memory ");
            stringBuilder.append(this.b.getFilesDir().getAbsolutePath());
            Toast.makeText(context, stringBuilder.toString(), 0).show();
            String str1 = this.b.getFilesDir().getAbsolutePath();
            b.J = str1;
            this.b.a.write(str1.getBytes());
            fileOutputStream = this.b.a;
          } 
        } 
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
    
    public void onNothingSelected(AdapterView<?> param1AdapterView) {}
    
    class a implements DialogInterface.OnClickListener {
      a(SettingsActivity.b this$0, EditText param2EditText) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        String str = this.a.getText().toString();
        b.J = str;
        try {
          this.b.b.a.write(str.getBytes());
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
        Context context = this.b.b.getBaseContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Save pcap to ");
        stringBuilder.append(b.J);
        Toast.makeText(context, stringBuilder.toString(), 0).show();
        try {
          this.b.b.a.close();
          return;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          return;
        } 
      }
    }
    
    class b implements DialogInterface.OnClickListener {
      b(SettingsActivity.b this$0) {}
      
      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
        try {
          this.a.b.a.close();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
        param2DialogInterface.cancel();
      }
    }
  }
  
  class a implements DialogInterface.OnClickListener {
    a(SettingsActivity this$0, EditText param1EditText) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      String str = this.a.getText().toString();
      b.J = str;
      try {
        this.b.b.a.write(str.getBytes());
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      Context context = this.b.b.getBaseContext();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Save pcap to ");
      stringBuilder.append(b.J);
      Toast.makeText(context, stringBuilder.toString(), 0).show();
      try {
        this.b.b.a.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return;
      } 
    }
  }
  
  class b implements DialogInterface.OnClickListener {
    b(SettingsActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      try {
        this.a.b.a.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      param1DialogInterface.cancel();
    }
  }
  
  class c implements DialogInterface.OnClickListener {
    c(SettingsActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      b.y = 1;
      param1DialogInterface.dismiss();
    }
  }
  
  class d implements DialogInterface.OnClickListener {
    d(SettingsActivity this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      b.y = 0;
      param1DialogInterface.dismiss();
    }
  }
  
  public class e implements View.OnTouchListener {
    private final GestureDetector a = new GestureDetector((GestureDetector.OnGestureListener)new a(null));
    
    public e(SettingsActivity this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      this.a.onTouchEvent(param1MotionEvent);
      return false;
    }
    
    private final class a extends GestureDetector.SimpleOnGestureListener {
      private a(SettingsActivity.e this$0) {}
      
      public void a() {}
      
      public void b() {
        b.B.setCurrentTab(3);
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
    private a(SettingsActivity this$0) {}
    
    public void a() {}
    
    public void b() {
      b.B.setCurrentTab(3);
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


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */