package com.bookstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingVH> {


    List<SettingsClass> settingsClassList;

    public SettingsAdapter(List<SettingsClass> settingsClassList){
        this.settingsClassList=settingsClassList;
    }

    @NonNull
    @Override
    public SettingVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new SettingVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingVH holder, int position) {
        SettingsClass settingsClass = settingsClassList.get(position);
        holder.settingNameTxt.setText(settingsClass.getSettingName());
        holder.detailTxt.setText(settingsClass.getDetails());

        boolean isExpandable = settingsClassList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return settingsClassList.size();
    }

    public class SettingVH extends RecyclerView.ViewHolder {

        TextView settingNameTxt, detailTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public SettingVH(@NonNull View itemView) {
            super(itemView);

            settingNameTxt = itemView.findViewById(R.id.settingName);
            detailTxt = itemView.findViewById(R.id.details);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SettingsClass settingsClass = settingsClassList.get(getAdapterPosition());
                    settingsClass.setExpandable(!settingsClass.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
