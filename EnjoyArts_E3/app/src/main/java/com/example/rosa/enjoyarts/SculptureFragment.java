package com.example.rosa.enjoyarts;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SculptureFragment extends Fragment {

    private AppBarLayout appBar;    // para gestionar barra donde van las pestañas
    private TabLayout tabs;        // para las pestañas
    private ViewPager viewPager;  //mostrar vista de cada fragmento según pestaña seleccionada


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //para agregar la barra y pestañas
        View view = inflater.inflate(R.layout.fragment_sculpture, container, false);
        View containers = (View) container.getParent();
        appBar = (AppBarLayout) containers.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        //para cambiar el color del texto de las pestañas al estar en reposo y al ser seleccionadas.
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);

        //para agregar los títulos a las pestañas  y las vistas o fragments que se mostrarán dependiendo de la pestaña seleccionada

        viewPager = (ViewPager)view.findViewById(R.id.ViewSculpturePager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        return view;
    }


      /*Se llama al método onDestroyView() que permite remover las pestañas insertadas en el fragment,
    con el fin de que las pestañas no se agregen una debajo de la otra al volver a seleccionar el fragmento desde el NavigationDrawer.*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }



    /*Para poder gestionar las vistas y los títulos de las pestañas que se mostrarán a través del fragmento se hace uso de un adaptador,
     se hace creando una clase interna que hereda de la clase FragmentStatePagerAdapter. El adpatador: ViewPagerAdapter.
     Se añade un constructor al adaptador para que maneje los datos que se mostrarán a través de las pestañas.
     Como estamos manipulando fragmentos se hace uso de la clase FragmentManager.
    */

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Mediante un array se agregan los nombres de las pestañas

        String[] TabTittle = {"DETAIL", "imgCOMPLETE"};

               /*Se llama al método getItem y en su interior se hace uso de switch para devolver/return el fragmento respectivo,
        dependiendo de la posición de la pestaña seleccionada */

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Tab_sculptureFragment_detail();
                case 1:
                    return new Tab_sculptureFragment_imgComplete();
            }
            return null;
        }

        // para que devuelva la cantidad de pestañas que se agregarán a la barra de menú (en este caso 3)
        @Override
        public int getCount() {
            return 2;
        }

        // para devolver el array con los nombres de las pestañas
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return TabTittle[position];
        }
    }
}