package com.akash.open.ui;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akash.open.R;

public class OurVisionFragment extends Fragment {

    private OurVisionViewModel mViewModel;
    TextView visionText;

    public static OurVisionFragment newInstance() {
        return new OurVisionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.our_vision_fragment, container, false);
        visionText = root.findViewById(R.id.paraText);
        visionText.setText("\u2022 Shaping the future of Academia & Industry with Open Source practices. \n" +
                "\u2022 To promote and protect Open Source Software. \n" +
                "\u2022 To enrich the Education sector with innovative ideas. \n" +
                "\u2022 To educate the nation about open source development with various technical activities. \n" +
                "\u2022 To provide a platform that minimizes the gap between academy and industry. \n" +
                "\u2022 To enhance extraneous growth of the country through Open Source technologies. ");


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OurVisionViewModel.class);
        // TODO: Use the ViewModel
    }

}
