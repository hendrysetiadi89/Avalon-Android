package rhynedev.avalon;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import rhynedev.avalon.base.BaseActivity;
import rhynedev.avalon.fragment.PlayNowFragment;
import rhynedev.avalon.fragment.SetupPlayersFragment;

import static rhynedev.avalon.constant.Constant.WOOD_BG;

/**
 * Created by hendry on 18/06/18.
 */

public class MainActivity extends BaseActivity implements PlayNowFragment.OnPlayNowFragmentListener,
        SetupPlayersFragment.OnSetupPlayersFragmentListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivBackground = findViewById(R.id.iv_background);
        Glide.with(this).load(WOOD_BG).into(ivBackground);

        if (savedInstanceState == null) {
            replaceFragment(PlayNowFragment.newInstance(), false, false);
        }
    }

    @Override
    public void goToSetupPlayers() {
        replaceFragment(SetupPlayersFragment.newInstance(), true, true);
    }


    @Override
    public void goToSetupPlayersStep2() {
        //TODO
    }
}
