package fdne.pe.com.wear.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.wear.widget.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fdne.pe.com.wear.DetailActivity;
import fdne.pe.com.wear.R;
import fdne.pe.com.wear.models.User;

public class UsersAdapter extends WearableRecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private List<User> users;

    public UsersAdapter() {
    }

    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // layout: android.support.v7.widget.CardView
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder viewHolder, int i) {
        final User user = users.get(i);
        //Picasso.get().load("https://i.blogs.es/dcc721/url1/450_1000.jpg").into(viewHolder.imgAvatar);
        //DaVinci.with(viewHolder.context).load(user.getAvatarUrl()).into(viewHolder.imgAvatar);
        viewHolder.txtLogin.setText(user.getLogin());
        Glide.with(viewHolder.context).load("http://caballos.mascotahogar.com/Imagenes/caballo-andaluz-al-galope.jpg").into(viewHolder.imgAvatar);
        viewHolder.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(user.toBundle());
                context.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgAvatar;
        public TextView txtLogin;
        public Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtLogin = itemView.findViewById(R.id.txtLogin);
            context = itemView.getContext();
        }
    }
}
