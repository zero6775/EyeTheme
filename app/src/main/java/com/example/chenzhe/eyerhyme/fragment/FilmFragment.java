package com.example.chenzhe.eyerhyme.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ViewFlipper;

import com.example.chenzhe.eyerhyme.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment {


    @Bind(R.id.viewFlipper)
    ViewFlipper viewFlipper;
    private Animation slideLeftIn;
    private Animation slideLeftOut;
    private Animation slideRightIn;
    private Animation slideRightOut;

    public FilmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        ButterKnife.bind(this, view);
        slideLeftIn = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_left_in);
        slideLeftOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_left_out);
        slideRightIn = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_right_in);
        slideRightOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_right_out);
        init();
        return view;
    }

    private void init() {
        initViewFlipper();
    }

    private void initViewFlipper() {
        viewFlipper.setInAnimation(slideLeftIn);
        viewFlipper.setOutAnimation(slideLeftOut);
        viewFlipper.startFlipping();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
