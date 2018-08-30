package com.hoschtettler.jacques.interface3.Models;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CommunicationViewModel extends ViewModel
{
    public MutableLiveData<Integer> mChoisedUrl = new MutableLiveData<>() ;

    public void setChoisedUrl(int choisedUrl)
    {
        this.mChoisedUrl.setValue(choisedUrl);
    }

    public int getChoisedUrl()
    {
        return this.mChoisedUrl.getValue();
    }
}
