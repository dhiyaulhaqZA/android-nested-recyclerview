package com.dhiyaulhaqza.dynamicrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dhiyaulhaqza.dynamicrecyclerview.adapter.OuterAdapter;
import com.dhiyaulhaqza.dynamicrecyclerview.model.Inner;
import com.dhiyaulhaqza.dynamicrecyclerview.model.Outer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private OuterAdapter outerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRv();
        showList();
    }

    private void showList() {
        List<Inner> inners = new ArrayList<>();
        inners.add(new Inner(R.mipmap.ic_launcher, "BarbaQ"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Lords Mobile"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Seal"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Honkai Impact 3"));
        inners.add(new Inner(R.mipmap.ic_launcher, "BarbaQ"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Lords Mobile"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Seal"));
        inners.add(new Inner(R.mipmap.ic_launcher, "Honkai Impact 3"));

        for (int i = 0; i < 100; i++) { // 2 * 100 = 200 outer
            outerAdapter.addOuter(new Outer("Premium", inners));
            outerAdapter.addOuter(new Outer("Recommended", inners));
        }
    }

    private void setupRv() {
        rvMain.setHasFixedSize(true);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        outerAdapter = new OuterAdapter();
        rvMain.setAdapter(outerAdapter);
    }
}
