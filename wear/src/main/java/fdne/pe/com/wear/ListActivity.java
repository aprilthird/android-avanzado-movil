package fdne.pe.com.wear;

import android.os.Bundle;
import android.support.wear.widget.WearableLinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import fdne.pe.com.wear.adapters.UsersAdapter;
import fdne.pe.com.wear.models.User;

public class ListActivity extends WearableActivity {

    private TextView mTextView;
    private WearableRecyclerView usersWearableRecyclerView;
    private UsersAdapter usersAdapter;
    private WearableRecyclerView.LayoutManager usersLayoutManager;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        usersWearableRecyclerView = findViewById(R.id.usersWearRecyclerView);
        users = new ArrayList<>();
        //users.add(new User("1", "user1", "aaa", "equisde", 100));
        //users.add(new User("2", "user2", "aaa", "equisde", 100));
        //users.add(new User("3", "user3", "aaa", "equisde", 100));
        //users.add(new User("4", "user4", "aaa", "equisde", 100));
        //users.add(new User("5", "user5", "aaa", "equisde", 100));

        usersAdapter = new UsersAdapter(users);
        usersLayoutManager = new WearableLinearLayoutManager(this);
        usersWearableRecyclerView.setEdgeItemsCenteringEnabled(true);
        usersWearableRecyclerView.setCircularScrollingGestureEnabled(true);
        usersWearableRecyclerView.setBezelFraction(0.5f);
        usersWearableRecyclerView.setScrollDegreesPerScreen(90);
        usersWearableRecyclerView.setAdapter(usersAdapter);
        usersWearableRecyclerView.setLayoutManager(usersLayoutManager);

        // Enables Always-on
        setAmbientEnabled();
        loadUsers();
    }

    private void loadUsers() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(ListActivity.this);
        String url = "https://api.github.com/users";

        // Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        users = User.fromJSONArray(response);
                        usersAdapter.setUsers(users);
                        usersAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
    }
}
