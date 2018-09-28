package com.example.beatriz.toyota;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UsersAdapters extends RecyclerView.Adapter<UsersAdapters.ViewHolder>{
    private Context context;
    private List<Users> list;

    public UsersAdapters(Context context, List<Users> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public UsersAdapters.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item_users, parent, false);
        return new UsersAdapters.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsersAdapters.ViewHolder holder, int position) {
        Users users = list.get(position);

        holder.textId.setText(users.getId());
        holder.textName.setText(users.getName());
        holder.textEmail.setText(users.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textId, textName, textEmail;

        public ViewHolder(View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.main_id);
            textName = itemView.findViewById(R.id.main_name);
            textEmail = itemView.findViewById(R.id.main_email);
        }
    }
}
