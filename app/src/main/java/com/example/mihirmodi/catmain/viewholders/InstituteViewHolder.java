package com.example.mihirmodi.catmain.viewholders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mihirmodi.catmain.R;
import com.example.mihirmodi.catmain.models.Institute;

/**
 * Created by lenovo on 27-01-2016.
 */
public class InstituteViewHolder extends RecyclerView.ViewHolder {
    TextView tv_iimname;
    TextView tv_street;
    TextView tv_city;
    TextView tv_state;
    TextView tv_pincode;
    TextView tv_emailid;
    TextView tv_cutoff;
    TextView tv_isiim;
    Button btn_phnno;
    Button btn_website;
    Intent intent;
    Context context;

    public InstituteViewHolder(View itemView, Context context) {
        super(itemView);
        assignViews(itemView);
        this.context = context;
    }


    private void assignViews(View itemView) {
        tv_iimname = (TextView) itemView.findViewById(R.id.textView_collagename);
        tv_street = (TextView) itemView.findViewById(R.id.textView_street);
        tv_city = (TextView) itemView.findViewById(R.id.textView_city);
        tv_state = (TextView) itemView.findViewById(R.id.textView_state);
        tv_pincode = (TextView) itemView.findViewById(R.id.textView_pincode);
        tv_emailid=(TextView)itemView.findViewById(R.id.textView_emailid);
        tv_cutoff=(TextView)itemView.findViewById(R.id.textView_cutoff);
        tv_isiim=(TextView)itemView.findViewById(R.id.textView_isiim);
        btn_website = (Button) itemView.findViewById(R.id.b2);
        btn_phnno = (Button) itemView.findViewById(R.id.b1);


    }

    public void bindInstitute(final Institute institute) {
        String streetAddress= institute.getStreet()+", "+ institute.getCity();
        tv_street.setText(streetAddress);
        tv_iimname.setText(institute.getName());
        //tv_street.setText(nonInstitute.getStreet());
        //tv_area.setText(nonInstitute.getArea());
        //tv_city.setText(nonInstitute.getCity());

        String statePin= institute.getState()+", "+ institute.getPincode();
        tv_state.setText(statePin);
        //tv_state.setText(nonInstitute.getState());
        //tv_pincode.setText(nonInstitute.getPincode());
        String email= institute.getEmailid()+","+ institute.getCutOff()+","+ institute.isIsIIM();
tv_emailid.setText(email);

        //btn website
        //btn_website.setText("Visit WebSite");
        btn_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = institute.getWebsite();
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.e("Exception Caught", e.toString());
                }
            }
        });

        //btn phone
        //btn_phnno.setText("Call");

        btn_phnno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phn = institute.getPhoneNo();
                try {

                    Intent sIntent = new Intent();
                    sIntent.setAction("android.intent.action.DIAL");
                    sIntent.setData(Uri.parse("tel:" + phn));
                    context.startActivity(sIntent);
                } catch (Exception e) {
                    Log.e("Exception Caught", e.toString());
                }
            }
        });
    }
}











