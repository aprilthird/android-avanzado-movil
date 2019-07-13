package pe.com.fdne.fdneandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.activities.CategoriesActivity;
import pe.com.fdne.fdneandroid.models.Discipline;


public class DisciplinesAdapter extends RecyclerView.Adapter<DisciplinesAdapter.ViewHolder>{
    private List<Discipline> disciplines;

    public DisciplinesAdapter(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_discipline, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Discipline discipline = disciplines.get(i);
        Picasso.get().load(discipline.getUrlImage()).into(viewHolder.imgDisciplinePicture);
        viewHolder.txtDisciplineTitle.setText(discipline.getTitle());
        viewHolder.txtDisciplineDescription.setText(discipline.getDescription());
    }

    @Override
    public int getItemCount() {
        return disciplines.size();
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgDisciplinePicture;
        public TextView txtDisciplineTitle;
        public TextView txtDisciplineDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDisciplinePicture = (ImageView) itemView.findViewById(R.id.imgDisciplinePicture);
            txtDisciplineTitle = (TextView) itemView.findViewById(R.id.txtDisciplineTitle);
            txtDisciplineDescription = (TextView) itemView.findViewById(R.id.txtDisciplineDescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CategoriesActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
