package rhynedev.avalon;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import rhynedev.avalon.base.BaseActivity;
import rhynedev.avalon.fragment.PlayNowFragment;
import rhynedev.avalon.fragment.SetupModeFragment;

import static rhynedev.avalon.constant.Constant.WOOD_BG;

/**
 * Created by hendry on 18/06/18.
 */

public class MainActivity extends BaseActivity implements PlayNowFragment.OnPlayNowFragmentListener,
        SetupModeFragment.OnSetupPlayersFragmentListener {

    private ImageView ivBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ivBackground = findViewById(R.id.iv_background);

        Glide.with(this).load(WOOD_BG).into(ivBackground);

        if (savedInstanceState == null) {
            replaceFragment(PlayNowFragment.newInstance(), false, false);
        } else {
            setUpTitleByTag(getCurrentFragmentTag());
        }
    }

    @Override
    public void goToSetupPlayers() {
        replaceFragment(SetupModeFragment.newInstance(), true, true);
    }

    @Override
    public void backToPlayNow() {
        onBackPressed();
    }

    @Override
    public void goToSetupPlayersStep2() {
        //TODO
    }

}
