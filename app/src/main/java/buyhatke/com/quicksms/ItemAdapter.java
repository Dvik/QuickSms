package buyhatke.com.quicksms;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Divya on 5/6/2016.
 */
public class ItemAdapter extends CursorAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public ItemAdapter(Context context, Cursor c) {
        super(context, c);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = mLayoutInflater.inflate(R.layout.row, parent, false);
        return v;
    }


    @Override
    public void bindView(View v, Context context, Cursor c) {

        String address = c.getString(c.getColumnIndexOrThrow("address"));
        String date = c.getString(c.getColumnIndexOrThrow("date"));
        String body = c.getString(c.getColumnIndexOrThrow("body"));


        TextView title_text = (TextView) v.findViewById(R.id.textView1);
        if (title_text != null) {
            title_text.setText(address);
        }

        TextView date_text = (TextView) v.findViewById(R.id.textView2);
        if (date_text != null) {
            date_text.setText(date);
        }

        TextView body_text = (TextView) v.findViewById(R.id.textView3);
        if (body_text != null) {
            body_text.setText(body);
        }
    }
}