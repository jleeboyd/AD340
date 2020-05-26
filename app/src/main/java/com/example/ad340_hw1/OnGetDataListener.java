package com.example.ad340_hw1;

public interface OnGetDataListener<T> {
    //this is for callbacks
    void onSuccess(T dataResponse);
    void onFailure();
}
