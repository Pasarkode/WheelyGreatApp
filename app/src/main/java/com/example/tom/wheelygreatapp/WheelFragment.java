package com.example.tom.wheelygreatapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class WheelFragment extends Fragment {

    private static final float BASE_ROTATION_DEGREES = 3600;
    private static final int DURATION = 5000;

    private Button mButton;
    private View mSpinningView;

    public static WheelFragment newInstance() {
        return new WheelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.wheel_fragment, container, false);

        mSpinningView = root.findViewById(R.id.spinning_view);

        mButton = (Button) root.findViewById(R.id.spin_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float deg = mSpinningView.getRotation() + BASE_ROTATION_DEGREES + ((float)Math.random() * 360F);
                Toast.makeText(getActivity(), "Deg: " + deg, Toast.LENGTH_SHORT).show();
                mSpinningView.animate().rotation(deg).setDuration(DURATION)
                        .setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });
        return root;
    }
}
