package com.asura.android_study.activity.fragtofrag;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.asura.android_study.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Liuxd on 2016/11/1 21:05.
 */

public class Fragment2 extends Fragment {

    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.textView2)
    TextView mTextView2;
    MyListener mMyListener;

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }

    protected void onAttachToContext(Context context) {
        mMyListener = (MyListener) context;
    }

    public Fragment2() {

    }

    public static Fragment2 createInstance(String name) {
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragment2.setArguments(bundle);
        return fragment2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment2, null);
        ButterKnife.bind(this, root);
        if (getArguments() != null) {
            mTextView2.setText(getArguments().getString("name", "default"));
        }
        return root;
    }

    @OnClick(R.id.button2)
    public void onClick() {
        mMyListener.sendFrom2("收到fragment2的值");
    }
}
