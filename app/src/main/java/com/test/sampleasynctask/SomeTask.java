package com.test.sampleasynctask;

import android.content.Context;
import android.os.AsyncTask;

public class SomeTask extends AsyncTask<Void, Void, String> {

    private OnEventListener<String> mCallBack;
    private Context mContext;
    public Exception mException;

    public SomeTask(Context context, OnEventListener callback) {
        mCallBack = callback;
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            // todo try to do something dangerous
            return "HELLO";

        } catch (Exception e) {
            mException = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (mCallBack != null) {
            if (mException == null) {
                mCallBack.onSuccess(result);
            } else {
                mCallBack.onFailure(mException);
            }
        }
    }
}
