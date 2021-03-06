package rhynedev.avalon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rhynedev.avalon.R;
import rhynedev.avalon.base.BaseFragment;

/**
 * Created by hendry on 20/06/18.
 */

public class PlayNowFragment extends BaseFragment {

    private OnPlayNowFragmentListener onPlayNowFragmentListener;
    public interface OnPlayNowFragmentListener{
        void goToSetupPlayers();
    }

    public static PlayNowFragment newInstance() {

        Bundle args = new Bundle();

        PlayNowFragment fragment = new PlayNowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_now, container, false);
        View playNowButton = view.findViewById(R.id.tv_play_now);
        playNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayNowFragmentListener.goToSetupPlayers();
            }
        });
        return view;
    }

    @Override
    protected void onAttachActivity(Context context) {
        super.onAttachActivity(context);
        onPlayNowFragmentListener = (OnPlayNowFragmentListener) context;
    }
}
