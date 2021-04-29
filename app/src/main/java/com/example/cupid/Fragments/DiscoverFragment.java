package com.example.cupid.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cupid.Adapter.CardsAdapter;
import com.example.cupid.Model.CardItem;
import com.example.cupid.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverFragment extends Fragment {

    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;
    private int currentPosition;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_discover, container, false);



        cardStack = v.findViewById(R.id.container);
        setCardStackAdapter();
        currentPosition = 0;
//        FrameLayout frameLayout=v.findViewById(R.id.matches_frame);
//
//        MatchesFragment matchesFragment=new MatchesFragment();
//        setfragment(matchesFragment);

        return v;
    }

    private void setCardStackAdapter() {


        String url="http://api.betterdate.info/endpoints/user.php";
        RequestQueue queue1 = Volley.newRequestQueue(getContext());
        cardItems = new ArrayList<>();

        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue1.add(request);



//        cardItems.add(new CardItem(R.drawable.a, "Huyen My", "Hanoi"));
//        cardItems.add(new CardItem(R.drawable.f, "Do Ha", "Nghe An"));
//        cardItems.add(new CardItem(R.drawable.g, "Dong Nhi", "Hue"));
//        cardItems.add(new CardItem(R.drawable.e, "Le Quyen", "Sai Gon"));
//        cardItems.add(new CardItem(R.drawable.c, "Phuong Linh", "Thanh Hoa"));
//        cardItems.add(new CardItem(R.drawable.d, "Phuong Vy", "Hanoi"));
//        cardItems.add(new CardItem(R.drawable.b, "Ha Ho", "Da Nang"));

        cardsAdapter = new CardsAdapter(getActivity(), cardItems);
        cardStack.setAdapter(cardsAdapter);
    }

//    private void setfragment(Fragment page) {
//
//        FragmentTransaction fragmentTransaction =getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.matches_frame,page);
//        fragmentTransaction.commit();

//    }
}