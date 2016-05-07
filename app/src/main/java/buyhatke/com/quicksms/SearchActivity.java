package buyhatke.com.quicksms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    EditText et;
    RecyclerView rv;
    SmsAdapter adapter;

    String selectedText = "";
    ArrayList<CustomSms> smsSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        smsSearchList = new ArrayList<CustomSms>();

        et = (EditText) findViewById(R.id.search_edt);

        rv = (RecyclerView) findViewById(R.id.search_recycler);

        Intent i = this.getIntent();
        smsSearchList = i.getParcelableArrayListExtra("search");

        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(llm);


        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                selectedText = et.getText().toString();
                updateListOfCustomSmss();
            }
        });
    }

    public void updateListOfCustomSmss() {

        if (selectedText != null && !selectedText.equals("")) {

            ArrayList<CustomSms> searchList = new ArrayList<>();

            for (int i = 0; i < smsSearchList.size(); i++) {


                if(smsSearchList.get(i).address.toLowerCase().contains(selectedText.toLowerCase())) {
                    if (!searchList.contains(smsSearchList.get(i)))
                        searchList.add(smsSearchList.get(i));
                }
                if(smsSearchList.get(i).date.toLowerCase().contains(selectedText.toLowerCase())) {
                    if (!searchList.contains(smsSearchList.get(i)))
                        searchList.add(smsSearchList.get(i));
                }
                if(smsSearchList.get(i).body.toLowerCase().contains(selectedText.toLowerCase())) {
                    if (!searchList.contains(smsSearchList.get(i)))
                        searchList.add(smsSearchList.get(i));
                }


                adapter = new SmsAdapter(getApplicationContext());
                adapter.updateList(searchList);
                rv.setAdapter(adapter);

            }
        }
    }
}
