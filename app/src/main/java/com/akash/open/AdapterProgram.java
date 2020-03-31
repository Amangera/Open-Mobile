package com.akash.open;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.StringBufferInputStream;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProgram extends RecyclerView.Adapter<AdapterProgram.ProgramViewHolder>{

    private  String[] userNameData;



    public AdapterProgram(String[] data ){
        this.userNameData = data;

    }


    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_item,viewGroup,false);

        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {
        String name = userNameData[i];


//        programViewHolder.textView.setText(name);


       // if(imageStatusT == 0){programViewHolder.imgview.setImageResource(R.drawable.bulebutton); }
       // else if(imageStatusT == 1){programViewHolder.imgview.setImageResource(R.drawable.yellowbutton); }
        //else if(imageStatusT == 2){programViewHolder.imgview.setImageResource(R.drawable.greenbutton); }
    }

    @Override
    public int getItemCount() {
        return  userNameData.length;
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);

          //  imgview = (ImageView) itemView.findViewById(R.id.statusImageView);
          //  textView = (TextView) itemView.findViewById(R.id.textView);
          //  textDataView = (TextView) itemView.findViewById(R.id.textView2);
         //   textAddressView = (TextView) itemView.findViewById(R.id.AddressTextView);
         //   textStatusView = (TextView) itemView.findViewById(R.id.statusView);

        }
    }
}
