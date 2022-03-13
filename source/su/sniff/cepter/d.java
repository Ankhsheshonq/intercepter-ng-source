package su.sniff.cepter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class d extends Dialog implements View.OnClickListener {
  private File a = new File("/");
  
  private ListView b = null;
  
  private FilenameFilter c = null;
  
  private c d = null;
  
  public d(Context paramContext, String paramString, String[] paramArrayOfString, c paramc) {
    super(paramContext);
    a(paramString, paramArrayOfString, paramc);
  }
  
  private void a() {
    if (this.a.getParentFile() != null)
      a(this.a.getParentFile()); 
  }
  
  private void a(Exception paramException) {
    Log.e("OpenFileDialog", paramException.getMessage());
  }
  
  private void a(String paramString, String[] paramArrayOfString, c paramc) {
    this.d = paramc;
    if (paramString != null && (new File(paramString)).exists())
      this.a = new File(paramString); 
    a(paramArrayOfString);
    setContentView(2130968589);
    setTitle(2131230723);
    this.b = (ListView)findViewById(2130903088);
    a(this.a);
    this.b.setOnItemClickListener(new a(this));
    ((Button)findViewById(2130903084)).setOnClickListener(this);
  }
  
  private void a(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    this.c = new b(this, paramArrayOfString);
  }
  
  private boolean a(File paramFile) {
    if (!paramFile.isDirectory())
      return false; 
    if (!b(paramFile))
      return true; 
    this.a = paramFile;
    ((TextView)findViewById(2130903083)).setText(this.a.getAbsolutePath());
    return true;
  }
  
  private boolean b(File paramFile) {
    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
    try {
      if (this.c != null) {
        String[] arrayOfString = paramFile.list(this.c);
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
    SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), arrayList, 2130968590, new String[] { "filename", "fileimage" }, new int[] { 2130903087, 2130903086 });
    this.b.setAdapter((ListAdapter)simpleAdapter);
    return true;
  }
  
  public void onClick(View paramView) {
    a();
  }
  
  class a implements AdapterView.OnItemClickListener {
    a(d this$0) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      String str = (String)((Map)param1AdapterView.getItemAtPosition(param1Int)).get("filename");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d.a(this.a).getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(str);
      File file = new File(stringBuilder.toString());
      if (!d.a(this.a, file) && d.b(this.a) != null) {
        d.b(this.a).a(file);
        this.a.dismiss();
      } 
    }
  }
  
  class b implements FilenameFilter {
    b(d this$0, String[] param1ArrayOfString) {}
    
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
  
  public static interface c {
    void a(File param1File);
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */