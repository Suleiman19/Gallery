package com.grafixartist.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;

    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMGS[] = {
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/BE0UGGW85Y.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/J7I8CZIT2K.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/J0JG8CVLLS.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/MK3VLNK8NA.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/07Z2HAJFID.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/QONQWUGHON.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/HQMMUYMHG3.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/R926LU1YEA.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/GWALUDW45B.jpg",
            "https://snap-photos.s3.amazonaws.com/img-thumbs/280h/UPBMJVHAVL.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Image " + i);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(MainActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

    }

}
