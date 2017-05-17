package com.appsolutions.farmlog;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EditFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";


    private int mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;

    DBHelper dbHelper;

    TextView editTitle, editContent;
    Button update, delete;

    public EditFragment() {
        // Required empty public constructor
    }

    public static EditFragment newInstance(int id, String title, String content, String location) {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, id);
        args.putString(ARG_PARAM2, title);
        args.putString(ARG_PARAM3, content);
        args.putString(ARG_PARAM4, location);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dbHelper = new DBHelper(getContext());

        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        editTitle = (TextView)view.findViewById(R.id.editTitle);
        editContent = (TextView)view.findViewById(R.id.editContent);
        update = (Button)view.findViewById(R.id.update);
        delete = (Button)view.findViewById(R.id.delete);

        editTitle.setText(mParam2);
        editContent.setText(mParam3);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.updateContact(mParam1, editTitle.getText().toString(), editContent.getText().toString(), mParam4);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteContact(mParam1);
            }
        });

        return view;
    }

}
