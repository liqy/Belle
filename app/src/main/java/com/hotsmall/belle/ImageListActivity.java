package com.hotsmall.belle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.request.StringRequest;
import com.hotsmall.belle.adapter.BelleImageAdapter;
import com.hotsmall.belle.client.BelleClient;
import com.hotsmall.belle.model.BelleClass;
import com.hotsmall.belle.model.BelleGallery;
import com.hotsmall.belle.model.BelleImage;
import com.hotsmall.belle.model.ResponseData;
import com.hotsmall.belle.service.BelleService;
import com.hotsmall.belle.util.GsonUtil;
import com.hotsmall.belle.util.RecyclerUtils;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.orhanobut.logger.Logger;

public class ImageListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {
    private SuperRecyclerView recyclerView;
    private BelleImageAdapter imageAdapter;
    private BelleClass belleClass;
    private int currentPage = 1;

    public static void openImageListActivity(Activity activity, BelleClass belleClass) {
        Intent intent = new Intent(activity, ImageListActivity.class);
        intent.putExtra("BelleClass", belleClass);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        belleClass = getIntent().getParcelableExtra("BelleClass");
        initBar();
        initView();
        getNews(currentPage);
    }

    @Override
    public void initBar() {
        super.initBar();
        bar.setTitle(belleClass.getTitle());
        bar.setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        recyclerView = (SuperRecyclerView) findViewById(R.id.list);
        recyclerView.setOnMoreListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addOnItemTouchListener(new RecyclerUtils.RecyclerItemClickListener(this, new RecyclerUtils.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ImageGalleryActivity.openImageGalleryActivity(ImageListActivity.this, imageAdapter.getImage(position));
            }
        }));

        imageAdapter = new BelleImageAdapter(this);
        imageAdapter.setHasStableIds(true);
        recyclerView.setAdapter(imageAdapter);
    }

    public void getNews(int page) {
        StringRequest request = new StringRequest(Request.Method.GET
                , String.format(BelleService.API_LIST, belleClass.getId(), page)
                , createReqSuccessListener(page)
                , createReqErrorListener());

        BelleClient.getRequestQueue().add(request);
    }

    private Response.Listener<String> createReqSuccessListener(final int page) {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ResponseData<BelleImage> data = GsonUtil.imageFrom(response);
                if (page == 1) {
                    imageAdapter.clear();
                }
                imageAdapter.addData(data.tngou);
                if (data.total==imageAdapter.getItemCount()){
                    recyclerView.removeMoreListener();
                }
            }
        };
    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
        currentPage++;
        getNews(currentPage);
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        getNews(currentPage);
    }
}
