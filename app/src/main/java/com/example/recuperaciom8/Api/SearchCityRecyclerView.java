/* package com.example.recuperaciom8.Api;

import static com.example.recuperaciom8.Api.DefaultConstants.BASE_IMG_URL;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperaciom8.Api.Model.UbicacioApi;
import com.example.recuperaciom8.R;

import java.util.ArrayList;

public class SearchCityRecyclerView extends RecyclerView.Adapter<SearchCityRecyclerView.ViewHolder> {
    private UbicacioApi u;
    private Context context;

    public SearchCityRecyclerView(UbicacioApi ubi, Context c){
        this.u = ubi;
        this.context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container) {

        holder.city.setText(u.getCity());

        View viewmaps = inflater.inflate(R.layout.fragment_maps, container, false);
        ImageButton favButton = viewmaps.findViewById(R.id.favButton);
        holder.favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageButton favButton;
        TextView city;
        TextView temps;
        TextView temperatura;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.ciutatField);
            temps = itemView.findViewById(R.id.tempsField);
            temperatura = itemView.findViewById(R.id.temperaturaField);
    }
}


}
*/

