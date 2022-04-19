package com.test.sampleasynctask;

public interface OnEventListener<T> {
    void onSuccess(T object);
    void onFailure(Exception e);
}
