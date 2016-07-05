package com.metis.avinash.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.metis.avinash.Models.PostModel;
import com.metis.avinash.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash on 7/4/16.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.RecyclerHolder> {
    public interface OnItemClickListener {
        void onItemClick(PostModel item, int position);
    }
    private final OnItemClickListener listener;
    private List<PostModel> postModels;

    public PostAdapter(List<PostModel> postModels, OnItemClickListener listener) {
        this.postModels = postModels;
        this.listener = listener;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,parent,false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.bind(postModels.get(position), listener, position);
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{



        TextView user,title,content;

        public RecyclerHolder(View itemView) {
            super(itemView);

            user = (TextView) itemView.findViewById(R.id.tv_user);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            content = (TextView) itemView.findViewById(R.id.tv_content);
        }

        public void bind(final PostModel item, final OnItemClickListener listener, final int position) {

            user.setText(item.user);
            title.setText(item.title);
            content.setText(item.content);

            itemView.setOnClickListener(new View.OnClickListener() {


                @Override public void onClick(View v) {
                    listener.onItemClick(item,position);

                }
            });
        }
    }
}

