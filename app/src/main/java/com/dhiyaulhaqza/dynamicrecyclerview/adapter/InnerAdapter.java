package com.dhiyaulhaqza.dynamicrecyclerview.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhiyaulhaqza.dynamicrecyclerview.R;
import com.dhiyaulhaqza.dynamicrecyclerview.model.Inner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhiyaulhaqza on 1/7/18.
 */

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ViewHolder> {

    private Context context;
    private List<Inner> innerList;

    public InnerAdapter() {
        innerList = new ArrayList<>();
    }

    public void addInner(List<Inner> inners) {
        innerList.clear();
        innerList.addAll(inners);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_inner_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return innerList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.img_inner_content)
        ImageView imgContent;
        @BindView(R.id.tv_inner_content)
        TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            Inner inner = innerList.get(position);
            if (inner != null) {
                imgContent.setImageDrawable(ContextCompat.getDrawable(context, inner.getDrawableId()));
                tvContent.setText(inner.getName());
            }
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, tvContent.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
