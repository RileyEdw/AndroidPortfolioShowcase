package com.example.rileyshowcasefinal.ui.MadLibs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MadLibsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MadLibsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}