package com.hotsmall.belle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.request.StringRequest;
import com.daprlabs.cardstack.SwipeDeck;
import com.hotsmall.belle.adapter.SwipeDeckAdapter;
import com.hotsmall.belle.client.BelleClient;
import com.hotsmall.belle.model.BelleImage;
import com.hotsmall.belle.service.BelleService;
import com.hotsmall.belle.util.GsonUtil;
import com.hotsmall.belle.util.Utils;
import com.orhanobut.logger.Logger;

public class ImageGalleryActivity extends BaseActivity {

    public static void openImageGalleryActivity(Activity activity, BelleImage belleImage) {
        Intent intent = new Intent(activity, ImageGalleryActivity.class);
        intent.putExtra("BelleImage", belleImage);
        activity.startActivity(intent);
    }

    private SwipeDeck cardStack;
    BelleImage image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);
        image = getIntent().getParcelableExtra("BelleImage");
        initBar();
        initView();
        show();
    }

    @Override
    public void initBar() {
        super.initBar();
        bar.setTitle(image.getTitle());
        bar.setDisplayHomeAsUpEnabled(true);
    }

    public void initView() {
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        ViewGroup.LayoutParams params = cardStack.getLayoutParams();
        DisplayMetrics dm = Utils.getDisplayMetrics(this);
        params.height = dm.heightPixels - Utils.dip2px(this, 88);
        cardStack.setLayoutParams(params);
    }

    void show() {
        StringRequest request = new StringRequest(Request.Method.GET
                , String.format(BelleService.API_SHOW_ID, image.getId())
                , createReqSuccessListener()
                , createReqErrorListener());

        BelleClient.getRequestQueue().add(request);
    }

    private Response.Listener<String> createReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Logger.json(response);
                BelleImage belleImage = GsonUtil.from(response, BelleImage.class);
                final SwipeDeckAdapter adapter = new SwipeDeckAdapter(ImageGalleryActivity.this, belleImage.getList());
                cardStack.setAdapter(adapter);
            }
        };
    }


}
