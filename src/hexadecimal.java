import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;
public class hexadecimal {

    static String battery(String str){
        String out = null;
        switch (str){
            case "00":
                out="No Power";
                break;
            case "01":
                out="Extremely Low Battery";
                break;
            case "02":
                out = "Very Low Battery";
                break;
            case "03":
                out = "Low Battery (can be used normally)";
            case "04":
                out = "Medium";
                break;
            case "05":
                out = "High";
                break;
            case "06":
                out = "Full";
                break;    
        }
        return out;
    }

    static void accepthexa(String str1) {

        String str3 = str1.substring(6,8);
//01 - login,22 - gps,13 - heart , alarm 26;

            if (str3.equals("01")) {
                 String str4 = str1.substring(8,25);
                System.out.println("IMEI - "+ str4);
                }
            else if(str3.equals("22")){
                String str4 = str1.substring(22,30);
                double a = Integer.parseInt(str4,16)/1800000.0;
                System.out.println("Lat - "+a);
                str4 = str1.substring(30,38);
                a = Integer.parseInt(str4,16)/1800000.0;
                System.out.println("Long - "+ a);
                str4 = str1.substring(38,40);
                System.out.println("Speed - "+Integer.parseInt(str4,16));
                str4 = str1.substring(64,66);
                long convertedMillis1 = Long.decode("0x" + str4);
                Instant instant1 = Instant.ofEpochMilli(convertedMillis1);
                LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
                System.out.println(localDateTime1);
            }
            else if(str3.equals("13")){
                String str4 = str1.substring(10,12);
                System.out.println("Battery "+battery(str4));
                str4 = str1.substring(8,10);
                String acc = Integer.toBinaryString(Integer.parseInt(str4, 16));
                if(acc.substring(1,2).equals("0"))
                System.out.println("ACC Low");
                else
                    System.out.println("ACC High");

            }
            else if(str3.equals("26")){
                String str4 = str1.substring(22,30);
                double a = Integer.parseInt(str4, 16) / 1800000.0;
                System.out.println("Lat - "+a);
                str4 = str1.substring(30,38);
                 a = Integer.parseInt(str4, 16) / 1800000.0;
                System.out.println("Long - "+a);
                str4 = str1.substring(68,72);
                if(str4 =="01")
                    System.out.println("SOS Message Detected");
                else
                    System.out.println("No SOS Message");

            }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
        accepthexa(sc.next());
        }




    }
}


