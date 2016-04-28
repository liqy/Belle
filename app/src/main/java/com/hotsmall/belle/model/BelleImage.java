package com.hotsmall.belle.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hotsmall.belle.service.BelleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqy on 16/1/16.
 */
public class BelleImage implements Parcelable {

    /**
     * count : 1252
     * fcount : 0
     * galleryclass : 3
     * id : 1
     * img : /ext/150714/aeb85cdb34f325ccfb3ae0928f846d2d.jpg
     * rcount : 0
     * size : 18
     * time : 1436874237000
     * title : 絕對吸引眼球的超級美腿
     */

    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private int rcount;
    private int size;
    private long time;
    private String title;
    private ArrayList<BelleGallery> list;

    @Override
    public String toString() {
        return "BelleImage{" +
                "count=" + count +
                ", fcount=" + fcount +
                ", galleryclass=" + galleryclass +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", rcount=" + rcount +
                ", size=" + size +
                ", time=" + time +
                ", title='" + title + '\'' +
                '}';
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public int getFcount() {
        return fcount;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return BelleService.IMAGE_URL + img;
    }

    public int getRcount() {
        return rcount;
    }

    public int getSize() {
        return size;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<BelleGallery> getList() {
        return list;
    }

    public void setList(ArrayList<BelleGallery> list) {
        this.list = list;
    }

    public BelleImage() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeInt(this.fcount);
        dest.writeInt(this.galleryclass);
        dest.writeInt(this.id);
        dest.writeString(this.img);
        dest.writeInt(this.rcount);
        dest.writeInt(this.size);
        dest.writeLong(this.time);
        dest.writeString(this.title);
        dest.writeList(this.list);
    }

    protected BelleImage(Parcel in) {
        this.count = in.readInt();
        this.fcount = in.readInt();
        this.galleryclass = in.readInt();
        this.id = in.readInt();
        this.img = in.readString();
        this.rcount = in.readInt();
        this.size = in.readInt();
        this.time = in.readLong();
        this.title = in.readString();
        this.list = new ArrayList<BelleGallery>();
        in.readList(this.list, List.class.getClassLoader());
    }

    public static final Creator<BelleImage> CREATOR = new Creator<BelleImage>() {
        public BelleImage createFromParcel(Parcel source) {
            return new BelleImage(source);
        }

        public BelleImage[] newArray(int size) {
            return new BelleImage[size];
        }
    };
}
