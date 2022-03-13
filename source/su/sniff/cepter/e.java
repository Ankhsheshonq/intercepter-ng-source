package su.sniff.cepter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class e extends Dialog implements View.OnClickListener {
  private File a = new File("/");
  
  private File b = null;
  
  private ListView c = null;
  
  private EditText d = null;
  
  private FilenameFilter e = null;
  
  private d f = null;
  
  public e(Context paramContext, String paramString, String[] paramArrayOfString, d paramd) {
    super(paramContext);
    a(paramString, paramArrayOfString, paramd);
  }
  
  private void a() {
    if (this.a.getParentFile() != null)
      a(this.a.getParentFile()); 
  }
  
  private void a(Exception paramException) {
    Log.e("SaveFileDialog", paramException.getMessage());
  }
  
  private void a(String paramString) {
    if (paramString == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    File file = new File(stringBuilder.toString());
    if (!file.exists()) {
      file.mkdirs();
      this.d.setText(null);
      a(file);
    } 
  }
  
  private void a(String paramString, String[] paramArrayOfString, d paramd) {
    this.f = paramd;
    if (paramString != null && (new File(paramString)).exists())
      this.a = new File(paramString); 
    a(paramArrayOfString);
    setContentView(2130968598);
    setTitle(2131230731);
    this.d = (EditText)findViewById(2130903095);
    Calendar calendar = Calendar.getInstance();
    int i = calendar.get(5);
    int j = calendar.get(2);
    int k = calendar.get(1);
    int m = calendar.get(11);
    int n = calendar.get(12);
    EditText editText = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("log_");
    stringBuilder.append(i);
    stringBuilder.append("_");
    stringBuilder.append(j + 1);
    stringBuilder.append("_");
    stringBuilder.append(k);
    stringBuilder.append("_");
    stringBuilder.append(m);
    stringBuilder.append("_");
    stringBuilder.append(n);
    stringBuilder.append(".txt");
    editText.setText(stringBuilder.toString());
    this.c = (ListView)findViewById(2130903100);
    a(this.a);
    this.c.setOnItemClickListener(new a(this));
    ((Button)findViewById(2130903096)).setOnClickListener(this);
    ((Button)findViewById(2130903101)).setOnClickListener(this);
    ((Button)findViewById(2130903102)).setOnClickListener(this);
  }
  
  private void a(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    this.e = new b(this, paramArrayOfString);
  }
  
  private boolean a(File paramFile) {
    if (!paramFile.isDirectory())
      return false; 
    if (!b(paramFile))
      return true; 
    this.a = paramFile;
    ((TextView)findViewById(2130903094)).setText(this.a.getAbsolutePath());
    return true;
  }
  
  private File b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    File file = new File(stringBuilder.toString());
    this.b = file;
    if (!file.exists())
      try {
        this.b.createNewFile();
        return this.b;
      } catch (IOException iOException) {
        a(iOException);
        return null;
      } catch (SecurityException securityException) {
        a(securityException);
        return null;
      }  
    (new AlertDialog.Builder(getContext())).setIcon(17301543).setTitle(2131230727).setMessage(2131230726).setPositiveButton(2131230725, new c(this)).setNegativeButton(2131230724, null).show();
    return null;
  }
  
  private boolean b(File paramFile) {
    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
    try {
      if (this.e != null) {
        String[] arrayOfString = paramFile.list(this.e);
      } else {
        String[] arrayOfString = paramFile.list();
      } 
    } catch (SecurityException securityException) {
      a(securityException);
      securityException = null;
    } 
    int i = 0;
    if (securityException == null)
      return false; 
    int j = securityException.length;
    while (i < j) {
      int k;
      SecurityException securityException1 = securityException[i];
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("filename", securityException1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFile.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append((String)securityException1);
      if ((new File(stringBuilder.toString())).isDirectory()) {
        k = 2130837512;
      } else {
        k = 2130837513;
      } 
      hashMap.put("fileimage", Integer.valueOf(k));
      arrayList.add(hashMap);
      i++;
    } 
    SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), arrayList, 2130968599, new String[] { "filename", "fileimage" }, new int[] { 2130903099, 2130903098 });
    this.c.setAdapter((ListAdapter)simpleAdapter);
    return true;
  }
  
  private void c(File paramFile) {
    d d1 = this.f;
    if (d1 != null)
      d1.a(paramFile); 
    dismiss();
  }
  
  public void onClick(View paramView) {
    if (paramView == findViewById(2130903096)) {
      a();
      return;
    } 
    if (paramView == findViewById(2130903101)) {
      a(this.d.getText().toString());
      return;
    } 
    if (paramView == findViewById(2130903102)) {
      File file = b(this.d.getText().toString());
      if (file != null && this.f != null)
        c(file); 
    } 
  }
  
  class a implements AdapterView.OnItemClickListener {
    a(e this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      String str = (String)((Map)param1AdapterView.getItemAtPosition(param1Int)).get("filename");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e.a(this.a).getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(str);
      File file = new File(stringBuilder.toString());
      if (!e.a(this.a, file))
        e.b(this.a).setText(str); 
    }
  }
  
  class b implements FilenameFilter {
    b(e this$0, String[] param1ArrayOfString) {}
    
    public boolean accept(File param1File, String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1File);
      stringBuilder.append(File.separator);
      stringBuilder.append(param1String);
      if ((new File(stringBuilder.toString())).isDirectory())
        return true; 
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        if (param1String.endsWith(arrayOfString[i]))
          return true; 
      } 
      return false;
    }
  }
  
  class c implements DialogInterface.OnClickListener {
    c(e this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      e e1 = this.a;
      e.b(e1, e.c(e1));
    }
  }
  
  public static interface d {
    void a(File param1File);
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */