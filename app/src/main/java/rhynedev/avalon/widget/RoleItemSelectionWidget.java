package rhynedev.avalon.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import rhynedev.avalon.R;

/**
 * Created by hendry on 21/06/18.
 */

public class RoleItemSelectionWidget extends FrameLayout {
    public RoleItemSelectionWidget(@NonNull Context context) {
        super(context);
        init();
    }

    public RoleItemSelectionWidget(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoleItemSelectionWidget(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoleItemSelectionWidget(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_role_item_selection,
                this, true);
    }
}
