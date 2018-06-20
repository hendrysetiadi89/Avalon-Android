package rhynedev.avalon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rhynedev.avalon.R;
import rhynedev.avalon.base.BaseFragment;

/**
 * Created by hendry on 20/06/18.
 */

public class SetupPlayersFragment extends BaseFragment {

    private OnSetupPlayersFragmentListener onSetupPlayersFragmentListener;
    public interface OnSetupPlayersFragmentListener{
        void goToSetupPlayersStep2();
    }

    public static SetupPlayersFragment newInstance() {

        Bundle args = new Bundle();

        SetupPlayersFragment fragment = new SetupPlayersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setup_players, container, false);
        return view;
    }

    @Override
    protected void onAttachActivity(Context context) {
        super.onAttachActivity(context);
        onSetupPlayersFragmentListener = (OnSetupPlayersFragmentListener) context;
    }
}
