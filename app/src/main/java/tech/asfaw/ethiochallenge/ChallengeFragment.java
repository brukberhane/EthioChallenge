package tech.asfaw.ethiochallenge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.asfaw.ethiochallenge.models.Challenge;
import tech.asfaw.ethiochallenge.models.ChallengeLab;


public class ChallengeFragment extends Fragment {

    @SuppressWarnings("FieldCanBeLocal")
    private ChallengeLab mChallengeLab;
    @SuppressWarnings("FieldCanBeLocal")
    private List<Challenge> mChallenges;


    @BindView(R.id.text_view_fragment_main)
    TextView mFirstText;
    @BindView(R.id.question_text)
    TextView mQuestionText;
    @BindView(R.id.first_choice)
    Button mFirstChoiceButton;
    @BindView(R.id.second_choice)
    Button mSecondChoiceButton;
    @BindView(R.id.third_choice)
    Button mThirdChoiceButton;

    public ChallengeFragment(){
        // Required public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);
        ButterKnife.bind(this, view);
        mFirstText.setText("ኣዲስ ኣፕሊኬሽን");
        mFirstText.setTextSize(20);

        mChallengeLab = new ChallengeLab(getActivity());
        mChallenges = mChallengeLab.getChallenges();
        Challenge tchallenge = mChallenges.get(0);
        mQuestionText.setText(tchallenge.getQuestion());
        mFirstChoiceButton.setText(tchallenge.getOptions().get(0));
        mSecondChoiceButton.setText(tchallenge.getOptions().get(1));
        mThirdChoiceButton.setText(tchallenge.getOptions().get(2));

//        Toast.makeText(getActivity(), tchallenge.getQuestion(), Toast.LENGTH_SHORT).show();

        return view;
    }

    /**
     * Idea! Put in a link within this class to randomly pick, either the buttons or the options
     * and place them randomly with the buttons. maybe take some of the code from CSVParser.java
     * the new RandomGenerator can help with what we wanna do...
     */

}
