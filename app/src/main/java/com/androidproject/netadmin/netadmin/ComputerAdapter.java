package com.androidproject.netadmin.netadmin;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidproject.netadmin.netadmin.Utils.State;
import com.androidproject.netadmin.netadmin.model.Color;
import com.androidproject.netadmin.netadmin.model.Computer;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

/**
 * Created by Anna Kopeliovich on 18.12.2016.
 */

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ComputerViewHolder> {
    private final Context context;
    private final LayoutInflater layoutInflater;

    @NonNull
    private List<Computer> devices = Collections.emptyList();

    public ComputerAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setComputers(@NonNull List<Computer> devices) {
        this.devices = devices;
        notifyDataSetChanged();
    }

    @Override
    public ComputerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ComputerViewHolder.newInstance(layoutInflater, parent);
    }

    public int intOfColor(Color color) {
        switch (color) {
            case GOOD:
                return R.color.colorGood;
            case BAD:
                return R.color.colorBad;
            case FAIL:
                return R.color.colorFail;
            case WAIT:
                return R.color.colorWait;
        }
        return 0;
    }



    @Override
    public void onBindViewHolder(ComputerViewHolder holder, int position) {
        final Computer computer = devices.get(position);
        holder.numberView.setText(Integer.toString(computer.getId()));
        holder.nameView.setText(computer.getName());
        holder.ipView.setText(computer.getIP());
        State state = computer.getState();
        holder.stateView.setText(state.toString());
        holder.itemsView.setBackgroundColor(context.getResources().getColor(intOfColor(computer.getColor())));
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public static class ComputerViewHolder extends RecyclerView.ViewHolder {

        final TextView numberView;
        final TextView nameView;
        final TextView ipView;
        final TextView stateView;
        final LinearLayout itemsView;

        private ComputerViewHolder(View itemView) {
            super(itemView);
            numberView = (TextView) itemView.findViewById(R.id.Number);
            nameView = (TextView) itemView.findViewById(R.id.Name);
            ipView = (TextView) itemView.findViewById(R.id.IP);
            stateView = (TextView) itemView.findViewById(R.id.State);
            itemsView = (LinearLayout) itemView.findViewById(R.id.Items);

        }

        static ComputerViewHolder newInstance(LayoutInflater layoutInflater, ViewGroup parent) {
            final View view = layoutInflater.inflate(R.layout.item_computer, parent, false);
            return new ComputerViewHolder(view);
        }
    }
}
