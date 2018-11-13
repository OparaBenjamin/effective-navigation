package courses.pluralsight.com.tabiandating;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import courses.pluralsight.com.tabiandating.model.User;
import courses.pluralsight.com.tabiandating.util.Users;

import static android.support.constraint.Constraints.TAG;


public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private List<User> mUsers = Users.userList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        for (User user:mUsers) {
            Log.i(TAG, "initRecyclerView: "+ user.getProfile_image());
        }
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mUsers, getContext());
        mRecyclerView.setAdapter(adapter);
    }


}
