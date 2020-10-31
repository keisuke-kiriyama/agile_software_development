package Chapter14_Template_Pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ftocraw {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while (!done) {
            String fahrString = br.readLine();
            if (fahrString == null || fahrString.length() == 0)
                done = true;
            else {
                double fahr = Double.parseDouble(fahrString);
                double celsius = 5.0/9.0*(fahr - 32);
                System.out.println("F=" + fahr + ", C=" + celsius);
            }
        }
        System.out.println("ftoc exit");
    }
}
