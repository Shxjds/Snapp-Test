package com.snapp.dev.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snapp.dev.models.Product;
import com.snapp.dev.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewProductAdapter extends RecyclerView.Adapter<RecyclerViewProductAdapter.RecyclerViewHolder> {

    // creating a variable for our list and listener.
    private final List<Product> productList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    // creating a constructor class.
    public RecyclerViewProductAdapter(List<Product> recyclerDataArrayList) {
        this.productList = recyclerDataArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new RecyclerViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview from our modal class.
        Product item = productList.get(position);

        holder.title.setText(item.getName());
        holder.description.setText(item.getDescription());
        Picasso.get().load(item.getPicture_url()).fit().centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return productList.size();
    }

    // View Holder Class to handle Recycler View.
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private final TextView title, description;
        private final ImageView image;

        public RecyclerViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            // initializing our views with their ids.
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
