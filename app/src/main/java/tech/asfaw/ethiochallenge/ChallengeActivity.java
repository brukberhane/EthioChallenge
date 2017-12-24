package tech.asfaw.ethiochallenge;

import android.support.v4.app.Fragment;

public class ChallengeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new ChallengeFragment();
    }

}