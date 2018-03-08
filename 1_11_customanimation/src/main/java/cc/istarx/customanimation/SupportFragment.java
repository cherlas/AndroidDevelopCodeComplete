package cc.istarx.customanimation;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by cherlas on 2018/3/8.
 */

public class SupportFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(R.string.fragment_animation);
        textView.setBackgroundColor(Color.RED);
        return textView;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                if (enter) {
                    return AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
                } else {
                    return AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_out);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                if (enter) {
                    return AnimationUtils.loadAnimation(getContext(),R.anim.activity_close_enter);
                } else {
                    return AnimationUtils.loadAnimation(getContext(),R.anim.activity_close_exit);
                }
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
            default:
                if (enter) {
                    return AnimationUtils.loadAnimation(getContext(),R.anim.activity_open_enter);
                } else {
                    return AnimationUtils.loadAnimation(getContext(),R.anim.activity_open_exit);
                }
        }
    }


}
