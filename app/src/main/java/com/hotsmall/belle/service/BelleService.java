package com.hotsmall.belle.service;


/**
 * Created by liqy on 16/1/16.
 */
public class BelleService {
    public static final String API_URL = "http://www.tngou.net/tnfs/api";
    public static final String IMAGE_URL = "http://tnfs.tngou.net/image";
    public static final String API_NEWS_ID = API_URL + "/news?id=%1$s&rows=20";
    public static final String API_SHOW_ID = API_URL + "/show?id=%1$s";
    public static final String API_NEWS_ID_CLASS = API_URL + "/news?id=%1$s&classify=%2$s&rows=20";
    public static final String API_CLASS = API_URL + "/classify";
    public static final String API_LIST = API_URL + "/list?id=%1$s&page=%2$s&rows=20";
}
