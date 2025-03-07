package com.example.myapplication;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private String imageUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void clearImageUrl() {
        imageUrl = null;
    }
}
