package com.actionbarsherlock.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import static com.actionbarsherlock.app.SherlockFragmentActivity.OnCreateOptionsMenuListener;
import static com.actionbarsherlock.app.SherlockFragmentActivity.OnOptionsItemSelectedListener;
import static com.actionbarsherlock.app.SherlockFragmentActivity.OnPrepareOptionsMenuListener;

public class SherlockFragment extends Fragment implements OnCreateOptionsMenuListener, OnPrepareOptionsMenuListener, OnOptionsItemSelectedListener {
    private SherlockFragmentActivity mActivity;

    public SherlockFragmentActivity getSherlockActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        if (!(activity instanceof SherlockFragmentActivity)) {
            throw new IllegalStateException(getClass().getSimpleName() + " must be attached to a SherlockFragmentActivity.");
        }
        mActivity = (SherlockFragmentActivity)activity;

        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public final void onCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) {
        onCreateOptionsMenu((android.view.Menu) new MenuWrapper(menu), mActivity.getSupportMenuInflater());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //Nothing to see here.
    }

    @Override
    public final void onPrepareOptionsMenu(android.view.Menu menu) {
        onPrepareOptionsMenu(new MenuWrapper(menu));
    }

    public void onPrepareOptionsMenu(Menu menu) {
        //Nothing to see here.
    }

    @Override
    public final boolean onOptionsItemSelected(android.view.MenuItem item) {
        return onOptionsItemSelected(new MenuItemWrapper(item));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //Nothing to see here.
        return false;
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Needed due to a bug in compat library 
        // when fragment hidden, the mUserVisibleHint is set to false
        // This imply that the compat lib tries to save to state the USER_VISIBLE_HINT_TAG
        // But they don't safely check if result is not null, so we have to force that
        outState.putBoolean("FAKE_KEY", true);
        super.onSaveInstanceState(outState);
    }
}