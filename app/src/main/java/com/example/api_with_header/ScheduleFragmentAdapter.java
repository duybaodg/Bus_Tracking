package com.example.api_with_header;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_with_header.objects.BusTrip;
import com.example.api_with_header.objects.StopLocation;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragmentAdapter extends RecyclerView.Adapter<ScheduleFragmentAdapter.ScheduleViewHolder> {
    private List<StopLocation> stopLocations = new ArrayList<>();
    public ScheduleFragmentAdapter(List<StopLocation> stopLocations) {
        this.stopLocations = stopLocations;
    }
    @NonNull
    @Override
    public ScheduleFragmentAdapter.ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
        return new ScheduleFragmentAdapter.ScheduleViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ScheduleFragmentAdapter.ScheduleViewHolder holder, int position) {
        final StopLocation stopLocation = stopLocations.get(position);
        if(stopLocation == null) {
            return;
        }
        holder.tvScheduleId.setText(String.valueOf(stopLocation.getStop_id()));
        holder.tvScheduleRoute.setText(stopLocation.getStop_name());
    }
    @Override
    public int getItemCount() {
        Log.d("BusTrips Size", "Size" + stopLocations.size());
        return stopLocations.size();
    }
    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relativeLayout;
        private TextView tvScheduleId;
        private TextView tvScheduleRoute;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.schedule_item);
            tvScheduleId = itemView.findViewById(R.id.tv_scheduleId);
            tvScheduleRoute = itemView.findViewById(R.id.tv_schedule_route);
        }
    }
}
