package org.esiea.patel_verrier.ebay;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import static java.security.AccessController.getContext;

/**
 * Created by patel_verrier on 03/05/2018.
 */

class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {
    private JSONArray pokemons;
    public PokemonAdapter (JSONArray pokemons){
        this.pokemons=pokemons;
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater lI = LayoutInflater.from(parent.getContext());
        View view = lI.inflate(R.layout.rv_pokemon_element,parent,false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonHolder holder, int position) {
        try {
            holder.name.setText(pokemons.getJSONObject(position).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if(pokemons != null) {
            return pokemons.length();
        }
        else{
            return 0;
        }
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public PokemonHolder(View view) {
            super(view);
            this.name=(TextView) view.findViewById(R.id.rv_pokemon_element_name);
        }
    }

    public void setNewPokemon (JSONArray newPokemon){
        this.pokemons=newPokemon;
        notifyDataSetChanged();
        Log.d("TAG", String.valueOf(getItemCount()));
    }


}


