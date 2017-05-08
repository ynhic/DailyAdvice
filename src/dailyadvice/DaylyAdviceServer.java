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
public class DaylyAdviceServer {
    //array com os conselhos
    String[] adviceList = {"morde pedaços menores", "use o jeans apertado. NÃO. ele nao te deixa gorda.", "so vou dizer uma palavra: inapropriado",
        "pelo menos hoje, seja honesta", "reconsidere ess corte de cabelo"};
    
    
    public void go(){
        
        
        try{
            //ServerSocket fará esse app de servidor escutar solicitações do cliente na porta 4242 em ambiante local
            ServerSocket serverSock = new ServerSocket(4242);
            
            
            while(true){
                //o metodo accept() ficará aguardando ate uma solicitação chegar, momento em que el retornará
                //um obj Socket(em alguma porta anonima) para cominucação com o cliente
                Socket sock = serverSock.accept();
                
                //apos a conexão estar estabelecida
                //iremos criar o obj PrintWriter e enviar um println()
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                System.out.println(advice);
                
                
                
            }
            
        } catch (IOException ex){
        ex.printStackTrace();
        }
    }
    
    private String getAdvice(){
        int random = (int) (Math.random()*adviceList.length);
        return adviceList[random];
        
    }
    
    public static void main(String[] args) {
        DaylyAdviceServer server = new DaylyAdviceServer();
        server.go();
    }
    
    
    
    
}
