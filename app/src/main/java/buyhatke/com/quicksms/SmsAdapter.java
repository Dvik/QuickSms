package buyhatke.com.quicksms;



        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;


        import java.util.ArrayList;


public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder> {

    private ArrayList<CustomSms> smsList = new ArrayList<CustomSms>();
   

    Context context;
   
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1,textView2,textView3;
      

        public ViewHolder(RelativeLayout v) {
            super(v);
            textView1= (TextView) v.findViewById(R.id.address);
            textView2= (TextView) v.findViewById(R.id.date);
            textView3= (TextView) v.findViewById(R.id.body);
        }
    }

    

    public void updateList(ArrayList<CustomSms> data) {
        smsList = data;
        notifyDataSetChanged();
    }

    public SmsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder((RelativeLayout)v);
        return vh;
    }


    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        final CustomSms r = smsList.get(position);

        holder.textView1.setText(r.address);
        holder.textView2.setText(r.date);
        holder.textView3.setText(r.body);

        Log.d("dgegf4",r.address);

    }


    @Override
    public int getItemCount() {
        return smsList.size();

    }
}

