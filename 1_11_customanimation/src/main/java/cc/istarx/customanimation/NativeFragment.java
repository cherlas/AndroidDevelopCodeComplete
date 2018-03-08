package cc.istarx.customanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cherlas on 2018/3/8.
 */

public class NativeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        TextView tv = new TextView(getContext());
        tv.setText(R.string.native_fragment);
        tv.setBackgroundColor(Color.BLUE);
        return tv;
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                if (enter) {
                    return AnimatorInflater.loadAnimator(getContext(), android.R.animator.fade_in);
                } else {
                    return AnimatorInflater.loadAnimator(getContext(), android.R.animator.fade_out);
                }
                case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                    if (enter) {
                        return AnimatorInflater.loadAnimator(getContext(),R.animator.fragment_pop_enter);
                    } else {
                        return AnimatorInflater.loadAnimator(getContext(),R.animator.fragment_pop_exit);
                    }

                    case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                        default:
                            if (enter) {
                                return AnimatorInflater.loadAnimator(getContext(),R.animator.fragment_enter);
                            } else {
                                return AnimatorInflater.loadAnimator(getContext(),R.animator.fragment_exit);
                            }
        }
    }
}
