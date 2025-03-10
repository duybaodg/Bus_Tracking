package com.example.api_with_header.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api_with_header.DetailsActivity;
import com.example.api_with_header.objects.ListOfData;
import com.example.api_with_header.R;
import com.example.api_with_header.objects.BusTrip;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements IClickItemUserListener {
    private List<BusTrip> busTrips = new ArrayList<>();
    public HomeFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpData();
    }
    @Override
    public void onClickBusItem(BusTrip busTrip) {
        Intent intent = new Intent(requireContext(), DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("sendData",busTrip);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void setUpData () {
        RecyclerView recyclerView = requireView().findViewById(R.id.rcv_data);
        busTrips.clear();
        ListOfData listOfData = (ListOfData) requireActivity().getApplication();
        busTrips = listOfData.getListOfBusTrips();
        HomeFragmentAdapter homeFragmentAdapter = new HomeFragmentAdapter(busTrips, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeFragmentAdapter);
        homeFragmentAdapter.notifyDataSetChanged();
    }
}