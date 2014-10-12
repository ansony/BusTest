package org.ansony.bustime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by ansony on 14/10/12.
 */
public class CustomFragment extends Fragment implements View.OnTouchListener{

    static private final String TOUCH = "Touch Event Listener";
    static private final float LEFT_EDGE = 30.0f;
    private boolean isLeftEdge = false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        view.setOnTouchListener(this);
        return view;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, int id) {
        View v = inflater.inflate(id, container, false);
        v.setOnTouchListener(this);
        return v;
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("touch x:","x:"+motionEvent.getX());
                if (motionEvent.getX()<LEFT_EDGE){
                    isLeftEdge = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isLeftEdge) {
                    if (motionEvent.getX() > 200.0) {
                        getActivity().getSupportFragmentManager().popBackStack();
                    }
                }
                isLeftEdge = false;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("hoge","x:"+motionEvent.getX());
                break;
        }
        return true;
    }
}
