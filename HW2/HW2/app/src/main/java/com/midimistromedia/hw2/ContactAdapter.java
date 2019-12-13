package com.midimistromedia.hw2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    View listItemView;
    private static final String LOG_TAG = ContactAdapter.class.getSimpleName();
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param contacts A List of contact objects to display in a list
     */

    public ContactAdapter(Activity context, ArrayList<Contact> contacts) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, contacts);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
         listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Dessert} object located at this position in the list
        Contact currentContact = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView lastnameTextView = (TextView) listItemView.findViewById(R.id.list_item_last_name);
        // Get the version name from the current Dessert object and
        // set this text on the name TextView
        lastnameTextView.setText(currentContact.getLastName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView firsnameTextView = (TextView) listItemView.findViewById(R.id.list_item_first_name);
        // Get the version number from the current Dessert object and
        // set this text on the number TextView
        firsnameTextView.setText(String.valueOf(currentContact.getFirstName()));

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Dessert object and
        // set the image to iconView
        //iconView.setImageResource(currentContact.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
