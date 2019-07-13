package pe.com.fdne.fdneandroid.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.adapters.BinomialsAdapter;
import pe.com.fdne.fdneandroid.adapters.CategoriesAdapter;
import pe.com.fdne.fdneandroid.models.Binomial;
import pe.com.fdne.fdneandroid.models.Category;

public class BinomialsActivity extends AppCompatActivity {
    RecyclerView binomialsRecyclerView;
    BinomialsAdapter binomialsAdapter;
    RecyclerView.LayoutManager binomialsLayoutManager;
    List<Binomial> binomials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binomials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binomialsRecyclerView = (RecyclerView) findViewById(R.id.binomialsRecyclerView);
        binomials = new ArrayList();
        binomials.add(new Binomial("Pegaso", "Pedro Y. Saravia", 1, 95.67, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomials.add(new Binomial("Sugar", "Roberto N.", 2, 85.67, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomials.add(new Binomial("Angel", "Carlos S. R.", 3, 77.20, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomials.add(new Binomial("Roo", "Almr. Martín", 4, 65.10, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomials.add(new Binomial("Caballin", "Cesar V.", 5, 50.50, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomials.add(new Binomial("Sugar", "Juan Flores", 6, 34.20, "https://fotos02.lne.es/2015/03/22/318x200/jinete-francisco.jpg"));
        binomialsAdapter = new BinomialsAdapter(binomials);
        binomialsLayoutManager = new LinearLayoutManager(this);
        binomialsRecyclerView.setAdapter(binomialsAdapter);
        binomialsRecyclerView.setLayoutManager(binomialsLayoutManager);
    }
}
