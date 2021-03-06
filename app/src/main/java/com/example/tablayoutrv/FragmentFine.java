package com.example.tablayoutrv;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentFine extends Fragment {


    View view;
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fine_fragment, container, false);

        ArrayList<Fine_ActivitiesItem> examplelist = new ArrayList<>();



        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));
        examplelist.add(new Fine_ActivitiesItem("Java","12457","shreyansh","08/03/2019","30/06/2019"));


        mrecyclerView = view.findViewById(R.id.issue_recyclerview);
        mrecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        madapter = new Fine_ActivitiesAdapter(examplelist);

        mrecyclerView.setLayoutManager(mlayoutManager);
        mrecyclerView.setAdapter(madapter);


        return view;
    }

}
