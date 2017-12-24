package tech.asfaw.ethiochallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.asfaw.ethiochallenge.models.Challenge;
import tech.asfaw.ethiochallenge.models.Person;
import tech.asfaw.ethiochallenge.models.UserLab;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    @BindView(R.id.fragment_home_enter_challenge_button)
    Button mEnterChallengeButton;

    @BindView(R.id.home_display_text)
    TextView mDisplayText;

    private Person mPerson;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        mPerson = UserLab.getLab(getActivity()).getUser();
        if (mPerson != null) {
            displayScore();
        }

        mEnterChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChallengeActivity.class);
                //noinspection ConstantConditions
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void displayScore() {
        mDisplayText.setText("You got " + mPerson.getCorrect() + "  correct :) \n And you got "
                + mPerson.getWrong() + " wrong :( \n Play again to win!");
    }
}
