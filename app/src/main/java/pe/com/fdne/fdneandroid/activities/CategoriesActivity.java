package pe.com.fdne.fdneandroid.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.adapters.CategoriesAdapter;
import pe.com.fdne.fdneandroid.adapters.DisciplinesAdapter;
import pe.com.fdne.fdneandroid.models.Category;
import pe.com.fdne.fdneandroid.models.Discipline;

public class CategoriesActivity extends AppCompatActivity {
    RecyclerView categoriesRecyclerView;
    CategoriesAdapter categoriesAdapter;
    RecyclerView.LayoutManager categoriesLayoutManager;
    List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoriesRecyclerView = (RecyclerView) findViewById(R.id.categoriesRecyclerView);
        categories = new ArrayList();
        categories.add(new Category("A1", "https://img.icons8.com/plasticine/420/horse.png"));
        categories.add(new Category("A2", "https://img.icons8.com/plasticine/420/horse.png"));
        categories.add(new Category("A3", "https://img.icons8.com/plasticine/420/horse.png"));
        categoriesAdapter = new CategoriesAdapter(categories);
        categoriesLayoutManager = new LinearLayoutManager(this);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
        categoriesRecyclerView.setLayoutManager(categoriesLayoutManager);

    }


}
