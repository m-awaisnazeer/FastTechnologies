package com.example.fasttechnologies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SearchFrag extends Fragment {
     SearchView searchView;
     ListView listView;
     ArrayList<String> searchlist;
     ArrayAdapter<String> searchAdapater;
    String[] search={"Python with Django","Front End Web Development","Android App Development",
            "Certified Ethical Hacking","Blockchain","ASP.NET","MERN Stack","3d Max & Adobe and After Affects",
    "PHP Laravel","Game development Unity 3D"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.search_fragment,container,false);
        searchView=rootView.findViewById(R.id.search);
        listView=rootView.findViewById(R.id.list);
        searchlist = new ArrayList<>();
        searchlist.add("Python with Django");
        searchlist.add("Front End Web Development");
        searchlist.add("Android App Development");
        searchlist.add("Certified Ethical Hacking");
        searchlist.add("Blockchain");
        searchlist.add("ASP.NET");
        searchlist.add("MERN Stack");
        searchlist.add("3d Max & Adobe and After Affects");
        searchlist.add("PHP Laravel");
        searchlist.add("Game development Unity 3D");

        searchAdapater  = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,searchlist);
        listView.setAdapter(searchAdapater);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (searchlist.contains(s)){
                    if(s==search[0]){

                    }
                    searchAdapater.getFilter().filter(s);

                }else {
                    Toast.makeText(getContext(), "No Match Found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchAdapater.getFilter().filter(s);
                return false;
            }
        });


        /*ListView listView=rootView.findViewById(R.id.list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1,search);
        listView.setAdapter(arrayAdapter);*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    toastMessage("Python with Django");
                    Intent intent = new Intent(getContext(),PythonWithDjango.class);
                    startActivity(intent);
                }
                else if (i==1){
                    toastMessage("Front End Web Development");
                    Intent intent = new Intent(getContext(),FrontEndWebDev.class);
                    startActivity(intent);
                }
                else if (i==2){
                    toastMessage("Android App Development");
                    Intent intent = new Intent(getContext(),AndroidAppDev.class);
                    startActivity(intent);
                }
                else if (i==3){
                    toastMessage("Certified Ethical Hacking");
                    Intent intent = new Intent(getContext(),CEH.class);
                    startActivity(intent);
                }
                else if(i==4){
                    toastMessage("Blockchain");
                    Intent intent = new Intent(getContext(),BlockChain.class);
                    startActivity(intent);
                }
                else if(i==5){
                    toastMessage("ASP.NET");
                    Intent intent = new Intent(getContext(),ASPdotNet.class);
                    startActivity(intent);
                }
                else if(i==6){
                    toastMessage("MERN Stack");
                    Intent intent = new Intent(getContext(),MernStack.class);
                    startActivity(intent);
                }
                else if(i==7){
                    toastMessage("3d Max & Adobe and After Affects");
                    Intent intent = new Intent(getContext(),TDMaxAfterAffect.class);
                    startActivity(intent);
                }
                else if(i==8){
                    toastMessage("PHP Laravel");
                    Intent intent = new Intent(getContext(),PHPLaravel.class);
                    startActivity(intent);
                }
                else {
                    toastMessage("Game development Unity 3D");
                    Intent intent = new Intent(getContext(),GameDevUnityTD.class);
                    startActivity(intent);
                }

            }
        });
    return rootView;
    }
    public void toastMessage(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
