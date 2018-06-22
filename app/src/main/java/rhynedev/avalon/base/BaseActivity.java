package rhynedev.avalon.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rhynedev.avalon.R;

/**
 * Created by hendry on 20/06/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String SAVED_TAG = "tag";

    private String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState!= null) {
            tag = savedInstanceState.getString(SAVED_TAG);
        }
        super.onCreate(savedInstanceState);

    }

    public String getCurrentFragmentTag() {
        return tag;
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack, boolean withAnim) {
        replaceFragment(fragment, addToBackstack, fragment.getClass().getSimpleName(), withAnim);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack, String tag, boolean withAnim) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (withAnim) {
            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        }
        if (!addToBackstack) {
            ft.replace(R.id.fragment, fragment, tag).commit();
        }
        else {
            ft.replace(R.id.fragment, fragment, tag).addToBackStack(tag).commit();
        }
        setUpTitleByTag (tag);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            int backStackCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackCount == 1) {
                setUpTitleByTag(null); // set default
            } else { //2 or more
                setUpTitleByTag(getSupportFragmentManager()
                        .getBackStackEntryAt(backStackCount-2)
                        .getName());
            }
            getSupportFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @CallSuper
    protected void setUpTitleByTag(String tag){
        this.tag = tag;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_TAG, tag);
    }
}
