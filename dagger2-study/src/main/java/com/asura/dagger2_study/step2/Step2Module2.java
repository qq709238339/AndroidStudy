package com.asura.dagger2_study.step2;

import com.asura.dagger2_study.step1.GirlFriend;

import dagger.Module;
import dagger.Provides;

/**
 * @author Created by Asura on 2018/5/31 16:13.
 */
@Module
public class Step2Module2 {
    private Step2Activity2 mActivity;

    public Step2Module2(Step2Activity2 activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    static GirlFriend providerGirlFriend() {
        return new GirlFriend();
    }
}
