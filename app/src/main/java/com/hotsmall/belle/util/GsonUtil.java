package com.hotsmall.belle.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hotsmall.belle.model.BelleClass;
import com.hotsmall.belle.model.BelleImage;
import com.hotsmall.belle.model.ResponseData;

public class GsonUtil {

	public static <T> T from(String str, Class<T> t) {
		Gson gson = new Gson();
		return gson.fromJson(str, t);
	}

	public static ResponseData<BelleImage> imageFrom(String str) {
		Gson gson = new Gson();
		return gson.fromJson(str, new TypeToken<ResponseData<BelleImage>>() {
		}.getType());
	}

	public static ResponseData<BelleClass> classFrom(String str) {
		Gson gson = new Gson();
		return gson.fromJson(str, new TypeToken<ResponseData<BelleClass>>() {
		}.getType());
	}



}