package pe.com.fdne.fdneandroid.fragments;


import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.adapters.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SkidRightLayoutManager mSkidRightLayoutManager;
    private HomeAdapter homeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        List<String> imgs = new ArrayList<>();
        imgs.add("https://eqsol.com/file/2018/01/natasha-traurig-neil-jones-equestrian-donnate.jpg");
        imgs.add("https://www.discoverseabrook.com/wp-content/uploads/2017/02/rides-grid_link.jpg");
        imgs.add("https://haigpoint.com/images/dynamic/getImage.gif?ID=100993");
        imgs.add("https://www.williamwoods.edu/_files/images/MarketingPhotos/large-images/01.jpg");
        List<String> titles = new ArrayList<>();
        titles.add("Salto");
        titles.add("Enduro");
        titles.add("Prueba Completa");
        titles.add("Adiestramiento");
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Pone a prueba la capacidad del caballo para superar obstáculos de altura.");
        descriptions.add("Prueba de resistencia del caballo en un entorno difícil de caminar.");
        descriptions.add("Prueba mixta de las 3 disciplinas en una sola contienda.");
        descriptions.add("Mide la capacidad del jinete y el caballo para realizar maniebras riesgosas y de alto control.");
        homeAdapter = new HomeAdapter();
        homeAdapter.setTitles(titles);
        homeAdapter.setDescriptions(descriptions);
        homeAdapter.setImgs(imgs);
        mRecyclerView = view.findViewById(R.id.homeRecyclerView);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ViewGroup.LayoutParams params = mRecyclerView.getLayoutParams();
        params.height = (int)(size.y * 0.85);
        params.width = (int)(size.x * 1);
        mRecyclerView.setLayoutParams(params);
        mRecyclerView.setAdapter(homeAdapter);
        mSkidRightLayoutManager = new SkidRightLayoutManager(1.25f, 0.5f);
        mRecyclerView.setLayoutManager(mSkidRightLayoutManager);
        return view;
    }
}
