package buyhatke.com.quicksms;

import android.widget.CursorAdapter;

/**
 * Created by Divya on 5/6/2016.
 */
public class CustomSms {

    public String address;
    public String date;
    public String body;

    public CustomSms(String address,String date,String body)
    {
        this.address = address;
        this.date = date;
        this.body = body;
    }
}
