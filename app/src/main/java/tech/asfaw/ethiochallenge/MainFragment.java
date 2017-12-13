package tech.asfaw.ethiochallenge;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    public MainFragment(){
        // Required public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        TextView text = (TextView) v.findViewById(R.id.text_view_fragment_main);
        text.setText("ኣዲስ ኣፕሊኬሽን");
        text.setTextSize(20);

        return v;
    }

}
