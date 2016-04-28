package com.hotsmall.belle.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liqy on 16/1/17.
 */
public class BelleClass implements Parcelable {

    /**
     * description : 性感美女
     * id : 1
     * keywords : 性感美女
     * name : 性感美女
     * seq : 1
     * title : 性感美女
     */

    private String description;
    private int id;
    private String keywords;
    private String name;
    private int seq;
    private String title;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getName() {
        return name;
    }

    public int getSeq() {
        return seq;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeInt(this.id);
        dest.writeString(this.keywords);
        dest.writeString(this.name);
        dest.writeInt(this.seq);
        dest.writeString(this.title);
    }

    public BelleClass() {
    }

    protected BelleClass(Parcel in) {
        this.description = in.readString();
        this.id = in.readInt();
        this.keywords = in.readString();
        this.name = in.readString();
        this.seq = in.readInt();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<BelleClass> CREATOR = new Parcelable.Creator<BelleClass>() {
        public BelleClass createFromParcel(Parcel source) {
            return new BelleClass(source);
        }

        public BelleClass[] newArray(int size) {
            return new BelleClass[size];
        }
    };
}
