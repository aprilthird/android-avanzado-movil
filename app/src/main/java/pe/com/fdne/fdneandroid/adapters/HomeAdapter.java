package pe.com.fdne.fdneandroid.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.com.fdne.fdneandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<String> imgs;
    private List<String> titles;
    private List<String> descriptions;

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.get().load(imgs.get(position)).into(holder.imgBg);
        holder.tvTitle.setText(titles.get(position));
        holder.tvBottom.setText(descriptions.get(position));
        /*holder.imgBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkidRightActivity_1.this, SkidRightActivity_2.class);
                intent.putExtra("img", imgs[position % 7]);
                intent.putExtra("title", titles[position % 6]);
                Pair<View, String> p1 = Pair.create((View)holder.imgBg, "img_view_1");
                Pair<View, String> p2 = Pair.create((View)holder.tvTitle, "title_1");
                Pair<View, String> p3 = Pair.create((View)holder.tvBottom, "tv_bottom");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(SkidRightActivity_1.this, p1,p2,p3);
                startActivity(intent,options.toBundle());
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBg;
        TextView tvTitle;
        TextView tvBottom;

        public ViewHolder(View itemView) {
            super(itemView);
            imgBg = itemView.findViewById(R.id.img_bg);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBottom = itemView.findViewById(R.id.tv_bottom);
        }
    }
}
