package pe.com.fdne.fdneandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.com.fdne.fdneandroid.R;
import pe.com.fdne.fdneandroid.models.Binomial;
import pe.com.fdne.fdneandroid.models.Category;

public class BinomialsAdapter extends RecyclerView.Adapter<BinomialsAdapter.ViewHolder> {
    private List<Binomial> binomials;

    public BinomialsAdapter(List<Binomial> binomials) {
        this.binomials = binomials;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_binomial, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BinomialsAdapter.ViewHolder viewHolder, int i) {
        final Binomial binomial = binomials.get(i);
        Picasso.get().load(binomial.getUrlImage()).into(viewHolder.imgBinomialPicture);
        viewHolder.txtBinomialPosition.setText(Integer.toString(binomial.getPosition()));
        viewHolder.txtBinomialPoints.setText(Double.toString(binomial.getPoints()));
        viewHolder.txtHorseName.setText(binomial.getHorseName());
        viewHolder.txtRiderName.setText(binomial.getRiderName());
    }

    @Override
    public int getItemCount() {
        return binomials.size();
    }

    public List<Binomial> getBinomials() {
        return binomials;
    }

    public void setBinomials(List<Binomial> binomials) {
        this.binomials = binomials;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgBinomialPicture;
        public TextView txtBinomialPosition;
        public TextView txtBinomialPoints;
        public TextView txtHorseName;
        public TextView txtRiderName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBinomialPicture = (ImageView) itemView.findViewById(R.id.imgBinomialPicture);
            txtBinomialPosition = (TextView) itemView.findViewById(R.id.txtBinomialPosition);
            txtBinomialPoints = (TextView) itemView.findViewById(R.id.txtBinomialPoints);
            txtHorseName = (TextView) itemView.findViewById(R.id.txtHorseName);
            txtRiderName = (TextView) itemView.findViewById(R.id.txtRiderName);
        }
    }
}
