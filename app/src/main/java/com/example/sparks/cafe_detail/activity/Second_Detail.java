package com.example.sparks.cafe_detail.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.provider.SearchRecentSuggestions;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sparks.cafe_detail.R;
import com.example.sparks.cafe_detail.adapter.RvAdapter;
import com.example.sparks.cafe_detail.model.Detail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static android.content.SearchRecentSuggestionsProvider.DATABASE_MODE_QUERIES;

public class Second_Detail extends ActionBarActivity {
            private String URL_JSON = "http://maieutic-pleads.000webhostapp.com/cafe_detail.php";
            private JsonArrayRequest ArrayRequest ;
            private RequestQueue requestQueue ;
            RecyclerView.LayoutManager mLayoutManager;

            RvAdapter myAdapter;

            private List<Detail> lstAnime = new ArrayList<>();
            private RecyclerView myrv ;



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_second__detail);
                myrv = (RecyclerView) findViewById(R.id.rv);

                jsoncall();
            }

            private void jsoncall() {
                ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSONObject jsonObject = null;


                        for (int i = 0 ; i<response.length();i++) {


                            try {
                                jsonObject = response.getJSONObject(i);
                                Detail detail=new Detail();
                                detail.setCafe_name(jsonObject.getString("cafe_name"));
                                detail.setCafe_image(jsonObject.getString("cafe_image"));
                                detail.setCafe_rate(jsonObject.getString("cafe_rate"));
                                detail.setCafe_address(jsonObject.getString("cafe_address"));
                                detail.setCafe_open(jsonObject.getString("cafe_open"));
                                detail.setCafe_phone(jsonObject.getString("cafe_phone"));
                                detail.setCafe_showadd(jsonObject.getString("cafe_showadd"));

                                lstAnime.add(detail);
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                        setRvadapter(lstAnime);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(Second_Detail.this);
        requestQueue.add(ArrayRequest);
    }

    private void setRvadapter(List<Detail> lstAnime) {
         myAdapter = new RvAdapter(Second_Detail.this,lstAnime) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
}


