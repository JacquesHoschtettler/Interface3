package com.hoschtettler.jacques.interface3.Controllers.Fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hoschtettler.jacques.interface3.Models.CommunicationViewModel;
import com.hoschtettler.jacques.interface3.Models.Favorites;
import com.hoschtettler.jacques.interface3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends ListFragment
{

    private CommunicationViewModel mChoisedUrl ;

    public FragmentA()
    { }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState) ;
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.prototype,
                Favorites.SitesNames);
        setListAdapter(adapter );
    }


    @Override
    public void onStart()
    {
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.display_sites_url) !=null)
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mChoisedUrl = ViewModelProviders.of(getActivity()).get(CommunicationViewModel.class);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        mChoisedUrl.setChoisedUrl(position);
        getListView().setItemChecked(position, true);
    }

}
