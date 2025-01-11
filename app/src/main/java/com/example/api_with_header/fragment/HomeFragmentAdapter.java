package com.example.api_with_header.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_with_header.IClickItemUserListener;
import com.example.api_with_header.R;
import com.example.api_with_header.objects.BusTrip;
import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.BusViewHolder> {
    private List<BusTrip> busTrips;
    private final IClickItemUserListener iClickItemUserListener;
    public HomeFragmentAdapter(List<BusTrip> busTrips, IClickItemUserListener listener) {
        this.busTrips = busTrips;
        this.iClickItemUserListener = listener;
    }
    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_item, parent, false);
        return new BusViewHolder(view, iClickItemUserListener, busTrips);
    }
    @Override
    public void onBindViewHolder(@NonNull BusViewHolder holder, int position) {
        final BusTrip route = busTrips.get(position);
        if(route == null) {
            return;
        }
        holder.tvBusId.setText(route.getBusIdName());
        holder.tvBusRoute.setText(route.getBusRoutine());
    }
    @Override
    public int getItemCount() {
        Log.d("BusTrips Size", "Size" + busTrips.size());
        return busTrips.size();
    }
    public static class BusViewHolder extends RecyclerView.ViewHolder {
            private RelativeLayout relativeLayout;
            private TextView tvBusId;
            private TextView tvBusRoute;
        public BusViewHolder(@NonNull View itemView, IClickItemUserListener listener, List<BusTrip> busTrips) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.layout_item);
            tvBusId = itemView.findViewById(R.id.tv_busId);
            tvBusRoute = itemView.findViewById(R.id.tv_busRoute);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClickBusItem(busTrips.get(position));
                    } else {
                        Log.d("Error Somewhere", "Please check");
                    }
                }
            });

        }
    }
}
