package com.akash.open.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.akash.open.LoginActivity;
import com.akash.open.MainActivity;
import com.akash.open.R;
import com.akash.open.SliderAdapterExample;
import com.akash.open.SliderItem;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewFlipper v_flipper;
    Button memberLogin;
    Button knowMore;
    FirebaseAuth mAuth;

    private SliderAdapterExample adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        int images[] = {R.drawable.g4 , R.drawable.g5 };

        mAuth = FirebaseAuth.getInstance();


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.nav_home_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView textView2 = root.findViewById(R.id.text_home2);
        v_flipper = root.findViewById(R.id.v_flipper);
        knowMore = (Button)root.findViewById(R.id.buttonKnowMore);
        memberLogin = (Button)root.findViewById(R.id.buttonMemberLogin);

        if(mAuth.getCurrentUser() == null){
            knowMore.setVisibility(View.GONE);
        }else {
            memberLogin.setVisibility(View.GONE);
        }
        knowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        memberLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(root.getContext() , LoginActivity.class));
            }
        });

        for(int i = 0; i< images.length ; i++){
            flipperImages(images[i]);
        }

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("In Association with :");
                textView2.setText("AWARE | ADOPT | CONTRIBUTE");
            }
        });

        ImageView github = (ImageView) root.findViewById(R.id.github);
        ImageView insta = (ImageView) root.findViewById(R.id.InstaLogo);
        ImageView fb = (ImageView)root.findViewById(R.id.facebook);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/upes-open";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(root.getContext(), "Work in Progress :)", Toast.LENGTH_SHORT).show();
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/_o.p.e.n_/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



        return root;
    }


    public void flipperImages(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);

    }
}
