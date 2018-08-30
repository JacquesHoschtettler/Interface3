package com.hoschtettler.jacques.interface3.Controllers.Fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;

import com.hoschtettler.jacques.interface3.Models.CommunicationViewModel;
import com.hoschtettler.jacques.interface3.Models.Favorites;
import com.hoschtettler.jacques.interface3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment
{

    public final static String ARG_POSITION = "position" ;
    CommunicationViewModel mPosition ;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_b, container, false) ;
        if (savedInstanceState != null)
        {
            mPosition.setChoisedUrl(savedInstanceState.getInt(ARG_POSITION)) ;
        }
        view.setBackgroundColor(getResources().getColor(R.color.text_color_2));
        return view ;

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mPosition = ViewModelProviders.of(getActivity()).get(CommunicationViewModel.class) ;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Bundle args = getArguments() ;
        if (mPosition != null)
        {
            updateSiteView(mPosition.getChoisedUrl());
        }

    }

    public void updateSiteView(int position)
    {
        if (position != -1)
        {
            WebView siteView = (WebView) getActivity().findViewById(R.id.site_web_view);
            siteView.loadUrl(Favorites.SitesURL[position]);
        }

    }

    @Override
    public  void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mPosition.getChoisedUrl());
    }

}
