package com.example.shopnow.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopnow.R;
import com.example.shopnow.adapters.CategoryAdapter;
import com.example.shopnow.adapters.ProductAdapter;
import com.example.shopnow.databinding.ActivityMainBinding;
import com.example.shopnow.model.Category;
import com.example.shopnow.model.Product;
import com.example.shopnow.utils.Constants;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    ProductAdapter productAdapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();
        initSlider();

    }

    private void initSlider() {
        binding.carousel.addData(new CarouselItem("https://i.pinimg.com/736x/e6/ee/2a/e6ee2a5888b79c216ba21bc2ca6c8939.jpg", ""));
        binding.carousel.addData(new CarouselItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpUuciHt98I7QuvzdW0-AMUCsQLTV5KQplVCuY2PX7jS0CBRFMyJyK-nOqJTiGozTPSl0&usqp=CAU", ""));
        binding.carousel.addData(new CarouselItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOgvNGrwNHTJwV4FsH5AZK7D9nEtjz-kztJw&usqp=CAU", ""));
        binding.carousel.addData(new CarouselItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNS4z_1u6ia0kY61Sb92Qa4g3DXeelRpa35U5Y0zTyFC_yYJyQJ-LmuIQsCebAHTgfm8Q&usqp=CAU", ""));
    }

    void initCategories() {
        categories =new ArrayList<>();

        categoryAdapter = new CategoryAdapter(this, categories);

        getCategories();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
    }


    void getCategories(){
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, Constants.GET_CATEGORIES_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.e("err",response);
                    JSONObject mainObj = new JSONObject(response);
                    if(mainObj.getString("status").equals("success")){
                        JSONArray categoriesArray = mainObj.getJSONArray("categories");
                        for (int i = 0; i < categoriesArray.length(); i++){
                            JSONObject object = categoriesArray.getJSONObject(i);
                            Category category = new Category(
                                    object.getString("name"),
                                    Constants.CATEGORIES_IMAGE_URL + object.getString("icon"),
                                    object.getString("color"),
                                    object.getString("brief"),
                                    object.getInt("id")
                            );
                            categories.add(category);
                        }
                        categoryAdapter.notifyDataSetChanged();
                    }else {
                        // Do nothing
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }


    void initProducts() {
        products = new ArrayList<>();
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));
        products.add(new Product("Stylish Men's Cotton Formal", "https://m.media-amazon.com/images/I/61PgOZ-IH0L._AC_UL320_.jpg", "", 12, 12, 1, 1));


        productAdapter = new ProductAdapter(this, products);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.productList.setLayoutManager(layoutManager);
        binding.productList.setAdapter(productAdapter);
    }

}