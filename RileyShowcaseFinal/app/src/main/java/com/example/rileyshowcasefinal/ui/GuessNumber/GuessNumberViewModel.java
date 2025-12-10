package com.example.rileyshowcasefinal.ui.GuessNumber;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuessNumberViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GuessNumberViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}