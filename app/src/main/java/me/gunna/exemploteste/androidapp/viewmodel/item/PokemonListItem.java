package me.gunna.exemploteste.androidapp.viewmodel.item;

import com.genius.groupie.Item;

import me.gunna.exemploteste.androidapp.R;
import me.gunna.exemploteste.androidapp.databinding.ItemPokemonListBinding;
import me.gunna.exemploteste.androidapp.service.model.PokemonListItemResponse;
import me.gunna.exemploteste.androidapp.viewmodel.PokemonListItemViewModel;
import me.gunna.exemploteste.androidapp.viewmodel.PokemonScreenViewModel;

/**
 * Created by Daniel on 26/07/17.
 */

public class PokemonListItem extends Item<ItemPokemonListBinding> {

    private PokemonScreenViewModel mViewModel;
    private PokemonListItemViewModel mItemViewModel;


    public PokemonListItem(PokemonListItemResponse response, PokemonScreenViewModel viewModel) {
        mViewModel = viewModel;
        mItemViewModel = new PokemonListItemViewModel(response, this);

    }

    @Override
    public int getLayout() {
        return R.layout.item_pokemon_list;
    }

    @Override
    public void bind(ItemPokemonListBinding viewBinding, int position) {
        viewBinding.setContainerViewModel(mViewModel);
        viewBinding.setViewModel(mItemViewModel);
    }
}
