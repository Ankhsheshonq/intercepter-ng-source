package su.sniff.cepter;

import java.util.ArrayList;
import java.util.List;

public class c {
  int a;
  
  int b;
  
  public c(String paramString) {
    String[] arrayOfString = paramString.split("\\/");
    if (arrayOfString.length == 2) {
      int i = 0;
      paramString = arrayOfString[0];
      Integer integer = new Integer(arrayOfString[1]);
      if (integer.intValue() <= 32) {
        String[] arrayOfString1 = paramString.split("\\.");
        if (arrayOfString1.length == 4) {
          StringBuilder stringBuilder2;
          int j = 24;
          this.a = 0;
          while (i < arrayOfString1.length) {
            int k = Integer.parseInt(arrayOfString1[i]);
            if (k == (k & 0xFF)) {
              this.a += k << j;
              j -= 8;
              i++;
              continue;
            } 
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid IP address: ");
            stringBuilder2.append(paramString);
            throw new NumberFormatException(stringBuilder2.toString());
          } 
          if (stringBuilder2.intValue() >= 8) {
            this.b = -1;
            this.b = -1 << 32 - stringBuilder2.intValue();
            return;
          } 
          throw new NumberFormatException("Netmask CIDR can not be less than 8");
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Invalid IP address: ");
        stringBuilder1.append(paramString);
        throw new NumberFormatException(stringBuilder1.toString());
      } 
      throw new NumberFormatException("CIDR can not be greater than 32");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid CIDR format '");
    stringBuilder.append(paramString);
    stringBuilder.append("', should be: xx.xx.xx.xx/xx");
    NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.toString());
    throw numberFormatException;
  }
  
  private String b(Integer paramInteger) {
    StringBuffer stringBuffer = new StringBuffer(15);
    for (int i = 24; i > 0; i -= 8) {
      stringBuffer.append(Integer.toString(paramInteger.intValue() >>> i & 0xFF));
      stringBuffer.append('.');
    } 
    stringBuffer.append(Integer.toString(paramInteger.intValue() & 0xFF));
    return stringBuffer.toString();
  }
  
  public Integer a() {
    int i;
    for (i = 0; i < 32 && this.b << i != 0; i++);
    Double double_2 = Double.valueOf(Math.pow(2.0D, (32 - i)));
    Double double_1 = double_2;
    if (double_2.doubleValue() == -1.0D)
      double_1 = Double.valueOf(1.0D); 
    return Integer.valueOf(double_1.intValue());
  }
  
  public List<String> a(Integer paramInteger) {
    ArrayList<String> arrayList = new ArrayList();
    int j = 0;
    int i;
    for (i = 0; i < 32 && this.b << i != 0; i++);
    Integer integer = Integer.valueOf(0);
    while (true) {
      boolean bool = true;
      if (j < 32 - i) {
        integer = Integer.valueOf(Integer.valueOf(integer.intValue() << 1).intValue() | 0x1);
        j++;
        continue;
      } 
      j = this.a;
      int k = this.b;
      for (i = bool; i < integer.intValue() && i < paramInteger.intValue(); i++)
        arrayList.add(b(Integer.valueOf(Integer.valueOf(j & k).intValue() + i))); 
      return arrayList;
    } 
  }
}


/* Location:              C:\Users\CETX\Desktop\classes-dex2jar.jar!\su\sniff\cepter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */