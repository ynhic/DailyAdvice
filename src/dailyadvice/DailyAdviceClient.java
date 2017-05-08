/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyadvice;
//importaçoes necessarias para usar o socket
import java.io.*;
import java.net.*;


/**
 *
 * @author ynhic
 */
public class DailyAdviceClient {
    
    public void go(){
        try{
            //criara uma conexão de socket com a porta 4242, no mesmo host que estiver sendo executado
            Socket s = new Socket("127.0.0.1", 4242);
            
            //encadeia um BufferedReader a um InputStreamReader que é encadeiada ao fluxo de entrada proveniente do socket
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            
            String advice = reader.readLine();//metodo readline é usado da mesma forma de que fosse com um arquivo
            System.out.println("Today you should: " + advice);
            
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DailyAdviceClient cliente = new DailyAdviceClient();
        cliente.go();
    }
    
}
