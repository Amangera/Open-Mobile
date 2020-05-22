package com.akash.open.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.akash.open.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    TextView aboutUsText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        aboutUsText = root.findViewById(R.id.DescText);
        aboutUsText.setText("The \"Open Source Practices to Educate Nation\" community was inaugurated on 18th Jan 2019 with the support of various global IT giants and organizations of repute including STPI, Xebia, IBM, TechMint. And with our offical association with The Linux Foundation, UPES became the first Asian University to be an Associate Member of Linux Foundation. OPEN is a budding platform form where UPES shall make its presence felt in Global Open Source Fraternity. We also were lucky to have motivation and praise from Mr Glyde Seepersad of the Linux Foundation over video.");
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
        //        textView.setText(s);
            }
        });


        return root;
    }
}
