package gwc.com.trouvaille.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gwc.com.trouvaille.Entity.Venue;
import gwc.com.trouvaille.Layout.VenueActivity;
import gwc.com.trouvaille.R;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder>{

    private ArrayList<Venue> venues;
    private Context context;


    public VenueAdapter(Context context, ArrayList<Venue> venues){
        this.venues = venues;
        this.context = context;

    }

    @NonNull
    @Override
    public VenueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_card,viewGroup, false);
        return new VenueAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VenueAdapter.ViewHolder viewHolder, int i) {
        final Venue venue = venues.get(i);
        viewHolder.name.setText(venue.getName());
        viewHolder.address.setText(venue.getAddress());
        Picasso.get().load(venue.getImage()).into(viewHolder.imageView);
        viewHolder.joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VenueActivity.class);
                intent.putExtra("venue", venue);
                Log.e("Selected Venue name", "venue name:" + venue.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView address;
        private ImageView imageView;
        private Button joinButton;

        public ViewHolder(View itemView){
            super(itemView);
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getAddress() {
            return address;
        }

        public void setAddress(TextView address) {
            this.address = address;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView= imageView;
        }
    }
}