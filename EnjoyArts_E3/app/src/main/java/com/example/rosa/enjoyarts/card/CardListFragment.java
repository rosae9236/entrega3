package com.example.rosa.enjoyarts.card;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.rosa.enjoyarts.card.MainCRUD;
import com.example.rosa.enjoyarts.R;
import com.example.rosa.enjoyarts.constants.constant;
import com.example.rosa.enjoyarts.provider.Contract;


//fragmento que va a implementar un ListView

public class CardListFragment extends ListFragment
		implements LoaderManager.LoaderCallbacks<Cursor> {    //elementos en PC el cursor localiza y muestra

    //private static final String LOGTAG = "Tiburcio - CartelaListFragment";

    CardCursorAdapter mAdapter;
    LoaderManager.LoaderCallbacks <Cursor> mCallbacks;

    public static CardListFragment newInstance() {                   //newInstance para cargar un nuevo fragmento
        CardListFragment f = new CardListFragment();
        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem menuItem = menu.add(Menu.NONE, constant.INSERT, Menu.NONE, "Insert");
        menuItem.setIcon(R.drawable.ic_playlist_add_black_24dp);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case constant.INSERT:
                Intent intentcrud = new Intent(getActivity(), MainCRUD.class);
                startActivity(intentcrud);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

        /**
         * The Fragment's UI is just a simple text view showing its
         * instance number.
         */





	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		//Log.i(LOGTAG, "onCreateView");
		View v = inflater.inflate(R.layout.fragment_card_list, container, false);


		mAdapter = new CardCursorAdapter(getActivity());
		setListAdapter(mAdapter);

		return v;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//Log.i(LOGTAG, "onActivityCreated");

		mCallbacks = this;

		getLoaderManager().initLoader(0, null, mCallbacks);

	}

	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// This is called when a new Loader needs to be created.  This
		// sample only has one Loader, so we don't care about the ID.
		// First, pick the base URI to use depending on whether we are
		// currently filtering.
		String columns[] = new String[] { Contract.Card._ID,
										  Contract.Card.ARTIST,
				                          Contract.Card.TITLE,
                                          Contract.Card.YEAR,
                                          Contract.Card.LOCATION,

										};

		Uri baseUri = Contract.Card.CONTENT_URI;      //URI que se va a llamar, puesta en el contrato

		// Now create and return a CursorLoader that will take care of
		// creating a Cursor for the data being displayed.

		String selection = null;

		return new CursorLoader(getActivity(), baseUri,                  //cargando el cursor
				columns, selection, null, null);  //de la URI se quieren las columnas y los datos
	}

	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// Swap the new cursor in.  (The framework will take care of closing the
		// old cursor once we return.)

		Uri laUriBase = Uri.parse("content://"+Contract.AUTHORITY+"/Cards");   //cuando la URI se cargue, nos suscribimos a la misma
		data.setNotificationUri(getActivity().getContentResolver(), laUriBase);   //cuando se modifiquen datos se cambia la información automáticamente
		
		mAdapter.swapCursor(data);
	}

	public void onLoaderReset(Loader<Cursor> loader) {
		// This is called when the last Cursor provided to onLoadFinished()
		// above is about to be closed.  We need to make sure we are no
		// longer using it.
		mAdapter.swapCursor(null);
	}

	//clase correspondiente al adaptador que relaciona el cursor de la bd con lo que se va a mostrar
	public class CardCursorAdapter extends CursorAdapter {
		public CardCursorAdapter(Context context) {
			super(context, null, false);
		}

		//cada vez que se carga un item se pone la información de cada item en su layout.
		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			int ID = cursor.getInt(cursor.getColumnIndex(Contract.Card._ID));
			String artist = cursor.getString(cursor.getColumnIndex(Contract.Card.ARTIST));
            String title = cursor.getString(cursor.getColumnIndex(Contract.Card.TITLE));
            String year = cursor.getString(cursor.getColumnIndex(Contract.Card.YEAR));
            String location = cursor.getString(cursor.getColumnIndex(Contract.Card.LOCATION));
	
			TextView textviewArtist = (TextView) view.findViewById(R.id.textview_card_list_item_artist);
			textviewArtist.setText(artist);

			TextView textviewTitle = (TextView) view.findViewById(R.id.textview_card_list_item_title);
			textviewTitle.setText(title);

            TextView textviewYear = (TextView) view.findViewById(R.id.textview_card_list_item_year);
            textviewYear.setText(year);

            TextView textviewLocation = (TextView) view.findViewById(R.id.textview_card_list_item_location);
            textviewLocation.setText(location);

		   // Log.i("tiburcio", ID + artist);

			ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
			int color = generator.getColor(artist); //Genera un color según el artista
			TextDrawable drawable = TextDrawable.builder()
					.buildRound(artist.substring(0,1), color);

			ImageView image = (ImageView) view.findViewById(R.id.image_view);
			image.setImageDrawable(drawable);

			view.setTag(ID);

		}
		//leyaout para cada item
		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View v = inflater.inflate(R.layout.card_list_item, parent, false);  //cada item tiene ese layout
			bindView(v, context, cursor);
			return v;
		}
	}
}
