package fdne.pe.com.wear.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String login;
    private String avatarUrl;
    private String bio;
    private String type;
    private int repos;

    public User() {
    }

    public User(String id, String login, String avatarUrl, String bio, String type, int repos) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.repos = repos;
        this.type = type;
    }

    public static User fromJSONObject(JSONObject jsonObject) {
        try {
            return new User()
                    .setLogin(jsonObject.getString("login"))
                    .setAvatarUrl(jsonObject.getString("avatar_url"))
                    .setType(jsonObject.getString("type"))
                    .setId(jsonObject.getString("id"));
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> fromJSONArray(JSONArray jsonArray) {
        try {
            List<User> users = new ArrayList();
            for(int i=0; i<jsonArray.length(); ++i) {
                User user = User.fromJSONObject(jsonArray.getJSONObject(i));
                users.add(user);
            }
            return users;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User fromBundle(Bundle bundle) {
        return new User()
                .setId(bundle.getString("id"))
                .setType(bundle.getString("type"))
                .setAvatarUrl(bundle.getString("avatarUrl"))
                .setLogin(bundle.getString("login"));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("login", login);
        bundle.putString("type", type);
        bundle.putString("avatarUrl", avatarUrl);
        return bundle;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public User setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public User setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public int getRepos() {
        return repos;
    }

    public User setRepos(int repos) {
        this.repos = repos;
        return this;
    }
}
