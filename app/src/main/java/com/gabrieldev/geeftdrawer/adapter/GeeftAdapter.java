package com.gabrieldev.geeftdrawer.adapter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gabrieldev.geeftdrawer.R;
import com.gabrieldev.geeftdrawer.model.Geeft;

import java.util.List;

/**
 * Created by oldboy on 08/01/16.
 */
public class GeeftAdapter extends RecyclerView.Adapter<GeeftAdapter.ViewHolder>{

    private List<Geeft> geefts;
    private int rowLayout;
    private Context mContext;

    public void setContext(Context context) {
        mContext = context;
    }

    public GeeftAdapter(List<Geeft> geefts, int rowLayout, Context context) {
        this.geefts = geefts;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflate a new view hierarchy from the specified xml resource.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);


    }

    //i need to specify the target because "getDrawable" is for lollipop build
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        Geeft geeft = geefts.get(i);
        viewHolder.getGeeftName().setText(geeft.getName());
        viewHolder.getGeefterName().setText(geeft.getGeefter());
        viewHolder.getGeeftDescription().setText(geeft.getDescription());
        viewHolder.getGeeftDescription().setSingleLine(true);
        viewHolder.getGeeftDescription().setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.setViewHolderContext(mContext);


//        viewHolder.mGeeftImage.setImageDrawable(mContext.getDrawable(geeft.getImageResourceId(mContext)));

    }

    @Override
    public int getItemCount() {
        return geefts == null ? 0 : geefts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mGeeftName;
        private TextView mGeefterName;
        private TextView mGeeftDescription;
        private ImageView mGeeftImage;
        private ImageButton mGeeftReservationButton;
        private Context mViewHolderContext;

        public void setViewHolderContext(Context viewHolderContext) {
            mViewHolderContext = viewHolderContext;
        }

        public TextView getGeeftName() {
            return mGeeftName;
        }


        public TextView getGeefterName() {
            return mGeefterName;
        }

        public TextView getGeeftDescription() {
            return mGeeftDescription;
        }


        public ImageView getGeeftImage() {
            return mGeeftImage;
        }


        public ImageButton getGeeftReservationButton() {
            return mGeeftReservationButton;
        }


        public ViewHolder(View itemView) {
            super(itemView);
            mGeeftName = (TextView) itemView.findViewById(R.id.geeft_name);
            mGeefterName = (TextView) itemView.findViewById(R.id.geefter_name);
            mGeeftDescription = (TextView) itemView.findViewById(R.id.geeft_description);
            mGeeftImage = (ImageView) itemView.findViewById(R.id.geeft_image);
            mGeeftReservationButton = (ImageButton) itemView.findViewById(R.id.geeft_like_reservation_button);



            //Every listened of the card , need to initialize here
            //Image Buttons///////////////
            mGeeftReservationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mViewHolderContext, "Reservation button to set", Toast.LENGTH_SHORT).show();
                    mGeeftReservationButton.setColorFilter(R.color.colorAccent);
                }
            });
            //////////////////////////////

            //Text Dialog/////////////////
            getGeefterName().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mViewHolderContext); //Read Update
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //here you can add functions
                        }
                    });

                    //On click, the user visualize can visualize some infos about the geefter
                    AlertDialog dialog = alertDialog.create();
                    dialog.setTitle(getGeefterName().getText());
                    dialog.setMessage("Some information that we can take from the facebook shared one");

                    dialog.show();  //<-- See This!
                }
            });
            //////////////////////////////

            //Text Expander///////////////
            mGeeftDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getGeeftDescription().setSingleLine(false);
                }
            });
            //////////////////////////////

        }

    }
}
