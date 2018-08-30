package com.hoschtettler.jacques.interface3.Controllers.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.webkit.WebView;

import com.hoschtettler.jacques.interface3.Controllers.Fragments.FragmentA;
import com.hoschtettler.jacques.interface3.Controllers.Fragments.FragmentB;
import com.hoschtettler.jacques.interface3.Models.CommunicationViewModel;
import com.hoschtettler.jacques.interface3.Models.Favorites;
import com.hoschtettler.jacques.interface3.R;

import static com.hoschtettler.jacques.interface3.Controllers.Fragments.FragmentB.ARG_POSITION;

public class MainActivity extends FragmentActivity
{
    private CommunicationViewModel mChoisedUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CommunicationViewModel mChoisedUrl = ViewModelProviders.of(this)
                .get(CommunicationViewModel.class) ;

        if (findViewById(R.id.display_one_fragment) != null)
        {
            if (savedInstanceState != null)
            {
                return;
            }
            FragmentA listeSites = new FragmentA() ;
            listeSites.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.display_one_fragment, listeSites)
                    .commit() ;
        }

        mChoisedUrl.setChoisedUrl(-1);
        mChoisedUrl.mChoisedUrl.observe(this, new Observer<Integer>()
        {
            @Override
            public void onChanged(@Nullable Integer position)
            {
                FragmentB siteView = (FragmentB) getSupportFragmentManager()
                        .findFragmentById(R.id.display_sites_url);
                if (siteView != null)
                {
                    siteView.updateSiteView(position);
                }
                else
                {
                    FragmentB newSiteView = new FragmentB() ;

                    Bundle args = new Bundle() ;
                    args.putInt(FragmentB.ARG_POSITION, position);
                    newSiteView.setArguments(args);

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction() ;
                    transaction.replace(R.id.display_one_fragment, newSiteView) ;
                    transaction.addToBackStack(null);
                    transaction.commit() ;
                }
            }
        });
    }


}
