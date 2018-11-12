package courses.pluralsight.com.tabiandating;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import courses.pluralsight.com.tabiandating.model.User;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private List<User> mUsers;
    private Context mContext;

    public RecyclerViewAdapter(List<User> mUsers, Context mContext) {
        this.mUsers = mUsers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_main_feed, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");


        try {
            String imageName = mUsers.get(i).getProfile_image();
            InputStream inputStream = mContext.getAssets().open(imageName);
            Drawable drawableFile = Drawable.createFromStream(inputStream, null);
            holder.image.setImageDrawable(drawableFile);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "onBindViewHolder ERROR: " + e.getMessage().toString());
        }
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.drawable.ic_launcher_background);
//        Glide.with(mContext)
//                .load(Uri.parse("file:///android_asset/"+mUsers.get(i).getProfile_image()))
////                .apply(new RequestOptions().override(100, 100))
//                .into(holder.image);
        holder.name.setText(mUsers.get(i).getName());
        holder.interestedIn.setText(mUsers.get(i).getInterested_in());
        holder.status.setText(mUsers.get(i).getStatus());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: called");
                Toast.makeText(mContext, "You have selected " + mUsers.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView interestedIn;
        TextView status;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            interestedIn = itemView.findViewById(R.id.interested_in);
            status = itemView.findViewById(R.id.status);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
