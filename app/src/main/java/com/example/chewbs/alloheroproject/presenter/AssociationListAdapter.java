package com.example.chewbs.alloheroproject.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.Association;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociationListAdapter extends RecyclerView.Adapter<AssociationListAdapter.ViewHolder> {

    private List<Association> asksList;
    private Listener listener;

    public AssociationListAdapter(List<Association> associationList) {
        this.asksList = associationList;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_association, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Association association = asksList.get(position);
        holder.association_name.setText(association.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null) {
                    listener.onAskClick(association);
                }
            }
        });
    }

    @Override public int getItemCount() {
        return asksList == null ? 0 : asksList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.association_name)
        TextView association_name;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface Listener {
        void onAskClick(Association association);
    }
}