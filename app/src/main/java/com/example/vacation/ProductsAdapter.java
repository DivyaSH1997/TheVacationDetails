package com.example.vacation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    Product product;
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products){
        this.products = products;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtProductTitle,txtProductPrice,txtsrno;
        ImageView imgProduct;



        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgplace);
            txtProductPrice=itemView.findViewById(R.id.txtprice);
            txtProductTitle=itemView.findViewById(R.id.txtplace);
            txtsrno=itemView.findViewById(R.id.txtsrno);



            imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        int pos=getAdapterPosition()+1;
                        Toast.makeText(view.getContext(), "Position No: "+pos,Toast.LENGTH_LONG).show();
                        product = products.get(getAdapterPosition());
                        Intent intent = new Intent(view.getContext(),ProductsDetailActivity.class);
                        intent.putExtra("product",product);
                        view.getContext().startActivity(intent);
                    }
                });
            }

        }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view,null);
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        product = products.get(position);
        holder.txtsrno.setText(product.getId()+"");
        holder.txtProductTitle.setText(product.getTitle());
        holder.txtProductPrice.setText(product.getPrice()+"");
        holder.imgProduct.setImageResource(product.getImageId());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
