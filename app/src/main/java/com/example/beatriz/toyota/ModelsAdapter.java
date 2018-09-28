package com.example.beatriz.toyota;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ModelsAdapter extends RecyclerView.Adapter<ModelsAdapter.ViewHolder> {

        private Context context;
        private List<Models> list;

    public ModelsAdapter(Context context, List<Models> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Models models = list.get(position);

            holder.textName.setText(models.getName());
            holder.textPower.setText(models.getPower());
            holder.textFuel.setText(models.getFuel());
            holder.textPrice.setText(models.getPrice());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textName, textPower, textFuel, textPrice;

            public ViewHolder(View itemView) {
                super(itemView);

                textName = itemView.findViewById(R.id.main_name);
                textPower = itemView.findViewById(R.id.main_power);
                textFuel = itemView.findViewById(R.id.main_fuel);
                textPrice = itemView.findViewById(R.id.main_price);
            }
        }

    }
