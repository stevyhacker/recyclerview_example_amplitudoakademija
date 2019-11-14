package me.amplitudo.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

class Planet implements Parcelable {

    private String name;
    private String image;
    private int viewType;

    Planet(String name, String image, int viewType) {
        this.name = name;
        this.image = image;
        this.viewType = viewType;
    }

    protected Planet(Parcel in) {
        name = in.readString();
        image = in.readString();
        viewType = in.readInt();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeInt(viewType);
    }
}
