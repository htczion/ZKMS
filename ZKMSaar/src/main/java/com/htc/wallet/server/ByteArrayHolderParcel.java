package com.htc.wallet.server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shihshi-mac on 2019/1/23.
 */
public class ByteArrayHolderParcel implements Parcelable {
    private static final int DEFAULT_ARRAY_SIZE = 2 * 1024; // 2KB
    public int receivedLength;
    public byte[] byteArray;


    public ByteArrayHolderParcel() {
        receivedLength = 0;
        byteArray = new byte[DEFAULT_ARRAY_SIZE];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(receivedLength);
        out.writeByteArray(byteArray);
    }

    private ByteArrayHolderParcel(Parcel in) {
        readFromParcel(in);
    }

    protected void readFromParcel(Parcel in) {
        try {
            receivedLength = in.readInt();
            byteArray = new byte[receivedLength];
            in.readByteArray(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementation of Parcelable
     */
    public static final Creator<ByteArrayHolderParcel> CREATOR = new Creator<ByteArrayHolderParcel>() {
        public ByteArrayHolderParcel createFromParcel(Parcel in) {
            return new ByteArrayHolderParcel(in);
        }

        public ByteArrayHolderParcel[] newArray(int size) {
            return new ByteArrayHolderParcel[size];
        }
    };
}
