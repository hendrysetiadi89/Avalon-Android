package rhynedev.avalon;

import android.os.Bundle;
import android.view.View;
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

    private ImageView ivBackground;
    private ImageView ivNavLeft;
    private ImageView ivNavRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBackground = findViewById(R.id.iv_background);
        ivNavLeft = findViewById(R.id.button_nav_left);
        ivNavRight = findViewById(R.id.button_nav_right);

        Glide.with(this).load(WOOD_BG).into(ivBackground);

        ivNavLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ivNavRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        if (savedInstanceState == null) {
            replaceFragment(PlayNowFragment.newInstance(), false, false);
        } else {
            setUpTitleByTag(getCurrentFragmentTag());
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

    @Override
    protected void setUpTitleByTag(String tag) {
        super.setUpTitleByTag(tag);
        if (tag == null || tag.equals(PlayNowFragment.class.getSimpleName())){
            ivNavLeft.setVisibility(View.GONE);
            ivNavRight.setVisibility(View.GONE);
        } else if (SetupPlayersFragment.class.getSimpleName().equals(tag)){
            ivNavLeft.setVisibility(View.VISIBLE);
            ivNavRight.setVisibility(View.VISIBLE);
        }
    }
}
