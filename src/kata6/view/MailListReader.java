package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata6.model.Mail;


public class MailListReader {
    public static List read(String nameFile) throws FileNotFoundException, IOException{
        List<Mail> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        Integer id=0;
        while((mail = reader.readLine())!=null){
            if(mail.contains("@")){
                mailList.add(new Mail(id,mail));
            }            
        }
        reader.close();
        return mailList;               
    }
}
