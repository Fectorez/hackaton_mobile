package com.example.chewbs.alloheroproject.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chewbs.alloheroproject.R;
import com.example.chewbs.alloheroproject.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociationUserListAdapter extends RecyclerView.Adapter<AssociationUserListAdapter.ViewHolder> {

    private List<User> heroesList;
    private Listener listener;

    public AssociationUserListAdapter(List<User> userList) {
        this.heroesList = userList;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user = heroesList.get(position);
        holder.firstname.setText(user.getFirstname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null) {
                    listener.onHeroClick(user);
                }
            }
        });
    }

    @Override public int getItemCount() {
        return heroesList == null ? 0 : heroesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_firstname)
        TextView firstname;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface Listener {
        void onHeroClick(User user);
    }
}