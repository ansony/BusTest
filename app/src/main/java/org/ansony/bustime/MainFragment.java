package org.ansony.bustime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ansony on 14/10/10.
 */
public class MainFragment extends Fragment implements AdapterView.OnItemClickListener{
    private View mView;
    private ListView mListView;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<String> names = new ArrayList<String>();
        names.add("hoge");
        names.add("foo");
        names.add("test");
        names.add("ok");
        mListView = (ListView) mView.findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, names);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
        return mView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                DetailFragment fragment = new DetailFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment).addToBackStack(null).commit();
                break;
            case 1:
            default:
                CustomFragment testFragment = new CustomFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, testFragment).addToBackStack(null).commit();

        }

    }
}
