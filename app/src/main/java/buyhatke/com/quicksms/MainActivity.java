package buyhatke.com.quicksms;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    SmsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.messages_view);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);




    }

    @Override
    protected void onResume() {
        super.onResume();
        Cursor c;

        ArrayList<CustomSms> smslist;

        smslist = new ArrayList<>();

        c = getContentResolver().query(SmsApplication.INBOX_URI, null, null, null, null);


        while (c.moveToNext()) {
            String address = c.getString(c.getColumnIndexOrThrow("address"));
            String date = c.getString(c.getColumnIndexOrThrow("date"));
            String body = c.getString(c.getColumnIndexOrThrow("body"));

            smslist.add(new CustomSms(address,date,body));
        }

       /*for(int i=smslist.size()-1;i>=0;i--)
        {
            String s = smslist.get(i).address;

            for(int j=smslist.size()-1;j>=0;j--)
            {
                if(i!=j) {
                    if (smslist.get(j).address.equals(s)) {
                        smslist.remove(j);
                    }
                }
            }
        }*/

        Map<String, CustomSms> map = new LinkedHashMap<>();

        for (CustomSms ays : smslist) {
            map.put(ays.address, ays);
        }

        smslist.clear();
        smslist.addAll(map.values());

        adapter = new SmsAdapter(MainActivity.this);
        adapter.updateList(smslist);
        rv.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
