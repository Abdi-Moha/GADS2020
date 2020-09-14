package com.abdimoha.gads2020.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdimoha.gads2020.DataViewModel;
import com.abdimoha.gads2020.TopLearnersAdapter;
import com.abdimoha.gads2020.DataViewModel;
import com.abdimoha.gads2020.R;
import com.abdimoha.gads2020.TopLearnersAdapter;
import com.abdimoha.gads2020.model.TopLearner;

import java.util.List;
import java.util.Objects;

public class TopLearnerFragment extends Fragment {
    DataViewModel dataViewModel;

    public TopLearnerFragment() {
        //Empty Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_learner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.topLearnerRecyclerview);
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        dataViewModel.getTopLearner();
        //Pass the context (here it's fragment not activity) here that was created in our adapter constructor
        final TopLearnersAdapter adapter = new TopLearnersAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        dataViewModel.topLearnerMutableData.observe((LifecycleOwner) Objects.requireNonNull(getContext()), new Observer<List<TopLearner>>() {
            @Override
            public void onChanged(List<TopLearner> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}