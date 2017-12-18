package tech.asfaw.ethiochallenge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tech.asfaw.ethiochallenge.models.Challenge;
import tech.asfaw.ethiochallenge.models.ChallengeLab;


public class MainFragment extends Fragment {

    private ChallengeLab mChallengeLab;
    private List<Challenge> mChallenges;

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

        mChallengeLab = new ChallengeLab(getActivity());
        mChallenges = mChallengeLab.getChallenges();
        Challenge tchallenge = mChallenges.get(0);
        Toast.makeText(getActivity(), tchallenge.getQuestion(), Toast.LENGTH_SHORT).show();

        return v;
    }

}
