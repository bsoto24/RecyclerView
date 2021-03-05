package com.example.myapplication;

/**
 * OnItemClick
 *
 * @author Bryam Soto
 * @email bsoto.dev@gmail.com
 * @since 3/5/21
 */
public interface OnCanalesClick {

    /**
     * Envias el objeto canal para controlarlo en tu MainActivity
     * @param canal Objeto canal seleccionado en el RecyclerView
     */
    void onClick(Canales canal);


    /**
     * Envias la posicion del item para controlarlo en tu MainActivity
     * @param itemPosition posicion del item en el RecyclerView
     */
//    void onClick(int itemPosition);

}
