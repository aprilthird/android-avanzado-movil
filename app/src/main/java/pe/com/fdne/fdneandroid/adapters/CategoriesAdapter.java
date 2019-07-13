package pe.com.fdne.fdneandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.activities.BinomialsActivity;
import pe.com.fdne.fdneandroid.activities.CategoriesActivity;
import pe.com.fdne.fdneandroid.models.Category;
import pe.com.fdne.fdneandroid.models.Discipline;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private List<Category> categories;

    public CategoriesAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder viewHolder, int i) {
        final Category category = categories.get(i);
        Picasso.get().load(category.getUrlImage()).into(viewHolder.imgCategoryPicture);
        viewHolder.txtCategoryTitle.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgCategoryPicture;
        public TextView txtCategoryTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategoryPicture = (ImageView) itemView.findViewById(R.id.imgCategoryPicture);
            txtCategoryTitle = (TextView) itemView.findViewById(R.id.txtCategoryTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, BinomialsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
