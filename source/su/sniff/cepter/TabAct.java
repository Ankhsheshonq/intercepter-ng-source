package su.sniff.cepter;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TabHost;

public class TabAct extends TabActivity {
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130968601);
    getWindow().setFeatureDrawableResource(3, 2130837514);
    b.M = (Activity)this;
    TabHost tabHost = getTabHost();
    b.B = tabHost;
    b.C = 0;
    if (Build.VERSION.SDK_INT >= 24 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      a.a.a.a.a.a((Activity)this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1); 
    String str1 = getIntent().getExtras().getString("Key_String");
    String str2 = getIntent().getExtras().getString("Key_String_origin");
    Intent intent4 = new Intent((Context)this, MainActivity.class);
    intent4.putExtra("Key_String", str1);
    intent4.putExtra("Key_String_origin", str2);
    Intent intent2 = new Intent((Context)this, RawActivity.class);
    intent2.putExtra("Key_String", str1);
    intent2.putExtra("Key_String_origin", str2);
    Intent intent1 = new Intent((Context)this, SettingsActivity.class);
    intent1.putExtra("Key_String", str1);
    intent1.putExtra("Key_String_origin", str2);
    Intent intent5 = new Intent((Context)this, WebActivity.class);
    Intent intent3 = new Intent((Context)this, GalleryActivity.class);
    Resources resources = getResources();
    TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("1");
    tabSpec3.setIndicator("", resources.getDrawable(2130837521));
    tabSpec3.setContent(intent4);
    tabHost.addTab(tabSpec3);
    TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("2");
    tabSpec2.setIndicator("", resources.getDrawable(2130837530));
    tabSpec2.setContent(intent2);
    tabHost.addTab(tabSpec2);
    TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("3");
    tabSpec1.setIndicator("", resources.getDrawable(2130837508));
    tabSpec1.setContent(intent5);
    tabHost.addTab(tabSpec1);
    tabSpec1 = tabHost.newTabSpec("4");
    tabSpec1.setIndicator("", resources.getDrawable(2130837511));
    tabSpec1.setContent(intent3);
    tabHost.addTab(tabSpec1);
    tabSpec1 = tabHost.newTabSpec("5");
    tabSpec1.setIndicator("", resources.getDrawable(2130837529));
    tabSpec1.setContent(intent1);
    tabHost.addTab(tabSpec1);
    tabHost.setOnTabChangedListener(new a(this));
  }
  
  class a implements TabHost.OnTabChangeListener {
    a(TabAct this$0) {}
    
    public void onTabChanged(String param1String) {
      b.C = Integer.parseInt(param1String.trim()) - 1;
      ((Vibrator)this.a.getSystemService("vibrator")).vibrate(20L);
    }
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\TabAct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */