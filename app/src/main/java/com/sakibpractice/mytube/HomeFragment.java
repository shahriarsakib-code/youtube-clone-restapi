package com.sakibpractice.mytube;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.facebook.shimmer.ShimmerFrameLayout;
public class HomeFragment extends Fragment {

    String restapiUrl ="https://onlineserviceagencyuk.com/api_app/videos_yt.json";
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<VideosItem> lists_v;

    ShimmerFrameLayout mshimmerlayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mshimmerlayout=view.findViewById(R.id.shimmer_layout);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        lists_v = new ArrayList<>(); // Initialize the list

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(requireContext());
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, restapiUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Stopping Shimmer Effect's animation after data is loaded to ListView
                        mshimmerlayout.stopShimmerAnimation();
                        mshimmerlayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject receive = jsonArray.getJSONObject(i);
                                VideosItem items = new VideosItem(
                                        receive.getString("title"),
                                        receive.getString("description"),
                                        receive.getString("thumbnail"),
                                        receive.getString("cname"),
                                        receive.getString("cpic"),
                                        receive.getString("uploadtime"),
                                        receive.getString("totalviews"),
                                        receive.getString("subscriber"),
                                        receive.getString("videourl"),
                                        receive.getString("time"),
                                        receive.getString("likes")
                                );
                                lists_v.add(items);
                            }
                            recyclerAdapter = new RecyclerAdapter(lists_v, requireContext());
                            recyclerView.setAdapter(recyclerAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mshimmerlayout.startShimmerAnimation();

    }

    @Override
    public void onPause() {
        mshimmerlayout.stopShimmerAnimation();
        super.onPause();
    }
}