package QueueApi.util;

import org.springframework.stereotype.Component;

import java.util.Locale;
@Component
public class GetQueNumber {
    public String getQueNumber(String label,String num){
        if(num.length()==1) num="00"+num;
        else if(num.length()==2) num="0"+num;
        return label.toUpperCase(Locale.ROOT)+num;
    }
}
