package com.hotsmall.belle;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.request.StringRequest;
import com.hotsmall.belle.adapter.BelleClassAdapter;
import com.hotsmall.belle.client.BelleClient;
import com.hotsmall.belle.model.BelleClass;
import com.hotsmall.belle.model.ResponseData;
import com.hotsmall.belle.service.BelleService;
import com.hotsmall.belle.util.GsonUtil;
import com.hotsmall.belle.util.RecyclerUtils;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    private SuperRecyclerView recyclerView;
    private BelleClassAdapter classAdapter;
    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBar();
        initView();
        getClasses();
    }

    private void initView() {
        recyclerView = (SuperRecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerUtils.RecyclerItemClickListener(this, new RecyclerUtils.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ImageListActivity.openImageListActivity(MainActivity.this, classAdapter.getData(position));
            }
        }));

        classAdapter = new BelleClassAdapter(this);
        classAdapter.setHasStableIds(true);
        recyclerView.setAdapter(classAdapter);
        adView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
    }

    public void getClasses() {
        StringRequest request = new StringRequest(Request.Method.GET
                , BelleService.API_CLASS
                , createReqSuccessListener()
                , createReqErrorListener());

        BelleClient.getRequestQueue().add(request);
    }

    private Response.Listener<String> createReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ResponseData<BelleClass> data= GsonUtil.classFrom(response);
                classAdapter.addData(data.tngou);
            }
        };
    }

    @Override
    public void initBar() {
        super.initBar();
        bar.setDisplayUseLogoEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adView!=null){
            adView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView!=null){
            adView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView!=null){
            adView.destroy();
        }
    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }

    @Override
    public void onRefresh() {

    }
}
