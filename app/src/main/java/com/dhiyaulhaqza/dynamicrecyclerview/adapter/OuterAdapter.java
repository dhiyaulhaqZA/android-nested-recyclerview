package com.dhiyaulhaqza.dynamicrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhiyaulhaqza.dynamicrecyclerview.R;
import com.dhiyaulhaqza.dynamicrecyclerview.model.Outer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhiyaulhaqza on 1/7/18.
 */

public class OuterAdapter extends RecyclerView.Adapter<OuterAdapter.ViewHolder> {

    private final RecyclerView.RecycledViewPool recycledViewPool;
    private Context context;
    private List<Outer> outerList;

    public OuterAdapter() {
        outerList = new ArrayList<>();
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    public void addOuter(Outer outer) {
        outerList.add(outer);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_outer_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.rvOuter.setRecycledViewPool(recycledViewPool);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return outerList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_outer_category)
        TextView tvCategory;
        @BindView(R.id.rv_outer)
        RecyclerView rvOuter;
        private InnerAdapter innerAdapter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setupRv();
        }

        private void setupRv() {
            rvOuter.setHasFixedSize(true);
            rvOuter.setLayoutManager(new GridLayoutManager(context, 4));
            innerAdapter = new InnerAdapter();
            rvOuter.setAdapter(innerAdapter);
        }

        public void bind(int position) {
            Outer outer = outerList.get(position);
            if (outer != null) {
                tvCategory.setText(outer.getName());
                innerAdapter.addInner(outer.getGames());
            }
        }
    }
}
