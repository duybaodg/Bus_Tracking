package com.example.api_with_header.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_with_header.ListApplication;
import com.example.api_with_header.MainActivity;
import com.example.api_with_header.R;
import com.example.api_with_header.ScheduleFragmentAdapter;
import com.example.api_with_header.api.APIStaticService;
import com.example.api_with_header.objects.BusTrip;
import com.example.api_with_header.objects.Routes;
import com.example.api_with_header.objects.StopLocation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleFragment extends Fragment {
    private List<BusTrip> busTrips = new ArrayList<>();
    private EditText searchBox;
    private Button btnSearch;
    private List<StopLocation> listOfStopIdObject = new ArrayList<>();
    private List<StopLocation> listOfStopLocationGetFromAPI = new ArrayList<>();
    public ScheduleFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchBox = (EditText) view.findViewById(R.id.editText_search);
        btnSearch = (Button) view.findViewById(R.id.id_btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAPI();
            }
        });
    }
    public void callAPIGetStopLocation(String routeId) {
        APIStaticService.apiService2.callAPIStopLocation(routeId).enqueue(new Callback<List<StopLocation>>() {
            @Override
            public void onResponse(@NonNull Call<List<StopLocation>> call, @NonNull Response<List<StopLocation>> response) {
                if(response.isSuccessful()) {
                    listOfStopIdObject.clear();
                    listOfStopLocationGetFromAPI = response.body();
                    assert listOfStopLocationGetFromAPI != null;
                    for (StopLocation stopLocation : listOfStopLocationGetFromAPI) {
                        listOfStopIdObject.add(stopLocation);
                    }
                    updateRecyclerView();
                    Log.d("Fragment", "this is listOfStopIdObject Size: " +listOfStopIdObject.size());
                } else {
                    Log.e("Fail", "Error code at StopId API"+ response.code());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<StopLocation>> call, @NonNull Throwable throwable) {
                Log.e("Error network", "Network Error At Stop ID API "+ throwable.getMessage());
            }
        });
    }
public void runAPI() {
    String addOn = "0";
    String searchResult = searchBox.getText().toString().trim() + addOn;
    callAPIGetStopLocation(searchResult);
    }
    private void updateRecyclerView() {
        RecyclerView recyclerView = getView().findViewById(R.id.rcv_data_schedule);
        ScheduleFragmentAdapter scheduleFragmentAdapter = new ScheduleFragmentAdapter(listOfStopIdObject);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(scheduleFragmentAdapter);
        scheduleFragmentAdapter.notifyDataSetChanged();
    }
}