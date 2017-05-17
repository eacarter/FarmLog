package com.appsolutions.farmlog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NoteFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private double mParam1;
    private double mParam2;

    TextView title;
    TextView content;

    List<NoteModel> noteList = new ArrayList<>();

    DBHelper dbHelper;

    public NoteFragment() {
        // Required empty public constructor
    }


    public static NoteFragment newInstance(double param1, double param2) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_PARAM1, param1);
        args.putDouble(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getDouble(ARG_PARAM1);
            mParam2 = getArguments().getDouble(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note, container, false);

        dbHelper = new DBHelper(getContext());

        title = (TextView) view.findViewById(R.id.title);
        content = (TextView) view.findViewById(R.id.content);
        final Button save = (Button) view.findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.insertContact(title.getText().toString(), content.getText().toString(), mParam1 + ",  " + mParam2);
            }
        });

        return view;
    }

    private void saveItem (List<NoteModel> item){



        Gson gson = new Gson();

        String value = gson.toJson(item);

        SharedPreferences sharedPreferences = getActivity().
                getApplicationContext().getSharedPreferences("List", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("List", value);
        editor.commit();

    }
}
