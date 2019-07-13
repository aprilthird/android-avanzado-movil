package pe.com.fdne.fdneandroid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.adapters.DisciplinesAdapter;
import pe.com.fdne.fdneandroid.models.Discipline;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingsFragment extends Fragment {
    RecyclerView disciplinesRecyclerView;
    DisciplinesAdapter disciplinesAdapter;
    RecyclerView.LayoutManager disciplinesLayoutManager;
    List<Discipline> disciplines;

    public RankingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rankings, container, false);
        disciplinesRecyclerView = (RecyclerView) view.findViewById(R.id.disciplinesRecyclerView);
        disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Salto", "Disciplina de Salto", "https://eqsol.com/file/2018/01/natasha-traurig-neil-jones-equestrian-donnate.jpg"));
        disciplines.add(new Discipline("Enduro", "Disciplina de Enduro", "https://www.discoverseabrook.com/wp-content/uploads/2017/02/rides-grid_link.jpg"));
        disciplines.add(new Discipline("Prueba Completa", "Disciplina de Prueba Completa", "https://haigpoint.com/images/dynamic/getImage.gif?ID=100993"));
        disciplines.add(new Discipline("Adiestramiento", "Disciplina de Adiestramiento", "https://www.williamwoods.edu/_files/images/MarketingPhotos/large-images/01.jpg"));
        disciplinesAdapter = new DisciplinesAdapter(disciplines);
        disciplinesLayoutManager = new LinearLayoutManager(view.getContext());
        disciplinesRecyclerView.setAdapter(disciplinesAdapter);
        disciplinesRecyclerView.setLayoutManager(disciplinesLayoutManager);
        return view;
    }

}
