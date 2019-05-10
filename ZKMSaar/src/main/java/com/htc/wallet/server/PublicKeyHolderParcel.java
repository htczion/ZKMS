package com.htc.wallet.server;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by shihshi-mac on 2019/1/23.
 */
public class PublicKeyHolderParcel implements Parcelable {

    public String mPublicKey;
    public String mKeyPath;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flag) {
        out.writeString(mPublicKey);
        out.writeString(mKeyPath);
    }

    public PublicKeyHolderParcel()
    {
        mPublicKey = null;
        mKeyPath = null;
    }

    private PublicKeyHolderParcel(Parcel in) {
        readFromParcel(in);
    }

    protected void readFromParcel(Parcel in) {

        try {
            mPublicKey = in.readString();
            mKeyPath = in.readString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementation of Parcelable
     */
    public static final Creator<PublicKeyHolderParcel> CREATOR = new Creator<PublicKeyHolderParcel>() {
        public PublicKeyHolderParcel createFromParcel(Parcel in) {
            return new PublicKeyHolderParcel(in);
        }

        public PublicKeyHolderParcel[] newArray(int size) {
            return new PublicKeyHolderParcel[size];
        }
    };
}
