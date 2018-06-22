package rhynedev.avalon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import rhynedev.avalon.R;
import rhynedev.avalon.base.BaseFragment;

/**
 * Created by hendry on 20/06/18.
 */

public class SetupModeFragment extends BaseFragment {

    private ImageView ivNavLeft;
    private ImageView ivNavRight;

    private OnSetupPlayersFragmentListener onSetupPlayersFragmentListener;
    public interface OnSetupPlayersFragmentListener{
        void goToSetupPlayersStep2();
        void backToPlayNow();
    }

    public static SetupModeFragment newInstance() {

        Bundle args = new Bundle();

        SetupModeFragment fragment = new SetupModeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setup_mode, container, false);
        ivNavLeft = view.findViewById(R.id.button_nav_left);
        ivNavRight = view.findViewById(R.id.button_nav_right);
        ivNavLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSetupPlayersFragmentListener.backToPlayNow();
            }
        });
        ivNavRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        return view;
    }

    @Override
    protected void onAttachActivity(Context context) {
        super.onAttachActivity(context);
        onSetupPlayersFragmentListener = (OnSetupPlayersFragmentListener) context;
    }
}
