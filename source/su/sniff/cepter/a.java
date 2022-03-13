package su.sniff.cepter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class a extends ArrayAdapter<String> {
  ArrayList<String> a;
  
  public a(Context paramContext, int paramInt, ArrayList<String> paramArrayList) {
    super(paramContext, paramInt, paramArrayList);
    this.a = paramArrayList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130968594, null); 
    TextView textView = (TextView)view.findViewById(2130903081);
    textView.setText(this.a.get(paramInt));
    textView.setTextSize(2, b.q);
    textView.setBackgroundResource(2130771970);
    if (((String)this.a.get(paramInt)).indexOf("ARP") > 0)
      textView.setBackgroundResource(2130771968); 
    if (((String)this.a.get(paramInt)).indexOf("ICMP") > 0)
      textView.setBackgroundResource(2130771974); 
    if (((String)this.a.get(paramInt)).indexOf("SMB") > 0)
      textView.setBackgroundResource(2130771975); 
    if (((String)this.a.get(paramInt)).indexOf("HTTP") > 0 || ((String)this.a.get(paramInt)).indexOf("HTTPS") > 0 || ((String)this.a.get(paramInt)).indexOf("AOL") > 0)
      textView.setBackgroundResource(2130771972); 
    if (((String)this.a.get(paramInt)).indexOf("DNS") > 0 || ((String)this.a.get(paramInt)).indexOf("UDP") > 0 || ((String)this.a.get(paramInt)).indexOf("SNMP") > 0 || ((String)this.a.get(paramInt)).indexOf("DHCP") > 0 || ((String)this.a.get(paramInt)).indexOf("NTP") > 0 || ((String)this.a.get(paramInt)).indexOf("RADIUS") > 0)
      textView.setBackgroundResource(2130771976); 
    if (((String)this.a.get(paramInt)).indexOf("FTP") > 0 || ((String)this.a.get(paramInt)).indexOf("POP3") > 0 || ((String)this.a.get(paramInt)).indexOf("SMTP") > 0 || ((String)this.a.get(paramInt)).indexOf("IMAP") > 0 || ((String)this.a.get(paramInt)).indexOf("IMAPS") > 0 || ((String)this.a.get(paramInt)).indexOf("POP3S") > 0 || ((String)this.a.get(paramInt)).indexOf("TELNET") > 0 || ((String)this.a.get(paramInt)).indexOf("SSH") > 0 || ((String)this.a.get(paramInt)).indexOf("SMTPS") > 0 || ((String)this.a.get(paramInt)).indexOf("TNS") > 0 || ((String)this.a.get(paramInt)).indexOf("MYSQL") > 0 || ((String)this.a.get(paramInt)).indexOf("TCP") > 0)
      textView.setBackgroundResource(2130771970); 
    textView.setTypeface(Typeface.MONOSPACE);
    return view;
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */