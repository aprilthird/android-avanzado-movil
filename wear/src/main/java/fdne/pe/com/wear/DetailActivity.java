package fdne.pe.com.wear;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fdne.pe.com.wear.models.User;

public class DetailActivity extends WearableActivity {

    private User user;
    private ImageView imgAvatarDetail;
    private TextView txtLoginDetail;
    private TextView txtTypeDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Enables Always-on
        setAmbientEnabled();

        user = User.fromBundle(getIntent().getExtras());

        txtLoginDetail = findViewById(R.id.txtLoginDetail);
        txtTypeDetail = findViewById(R.id.txtTypeDetail);
        imgAvatarDetail = findViewById(R.id.imgAvatarDetail);

        txtLoginDetail.setText(user.getLogin());
        txtTypeDetail.setText(user.getType());
        Glide.with(this).load(user.getAvatarUrl()).into(imgAvatarDetail);
    }
}
